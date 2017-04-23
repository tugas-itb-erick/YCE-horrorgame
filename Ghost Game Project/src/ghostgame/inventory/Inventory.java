package ghostgame.inventory;

import ghostgame.Handler;

import ghostgame.items.Item;

import java.util.ArrayList;

/**
 * File : Inventory.java
 * Kelas Inventory merupakan kelas real yang merepresentasikan 
 * inventory dan interaksinya.
 * @author Catherine Almira - 13515111
 */

public class Inventory {

	private Handler handler;
	private boolean active = false;
	private Item activeItem;
	private ArrayList<Item> inventoryItems;
	
	private int selectedItem = 0;
	
  /**
   * Constructor dengan parameter.
   * @param handler nilai handler dari inventory.
   */
	
	public Inventory(Handler handler){
		this.handler = handler;
		inventoryItems = new ArrayList<Item>();
	}
	
  /**
   * Mengembalikan nilai handler.
   * @return handler.
   */
	
	public void addItem(Item item){
		for(Item i : inventoryItems){
			if(i.getId() == item.getId()){
				i.setCount(i.getCount() + item.getCount());
				return;
			}
		}
		inventoryItems.add(item);
	}
	
  /**
   * Mengembalikan nilai handler.
   * @return handler.
   */

	public Handler getHandler() {
		return handler;
	}

	/**
	 * Mengubah nilai handler.
	 * @param handler.
	 */

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	/**
	 * Mengembalikan status inventory apakah aktif atau tidak.
	 * @return true jika inventory aktif.
	 */

	public Item getActiveItem() {
		return activeItem;
	}

	/**
	 * I.S. activeItem sembarang.
	 * F.S. activeItem terdefinisi sesuai dengan activeItem yang baru.
	 * @param activeItem nilai activeItem yang baru.
	 */

	public void setActiveItem(Item activeItem) {
		this.activeItem = activeItem;
	}

	/**
	 * Mengembalikan list item.
	 * @return list item.
	 */

	public ArrayList<Item> getInventoryItems() {
		return inventoryItems;
	}

	/**
	 * Mengubah list item.
	 * @param inventoryItems list item yang baru.
	 */

	public void setInventoryItems(ArrayList<Item> inventoryItems) {
		this.inventoryItems = inventoryItems;
	}

	/**
	 * Mengembalikan indeks selectedItem.
	 * @return indeks selectedItem.
	 */

	public int getSelectedItem() {
		return selectedItem;
	}

	/**
	 * Mengubah nilai selectedItem.
	 * @param selectedItem nilai selectedItem yang baru.
	 */

	public void setSelectedItem(int selectedItem) {
		this.selectedItem = selectedItem;
	}

	/**
	 * Mengembalikan status inventory (aktif atau tidak).
	 * @return true jika inventory aktif (bisa diakses player).
	 */

	public boolean isActive() {
		return active;
	}

	/**
	 * Mengubah nilai keaktifan inventory.
	 * @param active status keaktifan inventory.
	 */

	public void setActive(boolean active) {
		this.active = active;
	}
}
