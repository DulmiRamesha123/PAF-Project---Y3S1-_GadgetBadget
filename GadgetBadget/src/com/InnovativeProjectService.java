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

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertItem(
			@FormParam("proj_code") String proj_code,
			@FormParam("proj_name") String proj_name,
			@FormParam("proj_desc") String proj_desc,
			@FormParam("skills_required") String skills_required,
			@FormParam("estimate_fund") String estimate_fund,
			@FormParam("no_of_funds_made") String no_of_funds_made,
			@FormParam("amount_to_fund") String amount_to_fund)
	{
	 String output = innovetiveObj.insertItem(proj_code,proj_name,proj_desc,skills_required,estimate_fund,no_of_funds_made,amount_to_fund);
	 return output;
	}

}
