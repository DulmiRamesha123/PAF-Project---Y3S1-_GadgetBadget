package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class FundProposal {

		//A common method to connect to the DB
		private Connection connect()
		{
			Connection con = null;
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
					
				//Provide the correct details: DBServer/DBName, username, password
				con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/funddb", "root", "");
			}
			catch (Exception e)
			{e.printStackTrace();}
				return con;
		}
		
		
		public String insertfunds(String fundname, String projreq, String compname, String typeofproj,String excdate,String Amooffunds,String paydesc)
		 {
			String output = "";
			try
			{
				Connection con = connect();
				if (con == null)
				{return "Error while connecting to the database for inserting."; }
				
				// create a prepared statement
				String query = " insert into fund_proposal_t(`fundID`,`fundName`,`projRequrment`,`companyName`,`typeOfProject`,`ExceptedDate`,`AmountOfFunds`,`paymentDesc`) values (?, ?, ?, ?, ?,?,?,?,?)";
				PreparedStatement preparedStmt = con.prepareStatement(query);
				
				// binding values
				preparedStmt.setInt(1, 0);
				preparedStmt.setString(2, fundname);
				preparedStmt.setString(3, projreq);
				preparedStmt.setString(4, compname);
				preparedStmt.setString(5, typeofproj);
				preparedStmt.setString(6, excdate);
				preparedStmt.setDouble(7, Double.parseDouble(Amooffunds));
				preparedStmt.setString(8, paydesc);
				
				// execute the statement
		 
				preparedStmt.execute();
				con.close();
				output = "Inserted successfully";
			}
			catch (Exception e)
			{
				output = "Error while inserting the funds Details.";
				System.err.println(e.getMessage());
			}
			return output;
		 }
		
		
		public String readFunds()
		{
			String output = "";
			try
			{
				Connection con = connect();
				if (con == null)
				{return "Error while connecting to the database for reading."; }
				
				// Prepare the html table to be displayed
				output = "<table border='1'><tr><th>Owner of Funds</th><th>Project Requirments</th>" +
						"<th>Company Name</th>"+
						"<th>Type of project</th>" +
						"<th>Excepted Date</th>"+ 
						"<th>Amount Of Funds</th>"+ 
						"<th>Payments description</th></tr>";
	
				String query = "select * from fund_proposal_t";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				
				// iterate through the rows in the result set
				while (rs.next())
				{
					String fundID = Integer.toString(rs.getInt("fundID"));
					String fundName = rs.getString("fundName");
					String projRequrment = rs.getString("projRequrment");
					String companyName = rs.getString("companyName");
					String typeOfProject = rs.getString("typeOfProject");
					String ExceptedDate = rs.getString("ExceptedDate");
					String AmountOfFunds = Double.toString(rs.getDouble("AmountOfFunds"));
					String paymentDesc = rs.getString("paymentDesc");
					
					// Add into the html table
					output += "<tr><td>" + fundName + "</td>";
					output += "<td>" + projRequrment + "</td>";
					output += "<td>" + companyName + "</td>";
					output += "<td>" + typeOfProject + "</td>";
					output += "<td>" + ExceptedDate + "</td>";
					output += "<td>" + AmountOfFunds + "</td>";
					output += "<td>" + paymentDesc + "</td>";
					// buttons
					output += "<td><input name='btnUpdate' type='button' value='Update' class='btn btn-secondary'></td>"+ 
							"<td><form method='post' action='items.jsp'>"+ "<input name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>"
							+ "<input name='itemID' type='hidden' value='" + fundID + "'>" + "</form></td></tr>";
				}
				con.close();
				
				// Complete the html table
				output += "</table>";
			}
			catch (Exception e)
			{
				output = "Error while reading the Funds Details.";
				System.err.println(e.getMessage());
			}
			return output;
		}
}
