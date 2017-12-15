package com.intuit.test.stockTrading.Database;

import java.util.ArrayList;
import java.util.List;

import com.intuit.test.stockTrading.ModelClasses.UserInfo;
import com.intuit.test.stockTrading.ModelClasses.UserQueryStatus;


public class OrdersDB {

	
	private static OrdersDB instance  = null;
	
	private OrdersDB()
	{
		
	}
	
	public static OrdersDB getInstance()
	{
		if(instance == null)
			instance= new OrdersDB();
		return instance;
			
	}

	 
	private final List<UserQueryStatus> orders = new ArrayList<UserQueryStatus>();
	
	public List<UserQueryStatus> getOrders() {
		return orders;
	}

	
}