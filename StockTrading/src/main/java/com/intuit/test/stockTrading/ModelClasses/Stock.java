package com.intuit.test.stockTrading.ModelClasses;

public class Stock {
	
	
	public Stock() {
		super();
	}
	public Stock(String stockId, double stockPrice) {
		super();
		this.stockId = stockId;
		this.stockPrice = stockPrice;
	}
	
	public String getStockId() {
		return stockId;
	}
	
	public void setStockId(String stockId) {
		this.stockId = stockId;
	}
	
	public double getStockPrice() {
		return stockPrice;
	}
	
	public void setStockPrice(double stockPrice) {
		this.stockPrice = stockPrice;
	}
	
	private String stockId;
	private double stockPrice;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stockId == null) ? 0 : stockId.hashCode());
		long temp;
		temp = Double.doubleToLongBits(stockPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stock other = (Stock) obj;
		if (stockId == null) {
			if (other.stockId != null)
				return false;
		} else if (!stockId.equals(other.stockId))
			return false;
		if (Double.doubleToLongBits(stockPrice) != Double.doubleToLongBits(other.stockPrice))
			return false;
		return true;
	}

}
