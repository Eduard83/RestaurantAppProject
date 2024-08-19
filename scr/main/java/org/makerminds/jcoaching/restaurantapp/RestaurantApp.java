package org.makerminds.jcoaching.restaurantapp;

import org.makerminds.jcoaching.restaurantapp.controller.MenuPrinter;
import org.makerminds.jcoaching.restaurantapp.controller.order.IOrderCalculator;
import org.makerminds.jcoaching.restaurantapp.controller.order.OrderCalculatorGER;
import org.makerminds.jcoaching.restaurantapp.controller.order.OrderCalculatorKS;
import org.makerminds.jcoaching.restaurantapp.controller.order.OrderProcessor;
import org.makerminds.jcoaching.restaurantapp.controller.table.TablePrinter;
import org.makerminds.jcoaching.restaurantapp.controller.table.TableReservationManager;
import org.makerminds.jcoaching.restaurantapp.enums.ApplicationMode;
import org.makerminds.jcoaching.restaurantapp.enums.Location;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import org.makerminds.jcoaching.restaurantapp.model.table.TableProvider;
import org.makerminds.jcoaching.restaurantapp.model.table.Table;
import org.makerminds.jcoaching.restaurantapp.controller.LocationManager;
import org.makerminds.jcoaching.restaurantapp.controller.MenuImporter;
import org.makerminds.jcoaching.restaurantapp.model.Client;
import org.makerminds.jcoaching.restaurantapp.model.Menu;
import org.makerminds.jcoaching.restaurantapp.model.Restaurant;

public class RestaurantApp {

	private static Location currentLocation;
	private static int tableId;
	private static Scanner scanner = new Scanner(System.in);

	private static TableProvider tableProvider = new TableProvider();
	private static List<Table> tableList = tableProvider.getTableList();
	private static TableReservationManager tableReservationManager = new TableReservationManager(tableList);
	
	private static final String MENU_FILE_PATH = "/menu-file.txt";

	public static void main(String[] args) {
    	ApplicationMode applicationMode;
    	try {
    		do {
    			applicationMode = getApplicationMode();
    			if(applicationMode == ApplicationMode.ORDER) {
    				getCurrentLocation();
    		}
    		validateApplicationMode(applicationMode);
    	}while (applicationMode != ApplicationMode.EXIT);
    		
    	}catch(Exception exeption) {
    		exeption.printStackTrace();
    	}finally {
    		scanner.close();
    	}
    }

	private static void validateApplicationMode(ApplicationMode applicationMode) {

		switch (applicationMode) {
		case ORDER:
			runOrderProcess();
			break;
		case TABLERESERVATION:
			tableReservation();
			break;
		case EXIT: {
			System.err.println("The application hes stopped. Thank you for using our app");
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + (applicationMode));
		}
	}

	private static ApplicationMode getApplicationMode() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Please select an application mode (type number):")
		.append(System.lineSeparator())
		.append("1. " + ApplicationMode.ORDER.name())
		.append(System.lineSeparator())
		.append("2. " + ApplicationMode.TABLERESERVATION.name())
		.append(System.lineSeparator())
		.append("3. " + ApplicationMode.EXIT.name());
		System.out.println(stringBuilder);
		int selectedApplicationModeId = scanner.nextInt();
		ApplicationMode selectedApplicationMode = getApplicationModeFromId(selectedApplicationModeId);
		return selectedApplicationMode;
	}

	private static Location getCurrentLocation() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Please select an application mode (type number):")
				.append(System.lineSeparator())
				.append("1. " + Location.KOSOVO.name())
				.append(System.lineSeparator())
				.append("2. " + Location.GERMANY.name())
				.append(System.lineSeparator());
		System.out.println(stringBuilder);
		int selectedApplicationModeId = scanner.nextInt();
		currentLocation = LocationManager.getLocationFormId(selectedLocationId);
		return currentLocation;
	}

	private static ApplicationMode getApplicationModeFromId(int selectedApplicationModeId) {
		switch (selectedApplicationModeId) {
		case 1: {
			return ApplicationMode.ORDER;
		}
		case 2: {
			return ApplicationMode.TABLERESERVATION;
		}
		case 3: {
			return ApplicationMode.EXIT;
		}
		default:
			throw new IllegalArgumentException("Invalid order application");
		}
	}

	private static void runOrderProcess() {

		Restaurant restaurant = new Restaurant("Route 66", "Te Heroinat, Prishtine");
		Client client = new Client("Filan Fisteku", "+383123456");
		
		// Object for menuImporter
		MenuImporter menuImporter = new MenuImporter();
		
		// Object for menu class
		Menu menu = menuImporter.importMenu(MENU_FILE_PATH);
		//
		MenuPrinter menuPrinter = new MenuPrinter();
		menuPrinter.printmenu(menu);
		
		OrderProcessor orderProcessor = new OrderProcessor();
		orderProcessor.processOrder(menu, restaurant, client, currentLocation);

	}

	private static void tableReservation() {

		TablePrinter tablePrinter = new TablePrinter();
		tablePrinter.printerTableList(tableList);
		boolean tableWasFound = false;
		tableId = getTableIdFromUser();

		List<LocalDateTime> tableReservations = tableReservationManager.getTableReservationByTableId(tableId);
		tablePrinter.printTableReservations(tableId, tableReservations);

		LocalDateTime reservationLocalDateTime = getReservationDateTimeFromUser();
		boolean isTableFree = tableReservationManager.isTableFreeAt(tableId, reservationLocalDateTime);
		if (isTableFree) {
			tableReservationManager.addReservation(tableId, reservationLocalDateTime);
			System.out.println("Table with ID: " + tableId + " has been reserved for " + reservationLocalDateTime);
		} else {
			System.out.println(
					"The table with ID: " + tableId + " has already been reserved at " + reservationLocalDateTime);
		}

		for (Table table : tableList) {
			if (table.getTableId() == tableId) {
				tableWasFound = true;
			}
		}
		if (tableWasFound) {
			System.out.println("The table with id " + tableId + " was found and reserved");
		} else {
			System.out.println("Table was not found");
		}

	}

	private static LocalDateTime getReservationDateTimeFromUser() {
		System.out.println("Please enter the date and time (YYYY-MM-DD HH:mm)");
		String input = scanner.nextLine();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("YYYY-MM-DD HH:mm");
		return LocalDateTime.parse(input, dateTimeFormatter);
	}

	private static int getTableIdFromUser() {
		System.out.println("Please enter the table ID: ");
		int selectedId = scanner.nextInt();
		scanner.nextLine();
		return selectedId;
	}

	private static IOrderCalculator getOrderCalculator(Location currentlocatiom) {
		switch (currentLocation) {
		case KOSOVO:
			return new OrderCalculatorKS();
		case GERMANY:
			return new OrderCalculatorGER();
		default:
			throw new IllegalArgumentException("Invalid location");
		}
	}

}
