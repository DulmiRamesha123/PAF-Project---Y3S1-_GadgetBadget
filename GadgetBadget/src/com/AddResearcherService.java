package com;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.AddResearcher;

@Path("/AddResearcher")

public class AddResearcherService {

AddResearcher addresearcherObj = new AddResearcher();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readItems()
	{
		return addresearcherObj.readItems();
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertItem(
			@FormParam("rid") String rid,
			@FormParam("fname") String fname,
			@FormParam("lname") String lname,
			@FormParam("address") String address,
			@FormParam("phone") String phone,
			@FormParam("email") String email,
			@FormParam("username") String username,
			@FormParam("password") String password)
	{
	 String output = addresearcherObj.insertItem(rid,fname,lname,address,phone,email,username,password);
	 return output;
	}
}
