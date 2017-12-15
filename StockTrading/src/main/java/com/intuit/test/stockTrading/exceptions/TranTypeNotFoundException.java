package com.intuit.test.stockTrading.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class TranTypeNotFoundException extends Exception implements ExceptionMapper<TranTypeNotFoundException>{


	public TranTypeNotFoundException(String message)
	{
		super(message);
	}
	
	public TranTypeNotFoundException()
	{
		super();
	}
	
	@Override
	public Response toResponse(TranTypeNotFoundException msg) {
		ErrorMessage errorMessage = new ErrorMessage(msg.getMessage());
		System.out.println("Printing Error Msg"+errorMessage.getErrorMsg());
		return Response.status(Response.Status.BAD_REQUEST)
					.entity(errorMessage)
						.build();
	}

}