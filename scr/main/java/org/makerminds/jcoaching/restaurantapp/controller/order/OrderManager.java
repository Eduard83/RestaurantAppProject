package org.makerminds.jcoaching.restaurantapp.controller.order;

import java.util.ArrayList;

import org.makerminds.jcoaching.restaurantapp.model.Menu;
import org.makerminds.jcoaching.restaurantapp.model.order.Order;
import org.makerminds.jcoaching.restaurantapp.model.order.OrderItem;
import org.makerminds.jcoaching.restaurantapp.model.order.OrderItemSize;
import org.makerminds.jcoaching.restaurantapp.model.product.Product;



public class OrderManager {
	
	//
	private ArrayList<Order> orders = new ArrayList<>();
	
	
	// getter
	public ArrayList<Order> getOrders() {
		return orders;
	}
	
	public Order createOrder(Menu menu) {
		
		Order order = new Order();
		
		addOrder(order, menu.getMenuItems().get(100), OrderItemSize.XXL, 1);
		addOrder(order, menu.getMenuItems().get(102), OrderItemSize.MEDIUM, 2);
		addOrder(order, menu.getMenuItems().get(200), OrderItemSize.LARGE, 1);
		addOrder(order, menu.getMenuItems().get(201), OrderItemSize.XXL, 3);
        return order;
	   
	}
	
	private void addOrder(Order order, Product product, OrderItemSize orderItemSize, int quantity) {
		OrderItem orderItemMeal = cerateOrderItemMeal(product, orderItemSize, quantity);
		order.getOrderItems().add(orderItemMeal);
		
	}
	
	private  OrderItem  cerateOrderItemMeal(Product product, OrderItemSize orderItemSize, int quantity) {
		
		return new OrderItem(product, quantity, orderItemSize);
	
	}
}
