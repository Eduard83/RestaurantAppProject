package org.makerminds.jcoaching.restaurantapp.controller.table;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.makerminds.jcoaching.restaurantapp.model.table.Table;

public class TableReservationManager {
	
	private Map<Integer, List<LocalDateTime>> reservationMap = new HashMap<>();
	List<Table> availableTables = null;
	
	public TableReservationManager(List<Table> tableList) {
		availableTables = tableList;
		 initializeTableReservations(availableTables);
	}
	
	private void initializeTableReservations(List<Table> tableList) {
		for(Table table : tableList) {
			int tableId = table.getTableId();
			List<LocalDateTime> reservations = new ArrayList<>();
			reservationMap.put(tableId, reservations);
			
		}
	}
	
	public List<LocalDateTime> getTableReservationByTableId(int tableIdToReserve){
		
		Table tableToReserve = getTableByTableId(tableIdToReserve, availableTables);
		tableToReserve = getTableByTableId(tableIdToReserve, availableTables);
		if(tableToReserve == null) {
			System.out.println("Table with id : " + tableIdToReserve + " was not found");
		}else {
			System.out.println("Table with id : " + tableIdToReserve + " was found");
			return reservationMap.get(tableToReserve);
		}
		return new ArrayList<>();
	}
	
	private Table getTableByTableId(int tableIdToReserve, List<Table> tablesList) {
		
		for(Table table : tablesList) {
			if(table.getTableId() ==  tableIdToReserve)
				return table;
		}
		
		return null;
	}
	
	public void addReservation(int tableId, LocalDateTime reservationDateTime) {
		reservationMap.putIfAbsent(tableId, new ArrayList<>());
		List<LocalDateTime> currentReservations = reservationMap.get(tableId);
		currentReservations.add(reservationDateTime);
		reservationMap.put(tableId, currentReservations);
		
	}
	
	public boolean isTableFreeAt(int tableId, LocalDateTime checkDateTime) {
		List<LocalDateTime> reservations = reservationMap.get(tableId);
		return reservations == null || !reservations.contains(checkDateTime);
	}
	
	
	
	
	
	
}
