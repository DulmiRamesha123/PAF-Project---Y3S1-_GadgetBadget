package com;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//For JSON
import com.google.gson.*;

import model.FundProposal;

//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/FundProposals")
public class FundProposalService {

	FundProposal fundObj = new FundProposal();
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readFunds()
	 {
	 return fundObj.readFunds();
	 }
}
