package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CompleteProject {
	
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

		public String insertItem(String code, String name, String desc, String skills, String pay_method, String budget)
		 {
			String output = "";
			try
			{
				Connection con = connect();
				if (con == null)
				{return "Error while connecting to the database for inserting."; }
				
				// create a prepared statement
				String query = " insert into complete_project(`proj_id`,`proj_code`,`proj_name`,`proj_desc`,`skills_required`,`payment_method`,`estimate_budget`)"
				 + " values (?, ?, ?, ?, ?, ?, ?)";
		 
				PreparedStatement preparedStmt = con.prepareStatement(query);
		 
				// binding values
				preparedStmt.setInt(1, 0);
				preparedStmt.setString(2, code);
				preparedStmt.setString(3, name);
				preparedStmt.setString(4, desc);
				preparedStmt.setString(5, skills);
				preparedStmt.setString(6, pay_method);
				preparedStmt.setDouble(7, Double.parseDouble(budget));
				
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
