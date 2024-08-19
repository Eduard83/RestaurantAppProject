package org.makerminds.jcoaching.restaurantapp.controller.order;

import org.makerminds.jcoaching.restaurantapp.enums.Location;
import org.makerminds.jcoaching.restaurantapp.model.Client;
import org.makerminds.jcoaching.restaurantapp.model.Menu;
import org.makerminds.jcoaching.restaurantapp.model.Restaurant;
import org.makerminds.jcoaching.restaurantapp.model.order.Order;
import org.makerminds.jcoaching.restaurantapp.model.order.OrderAmount;

public class OrderProcessor {
	
	public void processOrder(Menu menu, Restaurant restaurant, Client client, Location location) {
		OrderManager orderManager = new OrderManager();
    	Order order = orderManager.createOrder(menu);
    	orderManager.getOrders().add(order);
    	
    	 IOrderCalculator orderCalculator = OrderCalculatorFactory.getOrderCalculator(location);
    	 int vatRate = (int)orderCalculator.getVATRate(false);
         OrderAmount orderAmount  =  orderCalculator.calculateOrderAmount(order);
         OrderPrinter orderPrinter = new OrderPrinter();
         orderPrinter.printOrderInfo(restaurant, client, order, orderAmount, vatRate);
    
    }

}
