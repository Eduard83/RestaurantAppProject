package org.makerminds.jcoaching.restaurantapp.controller.order;

import java.util.ArrayList;


import org.makerminds.jcoaching.restaurantapp.model.Client;
import org.makerminds.jcoaching.restaurantapp.model.Restaurant;
import org.makerminds.jcoaching.restaurantapp.model.order.Order;
import org.makerminds.jcoaching.restaurantapp.model.order.OrderAmount;
import org.makerminds.jcoaching.restaurantapp.model.order.OrderItem;
import org.makerminds.jcoaching.restaurantapp.model.product.Product;

public class OrderPrinter {
	
	StringBuilder stringBuilder = new StringBuilder();
	
	public void printOrderInfo(Restaurant restaurant, Client client, Order order, OrderAmount orderAmount, int vatRate) {
		
		ArrayList<OrderItem>produktArrayList = order.getOrderItems();
		printOrderInfoHeader(client);
		
		
		// For each loop
		for(OrderItem orderItem : produktArrayList) {
			printOrderItemInfo(orderItem);
		}
		
		printOrderInfoFooter(restaurant, orderAmount, vatRate);
		
	}
	
	private void printOrderItemInfo(OrderItem orderItem) {
		Product product = orderItem.getProduct();
		double totalOrderItemPrice = orderItem.getOrderItemPrice() * orderItem.getQuantity();
		//System.out.println(orderItem.getQuantity() + "x |" + product.getId() + ". " + product.getName()
		//+ " | " + orderItem.getOrderItemPrece() + " | " + totalOrderItemPrice + " Euro ");
		stringBuilder.append(orderItem.getQuantity())
		.append("x |" + product.getId())
		.append(". " + product.getName())
		.append(" | ")
		.append(orderItem.getOrderItemPrice())
		.append(" | ")
		.append(totalOrderItemPrice)
		.append(" Euro. ");
	}
	
	private void printOrderInfoHeader(Client client) {
		// header
		stringBuilder.append("Order from: ")
		.append(client.getName())
		.append("Contact number: " + client.getPhoneNumber())	
		.append("------------------------------------------").append(System.lineSeparator());
		
	}
	
	private  void printOrderInfoFooter(Restaurant restaurant, OrderAmount orderAmount,int vatRate) {
		
		/*System.out.println("-----------------------------------------");
		
		// Footer
		System.out.println("The price of the order is");
		System.out.println("SUB TOTAL: " + ("SUB TOTAL: "  + " Euro ");
		System.out.println("VAT "+vatRate+"%: " + orderAmount.getTotaleOrderAmountVAT() + " Euro ");
		System.out.println("TOTAL after VAT: "+ orderAmount.getTotaleOrderAmountWithVAT() + " Euro ");
		System.out.println(restaurant.getName() + " in " + restaurant.getAddress());*/
		
		stringBuilder.append("----------------------------------------------------")
		.append("The price of the order is")
		.append("SUB TOTAL: ")
		.append(orderAmount.getTotaleOrderAmount())
		.append(" Euro ");
		stringBuilder.append("VAT")
		.append(vatRate).append(": ")
		.append( orderAmount.getTotaleOrderAmountVAT())
		.append("Euro ").append(System.lineSeparator())
		.append("Totali: " + orderAmount.getTotaleOrderAmountWithVAT() + "Euro ").append(System.lineSeparator())
		.append(restaurant.getName()  + " in " + restaurant.getAddress());
		System.out.println(stringBuilder);
		
	}
	
}
