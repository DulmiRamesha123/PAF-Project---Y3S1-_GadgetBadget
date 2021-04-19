package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserBuyer {
	private Connection connect()
	 {
		 Connection con = null;
		 try
	 {
		 Class.forName("com.mysql.jdbc.Driver");
		 
		 /*making the connection the connection
		  * with database -> userdetailsdb */
		 
		 con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/userdetailsdb", "root", "");
	 }
	//catch exception when connection fail	 
	 catch (Exception ex)
		 {
			 ex.printStackTrace();
		 }
		 
	 return con;
	 }
	public String readBuyers()
	 {
			 String output = "";
			 
			 try{
				 
				 Connection con = connect();
				 
				 if (con == null)
					 //if connection failed printing a error message
						{
					 		return "Error while connecting to the database for reading."; 
					 	}
				 
						 // output as a table
				 
						output = "<table border='2'><B>"+
								     "<tr><th>User ID</th>"+
								     "<th>First Name</th>"+
					                 "<th>Last Name</th>" +
									 "<th>Email</th>" +
									 "<th>Phone</th></tr></B>";
			
						//get the data from database
						
						String query = "select uID,firstName,lastname,email,phone from user where typeBuyer_T_F = 'T'";
						
						Statement stmt = con.createStatement();
						ResultSet rs = stmt.executeQuery(query);
						
						
						while (rs.next())
						{
							String uID = Integer.toString(rs.getInt("uID"));
							String firstName= rs.getString("firstName");
							String lastName = rs.getString("lastName");
							String email = rs.getString("email");
							String phone = rs.getString("phone");
							
							//put the details retrieved from database to above created html table
							
							output += "<tr><td>" + uID + "</td>";
							output += "<td>" + firstName + "</td>";
							output += "<td>" + lastName + "</td>";
							output += "<td>" + email + "</td>";
							output += "<td>" + phone + "</td></tr>";
							
							
							 
							}
							con.close();
							
							// close the above created html table
							
							output += "</table>";
		}
	    //catch exception
		catch (Exception e)
		{
			output = "Error while reading the Buyers.";
			System.err.println(e.getMessage());
		}
		return output;
	 }
	public String readResearchers()
	 {
			 String output = "";
			 
			 try{
				 
				 Connection con = connect();
				 
				 if (con == null)
					 //if connection failed printing a error message
						{
					 		return "Error while connecting to the database for reading."; 
					 	}
				 
						 // output as a table
				 
						output = "<table border='2'><B>"+
								     "<tr><th>User ID</th>"+
								     "<th>First Name</th>"+
					                 "<th>Last Name</th>" +
									 "<th>Email</th>" +
									 "<th>Phone</th></tr></B>";
			
						//get the data from database
						
						String query = "select uID,firstName,lastname,email,phone from user where typeResearcher_T_F = 'T'";
						
						Statement stmt = con.createStatement();
						ResultSet rs = stmt.executeQuery(query);
						
						
						while (rs.next())
						{
							String uID = Integer.toString(rs.getInt("uID"));
							String firstName= rs.getString("firstName");
							String lastName = rs.getString("lastName");
							String email = rs.getString("email");
							String phone = rs.getString("phone");
							
							//put the details retrieved from database to above created html table
							
							output += "<tr><td>" + uID + "</td>";
							output += "<td>" + firstName + "</td>";
							output += "<td>" + lastName + "</td>";
							output += "<td>" + email + "</td>";
							output += "<td>" + phone + "</td></tr>";
							
							
							 
							}
							con.close();
							
							// close the above created html table
							
							output += "</table>";
		}
	    //catch exception
		catch (Exception e)
		{
			output = "Error while reading the Researchers.";
			System.err.println(e.getMessage());
		}
		return output;
	 }   
	
	public String readFunders()
	 {
			 String output = "";
			 
			 try{
				 
				 Connection con = connect();
				 
				 if (con == null)
					 //if connection failed printing a error message
						{
					 		return "Error while connecting to the database for reading."; 
					 	}
				 
						 // output as a table
				 
						output = "<table border='2'><B>"+
								     "<tr><th>User ID</th>"+
								     "<th>First Name</th>"+
					                 "<th>Last Name</th>" +
									 "<th>Email</th>" +
									 "<th>Phone</th></tr></B>";
			
						//get the data from database
						
						String query = "select uID,firstName,lastname,email,phone from user where typeFundingBodies_T_F = 'T'";
						
						Statement stmt = con.createStatement();
						ResultSet rs = stmt.executeQuery(query);
						
						
						while (rs.next())
						{
							String uID = Integer.toString(rs.getInt("uID"));
							String firstName= rs.getString("firstName");
							String lastName = rs.getString("lastName");
							String email = rs.getString("email");
							String phone = rs.getString("phone");
							
							//put the details retrieved from database to above created html table
							
							output += "<tr><td>" + uID + "</td>";
							output += "<td>" + firstName + "</td>";
							output += "<td>" + lastName + "</td>";
							output += "<td>" + email + "</td>";
							output += "<td>" + phone + "</td></tr>";
							
							
							 
							}
							con.close();
							
							// close the above created html table
							
							output += "</table>";
		}
	    //catch exception
		catch (Exception e)
		{
			output = "Error while reading the Funders.";
			System.err.println(e.getMessage());
		}
		return output;
	 }
}
