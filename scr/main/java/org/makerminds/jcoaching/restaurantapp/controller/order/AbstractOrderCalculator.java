package org.makerminds.jcoaching.restaurantapp.controller.order;

import java.util.ArrayList;
import java.util.List;

import org.makerminds.jcoaching.restaurantapp.exception.InvalidOrderItemSizeExceptions;
import org.makerminds.jcoaching.restaurantapp.model.order.Order;
import org.makerminds.jcoaching.restaurantapp.model.order.OrderAmount;
import org.makerminds.jcoaching.restaurantapp.model.order.OrderItem;
import org.makerminds.jcoaching.restaurantapp.model.order.OrderItemSize;
import org.makerminds.jcoaching.restaurantapp.model.product.Product;

public abstract class AbstractOrderCalculator implements IOrderCalculator {
	public  OrderAmount calculateOrderAmount(Order order) {
	
		double totalOrderAmount = calculateTotalOrderAmount(order);
		
		double totalOrderAmountVAT = calculateTotalOrderAmount(totalOrderAmount);
		
		double totalOrderAmountWithVAT = totalOrderAmount + totalOrderAmountVAT;
		
		OrderAmount orderAmount = new OrderAmount(totalOrderAmountVAT, totalOrderAmountVAT, totalOrderAmountWithVAT);
		
		return orderAmount;

	}
	public abstract double calculateTotalOrderAmount(double totalOrderAmount);
	
	public double calculateTotalOrderAmount(Order order) {
		
		List<OrderItem> orderItems = order.getOrderItems();
		
		double totalOrderAmount = orderItems.stream()
		
			.mapToDouble(this::calculateOrderItemPrice)
			.sum();
		
		/*for(OrderItem orderItem : orderItems) {
			totalOrderAmount += calculateOrderItemPrice(orderItem);
	}*/
		
		return totalOrderAmount;
	
	}
	public double calculateTotalOrderAmountVat(double totalOrderAmount) {
		
		return totalOrderAmount * getVATRate();
	}
	public double calculateOrderItemPrice(OrderItem orderItem) {
		//double sizeRateAmount = getSizeRateAmount(orderItem.getOrderItemSize());
		double sizeRateAmount = 1;
		
		try {
			sizeRateAmount = getSizeRateAmount(orderItem.getOrderItemSize());
		}catch(InvalidOrderItemSizeExceptions e) {
			
			System.out.println("No valid order item size for " + orderItem.getProduct().getName() + " Defautl size rate amount (100%) will be appleid. ");
		
	}
		
		Product product = orderItem.getProduct();
		double totalOrderItemPriceSingle = product.getPrice() * sizeRateAmount;
		orderItem.setOrderItemPrice(totalOrderItemPriceSingle);
		return totalOrderItemPriceSingle * orderItem.getQuantity();
	}
	
	public abstract double getSizeRateAmount(OrderItemSize size);
	public abstract double getVATRate();
	public double getVATRate(boolean decimal) {
		if(decimal) {
			return getVATRate();
		}
		else {
			return getVATRate() * 100;
		}
	}
		
}
