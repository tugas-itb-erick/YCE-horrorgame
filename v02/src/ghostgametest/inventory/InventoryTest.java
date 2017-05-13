package ghostgametest.inventory;

import static org.junit.Assert.assertFalse;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ghostgame.Handler;
import ghostgame.inventory.Inventory;
import ghostgame.items.Item;

public class InventoryTest {
  Handler handler = new Handler(null);
  Inventory inventory = new Inventory(handler);
	Item item = new Item("Bed", 0);
	
  @Test
	public void testAddItem() {
		inventory.addItem(item);
		assertTrue(inventory.containItem(item));
	}

	@Test
	public void testRemoveItem() {
		inventory.addItem(item);
		inventory.removeItem(item);
		assertFalse(inventory.containItem(item));
	}

	@Test
	public void testContainItemString() {
		inventory.addItem(item);
		assertTrue(inventory.containItem("Bed"));
	}

	@Test
	public void testContainItemItem() {
		inventory.addItem(item);
		assertTrue(inventory.containItem(item));
	}

	@Test
	public void testGetInventoryItems() {
	  
		inventory.getInventoryItems();
	}

	@Test
	public void testIsActive() {
		assertFalse(inventory.isActive());
	}

	@Test
	public void testSetActive() {
		inventory.setActive(true);
		assertTrue(inventory.isActive());
	}

}
