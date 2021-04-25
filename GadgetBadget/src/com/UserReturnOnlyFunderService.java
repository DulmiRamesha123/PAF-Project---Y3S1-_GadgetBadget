package com;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.UserAll;

@Path("/Funders")


public class UserReturnOnlyFunderService {
	
	UserAll funderObj = new UserAll();
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	
	//Read user objects
	
	public String readFunders()
	 {
		return funderObj.readFunders();
	 }

}
