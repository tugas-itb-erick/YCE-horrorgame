package ghostgame.items;

import java.awt.Graphics;

import ghostgame.Handler;
import ghostgame.inventory.InventoryController;
import ghostgame.inventory.InventoryView;

/**
 * File : ItemController.java 
 * Kelas ItemController merupakan kelas yang merepresentasikan interaksi
 * barang-barang yang terdapat dalam permainan.
 * @author Catherine Almira - 13515111
 */

public class ItemController {
	
	private Item item;
	private ItemView view;
	
	/**
	 * Constructor dengan parameter.
	 * @param item model item.
	 * @param view view item.
	 */
	
	public ItemController(Item item, ItemView view) {
		this.item = item;
		this.view = view;
	}
	
	/**
	 * Menyatakan pergerakan permainan pada setiap sataun waktu.
	 */
	
	public void tick(){
		if(item.getHandler().getWorld().getEntityManager().getPlayer().getCollisionBounds(0f, 0f).intersects(item.getBounds())){
			item.setPickedUp(true);
			InventoryController ic = new InventoryController(item.getHandler().getWorld().getEntityManager().getPlayer().getInventory(), new InventoryView());
			ic.addItem(item);
		}
	}
	
	/**
	 * Menciptakan item yang baru.
	 * @param count jumlah item yang akan dibuat.
	 * @return item yang baru dibuat.
	 */
	
	public Item createNew(int count){
		Item i = new Item(item.getName(), item.getId());
		i.setPickedUp(true);
		i.setCount(count);
		return i;
	}
	
	/**
	 * Menciptakan item yang baru.
	 * @param x posisi dalam koordinat x.
	 * @param y posisi dalam koordinat y.
	 * @return item yang baru dibuat.
	 */
	
	public Item createNew(int x, int y){
		Item i = new Item(item.getName(), item.getId());
		i.setPosition(x, y);
		return i;
	}
	
	/**
	 * Menggambar item ke layar.
	 * @param g grafik yang menyatakan item di layar.
	 */
	
	public void render(Graphics g) {
		view.render(item, g);
	}
	
	/**
	 * Menggambar item ke layar.
	 * @param g grafik yang menyatakan item di layar.
	 * @param x posisi dalam koordinat x.
	 * @param y posisi dalam koordinat y.
	 */
	
	public void render(Graphics g, int x, int y) {
		view.render(item, g, x, y);
	}

	/**
	 * Mengembalikan item yang sedang dikontrol.
	 * @return item yang sedang dikontrol.
	 */
	
	public Item getItem() {
		return item;
	}

	/**
	 * Mengubah item yang sedang dikontrol.
	 * @param item yang baru dikontrol.
	 */
	
	public void setItem(Item item) {
		this.item = item;
	}
	
	/**
	 * Mengembalikan status keterambilan Item.
	 * @return status keterambilan Item.
	 */
	
	public boolean isItemPickedUp() {
		return item.isPickedUp();
	}
	
	/**
	 * Mengubah handler yang merupakan penghubung antara world dengan item.
	 * @param handler nilai yang menghubungkan world dengan item.
	 */
	
	public void setHandler(Handler handler) {
		item.setHandler(handler);
	}
}
