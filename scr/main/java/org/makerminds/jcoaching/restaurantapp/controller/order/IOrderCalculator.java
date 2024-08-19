package org.makerminds.jcoaching.restaurantapp.controller.order;

import org.makerminds.jcoaching.restaurantapp.model.order.Order;
import org.makerminds.jcoaching.restaurantapp.model.order.OrderAmount;
import org.makerminds.jcoaching.restaurantapp.model.order.OrderItem;
import org.makerminds.jcoaching.restaurantapp.model.order.OrderItemSize;

public interface IOrderCalculator {
	
	public OrderAmount calculateOrderAmount(Order order);
	public double calculateTotalOrderAmount(Order order);
	public double calculateTotalOrderAmountVAT(double totalOrderAmount);
	public double calculateOrderItemPrice(OrderItem orderItem);
	public double getSizeRateAmount(OrderItemSize size);
	public double getVATRate();
	public double getVATRate(boolean decimal);
	
	
	
	
}
