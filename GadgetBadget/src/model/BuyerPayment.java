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
	
	

}
