package com.intuit.test.stockTrading.ModelClasses;

public class QueryResponse {

	public QueryResponse(String queryRespMsg, int queryNum) {
		super();
		this.queryRespMsg = queryRespMsg;
		this.queryNum = queryNum;
	}
	//private final String queryRespMsg= "Your Query has been accepted and you can track status with below query number";
	private String queryRespMsg;
	private int queryNum;
	
	
	public QueryResponse() {
	
	}
	
	public int getQueryNum() {
		return queryNum;
	}
	public void setQueryNum(int queryNum) {
		this.queryNum = queryNum;
	}
	public String getQueryRespMsg() {
		return queryRespMsg;
	}
	public void setQueryRespMsg(String queryRespMsg) {
		this.queryRespMsg = queryRespMsg;
	}

}
