
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
		
		public String readItems()
		 {
		 String output = "";
		 try
		 {
		 Connection con = connect();
		 if (con == null)
		 {return "Error while connecting to the database for reading."; }
		 // Prepare the html table to be displayed
		 output = "<table border='1'><tr><th>Project Code</th><th>Project Name</th>" +
		 "<th>Project Description</th>" +
		 "<th> Skills Required</th>" +
		 "<th>Payment Method</th>" +
		 "<th>Estimate Budget</th>" +
		 "<th>Update</th><th>Remove</th></tr>";

		 String query = "select * from complete_project";
		 Statement stmt = con.createStatement();
		 ResultSet rs = stmt.executeQuery(query);
		 // iterate through the rows in the result set
		 while (rs.next())
		 {
		 String proj_id = Integer.toString(rs.getInt("proj_id"));
		 String proj_code = rs.getString("proj_code");
		 String proj_name = rs.getString("proj_name");
		 String proj_desc = rs.getString("proj_desc");
		 String skills_required = rs.getString("skills_required");
		 String payment_method = rs.getString("payment_method");
		 String estimate_budget = Double.toString(rs.getDouble("estimate_budget"));
		
		 // Add into the html table
		 output += "<tr><td>" + proj_code + "</td>";
		 output += "<td>" + proj_name + "</td>";
		 output += "<td>" + proj_desc + "</td>";
		 output += "<td>" + skills_required + "</td>";
		 output += "<td>" + payment_method + "</td>";
		 output += "<td>" + estimate_budget + "</td>";
		 
		 // buttons
		 output += "<td><input name='btnUpdate' type='button' value='Update'class='btn btn-secondary'></td>"
		 + "<td><form method='post' action='items.jsp'>"
		 + "<input name='btnRemove' type='submit' value='Remove'class='btn btn-danger'>"
		 + "<input name='itemID' type='hidden' value='" + proj_id
		 + "'>" + "</form></td></tr>";
		 }
		 con.close();
		 // Complete the html table
		 output += "</table>";
		 }
		 catch (Exception e)
		 {
		 output = "Error while reading the items.";
		 System.err.println(e.getMessage());
		 }
		 return output;
		 }
		
		public String updateItem(String ID, String code, String name, String desc, String skills, String pay_method, String budget)

		 {
		 String output = "";
		 try
		 {
		 Connection con = connect();
		 if (con == null)
		 {return "Error while connecting to the database for updating."; }
		 // create a prepared statement
		 String query = "UPDATE complete_project SET proj_code=?,proj_name=?,proj_desc=?,skills_required=?,payment_method=?,estimate_budget=?WHERE proj_id=?";
		 PreparedStatement preparedStmt = con.prepareStatement(query);
		 // binding values
		 preparedStmt.setString(1, code);
		 preparedStmt.setString(2, name);
		 preparedStmt.setString(3, desc);
		 preparedStmt.setString(4, skills);
		 preparedStmt.setString(5, pay_method);
		 preparedStmt.setDouble(6, Double.parseDouble(budget));
		 preparedStmt.setInt(7, Integer.parseInt(ID));
		 // execute the statement
		 preparedStmt.execute();
		 con.close();
		 output = "Updated successfully";
		 }
		 catch (Exception e)
		 {
		 output = "Error while updating the item.";
		 System.err.println(e.getMessage());
		 }
		 return output;
		 }
	
	

}



