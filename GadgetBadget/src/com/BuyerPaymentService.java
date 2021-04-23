package com;



import model.BuyerPayment;

import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;  


@Path("/BuyerPayments")
public class BuyerPaymentService {
	
	BuyerPayment paymentObj = new BuyerPayment();
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readPayment()
	{
			
			return paymentObj.readPayment();
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertPayment(
	 
	 @FormParam("CusID") String CusID,
	 @FormParam("ProductID") String ProductID,
	 @FormParam("ProductName") String ProductName,
	
	 @FormParam("ServiceCharge") String ServiceCharge,
	 @FormParam("Quantity") String Quantity,
	 
	 @FormParam("TotalPayment") String TotalPayment)
	{
	 String output = paymentObj.insertPayment(CusID, ProductID, ProductName,ServiceCharge,Quantity,TotalPayment);
	return output;
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updatePayment(String paymentData)
	{
	//Convert the input string to a JSON object
	 JsonObject paymentObject = new JsonParser().parse(paymentData).getAsJsonObject();
	//Read the values from the JSON object
	 String InvoiceID = paymentObject.get("InvoiceID").getAsString();
	 
	 String CusID = paymentObject.get("CusID").getAsString();
	 String ProductID = paymentObject.get("ProductID").getAsString();
	 String ProductName = paymentObject.get("ProductName").getAsString();
	 
	 String ServiceCharge = paymentObject.get("ServiceCharge").getAsString();
	 String Quantity = paymentObject.get("Quantity").getAsString();
	
	 String TotalPayment = paymentObject.get("TotalPayment").getAsString();
	 
	 String output = paymentObj.updatePayment(InvoiceID, CusID, ProductID, ProductName, ServiceCharge, Quantity, TotalPayment);
	return output;
	}
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deletePayment(String paymentData)
	{
	//Convert the input string to an XML document
	 Document doc = Jsoup.parse(paymentData, "", Parser.xmlParser());

	//Read the value from the element <itemID>
	 String InvoiceID = doc.select("InvoiceID").text();
	 String output = paymentObj.deletePayment(InvoiceID);
	return output;
	}

}
