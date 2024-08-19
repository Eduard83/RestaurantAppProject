package org.makerminds.jcoaching.restaurantapp.controller.order;

import org.makerminds.jcoaching.restaurantapp.enums.Location;

public class OrderCalculatorFactory {
	
	public static IOrderCalculator getOrderCalculator(Location location) {
		switch (location) {
		case KOSOVO: {
			return new OrderCalculatorKS();
		}
		case GERMANY: {
			return new OrderCalculatorGER();
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + location);
		}	
	}
}
