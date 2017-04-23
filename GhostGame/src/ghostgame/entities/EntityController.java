package ghostgame.entities;

import java.awt.Graphics;

public abstract class EntityController {

	private Entity entity;
	private EntityView view;
	
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
}
