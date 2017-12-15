package com.intuit.test.stockTrading.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


import com.intuit.test.stockTrading.exceptions.QueryNotFoundException;
import com.intuit.test.stockTrading.exceptions.StockNotFoundException;
import com.intuit.test.stockTrading.exceptions.TranTypeNotFoundException;
import com.intuit.test.stockTrading.Database.AnalyzerDB;
import com.intuit.test.stockTrading.ModelClasses.Stock;
import com.intuit.test.stockTrading.ModelClasses.UserQuery;
import com.intuit.test.stockTrading.ModelClasses.UserQueryStatus;


@Path("/query")
public class SubmitQuery {
	
	

	final QueryService queryService = new QueryService();
	@GET
	@Path("/stocks")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStocksList()
	{
		
		return Response.status(200)
				.entity(AnalyzerDB.getInstance().getStocks().get(0))
				.build();
		
	}
	

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postOrder(UserQuery query) throws StockNotFoundException, TranTypeNotFoundException{
		return queryService.processQuery(query);
	
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getQueryStatus(@QueryParam("QueryNum") int queryNum) throws QueryNotFoundException
	{
		Response response = null;
		if(queryNum <= AnalyzerDB.getInstance().getUserQueryStatus().size())
		{
			UserQueryStatus userQueryStatus=AnalyzerDB.getInstance().getUserQueryStatus().get(queryNum-1);
			response= Response.status(200)
					.entity(userQueryStatus)
					.build();
		}
		else
		{
			throw new QueryNotFoundException("Query Number does not exists");
		}
		return response;
		
	}
	
	
	
	

}
