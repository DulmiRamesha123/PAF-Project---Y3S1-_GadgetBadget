package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class BuyerPayment {
	
	//connect to database
	
			private Connection connect() {
				Connection con = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");

					// Provide the correct details: DBServer/DBName, username, password
					con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/payment", "root", "");
				} catch (Exception e) {
					e.printStackTrace();
				}
				return con;
			}
	
			//InsertPayments
			
			public String insertPayment(String cusid, String productid, String productname , String servicecg , String quantity , String totpay) {
				String output = "";

				try {
					Connection con = connect();
					if (con == null) {
						return "Error while connecting to the database for inserting.";
					}
					// create a prepared statement
					String query = " insert into bpaymenttb(`InvoiceID`,`CusID`,`ProductID`,`ProductName`,`ServiceCharge`,`Quantity`,`TotalPayment`)"
							+ " values (?, ?, ?, ?, ?, ?, ?)";

					PreparedStatement preparedStmt = con.prepareStatement(query);

					// binding values
					preparedStmt.setInt(1, 0);
					preparedStmt.setString(2, cusid);
					preparedStmt.setString(3, productid);
					preparedStmt.setString(4, productname);
					preparedStmt.setDouble(5, Double.parseDouble(servicecg));
					preparedStmt.setDouble(6, Double.parseDouble(quantity));
					preparedStmt.setDouble(7, Double.parseDouble(totpay));
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
					output = "<table border='1'><tr><th>Cus ID</th><th>Product ID</th>" 
							+ "<th>Product Name</th>" + "<th>Service Charge</th>" 
							+ "<th>Quentity</th>" 
							+ "<th>TOTAL PAYMENT</th>" 
							+ "<th>Update</th><th>Remove</th></tr>";

					String query = "select * from bpaymenttb";
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(query);
					// iterate through the rows in the result set
					while (rs.next()) {
						String InvoiceID = Integer.toString(rs.getInt("InvoiceID"));
						
						String CusID = rs.getString("CusID");
						String ProductID = rs.getString("ProductID");
						String ProductName = rs.getString("ProductName");
						
						String ServiceCharge = Double.toString(rs.getDouble("ServiceCharge"));
						String Quantity = Double.toString(rs.getDouble("Quantity"));
						
						String TotalPayment = Double.toString(rs.getDouble("TotalPayment"));
						
						//"TotalPayment"+
						// Add into the html table
						
						
						output += "<td>" + CusID   + "</td>";
						output += "<td>" + ProductID + "</td>";
						output += "<td>" + ProductName + "</td>";
						
						output += "<td>" + ServiceCharge + "</td>";
						output += "<td>" + Quantity + "</td>";
						
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
			
	
	

}
