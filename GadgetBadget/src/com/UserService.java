package com;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;

import model.User;

//For XML
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
			public String readItems()
			 {
			 return userObj.readUsers();
			 }
			
			
			
			@POST
			@Path("/")
			@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
			@Produces(MediaType.TEXT_PLAIN)
			public String insertItem(@FormParam("firstName") String firstName,
			 @FormParam("lastName") String lastName,
			 @FormParam("dob") String dob,
			 @FormParam("gender") String gender,
			 @FormParam("email") String email,
			 @FormParam("address") String address)
			{
			 String output = userObj.insertUser(firstName, lastName, dob, gender, email,address);
			return output;
			}
			
			@PUT
			@Path("/")
			@Consumes(MediaType.APPLICATION_JSON)
			@Produces(MediaType.TEXT_PLAIN)
			public String updateUser(String userData)
			{
			//Convert the input string to a JSON object
			 JsonObject userObject = new JsonParser().parse(userData).getAsJsonObject();
			//Read the values from the JSON object
			 String uID = userObject.get("uID").getAsString();
			 String firstName = userObject.get("firstName").getAsString();
			 String lastName = userObject.get("lastName").getAsString();
			 String dob = userObject.get("dob").getAsString();
			 String gender = userObject.get("gender").getAsString();
			 String email  = userObject.get("email").getAsString();
			 String address  = userObject.get("address").getAsString();
			 String output = userObj.updateUser(uID, firstName, lastName, dob, gender,email,address);
			return output;
			}
			
			
			@DELETE
			@Path("/")
			@Consumes(MediaType.APPLICATION_XML)
			@Produces(MediaType.TEXT_PLAIN)
			public String deleteUser(String userData)
			{
			//Convert the input string to an XML document
			 Document doc = Jsoup.parse(userData, "", Parser.xmlParser());

			//Read the value from the element <itemID>
			 String uID = doc.select("uID").text();
			 String output = userObj.deleteItem(uID);
			return output;
			}
				
}

