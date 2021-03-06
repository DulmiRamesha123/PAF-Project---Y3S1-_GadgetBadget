

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

import model.CompleteProject;

@Path("/CompleteProjects")
public class CompleteProjectService {
	
	CompleteProject completeProjectObj = new CompleteProject();

	// read details
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readCompleteProjects()
	{
		return completeProjectObj.readCompleteProjects();
	}
	
	//input details 
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertCompleteProjects(
			@FormParam("rid") String rid,
			@FormParam("proj_code") String proj_code,
			@FormParam("proj_name") String proj_name,
			@FormParam("proj_desc") String proj_desc,
			@FormParam("skills_required") String skills_required,
			@FormParam("payment_method") String payment_method,
			@FormParam("estimate_budget") String estimate_budget)
	{
	 String output = completeProjectObj.insertCompleteProjects(rid,proj_code,proj_name,proj_desc,skills_required,payment_method,estimate_budget);
	 return output;
	}
	
	//update details
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateCompleteProjects(String projData)
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
	 String payment_method = projObject.get("payment_method").getAsString();
	 String estimate_budget = projObject.get("estimate_budget").getAsString();
	 
	 String output = completeProjectObj.updateCompleteProjects(proj_id, rid, proj_code, proj_name, proj_desc, skills_required, payment_method, estimate_budget);
	return output;
	}
	
	// delete project
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteCompleteProjects(String projData)
	{
	//Convert the input string to an XML document
		
	 Document doc = Jsoup.parse(projData, "", Parser.xmlParser());

	//Read the value from the element <proj_id>
	 
	 String proj_id = doc.select("proj_id").text();
	 String output = completeProjectObj.deleteCompleteProjects(proj_id);
	return output;
	}
	

}

