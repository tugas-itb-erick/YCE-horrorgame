package ghostgame.inventory;

import ghostgame.items.Item;

import java.awt.Graphics;

import java.awt.event.KeyEvent;

/**
  * File : InventoryController.java
  * Kelas InventoryController merupakan kelas real yang merepresentasikan 
  * inventory dan interaksinya.
  * @author Catherine Almira - 13515111
  */

public class InventoryController {

  private Inventory inventory;
  private InventoryView view;
  
  public InventoryController(Inventory inventory, InventoryView view) {
    this.inventory = inventory;
    this.view = view;
  }
  
  /**
    * Mengupdate kondisi objek Inventory untuk setiap satuan waktu.
    */

  public void tick() {
    if(inventory.getHandler().getKeyManager().keyJustPressed(KeyEvent.VK_E)) {
      inventory.setActive(!inventory.isActive());
    }
    if(inventory.isActive()) {
      if(inventory.getHandler().getKeyManager().keyJustPressed(KeyEvent.VK_W)) {
      	inventory.setSelectedItem(inventory.getSelectedItem() - 1);
      }
      if(inventory.getHandler().getKeyManager().keyJustPressed(KeyEvent.VK_S)) {
        inventory.setSelectedItem(inventory.getSelectedItem() + 1);
      }
      if(inventory.getSelectedItem() < 0) {
      	inventory.setSelectedItem(inventory.getInventoryItems().size() - 1);
      } else if(inventory.getSelectedItem() >= inventory.getInventoryItems().size()) {
      	inventory.setSelectedItem(0);
      }
    }
  }
  
  /**
    * Menambahkan item ke dalam inventory.
    * @param item yang ingin ditambahkan.
    */

  public void addItem(Item item) {
    for(Item i : inventory.getInventoryItems()) {
      if(i.getId() == item.getId()) {
        i.setCount(i.getCount() + item.getCount());
        return;
      }
    }
    inventory.getInventoryItems().add(item);
    inventory.setSelectedItem(inventory.getInventoryItems().size() - 1);
    inventory.setActiveItem(inventory.getInventoryItems().get(inventory.getSelectedItem()));
  }
  
  /**
    * Menampilkan gambar inventory.
    * @param g grafik yang akan ditampilkan sebagai inventory.
    */

  public void render(Graphics g) {
    view.render(inventory, g);
  }
  
}
