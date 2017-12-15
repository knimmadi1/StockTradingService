package com.intuit.test.stockTrading.Database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.intuit.test.stockTrading.ModelClasses.Stock;
import com.intuit.test.stockTrading.ModelClasses.UserQuery;
import com.intuit.test.stockTrading.ModelClasses.UserQueryStatus;

public class AnalyzerDB {
	
	private static AnalyzerDB instance = null;
	private AnalyzerDB() {
		
		stocks.add(new Stock("s1",100d));
		stocks.add(new Stock("s2",70d));
		stocks.add(new Stock("s3",70d));
		stocks.add(new Stock("s4",70d));
	
		stockMap.put("s1", stocks.get(0));
		stockMap.put("s2", stocks.get(1));
		stockMap.put("s3", stocks.get(2));
		stockMap.put("s4", stocks.get(3));
	}
	
	public static AnalyzerDB getInstance()
	{
		if(instance == null)
		{
			instance = new AnalyzerDB();
		}
		return instance;
		
	}

	private final List<Stock> stocks= new ArrayList<Stock>();
	
	private final HashMap<String,Stock> stockMap = new HashMap<String,Stock>();
	
	private final HashMap<Stock,Integer> stockRating = new HashMap<Stock,Integer>();
	
	
	
	
	
	private final List<UserQueryStatus> userQueryStatus = new ArrayList<UserQueryStatus>();
	
	public List<Stock> getStocks() {
		return stocks;
	}

	public HashMap<String, Stock> getStockMap() {
		return stockMap;
	}

	public HashMap<Stock, Integer> getStockRating() {
		return stockRating;
	}
	
	
	public Boolean stockIdExists(String stockId) {
		return getStockMap().containsKey(stockId);
		
	}
	
	public Integer getRating(Stock stock)
	{
		return getStockRating().get(stock);
		
	}

	public List<UserQueryStatus> getUserQueryStatus() {
		return userQueryStatus;
	}

	
	public Double getActualStockPrice(String stockId)
	{
		return stockMap.get(stockId).getStockPrice();
		
		
	}
	
	

	
}
