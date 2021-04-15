package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {

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
	
	//read all the user details from details 
	//include all categories -> researchers , buyers ..
	
	public String readUsers()
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
								     "<tr><th>First Name</th>"+
					                 "<th>Last Name</th>" +
									 "<th>Date of Birth</th>" +
									 "<th>Gender</th>" +
									 "<th>Email</th>" +
									 "<th>Address</th>" +
									 "<th>Update</th><th>Remove</th></tr></B>";
			
						//get the data from database
						
						String query = "select * from user";
						
						Statement stmt = con.createStatement();
						ResultSet rs = stmt.executeQuery(query);
						
						
						while (rs.next())
						{
							String uID = Integer.toString(rs.getInt("uID"));
							String firstName= rs.getString("firstName");
							String lastName = rs.getString("lastName");
							String dob =  rs.getString("dob");
							String gender = rs.getString("gender");
							String email = rs.getString("email");
							String address = rs.getString("address");
							
							//put the details retrieved from database to above created html table
							
							output += "<tr><td>" + firstName + "</td>";
							output += "<td>" + lastName + "</td>";
							output += "<td>" + dob + "</td>";
							output += "<td>" + gender + "</td>";
							output += "<td>" + email + "</td>";
							output += "<td>" + address + "</td>";
							
							// buttons
							output += "<td><input name='btnUpdate' type='button' value='Update' class='btn btn-secondary'></td>"+ 
							"<td><form method='post' action='users.jsp'>"+ "<input name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>"
							+ "<input name='uID' type='hidden' value='" + uID + "'>" + "</form></td></tr>";
							}
							con.close();
							
							// close the above created html table
							
							output += "</table>";
		}
	    //catch exception
		catch (Exception e)
		{
			output = "Error while reading the items.";
			System.err.println(e.getMessage());
		}
		return output;
	 }
	
	//Insert users to the database
	
	public String insertUser(String fname, String lname, String d_ob, String gender,String mail,String home_address)
	 {
		String output = "";
		try
		{
		Connection con = connect();
			 if (con == null)
			 {return "Error while connecting to the database for inserting."; }
				 // create a prepared statement
				 String query = " insert into user('uID','firstName','lastName','dob','gender','email','address') values (?, ?, ?, ?, ?,?,?)";
				 PreparedStatement preparedStmt = con.prepareStatement(query);
				 // binding values
				 preparedStmt.setInt(1, 0);
				 preparedStmt.setString(2, fname);
				 preparedStmt.setString(3, lname);
				 preparedStmt.setString(4, d_ob);
				 preparedStmt.setString(5, gender);
				 preparedStmt.setString(6,  mail);
				 preparedStmt.setString(7, home_address);
				// execute the statement
				 
				 preparedStmt.execute();
				 con.close();
				 output = "Inserted successfully";
		}
		catch (Exception e)
			 {
			 output = "Error while inserting the user.";
			 System.err.println(e.getMessage());
			 }
		return output;
		}
	
	public String updateUser(String uid, String fname, String lname, String d_ob, String gender,String mail,String home_address)

	{
		 String output = "";
		 try
		 {
			 Connection con = connect();
			 if (con == null)
				 {return "Error while connecting to the database for updating."; }
				 // create a prepared statement
					 String query = "UPDATE user SET firstName=?,lastName=?,dob=?,gender=?,email=?,address=?, WHERE uID=?";
					 PreparedStatement preparedStmt = con.prepareStatement(query);
					 // binding values
					 preparedStmt.setString(1, fname);
					 preparedStmt.setString(2, lname);
					 preparedStmt.setString(2, d_ob);
					 preparedStmt.setString(4, gender);
					 preparedStmt.setString(5, mail);
					 preparedStmt.setString(4, home_address);
					 preparedStmt.setInt(5, Integer.parseInt(uid));
					 // execute the statement
					 preparedStmt.execute();
					 con.close();
				 output = "Updated successfully";
		 }
		 catch (Exception e)
		 {
		 output = "Error while updating the User";
		 System.err.println(e.getMessage());
		 }
		 return output;
	}
	public String deleteUser(String uID)
		 {
			 String output = "";
			 try
			 {
				 Connection con = connect();
				 if (con == null)
					 {return "Error while connecting to the database for deleting."; }
						 // create a prepared statement
						 String query = "delete from user where uID=?";
						 PreparedStatement preparedStmt = con.prepareStatement(query);
						 // binding values
						 preparedStmt.setInt(1, Integer.parseInt(uID));
						 // execute the statement
						 preparedStmt.execute();
						 con.close();
						 output = "Deleted successfully";
			 }
			 catch (Exception e)
			 {
				 output = "Error while deleting the user.";
				 System.err.println(e.getMessage());
			 }
			 return output;
	 }
	

}
