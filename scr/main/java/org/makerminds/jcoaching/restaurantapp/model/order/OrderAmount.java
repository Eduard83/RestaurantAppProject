package org.makerminds.jcoaching.restaurantapp.model.order;

public class OrderAmount {
	
	// attributes
	private double totaleOrderAmount;
	private double totaleOrderAmountVAT;
	private double totaleOrderAmountWithVAT;
	
	public OrderAmount(double totaleOrderAmount, double totaleOrderAmountVAT, double totaleOrderAmountWithVAT) {
		super();
		this.totaleOrderAmount = totaleOrderAmount;
		this.totaleOrderAmountVAT = totaleOrderAmountVAT;
		this.totaleOrderAmountWithVAT = totaleOrderAmountWithVAT;
	}

	public double getTotaleOrderAmount() {
		return totaleOrderAmount;
	}

	public void setTotaleOrderAmount(double totaleOrderAmount) {
		this.totaleOrderAmount = totaleOrderAmount;
	}

	public double getTotaleOrderAmountVAT() {
		return totaleOrderAmountVAT;
	}

	public void setTotaleOrderAmountVAT(double totaleOrderAmountVAT) {
		this.totaleOrderAmountVAT = totaleOrderAmountVAT;
	}

	public double getTotaleOrderAmountWithVAT() {
		return totaleOrderAmountWithVAT;
	}

	public void setTotaleOrderAmountWithVAT(double totaleOrderAmountWithVAT) {
		this.totaleOrderAmountWithVAT = totaleOrderAmountWithVAT;
	}

	
}
