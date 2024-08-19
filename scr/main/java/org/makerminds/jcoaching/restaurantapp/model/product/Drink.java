package org.makerminds.jcoaching.restaurantapp.model.product;

public class Drink extends Product {
	
	private boolean sugerFree;
	
	public Drink(int id, String name, double price) {
		setId(id);
		setName(name);
		setPrice(price);
	}
	public Drink(int id, String name, double price, boolean sugarFree) {
		this(id, name, price);
		this.sugerFree = sugarFree;
	}
	
	public boolean isSugerFree() {
		return sugerFree;
	}
	
	public void setSugerFree(boolean sugerFree) {
		this.sugerFree = sugerFree;
	}
	

}
