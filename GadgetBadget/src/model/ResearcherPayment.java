package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class ResearcherPayment {
	

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
	
		public String insertPayment(String type, String cusid, String productid, String productname , String gbfee, String servicecg , String othercg, String vat ,String totpay) {
			String output = "";

			try {
				Connection con = connect();
				if (con == null) {
					return "Error while connecting to the database for inserting.";
				}
				// create a prepared statement
				String query = " insert into paymenttb(`InvoiceID`,`InvoiceType`,`CusID`,`ProductID`,`ProductName`,`GBFee`,`ServiceCharge`,`OtherCharge`,`VAT`,`TotalPayment`)"
						+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";

				PreparedStatement preparedStmt = con.prepareStatement(query);

				// binding values
				preparedStmt.setInt(1, 0);
				preparedStmt.setString(2, type);
				preparedStmt.setString(3, cusid);
				preparedStmt.setString(4, productid);
				preparedStmt.setString(5, productname);
				preparedStmt.setDouble(6, Double.parseDouble(gbfee));
				preparedStmt.setDouble(7, Double.parseDouble(servicecg));
				preparedStmt.setDouble(8, Double.parseDouble(othercg));
				preparedStmt.setDouble(9, Double.parseDouble(vat));
				preparedStmt.setDouble(10, Double.parseDouble(totpay));
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
