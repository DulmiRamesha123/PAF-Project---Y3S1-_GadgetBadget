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
		 
		 con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gadgetbadget", "root", "");
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
				 
						output = "<center><h1>User Details<h1><table border='2'><B>"+
								     "<tr><th>User ID</th>"+
								     "<th>User Code</th>"+
								     "<th>First Name</th>"+
					                 "<th>Last Name</th>" +
									 "<th>Date of Birth</th>" +
									 "<th>Gender(M/F)</th>" +
									 "<th>Email</th>" +
									 "<th>Address</th>" +
									 "<th>Phone</th>" +
									 "<th>Buyer(T/F)</th>" +
									 "<th>Researcher(T/F)</th>" +
									 "<th>Funding Bodies(T/F)</th>" +
									 "<th>Update</th><th>Remove</th></tr></B>";
			
						//get the data from database
						
						String query = "select * from user";
						
						Statement stmt = con.createStatement();
						ResultSet rs = stmt.executeQuery(query);
						
						
						while (rs.next())
						{
							String uID = Integer.toString(rs.getInt("uID"));
							String userCode= rs.getString("userCode");
							String firstName= rs.getString("firstName");
							String lastName = rs.getString("lastName");
							String dob =  rs.getString("dob");
							String gender = rs.getString("gender_M_F");
							String email = rs.getString("email");
							String address = rs.getString("address");
							String phone = rs.getString("phone");
							String buyerType = rs.getString("typeBuyer_T_F");
							String researcherType = rs.getString("typeResearcher_T_F");
							String fundType = rs.getString("typeFundingBodies_T_F");
							
							//put the details retrieved from database to above created html table
							
							output += "<tr><td>" + uID + "</td>";
							output += "<td>" + userCode + "</td>";
							output += "<td>" + firstName + "</td>";
							output += "<td>" + lastName + "</td>";
							output += "<td>" + dob + "</td>";
							output += "<td>" + gender + "</td>";
							output += "<td>" + email + "</td>";
							output += "<td>" + address + "</td>";
							output += "<td>" + phone + "</td>";
							output += "<td>" + buyerType + "</td>";
							output += "<td>" + researcherType + "</td>";
							output += "<td>" + fundType + "</td>";
							
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
			output = "Error while reading the Usera.";
			System.err.println(e.getMessage());
		}
		return output;
	 }
	
	//Insert users to the database
	
	public String insertUser(String uCode,String fname, String lname, String d_ob, String gender,String mail,String home_address,String phone,String password,String buyerT,String researcherT,String fundT)
	 {
		String output = "";
		
		try{
			Connection con = connect();
			
				 if (con == null){
					 
					 	return "An error occured when inserting user details to the Data Base"; 
					 	
					 			 }
				 
				 
				String query = " insert into user(`uID`,`userCode`,`firstName`,`lastName`,`dob`,`gender_M_F`,`email`,`address`,`phone`,"
						+ "`password`,`typeBuyer_T_F`,`typeResearcher_T_F`,`typeFundingBodies_T_F`) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
			    PreparedStatement preparedStmt = con.prepareStatement(query);
					  
			    // binding values
					 
				preparedStmt.setInt(1, 0);
				preparedStmt.setString(2, uCode);
			    preparedStmt.setString(3, fname);
				preparedStmt.setString(4, lname);
				preparedStmt.setString(5, d_ob);
				preparedStmt.setString(6, gender);
			    preparedStmt.setString(7,  mail);
			    preparedStmt.setString(8, home_address);
			    preparedStmt.setString(9, phone);
			    preparedStmt.setString(10, password);
			    preparedStmt.setString(11, buyerT);
			    preparedStmt.setString(12, researcherT);
			    preparedStmt.setString(13, fundT);
					 
			  //Execution of the prepared statement  
			    
		    	preparedStmt.execute();
			    con.close();
				output = "Inserted successfully";
		}
		//catch exception
		catch (Exception ex)
			 {
				 output = "An error occured when inserting user";
				 //print the error
				 System.err.println(ex.getMessage());
			 }
		
		return output;
		
		}
	
	//update the user details according to user id
	
	public String updateUser(String uid,String uCode, String fname, String lname, String d_ob, String gender,String mail,String home_address,String phone,String password,String buyerT,String researcherT,String fundT)

	{
		 String output = "";
		 try
		 {
			 Connection con = connect();//check the connection
			 
			 if (con == null)
				 {
				 	return "Error occured when updating user details";
				 }
			 
			 		//updating values 
			 
					 String query = "UPDATE user SET userCode=?,firstName=?,lastName=?,dob=?,gender_M_F=?,email=?,address=?,phone=?,password=?,typeBuyer_T_F=?,typeResearcher_T_F=?,typeFundingBodies_T_F=? WHERE uID=?";
					 PreparedStatement preparedStmt = con.prepareStatement(query);
					 
					 // binding values
					 
					 preparedStmt.setString(1, uCode);
					 preparedStmt.setString(2, fname);
					 preparedStmt.setString(3, lname);
					 preparedStmt.setString(4, d_ob);
					 preparedStmt.setString(5, gender);
					 preparedStmt.setString(6, mail);
					 preparedStmt.setString(7, home_address);
					 preparedStmt.setString(8, phone);
					 preparedStmt.setString(9, password);
					 preparedStmt.setString(10, buyerT);
					 preparedStmt.setString(11, researcherT);
					 preparedStmt.setString(12, fundT);
					 preparedStmt.setInt(13, Integer.parseInt(uid));
					 
					//Execution of the prepared statement  
					 
					 preparedStmt.execute();
					 
					 //close the connection after updating
					 
					 con.close();
					 
					 //print the message when successfully updated the user details
				    output = "Updated successfully";
		 }
		 //catch exception
		 catch (Exception ex)
		 {
			 output = "An error occured when updating user";
			 System.err.println(ex.getMessage());
		 }
		 return output;
	}
	
	//Delete a user according to user id
	//take a user id as a input
	
	public String deleteUser(String uID)
		 {
			 String output = "";
			 
			 try{
				 
				  Connection con = connect();//check connection
				  if (con == null)
					  {
					  	return "Error: Can not connect to the Data Base to delete the user details";
					  }
						  
						  String query = "delete from user where uID=?";
						  
						  PreparedStatement preparedStmt = con.prepareStatement(query);
						  
						  // binding values
						  
						  preparedStmt.setInt(1, Integer.parseInt(uID));
						  
						  //Execution of the prepared statement 
						  
						  preparedStmt.execute();
						  
						  //close the connection after deleting
						  
						  con.close();
						  
						  //print a message after successfully deleting
						  
						  output = "Deleted successfully";
						 
			   }
			 //catch exception
			   catch (Exception ex)
			   {
				  output = "An error occured when deleting user";
				  System.err.println(ex.getMessage());
				  
			   }
			 
		     return output;
	 } 
	

}
