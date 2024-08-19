package org.makerminds.jcoaching.restaurantapp.controller;

import org.makerminds.jcoaching.restaurantapp.enums.Location;

public class LocationManager {
	
	public static Location getLocationFormString(String locationAsString) {
		for(Location location :Location.values()) {
			if(location.name().equals(locationAsString)) {
				return location;
		}
	
		}
		throw new IllegalArgumentException("Invalid location");
	}

}
