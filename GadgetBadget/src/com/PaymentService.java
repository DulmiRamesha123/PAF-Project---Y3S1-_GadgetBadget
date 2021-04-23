package com;

//For REST Service
//import javax.ws.rs.*;
//import javax.ws.rs.core.MediaType;

//For JS`	ON
//import com.google.gson.*;

import model.Payment;

//For XML
//import org.jsoup.*;
//import org.jsoup.parser.*;
//import org.jsoup.nodes.Document;

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

@Path("/Payments")
public class PaymentService
{
	
	Payment paymentObj = new Payment();
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
	 @FormParam("InvoiceType") String InvoiceType,
	 @FormParam("CusID") String CusID,
	 @FormParam("ProductID") String ProductID,
	 @FormParam("ProductName") String ProductName,
	 @FormParam("GBFee") String GBFee,
	 @FormParam("ServiceCharge") String ServiceCharge,
	 @FormParam("OtherCharge") String OtherCharge,
	 @FormParam("VAT") String VAT,
	 @FormParam("TotalPayment") String TotalPayment)
	{
	 String output = paymentObj.insertPayment(InvoiceType,CusID, ProductID, ProductName,GBFee,ServiceCharge,OtherCharge,VAT,TotalPayment);
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
	 String InvoiceType = paymentObject.get("InvoiceType").getAsString();
	 String CusID = paymentObject.get("CusID").getAsString();
	 String ProductID = paymentObject.get("ProductID").getAsString();
	 String ProductName = paymentObject.get("ProductName").getAsString();
	 String GBFee = paymentObject.get("GBFee").getAsString();
	 String ServiceCharge = paymentObject.get("ServiceCharge").getAsString();
	 String OtherCharge = paymentObject.get("OtherCharge").getAsString();
	 String VAT = paymentObject.get("VAT").getAsString();
	 String TotalPayment = paymentObject.get("TotalPayment").getAsString();
	 
	 String output = paymentObj.updatePayment(InvoiceID, InvoiceType, CusID, ProductID, ProductName, GBFee, ServiceCharge, OtherCharge, VAT, TotalPayment);
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
