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

import model.InnovativeProject;

@Path("/InnovetiveProjects")

public class InnovativeProjectService {
	
	InnovativeProject innovetiveObj = new InnovativeProject();
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readItems()
	{
		return innovetiveObj.readItems();
	}

	//insert part
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertItem(
			@FormParam("rid") String rid,
			@FormParam("proj_code") String proj_code,
			@FormParam("proj_name") String proj_name,
			@FormParam("proj_desc") String proj_desc,
			@FormParam("skills_required") String skills_required,
			@FormParam("estimate_fund") String estimate_fund,
			@FormParam("no_of_funds_made") String no_of_funds_made,
			@FormParam("amount_to_fund") String amount_to_fund)
	{
	 String output = innovetiveObj.insertItem(rid,proj_code,proj_name,proj_desc,skills_required,estimate_fund,no_of_funds_made,amount_to_fund);
	 return output;
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateItem(String projData)
	{
	//Convert the input string to a JSON object
	 JsonObject projObject = new JsonParser().parse(projData).getAsJsonObject();
	//Read the values from the JSON object
	 String proj_id = projObject.get("proj_id").getAsString();
	 String rid = projObject.get("rid").getAsString();
	 String proj_code = projObject.get("proj_code").getAsString();
	 String proj_name = projObject.get("proj_name").getAsString();
	 String proj_desc = projObject.get("proj_desc").getAsString();
	 String skills_required = projObject.get("skills_required").getAsString();
	 String estimate_fund = projObject.get("estimate_fund").getAsString();
	 String no_of_funds_made = projObject.get("no_of_funds_made").getAsString();
	 String amount_to_fund = projObject.get("amount_to_fund").getAsString();
	 
	 String output = innovetiveObj.updateItem(proj_id, rid, proj_code, proj_name, proj_desc, skills_required, estimate_fund, no_of_funds_made, amount_to_fund);
	return output;
	}

}
