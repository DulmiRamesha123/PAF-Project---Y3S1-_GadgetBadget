package com;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.CompleteProject;

@Path("/CompleteProjects")

public class CompleteProjectService {
	
	CompleteProject completeProject = new CompleteProject();
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readItems()
	{
		return completeProject.readItems();
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertItem(@FormParam("proj_code") String proj_code,
			@FormParam("proj_name") String proj_name,
			@FormParam("proj_desc") String proj_desc,
			@FormParam("skills_required") String skills_required,
			@FormParam("payment_method") String payment_method,
			@FormParam("estimate_budget") String estimate_budget)
	{
	 String output = completeProject.insertItem(proj_code,proj_name,proj_desc,skills_required,payment_method,estimate_budget);
	 return output;
	}

}
