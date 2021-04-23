package com;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
 
import model.UserBuyer;
 
@Path("/Buyers")

public class UsersBuyersService {
	
	
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
