package org.makerminds.jcoaching.restaurantapp.model.product;

public class Product {
	
	private String name;
	private int id;
	private double price;
	
	protected Product() {
	
	}

	public String getName() {
		return name;
	}
	
	// set method
	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
	

