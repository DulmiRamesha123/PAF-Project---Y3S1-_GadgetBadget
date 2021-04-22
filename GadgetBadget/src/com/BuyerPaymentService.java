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
	

}
