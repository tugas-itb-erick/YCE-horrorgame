package ghostgame.items;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import ghostgame.Handler;

public class ItemManager {
	
	private Handler handler;
	private ArrayList<Item> items;
	
	public ItemManager(Handler handler){
		this.handler = handler;
		items = new ArrayList<Item>();
	}
	
	public void tick(){
		Iterator<Item> it = items.iterator();
		ItemController ic = new ItemController(null, new ItemView());
		while(it.hasNext()){
			ic.setItem(it.next());
			ic.tick();
			if(ic.isItemPickedUp())
				it.remove();
		}
	}
	
	public void render(Graphics g){
		ItemController ic = new ItemController(null, new ItemView());
		for(Item i : items){
			ic.setItem(i);
			ic.render(g);
		}
	}
	
	public void addItem(Item i){
		i.setHandler(handler);
		items.add(i);
	}
	
	// Getters and Setters

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

}
