package com.intuit.test.stockTrading.service;

import java.util.concurrent.BlockingQueue;

import com.intuit.test.stockTrading.Database.OrdersDB;
import com.intuit.test.stockTrading.ModelClasses.UserInfo;
import com.intuit.test.stockTrading.ModelClasses.UserQuery;
import com.intuit.test.stockTrading.ModelClasses.UserQueryStatus;

public class OrderProcessService implements Runnable {

	public OrderProcessService(BlockingQueue<UserQueryStatus> orderQueue) {
		this.orderQueue = orderQueue;
	}

	private final BlockingQueue<UserQueryStatus> orderQueue;
	
	public void run() {
		try {
			
			process(orderQueue.take());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

	void process(UserQueryStatus userQueryStatus)
	{
		if(userQueryStatus.getTranType().equalsIgnoreCase("buy"))
		{
		//	UserInfo UserInfo = new UserInfo(); 
		//	OrdersDB.getInstance().getUserData().add(e)
		}
		else 
		{
			
		}
		
		
		//Set the status of Query that order has been placed
		int orderNum=OrdersDB.getInstance().getOrders().size()+1;
		userQueryStatus.setQueryStatus("Order has been placed with orderId "+orderNum);
		
		//Add order to orders list
		OrdersDB.getInstance().getOrders().add(userQueryStatus);
		
		//Print order which is placed
		System.out.println("************Order which is placed************************");
		UserQueryStatus order =OrdersDB.getInstance().getOrders().get(orderNum-1);
		System.out.println("user Id "+order.getUserId());
		System.out.println("stock Id "+order.getStockId());
		System.out.println("stock price "+order.getPrice());
		System.out.println("Transaction Type "+order.getTranType());
		System.out.println("Number of Stocks "+order.getNumOfStocks());
		System.out.println("Rank "+order.getRank());
		System.out.println("Query Number "+order.getQueryNum());
		System.out.println("Query Status "+order.getQueryStatus());
		
		
		
		
	}
}
