package org.makerminds.jcoaching.restaurantapp.controller.table;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.makerminds.jcoaching.restaurantapp.model.table.Table;


public class TablePrinter {
	
	public void printTableReservations(int tableIdToReserve, List<LocalDateTime> tableReservations) {
		if(tableReservations.isEmpty()) {
			System.out.println("No reservation was found. Table with ID: " + tableIdToReserve + " is available for booking at any time");
		}else {
			System.out.println("Existing resrvation for table with ID: " + tableIdToReserve);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD HH:mm");
			System.out.println("-------------------------------------------------------");
			for(LocalDateTime tableReservation : tableReservations) {
				String formattedDateTime = tableReservation.format(formatter);
				System.out.println(formattedDateTime);
			}
			

			System.out.println("-------------------------------------------------------");
		}
	}
	
	public TablePrinter() {
		
	}
	
	public void printerTableList(List<Table> tableList) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Table list: ").append(System.lineSeparator())
		.append("----------------------------------------").append(System.lineSeparator())
		.append("TableId\t\tTableSeats").append(System.lineSeparator())
		.append("----------------------------------------").append(System.lineSeparator());
		
		for(Table table : tableList) {
			stringBuilder.append(table.getTableId()).append("\t\t").append(table.getTableSeats()).append(System.lineSeparator());
		}
		
		stringBuilder.append("-----------------------------------------");
		System.out.println(stringBuilder);
	}

}
