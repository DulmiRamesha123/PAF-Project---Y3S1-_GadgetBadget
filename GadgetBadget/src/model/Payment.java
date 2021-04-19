package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Payment {
	
	//connect to database
	
	private Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// Provide the correct details: DBServer/DBName, username, password
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	//InsertPayments
	
	public String insertPayment(String type, String cusid, String productid, String productname , String gbfee, String servicecg , String othercg, String vat ,String totpay) {
		String output = "";

		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			// create a prepared statement
			String query = " insert into paymenttb (`InvoiceID`,`InvoiceType`,`CusID`,`ProductID`,`GBFee`,`ServiceCharge`,`OtherCharge`,`VAT`,`TotalPayment`)"
					+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, type);
			preparedStmt.setString(3, cusid);
			preparedStmt.setString(4, productid);
			preparedStmt.setString(5, productname);
			preparedStmt.setDouble(4, Double.parseDouble(gbfee));
			preparedStmt.setDouble(4, Double.parseDouble(servicecg));
			preparedStmt.setDouble(4, Double.parseDouble(othercg));
			preparedStmt.setDouble(4, Double.parseDouble(vat));
			preparedStmt.setDouble(4, Double.parseDouble(totpay));
			// execute the statement

			preparedStmt.execute();
			con.close();
			output = "Inserted successfully";
		} catch (Exception e) {
			output = "Error while inserting the payments.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	//readpayments
	
		public String readPayment() {
			String output = "";
			try {
				Connection con = connect();
				if (con == null) {
					return "Error while connecting to the database for reading.";
				}
				// Prepare the html table to be displayed
				output = "<table border='1'><tr><th>Invoice ID</th>Invoice Type<th></th>" 
						+ "<th>Cus ID</th>" + "<th>Product ID</th>" + "<th>GB Fee</th>" 
						+ "<th>Service Charge</th>" + "<th>Other Charge</th>" + "<th> VAT</th>" 
						+ "<th>Item Description</th>" 
						+ "<th>Update</th><th>Remove</th></tr>";

				String query = "select * from paymenttb";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				// iterate through the rows in the result set
				while (rs.next()) {
					String InvoiceID = Integer.toString(rs.getInt("InvoiceID"));
					String InvoiceType   = rs.getString("InvoiceType");
					String CusID = rs.getString("CusID");
					String ProductID = rs.getString("ProductID");
					String ProductName = rs.getString("ProductName");
					String GBFee = Double.toString(rs.getDouble("GBFee"));
					String ServiceCharge = Double.toString(rs.getDouble("ServiceCharge"));
					String OtherCharge = Double.toString(rs.getDouble("OtherCharge"));
					String VAT = Double.toString(rs.getDouble("VAT"));
					String TotalPayment = Double.toString(rs.getDouble("TotalPayment"));
					
					// Add into the html table
					
					output += "<tr><td>" + InvoiceType + "</td>";
					output += "<td>" + CusID   + "</td>";
					output += "<td>" + ProductID + "</td>";
					output += "<td>" + ProductName + "</td>";
					output += "<td>" + GBFee + "</td>";
					output += "<td>" + ServiceCharge + "</td>";
					output += "<td>" + OtherCharge + "</td>";
					output += "<td>" + VAT + "</td>";
					output += "<td>" + TotalPayment + "</td>";
					// buttons
					output += "<td><input name='btnUpdate' type='button' value='Update'class='btn btn-secondary'></td>"
							+ "<td><form method='post' action='payments.jsp'>"
							+ "<input name='btnRemove' type='submit' value='Remove'class='btn btn-danger'>"
							+ "<input name='InvoiceID' type='hidden' value='" + InvoiceID + "'>" + "</form></td></tr>";
				}
				con.close();
				// Complete the html table
				output += "</table>";
			} catch (Exception e) {
				output = "Error while reading the payments.";
				System.err.println(e.getMessage());
			}
			return output;
		}
		
		//updatepayments

				public String updatePayment(String ID, String type, String cusid, String productid, String productname , String gbfee, String servicecg , String othercg, String vat ,String totpay)

				{
					String output = "";
					try {
						Connection con = connect();

						if (con == null)

						{
							return "Error while connecting to the database for updating.";
						}

						// create a prepared statement

						String query = "UPDATE paymenttb SET InvoiceType=?,CusID=?,ProductID=?,ProductName=?,GBFee=?,ServiceCharge=?,OtherCharge=?,VAT=?,TotalPayment=? WHERE InvoiceID=?";

						PreparedStatement preparedStmt = con.prepareStatement(query);
						// binding values

						preparedStmt.setString(1, type);
						preparedStmt.setString(2, cusid);
						preparedStmt.setString(2, productid);
						preparedStmt.setString(2, productname);
						preparedStmt.setDouble(3, Double.parseDouble(gbfee));
						preparedStmt.setDouble(3, Double.parseDouble(servicecg));
						preparedStmt.setDouble(3, Double.parseDouble(othercg));
						preparedStmt.setDouble(3, Double.parseDouble(vat));
						preparedStmt.setDouble(3, Double.parseDouble(totpay));
						preparedStmt.setInt(5, Integer.parseInt(ID));
						
						// execute the statement
						preparedStmt.execute();
						con.close();
						output = "Updated successfully";
					} catch (Exception e) {
						output = "Error while updating the payments.";
						System.err.println(e.getMessage());
					}
					return output;
				}		
		
		
}
