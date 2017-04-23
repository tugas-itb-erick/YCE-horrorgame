package ghostgame.items;

import java.awt.Rectangle;

import ghostgame.Handler;

public class Item {
	
	// Static Instances
	public static Item[] items = new Item[50];
	public static Item woodItem = new Item("Wood", 0);
	public static Item rockItem = new Item("Rock", 1);
	
	// Class Body
	private static final int ITEMWIDTH = 32, ITEMHEIGHT = 32;
	
	private Handler handler;
	private String name;
	private final int id;
	
	private Rectangle bounds;
	
	private int x, y, count;
	private int width, heigth;
	private boolean pickedUp = false;
	
	public Item(String name, int id) {
		this.name = name;
		this.id = id;
		count = 1;
		
		width = ITEMWIDTH;
		heigth = ITEMHEIGHT;
		
		bounds = new Rectangle(x, y, width, heigth);
		items[id] = this;
	}
	
	public Item(String name, int id, int width, int height) {
		this.name = name;
		this.id = id;
		count = 1;
		
		bounds = new Rectangle(x, y, width, heigth);
		items[id] = this;
	}
	
	public Item createNew(int count) {
		Item i = new Item(name, id);
		i.setPickedUp(true);
		i.setCount(count);
		return i;
	}
	
	public Item createNew(int x, int y) {
		Item i = new Item(name, id);
		i.setPosition(x, y);
		return i;
	}
	
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
		bounds.x = x;
		bounds.y = y;
	}
	
	// Getters and Setters
	
	public Handler getHandler() {
		return handler;
	}

	public void setPickedUp(boolean pickedUp) {
		this.pickedUp = pickedUp;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getId() {
		return id;
	}

	public boolean isPickedUp() {
		return pickedUp;
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}

	public int getWidth() {
		return width;
	}

	public int getHeigth() {
		return heigth;
	}
}
