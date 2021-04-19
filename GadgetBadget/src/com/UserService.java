

package com;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import com.google.gson.*;
import model.User;
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/Users")

public class UserService
		{
			User userObj = new User();
			@GET
			@Path("/")
			@Produces(MediaType.TEXT_HTML)
			
			//Read user objects
			
			public String readUsers()
			 {
				return userObj.readUsers();
			 }
			
			
			
			@POST
			@Path("/")
			@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
			@Produces(MediaType.TEXT_PLAIN)
			
			//insert user
			
			public String insertUser(
					
					 @FormParam("firstName") String firstName,
					 @FormParam("lastName") String lastName,
					 @FormParam("dob") String dob,
					 @FormParam("gender") String gender,
					 @FormParam("email") String email,
					 @FormParam("address") String address,
					 @FormParam("password") String password,
					 @FormParam("typeBuyer(T/F)") String typeBuyer,
					 @FormParam("typeResearcher(T/F)") String typeResearcher)
			
			{
				//output
				String output = userObj.insertUser(firstName, lastName, dob, gender, email,address,password,typeBuyer,typeResearcher);
				return output;
			}
			
			@PUT
			@Path("/")
			@Consumes(MediaType.APPLICATION_JSON)
			@Produces(MediaType.TEXT_PLAIN)
			
			//updating user details according to user id
			
			public String updateUser(String userData)
			
			{
				
			//converting string to a JSON object
				
			 JsonObject userObject = new JsonParser().parse(userData).getAsJsonObject();
			 
			//Read the values from the JSON object
			 
			 String uID = userObject.get("uID").getAsString();
			 String firstName = userObject.get("firstName").getAsString();
			 String lastName = userObject.get("lastName").getAsString();
			 String dob = userObject.get("dob").getAsString();
			 String gender = userObject.get("gender").getAsString();
			 String email  = userObject.get("email").getAsString();
			 String address  = userObject.get("address").getAsString();
			 String password  = userObject.get("password").getAsString();
			 String typeBuyer  = userObject.get("typeBuyer(T/F)").getAsString();
			 String typeResearcher  = userObject.get("typeResearcher(T/F)").getAsString();
			 String output = userObj.updateUser(uID, firstName, lastName, dob, gender,email,address,password,typeBuyer,typeResearcher);
			 return output;
			}
			
			
			@DELETE
			@Path("/")
			@Consumes(MediaType.APPLICATION_XML)
			@Produces(MediaType.TEXT_PLAIN)
			//delete user according to user id
			
			public String deleteUser(String userData)
			{
				
			//Convert the input string to an XML document
				
			 Document doc = Jsoup.parse(userData, "", Parser.xmlParser());

			//read according to user id and delete
			 
			 String uID = doc.select("uID").text();
			 String output = userObj.deleteUser(uID);
			return output;
			}
				
}

