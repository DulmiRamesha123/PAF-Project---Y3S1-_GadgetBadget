package com;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
 
import model.UserAll;
 
@Path("/Buyers")

public class UsersReturnOnlyBuyerService {
	
	
		UserAll buyerObj = new UserAll();
		@GET
		@Path("/")
		@Produces(MediaType.TEXT_HTML)
		
		//Read user objects
		
		public String readBuyers()
		 {
			return buyerObj.readBuyers();
		 }

}
