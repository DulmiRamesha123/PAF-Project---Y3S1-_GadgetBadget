package com;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//For JSON
import com.google.gson.*;

import model.FundProposal;

//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/FundProposals")
public class FundProposalService {

	FundProposal fundObj = new FundProposal();
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readFunds()
	 {
	 return fundObj.readFunds();
	 }
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertfunds(
	 @FormParam("fundName") String fundName,
	 @FormParam("projRequrment") String projRequrment,
	 @FormParam("companyName") String companyName,
	 @FormParam("typeOfProject") String typeOfProject,
	 @FormParam("ExceptedDate") String ExceptedDate,
	 @FormParam("AmountOfFunds") String AmountOfFunds,
	 @FormParam("paymentDesc") String paymentDesc)
	{
	 String output = fundObj.insertfunds(fundName, projRequrment, companyName, typeOfProject,ExceptedDate,AmountOfFunds,paymentDesc);
	return output;
	}
	
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updatefunds(String funddata)
	{
	//Convert the input string to a JSON object
		
	 JsonObject fundObject = new JsonParser().parse(funddata).getAsJsonObject();
	 
	//Read the values from the JSON object
	 
	 String fundID = fundObject.get("fundID").getAsString();
	 String fundName = fundObject.get("fundName").getAsString();
	 String projRequrment = fundObject.get("projRequrment").getAsString();
	 String companyName = fundObject.get("companyName").getAsString();
	 String typeOfProject = fundObject.get("typeOfProject").getAsString();
	 String ExceptedDate = fundObject.get("ExceptedDate").getAsString();
	 String AmountOfFunds = fundObject.get("AmountOfFunds").getAsString();
	 String paymentDesc = fundObject.get("paymentDesc").getAsString();
	 
	 String output = fundObj.updatefunds(fundID, fundName, projRequrment, companyName, typeOfProject,ExceptedDate,AmountOfFunds,paymentDesc);
	return output;
	}
	
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteFunds(String funddata)
	{
	//Convert the input string to an XML document
	 Document doc = Jsoup.parse(funddata, "", Parser.xmlParser());

	//Read the value from the element <fundID>
	 String fundID = doc.select("fundID").text();
	 String output = fundObj.deleteFunds(fundID);
	return output;
	}
	
	
	
}
