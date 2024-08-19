package org.makerminds.jcoaching.retaurantapp.controlle.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.makerminds.jcoaching.restaurantapp.controller.order.AbstractOrderCalculator;
import org.makerminds.jcoaching.restaurantapp.model.Menu;
import org.makerminds.jcoaching.restaurantapp.model.order.OrderItem;
import org.makerminds.jcoaching.restaurantapp.model.order.OrderItemSize;
import org.makerminds.jcoaching.restaurantapp.model.product.Meal;

public class AbstractOrderCalculatorTest {
	
	Menu menu = new Menu();
	
	AbstractOrderCalculator abstractOrderCalculatorMock = new AbstractOrderCalculator() {
		
		@Override
		public double getVATRate() {
			//
			return 0.12;
		}
		@Override
		public double getSizeRateAmount(OrderItemSize size) {
			//
			return 1;
		}
		
	};
	@Test
	public void calculateOrderItemPriceTest() {
		//
		Meal hamburger = (Meal) menu.getMenuItems().get(100);
		OrderItem orderItem = new OrderItem(hamburger, 2, OrderItemSize.MEDIUM);
		
		double totalOrderItemPrice = abstractOrderCalculatorMock.calculateOrderItemPrice(orderItem);
		Assertions.assertEquals(9, totalOrderItemPrice);
		Assertions.assertEquals(4.5, orderItem.getOrderItemPrece());
	}
	

}
