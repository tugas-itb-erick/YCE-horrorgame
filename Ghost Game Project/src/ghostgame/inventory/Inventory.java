package ghostgame.inventory;

import ghostgame.Handler;

import ghostgame.items.Item;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * File : Inventory.java
 * Kelas Inventory merupakan kelas real yang merepresentasikan 
 * inventory dan interaksinya.
 * @author Catherine Almira - 13515111
 */

public class Inventory {

	private Handler handler;
	private boolean active = false;
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
   * Menambah Item pada inventory.
   * @param item yang ingin ditambah pada inventory.
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
   * Mengurangi Item pada inventory.
   * @param item yang ingin dikurangi dari inventory.
   */
	
	public void removeItem(Item item){
		for(Iterator<Item> it = inventoryItems.iterator(); it.hasNext(); ){
			Item i = it.next();
			if (i.getId() == item.getId())
				i.setCount(i.getCount() - 1);
				if (i.getCount() <= 0)
					it.remove();
		}
	}
	
	/**
	 * Mengembalikan true bila item bernama name ada di dalam inventory.
	 * @param name nama item yang dicari di inventory.
	 * @return true apabila item bernama name ditemukan dalam inventory.
	 */
	
	public boolean containItem(String name) {
		for(Item i : inventoryItems){
			if(i.getName() == name){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Mengembalikan true bila item ada di dalam inventory.
	 * @param item item yang dicari di inventory.
	 * @return true apabila itemditemukan dalam inventory.
	 */
	
	public boolean containItem(Item item) {
		for(Item i : inventoryItems){
			if(i.getName() == item.getName()){
				return true;
			}
		}
		return false;
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
