package ghostgame.worlds;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import ghostgame.Handler;
import ghostgame.entities.EntityManager;
import ghostgame.entities.creatures.Ghost2;
import ghostgame.entities.creatures.Player;
import ghostgame.entities.statics.StaticEntity;
import ghostgame.items.Item;
import ghostgame.items.ItemManager;
import ghostgame.tiles.Tile;
import ghostgame.tiles.TileController;
import ghostgame.tiles.TileView;

public class World {

	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;
	//Entities
	private EntityManager entityManager;
	// Item
	private ItemManager itemManager;
	
	public World(Handler handler, String path){
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 100, 100));
		itemManager = new ItemManager(handler);
		loadStaticEntity("res/worlds/staticentity.txt");
		loadItem("res/worlds/item.txt");
		// Temporary entity code!
		entityManager.addEntity(new Ghost2(handler, 64*6, 64*3));
		
		loadWorld(path);
		
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
	}
	
	public void tick(){
		itemManager.tick();
		entityManager.tick();
	}
	
	public void render(Graphics g){
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH) + entityManager.getPlayer().getSightX();
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1) - entityManager.getPlayer().getSightX();
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT) + entityManager.getPlayer().getSightY();
		int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1) - entityManager.getPlayer().getSightY();
		
		for(int y = yStart;y < yEnd;y++){
			for(int x = xStart;x < xEnd;x++){
				TileController tc = new TileController(getTile(x, y), new TileView());
				tc.render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
						(int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
		// Items
		itemManager.render(g);
		//Entities
		entityManager.render(g, xStart, yStart, xEnd, yEnd);
	}
	
	public Tile getTile(int x, int y){
		if(x < 0 || y < 0 || x >= width || y >= height)
			return Tile.floorTile;
		
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null)
			return Tile.floorTile;
		return t;
	}
	
	private void loadWorld(String path){
		StringBuilder builder = new StringBuilder();
		
		try{
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			while((line = br.readLine()) != null)
				builder.append(line + "\n");
			
			br.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		String file = builder.toString();
		String[] tokens = file.split("\\s+");
		width = Integer.parseInt(tokens[0]);
		height = Integer.parseInt(tokens[1]);
		spawnX = Integer.parseInt(tokens[2]);
		spawnY = Integer.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				tiles[x][y] = Integer.parseInt(tokens[(x + y * width) + 4]);
			}
		}
	}
	
	private void loadStaticEntity(String path) {
		try {
			Scanner sc = new Scanner(new File(path));
			while (sc.hasNext()) {
				int id = sc.nextInt();
				float x = sc.nextFloat();
				float y = sc.nextFloat();
				int kwidth = sc.nextInt();
				int kheight = sc.nextInt();
				entityManager.addEntity(new StaticEntity(handler, id, 64 * x, 64 * y, Tile.TILEWIDTH * kwidth, Tile.TILEHEIGHT * kheight));
			}
			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void loadItem(String path) {
		try {
			Scanner sc = new Scanner(new File(path));
			while (sc.hasNext()) {
				int id = sc.nextInt();
				int x = sc.nextInt();
				int y = sc.nextInt();
				itemManager.addItem(new Item("", id, x, y));
			}
			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public ItemManager getItemManager() {
		return itemManager;
	}

	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}
	
}








