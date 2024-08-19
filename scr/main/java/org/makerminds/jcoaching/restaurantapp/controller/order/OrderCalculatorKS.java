package org.makerminds.jcoaching.restaurantapp.controller.order;


import org.makerminds.jcoaching.restaurantapp.exception.InvalidOrderItemSizeExceptions;

import org.makerminds.jcoaching.restaurantapp.model.order.OrderItemSize;

public  class OrderCalculatorKS extends AbstractOrderCalculator {
		
	private final double VAT_RATE = 0.18;
		
	public double getSizeRateAmount(OrderItemSize orderItemSize) {
			
			switch(orderItemSize) {
			case SMALL:
				return 0.8;
			case MEDIUM:
				return 1;
			case LARGE:
				return 1.25;
			case XXL:
				return 1.5;
				default:
					throw new InvalidOrderItemSizeExceptions("invalid order item size");
					//System.err.println("Invalid order item size");
					//return 1;
			}
		}
		
		public double getVATRate() {
			return VAT_RATE;
		}


	}
		
		
			
			
			
	
		
		
		
		
			

