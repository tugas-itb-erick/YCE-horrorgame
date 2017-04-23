package ghostgame.entities.creatures;

import java.util.Iterator;

import ghostgame.Handler;
import ghostgame.entities.Entity;
import ghostgame.entities.statics.StaticEntity;
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
	
	@Override
	public void move() {
		if(!checkEntityCollisions(xMove, 0f))
			moveX();
		if(!checkEntityCollisions(0f, yMove))
			moveY();
	}
	
	@Override
	public boolean checkEntityCollisions(float xOffset, float yOffset) {
		Iterator<Entity> it = handler.getWorld().getEntityManager().getEntities().iterator();
		while(it.hasNext()){
			Entity e = it.next();
			if (e.equals(this))
				continue;
			if (e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset))){
				if (e instanceof Ghost) {
					hurt(((Ghost) e).getAtk()); // player get hurt by ghost
					it.remove(); // ghost died when collide player
				}
				return true;
			}
		}
		return false;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	
	public void checkCandle() {
		// if inventory contains candle then set sight x and y
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
