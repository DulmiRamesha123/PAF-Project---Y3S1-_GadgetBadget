package com;


import model.Buyer;


import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
@Path("/Buyer") 

public class BuyerService 
{ 
   Buyer BuyerObj = new Buyer(); 
   
   @POST
   @Path("/") 
   @Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
   @Produces(MediaType.TEXT_PLAIN) 
   public String insertBuyer(@FormParam("Buyer Code") String BuyerCode, 
    @FormParam("Buyer Name") String BuyerName, 
    @FormParam("Buyer Email") String BuyerEmail, 
    @FormParam("Buyer Contact Number") Integer BuyerContactNumber,
    @FormParam("Buyer Address") String BuyerAddress)
   
   { 
	 System.out.println("Hello");  
     String output= BuyerObj.insertBuyer(BuyerCode, BuyerName, BuyerEmail, BuyerContactNumber,BuyerAddress);
     
     System.out.println(BuyerCode);
     System.out.println(BuyerName);
     return output;
   }
   @GET
   @Path("/") 
   @Produces(MediaType.TEXT_HTML) 
    public String readBuyer()
    { 
       return BuyerObj.readBuyer(); 
    }
}