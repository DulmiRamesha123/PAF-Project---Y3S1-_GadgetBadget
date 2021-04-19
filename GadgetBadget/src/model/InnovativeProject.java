package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class InnovativeProject {
	
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

			public String insertItem(String code, String name, String desc, String skills, String budget,String no_of_funds,String amount)
			 {
				String output = "";
				try
				{
					Connection con = connect();
					if (con == null)
					{return "Error while connecting to the database for inserting."; }
					
					// create a prepared statement
					String query = " insert into innovetive_project(`proj_id`,`proj_code`,`proj_name`,`proj_desc`,`skills_required`,`estimate_fund`,`no_of_funds_made`,`amount_to_fund`)"
					 + " values (?, ?, ?, ?, ?, ?, ?, ?)";
			 
					PreparedStatement preparedStmt = con.prepareStatement(query);
			 
					// binding values
					preparedStmt.setInt(1, 0);
					preparedStmt.setString(2, code);
					preparedStmt.setString(3, name);
					preparedStmt.setString(4, desc);
					preparedStmt.setString(5, skills);
					preparedStmt.setDouble(6, Double.parseDouble(budget));
					preparedStmt.setDouble(7, Integer.parseInt(no_of_funds));
					preparedStmt.setDouble(8, Double.parseDouble(budget));
					
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
