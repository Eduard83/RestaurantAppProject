package org.makerminds.jcoaching.restaurantapp.model.table;

public class Table {
	
	private int tableId;
	private int tableSeats;
	
	public Table(int tableId, int tableSeats) {
		
		//
		this.tableId = tableId;
		setTableSeats(tableSeats);
	}

	public int getTableId() {
		return tableId;
	}
	
	public void setTableId(int tableId) {
		this.tableId = tableId;
	}
	
	public int getTableSeats() {
		return tableSeats;
	}

	public void setTableSeats(int tableSeats) {
		this.tableSeats = tableSeats;
	}
	

}
