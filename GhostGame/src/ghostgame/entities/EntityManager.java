package ghostgame.entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import ghostgame.Handler;
import ghostgame.entities.creatures.Player;
import ghostgame.entities.statics.Rock;

public class EntityManager {
	
	private Handler handler;
	private Player player;
	private ArrayList<Entity> entities;
	private Comparator<Entity> renderSorter = new Comparator<Entity>(){
		@Override
		public int compare(Entity a, Entity b) {
			return (int) ((a.getY() + a.getHeight()) - (b.getY() + b.getHeight()));
		}
	};
	
	public EntityManager(Handler handler, Player player){
		this.handler = handler;
		this.player = player;
		entities = new ArrayList<Entity>();
		addEntity(player);
	}
	
	public void tick(){
		Iterator<Entity> it = entities.iterator();
		while(it.hasNext()){
			Entity e = it.next();
			EntityController ec;
			if (e instanceof Player)
				ec = new PlayerController(e, new PlayerView());
			else if (e instanceof Rock)
				ec = new RockController(e, new RockView());
			else //if (e instanceof Rock)
				ec = new TreeController(e, new TreeView());
			else
			ec.tick();
			if(!ec.isActive())
				it.remove();
		}
		entities.sort(renderSorter);
	}
	
	public void render(Graphics g){
		for(Entity e : entities){
			e.render(g);
		}
		player.postRender(g);
	}
	
	public void addEntity(Entity e){
		entities.add(e);
	}
	
	public void deleteEntity(Entity e){
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
