package org.makerminds.jcoaching.restaurantapp.controller.test;

import java.util.HashMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.makerminds.jcoaching.restaurantapp.controller.MenuImporter;
import org.makerminds.jcoaching.restaurantapp.model.Menu;
import org.makerminds.jcoaching.restaurantapp.model.product.Product;

public class MenuImporterTest {
	
	private MenuImporter menuImporter;
	private final String MENU_FILE_PATH = "/menu-file.txt";
	
	// Testing
	@Test
	public void testImportmenu() {
		menuImporter = new MenuImporter();
		Menu importedMenu = menuImporter.importMenu(MENU_FILE_PATH);
		HashMap<Integer, Product> menuItems = importedMenu.getMenuItems();
		Assertions.assertEquals(8,menuItems.size());
		
	}

}
