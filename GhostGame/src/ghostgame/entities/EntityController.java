package ghostgame.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import ghostgame.Handler;

public abstract class EntityController {

	protected Entity entity;
	protected EntityView view;
	
	public EntityController(Entity entity, EntityView view) {
		this.entity = entity;
		this.view = view;
	}
	
	public boolean checkEntityCollisions(float xOffset, float yOffset){
		for(Entity e : entity.getHandler().getWorld().getEntityManager().getEntities()){
			if(e.equals(this))
				continue;
			if(e.getCollisionBounds(0f, 0f).intersects(entity.getCollisionBounds(xOffset, yOffset)))
				return true;
		}
		return false;
	}
	
	public void render(Graphics g) {
		view.render(entity, g);
	}
	
	public abstract void tick();
	
	public abstract void die();
	
	public void hurt(int amt){
		entity.setHealth(entity.getHealth() - amt);
		if(entity.getHealth() <= 0){
			entity.setActive(false);
			die();
		}
	}
	
	public Rectangle getCollisionBounds(float xOffset, float yOffset){
		return entity.getCollisionBounds(xOffset, yOffset);
	}

	public float getX() {
		return entity.getX();
	}

	public void setX(float x) {
		entity.setX(x);
	}

	public float getY() {
		return entity.getY();
	}

	public void setY(float y) {
		entity.setY(y);
	}

	public int getWidth() {
		return entity.getWidth();
	}

	public void setWidth(int width) {
		entity.setWidth(width);
	}

	public int getHeight() {
		return entity.getHealth();
	}

	public void setHeight(int height) {
		entity.setHeight(height);
	}

	public int getHealth() {
		return entity.getHealth();
	}

	public void setHealth(int health) {
		entity.setHealth(health);
	}

	public boolean isActive() {
		return entity.isActive();
	}

	public void setActive(boolean active) {
		entity.setActive(active);
	}

	public Handler getHandler() {
		return entity.getHandler();
	}
}
