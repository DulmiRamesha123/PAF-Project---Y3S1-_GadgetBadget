package model;
import java.sql.*; 

public class Buyer {
	private Connection connect() 
    { 
      Connection con = null; 
  try
    { 
    Class.forName("com.mysql.jdbc.Driver"); 

     //Provide the correct details: DBServer/DBName, username, password 
    con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/buyer", "root", ""); 
    } 
   catch (Exception e) 
   {e.printStackTrace();} 
    return con; 
   } 
	 public String insertBuyer(String code, String name, String email, Integer buyerContactNumber, String address) 
	   { 
	     String output = ""; 
	     try
	    { 
	     Connection con = connect(); 
	     if (con == null) 
	     {
	   	  return "Error while connecting to the database for inserting."; 
	      }
	     
	     // create a prepared statement
	     
	     String query = " insert into Buyer (`Buyer ID`,`Buyer Code`,`Buyer Name`,`Buyer Email`,`Buyer Contact Number`,`Buyer Address`)"+ " values (?, ?, ?, ?, ?, ?)"; 
	     PreparedStatement preparedStmt = con.prepareStatement(query); 
	     
	    // binding values
	    preparedStmt.setInt(1, 0); 
	    preparedStmt.setString(2, code); 
	    preparedStmt.setString(3, name); 
	    preparedStmt.setString(4, email); 
	    preparedStmt.setInt(5, buyerContactNumber); 
	    preparedStmt.setString(6,address);
	    
	    System.out.println(code);
	    System.out.println(name);
	    
	   // execute the statement3
	   preparedStmt.execute(); 
	   con.close(); 
	   output = "Inserted successfully"; 
	   } 
	   catch (Exception e) 
	   { 
	   output = "Error while inserting buyer.";
	   e.printStackTrace();
	   //System.err.println(e.getMessage()); 
	   } 
	   return output; 
	} 
}
