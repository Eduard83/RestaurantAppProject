package org.makerminds.jcoaching.restaurantapp.model.order;

import java.util.ArrayList;


public class Order {
	
	
	// switch from array to arrayList
	private ArrayList<OrderItem> orderItems = new ArrayList<>();
	
	public Order() {
	}

	public ArrayList<OrderItem> getOrderItems() {
		return orderItems;
	}
	
	public void setOrderItems(ArrayList<OrderItem>productArrayList) {
		this.orderItems = productArrayList;
		
		
	}
	
}
