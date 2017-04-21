package ghostgame.items;

import java.awt.Graphics;

import ghostgame.inventory.InventoryController;
import ghostgame.inventory.InventoryView;

public class ItemController {
	
	private Item item;
	private ItemView view;
	
	public ItemController(Item item, ItemView view) {
		this.item = item;
		this.view = view;
	}
	
	public void tick(){
		if(item.getHandler().getWorld().getEntityManager().getPlayer().getCollisionBounds(0f, 0f).intersects(item.getBounds())){
			item.setPickedUp(true);
			InventoryController ic = new InventoryController(item.getHandler().getWorld().getEntityManager().getPlayer().getInventory(), new InventoryView());
			ic.addItem(item);
		}
	}
	
	public Item createNew(int count){
		Item i = new Item(item.getTexture(), item.getName(), item.getId());
		i.setPickedUp(true);
		i.setCount(count);
		return i;
	}
	
	public Item createNew(int x, int y){
		Item i = new Item(item.getTexture(), item.getName(), item.getId());
		i.setPosition(x, y);
		return i;
	}
	
	public void render(Graphics g) {
		view.render(item, g);
	}
	
	public void render(Graphics g, int x, int y) {
		view.render(item, g, x, y);
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
	public boolean isItemPickedUp() {
		return item.isPickedUp();
	}
	
}
