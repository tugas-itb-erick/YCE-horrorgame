/**
  * File : Inventory.java
  * Kelas Inventory adalah kelas yang merepresentasikan tempat penyimpanan
  * barang yang dibawa oleh Player.
  * @author Catherine Almira - 13515111
  */

public class Inventory {
  private boolean active = false;
  private ArrayList<Item> inventoryItems;
  private int selectedItem = 0;
  
  /**
    * Constructor tanpa parameter.
    * Menciptakan objek Inventory.
    */

  public Inventory() {
  	inventoryItems = new ArrayList<Item>();
  }

  /**
    * I.S. Inventory terdefinisi dan tidak penuh.
    * F.S. Menambahkan item ke dalam inventory.
    * @param item objek yang akan ditambahkan ke dalam inventory.
    */

  public void addItem(Item item) {
  	inventoryItems.add(item);
  }

  /**
    * Mengembalikan status keaktifan.
    */
  
  public boolean isActive() {
  	return active;
  }
}