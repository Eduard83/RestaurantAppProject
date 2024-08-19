package org.makerminds.jcoaching.restaurantapp.model.table;

import java.util.ArrayList;
import java.util.List;

public class TableProvider {
	
	private List<Table> tableList;
	
	public TableProvider() {
		createTableList();
	}
	
	private void createTableList() {
		
		//
		tableList = new ArrayList<>();
		Table table1 = new Table(100,2);
		Table table2 = new Table(101,3);
		Table table3 = new Table(102,4);
		Table table4 = new Table(201,5);
		Table table5 = new Table(202,6);
		Table table6 = new Table(203,7);
		
		tableList.add(table1);
		tableList.add(table2);
		tableList.add(table3);
		tableList.add(table4);
		tableList.add(table5);
		tableList.add(table6);	
	}
	
	public List<Table> getTableList(){
		return tableList;
	}

}
