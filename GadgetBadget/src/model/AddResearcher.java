package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddResearcher {
	
	
	//A common method to connect to the DB
			private Connection connect()
			 {
			 Connection con = null;
			 try
			 {
			 Class.forName("com.mysql.jdbc.Driver");

			 //Provide the correct details: DBServer/DBName, username, password
			 con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/researcher", "root", "");
			 }                              
			 catch (Exception e)
			 {e.printStackTrace();}
			 return con;
			 }

			public String insertItem(String rid, String fname, String lname, String address, String phone, String email, String username, String password)
			 {
				String output = "";
				try
				{
					Connection con = connect();
					if (con == null)
					{return "Error while connecting to the database for inserting."; }
					
					// create a prepared statement
					String query = " insert into add_researcher(`id`,`rid`,`fname`,`lname`,`address`,`phone`,`email`,`username`,`password`)"
					 + " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			 
					PreparedStatement preparedStmt = con.prepareStatement(query);
					
			 
					// binding values
					preparedStmt.setInt(1, 0);
					preparedStmt.setString(2, rid);
					preparedStmt.setString(3, fname);
					preparedStmt.setString(4, lname);
					preparedStmt.setString(5, address);
					preparedStmt.setString(6, phone);
					preparedStmt.setString(7, email);
					preparedStmt.setString(8, username);
					preparedStmt.setString(9, password);
					
					// execute the statement

					preparedStmt.execute();
					con.close();
					output = "Inserted successfully";
				}
				catch (Exception e)
				{
					output = "Error while inserting the item.";
					System.err.println(e.getMessage());
				}
			 return output;
			 }
			

}
