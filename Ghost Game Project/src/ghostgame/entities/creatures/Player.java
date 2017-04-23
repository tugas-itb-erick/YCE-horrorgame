package ghostgame.entities.creatures;

import ghostgame.Handler;
import ghostgame.inventory.Inventory;

public class Player extends Creature {
	
	private boolean hasCandle;
	private boolean hasWeapon;
	private int sightX;
	private int sightY;
	private Inventory inventory;
	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		bounds.x = 22;
		bounds.y = 44;
		bounds.width = 19;
		bounds.height = 19;
		
		inventory = new Inventory(handler);
		hasCandle = false; // will change to = inv.contains(candle) n weapon
		hasWeapon = false;
		sightX = 2; //4,3 3,2 2,1
		sightY = 1;
	}
	
	@Override
	public void die(){
		System.out.println("You lose");
		
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	
	public void checkCandle() {
		// if inventory contains candle then setsight x and y
	}

	public int getSightX() {
		return sightX;
	}

	public void setSightX(int sightX) {
		this.sightX = sightX;
	}

	public int getSightY() {
		return sightY;
	}

	public void setSightY(int sightY) {
		this.sightY = sightY;
	}
}
