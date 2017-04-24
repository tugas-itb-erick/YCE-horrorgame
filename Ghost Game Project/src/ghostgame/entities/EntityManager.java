package ghostgame.entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import ghostgame.Handler;
import ghostgame.entities.creatures.Ghost;
import ghostgame.entities.creatures.GhostController;
import ghostgame.entities.creatures.GhostView;
import ghostgame.entities.creatures.Player;
import ghostgame.entities.creatures.PlayerController;
import ghostgame.entities.creatures.PlayerView;
import ghostgame.entities.statics.StaticEntity;
import ghostgame.entities.statics.StaticEntityController;
import ghostgame.entities.statics.StaticEntityView;
import ghostgame.tiles.Tile;

public class EntityManager {
	
	private Handler handler;
	private Player player;
	private ArrayList<Entity> entities;
	private Comparator<Entity> renderSorter = new Comparator<Entity>() {
		@Override
		public int compare(Entity a, Entity b) {
			if(a.getY() + a.getHeight() < b.getY() + b.getHeight())
				return -1;
			return 1;
		}
	};
	private PlayerController pc;
	private StaticEntityController sc;
	private GhostController gc;
	
	public EntityManager(Handler handler, Player player) {
		this.handler = handler;
		this.player = player;
		entities = new ArrayList<Entity>();
		addEntity(player);
		pc = new PlayerController(player, new PlayerView());
		sc = new StaticEntityController(null, new StaticEntityView());
		gc = new GhostController(null, new GhostView());
	}
	
	public void tick(){
		Iterator<Entity> it = entities.iterator();
		while(it.hasNext()){
			Entity e = it.next();
			if (e instanceof StaticEntity) {
				sc.setStaticEntity((StaticEntity)e);
				//sc.tick();
			}else if (e instanceof Player) {
				pc.tick();
			}else if (e instanceof Ghost) {
				gc.setGhost((Ghost) e);
				gc.tick();
			}
			if(!e.isActive())
				it.remove();
		}
		
		entities.sort(renderSorter);
	}
	
	public void render(Graphics g, int xStart, int yStart, int xEnd, int yEnd) {
		for(Entity e : entities){
			//if (e.getX()/Tile.TILEWIDTH >= xStart && e.getX()/Tile.TILEWIDTH+1 < xEnd && e.getY()/Tile.TILEWIDTH >= yStart && e.getY()/Tile.TILEWIDTH+1 < yEnd)
			if (e instanceof StaticEntity) {
				sc.setStaticEntity((StaticEntity) e);
				sc.render(g);
			}else if (e instanceof Player) {
				pc.render(g);
			}else if (e instanceof Ghost) {
				gc.setGhost((Ghost) e);
				gc.render(g);
			}
		}
		pc.postRender(g);
	}
	
	public void addEntity(Entity e) {
		entities.add(e);
	}
	
	public void deleteEntity(Entity e) {
		entities.remove(e);
	}
	
	//GETTERS SETTERS

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}
}
