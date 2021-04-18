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
			
			public String readItems()
			 {
			 String output = "";
			 try
			 {
			 Connection con = connect();
			 if (con == null)
			 {return "Error while connecting to the database for reading."; }
			 // Prepare the html table to be displayed
			 output = "<table border='1'><tr><th>Researcher rid</th><th>Researcher First Name</th>" +
			 "<th>Researcher Last Name</th>" +
			 "<th> Researcher Address</th>" +
			 "<th>Researcher Phone No</th>" +
			 "<th>Researcher email</th>" +
			 "<th>Researcher username</th>" +
			 "<th>Researcher password</th>" +
			 "<th>Update</th><th>Remove</th></tr>";

			 String query = "select * from add_researcher";
			 Statement stmt = con.createStatement();
			 ResultSet rs = stmt.executeQuery(query);
			 // iterate through the rows in the result set
			 while (rs.next())
			 {
			 String id = Integer.toString(rs.getInt("id"));
			 String rid = rs.getString("rid");
			 String fname = rs.getString("fname");
			 String lname = rs.getString("lname");
			 String address = rs.getString("address");
			 String phone = rs.getString("phone");
			 String email = rs.getString("email");
			 String username = rs.getString("username");
			 String password = rs.getString("password");
			
			 // Add into the html table
			 output += "<tr><td>" + rid + "</td>";
			 output += "<td>" + fname + "</td>";
			 output += "<td>" + lname + "</td>";
			 output += "<td>" + address + "</td>";
			 output += "<td>" + phone + "</td>";
			 output += "<td>" + email + "</td>";
			 output += "<td>" + username + "</td>";
			 output += "<td>" + password + "</td>";
			 
			 
			 // buttons
			 output += "<td><input name='btnUpdate' type='button' value='Update'class='btn btn-secondary'></td>"
			 + "<td><form method='post' action='items.jsp'>"
			 + "<input name='btnRemove' type='submit' value='Remove'class='btn btn-danger'>"
			 + "<input name='itemID' type='hidden' value='" + id
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


}
