package com;
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
 
import model.User;
 

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
					 @FormParam("userCode") String userCode,
					 @FormParam("firstName") String firstName,
					 @FormParam("lastName") String lastName,
					 @FormParam("dob") String dob,
					 @FormParam("gender_M_F") String gender,
					 @FormParam("email") String email,
					 @FormParam("address") String address,
					 @FormParam("phone") String phone,
					 @FormParam("password") String password,
					 @FormParam("typeBuyer_T_F") String typeBuyer,
					 @FormParam("typeResearcher_T_F") String typeResearcher,
					 @FormParam("typeFundingBodies_T_F") String typeFunder)
			
			{
				//output
				String output = userObj.insertUser(userCode,firstName, lastName, dob, gender, email,address,phone,password,typeBuyer,typeResearcher,typeFunder);
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
			 String uCode = userObject.get("userCode").getAsString();
			 String firstName = userObject.get("firstName").getAsString();
			 String lastName = userObject.get("lastName").getAsString();
			 String dob = userObject.get("dob").getAsString();
			 String gender = userObject.get("gender_M_F").getAsString();
			 String email  = userObject.get("email").getAsString();
			 String address  = userObject.get("address").getAsString();
			 String phone  = userObject.get("phone").getAsString();
			 String password  = userObject.get("password").getAsString();
			 String typeBuyer  = userObject.get("typeBuyer_T_F").getAsString();
			 String typeResearcher  = userObject.get("typeResearcher_T_F").getAsString();
			 String typeFunder  = userObject.get("typeFundingBodies_T_F").getAsString();
			 
			 String output = userObj.updateUser(uID,uCode, firstName, lastName, dob, gender,email,address,phone,password,typeBuyer,typeResearcher,typeFunder);
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