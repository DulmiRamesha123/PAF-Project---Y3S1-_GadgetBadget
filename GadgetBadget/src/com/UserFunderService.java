package com;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.UserBuyer;

@Path("/Funders")


public class UserFunderService {
	
	UserBuyer buyerObj = new UserBuyer();
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	
	//Read user objects
	
	public String readBuyers()
	 {
		return buyerObj.readBuyers();
	 }

}
