package org.makerminds.jcoaching.restaurantapp.controller.order;



import org.makerminds.jcoaching.restaurantapp.model.order.OrderItemSize;
	
public  class OrderCalculatorGER extends AbstractOrderCalculator {
		private final double VAT_RATE = 0.19;
		
		public double getSizeRateAmount(OrderItemSize orderItemSize) {
			
			switch(orderItemSize) {
			case SMALL:
				return 0.85;
			case MEDIUM:
				return 1;
			case LARGE:
				return 1.3;
			case XXL:
				return 1.45;
				default:
					System.err.println("Invalid order item size");
					return 1;
			}
		}
		
		public double getVATRate() {
			return VAT_RATE;
		
	}

}
		
	
	
	
		

