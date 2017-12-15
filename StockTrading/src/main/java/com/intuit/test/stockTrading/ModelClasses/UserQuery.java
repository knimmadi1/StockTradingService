package com.intuit.test.stockTrading.ModelClasses;

public class UserQuery implements Comparable<UserQuery>{
	
	public UserQuery() {
		
	}

	private String userId;
	private int rank;
	private String tranType;
	private String stockId;
	private int numOfStocks;
	private double price;
	
	public UserQuery(String userId, int rank, String tranType, String stockId, int numOfStocks, double price) {
		
		this.userId = userId;
		this.rank = rank;
		this.tranType = tranType;
		this.stockId = stockId;
		this.numOfStocks = numOfStocks;
		this.price = price;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getTranType() {
		return tranType;
	}
	public void setTranType(String tranType) {
		this.tranType = tranType;
	}
	public String getStockId() {
		return stockId;
	}
	public void setStockId(String stockId) {
		this.stockId = stockId;
	}
	public int getNumOfStocks() {
		return numOfStocks;
	}
	public void setNumOfStocks(int numOfStocks) {
		this.numOfStocks = numOfStocks;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int compareTo(UserQuery uq) {
		return Integer.compare(this.rank,uq.getRank());
		
	}
	

}