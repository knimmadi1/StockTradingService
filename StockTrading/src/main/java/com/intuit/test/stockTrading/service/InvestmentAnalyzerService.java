package com.intuit.test.stockTrading.service;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

import com.intuit.test.stockTrading.Database.AnalyzerDB;
import com.intuit.test.stockTrading.ModelClasses.Stock;
import com.intuit.test.stockTrading.ModelClasses.UserQuery;
import com.intuit.test.stockTrading.ModelClasses.UserQueryStatus;

public class InvestmentAnalyzerService implements Runnable{
	
	private final PriorityBlockingQueue<UserQueryStatus> queryQueue;
	private final  ArrayBlockingQueue<UserQueryStatus> orderQueue;
	
	public InvestmentAnalyzerService(PriorityBlockingQueue<UserQueryStatus> queryQueue, ArrayBlockingQueue orderQueue) {
		this.queryQueue = queryQueue;
		this.orderQueue=orderQueue;
		OrderProcessService orderProcessService= new OrderProcessService(orderQueue);
		new Thread(orderProcessService).start();
	}

	public void run() {
		while(true)
		{
			try {
				consume(queryQueue.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	void consume(UserQueryStatus userQueryStatus) throws InterruptedException{
		
		//Print the query which is processing
		System.out.println("************Query is Processing************************");
		System.out.println("user Id "+userQueryStatus.getUserId());
		System.out.println("stock Id "+userQueryStatus.getStockId());
		System.out.println("stock price "+userQueryStatus.getPrice());
		System.out.println("Transaction Type "+userQueryStatus.getTranType());
		System.out.println("Number of Stocks "+userQueryStatus.getNumOfStocks());
		System.out.println("Rank "+userQueryStatus.getRank());
		System.out.println("Query Number "+userQueryStatus.getQueryNum());
		System.out.println("Query Status "+userQueryStatus.getQueryStatus());
		
		
		//check in DB if Rating is already present or not for this stockId and price privided by user
		Integer rating = null;
		Stock stock = new Stock(userQueryStatus.getStockId(),userQueryStatus.getPrice());
		
		//check for rating in stockRating Map with key as Stock object
		if(AnalyzerDB.getInstance().getStockRating().containsKey(stock))
		{
			System.out.println("Rating is already there for this stock and price");
			rating=AnalyzerDB.getInstance().getRating(stock);
		}
		else
		{
			//Compute rating if rating is not available in DB
			rating=computeRating(userQueryStatus);
			System.out.println("Computed rating"+rating);
			AnalyzerDB.getInstance().getStockRating().put(stock, rating);
			System.out.println("Added computed rating in to DB");
		}
		
		if(rating.intValue() > 80)
		{
			//Rating > 80,put the query in second queue
			orderQueue.put(userQueryStatus);
			
			//update status of Query that it is sent for Ordering
			userQueryStatus.setQueryStatus("Query has been sent for ordering with order ID");
		}
		else
		{
			userQueryStatus.setQueryStatus("Order Rejected as Price provided is not close enough to Actual Stock Price");
		}
	
	}
	
	private Integer computeRating(UserQueryStatus userQueryStatus)
	{
		double actualStockPrice = AnalyzerDB.getInstance().getActualStockPrice(userQueryStatus.getStockId());
		System.out.println("Actual Stock Price *********"+actualStockPrice);
		double val=Math.abs(( (userQueryStatus.getPrice()-actualStockPrice)/actualStockPrice)*100);
		return (int) (100d-val);
		
	}

}
