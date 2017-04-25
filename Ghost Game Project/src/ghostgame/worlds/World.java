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

/**
 * File : World.java
 * Kelas World adalah kelas yang mendefinisikan ukuran level permainan
 * beserta segala entitas dan item yang ada di dalam world.
 * @author Erick Wijaya - 13515057
 */

public class World {

	private Handler handler;
	private int width;
	private int height;
	
	private int spawnX;
	private int spawnY;
	
	private int[][] tiles;
	
	private EntityManager entityManager;
	private ItemManager itemManager;
	
	/**
	 * Constructor dengan parameter.
	 * @param handler handler game.
	 * @param path path menuju file input.
	 */
	
	public World(Handler handler, String path) {
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 100, 100));
		itemManager = new ItemManager(handler);
		loadStaticEntity("res/worlds/staticentity.txt");
		loadItem("res/worlds/item.txt");
		// Temporary entity code!
		entityManager.addEntity(new Ghost2(handler, 64*6, 64*3));
		entityManager.addEntity(new Ghost2(handler, 64*6, 64*4));
		entityManager.addEntity(new Ghost2(handler, 64*6, 64*5));
		entityManager.addEntity(new Ghost2(handler, 64*6, 64*6));
		entityManager.addEntity(new Ghost2(handler, 64*6, 64*7));
		
		loadWorld(path);
		
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
	}
	
	/**
	 * Mengupdate seluruh item dan entitas pada world.
	 * I.S. itemManager dan entityManager terdefinisi
	 * F.S. seluruh entitas dan item di-update
	 */
	
	public void tick() {
		assert(itemManager != null);
		assert(entityManager != null);
		
		itemManager.tick();
		entityManager.tick();
	}
	
	/**
	 * Menampilkan gambar seluruh komponen pada world.
	 * I.S. Matriks tiles terdefinisi.
	 * F.S. Gambar seluruh komponen world ditampilkan.
	 * @param g tool graphics yang digunakan.
	 */
	
	public void render(Graphics g) {
		assert(tiles != null);
		assert(handler != null);
		
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
	
	/**
	 * Mengembalikan Tile pada posisi (x,y).
	 * @param x posisi absis.
	 * @param y posisi ordinat.
	 * @return Tile pada posisi (x,y).
	 */
	
	public Tile getTile(int x, int y) {
		assert(tiles != null);
		
		if(x < 0 || y < 0 || x >= width || y >= height)
			return Tile.floorTile;
		
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null)
			return Tile.floorTile;
		return t;
	}
	
	/**
	 * Menerima masukkan konfigurasi world dari file untuk diload ke program.
	 * I.S. Sembarang
	 * F.S. Matriks tiles terdefinisi sesuai dari file
	 * @param path path menuju file input.
	 */
	
	private void loadWorld(String path) {
		StringBuilder builder = new StringBuilder();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			while((line = br.readLine()) != null)
				builder.append(line + "\n");
			
			br.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		String file = builder.toString();
		String[] tokens = file.split("\\s+");
		width = Integer.parseInt(tokens[0]);
		height = Integer.parseInt(tokens[1]);
		spawnX = Integer.parseInt(tokens[2]);
		spawnY = Integer.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for (int y = 0;y < height;y++) {
			for (int x = 0;x < width;x++) {
				tiles[x][y] = Integer.parseInt(tokens[(x + y * width) + 4]);
			}
		}
		
		assert(tiles != null);
	}
	
	/**
	 * Menerima masukkan informasi entitas dari file untuk diload ke program.
	 * I.S. entityManager terdefinisi.
	 * F.S. entityManager menyimpan data entitas dari file.
	 * @param path path menuju file input.
	 */
	
	private void loadStaticEntity(String path) {
		assert(entityManager != null);
		
		try {
			Scanner sc = new Scanner(new File(path));
			while (sc.hasNext()) {
				int id = sc.nextInt();
				float x = sc.nextFloat();
				float y = sc.nextFloat();
				int kwidth = sc.nextInt();
				int kheight = sc.nextInt();
				entityManager.addEntity(new StaticEntity(handler, id, Tile.TILEWIDTH * x, Tile.TILEHEIGHT * y, Tile.TILEWIDTH * kwidth, Tile.TILEHEIGHT * kheight));
			}
			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Menerima masukkan informasi item dari file untuk diload ke program.
	 * I.S. itemManager terdefinisi.
	 * F.S. itemManager menyimpan data item dari file.
	 * @param path path menuju file input.
	 */
	
	private void loadItem(String path) {
		assert(itemManager != null);
		
		try {
			Scanner sc = new Scanner(new File(path));
			while (sc.hasNext()) {
				int id = sc.nextInt();
				int x = sc.nextInt();
				int y = sc.nextInt();
				switch (id) {
					case 0: itemManager.addItem(Item.keyItem.createNew(x*Tile.TILEWIDTH, y*Tile.TILEHEIGHT)); break;
					case 1: itemManager.addItem(Item.candleItem.createNew(x*Tile.TILEWIDTH, y*Tile.TILEHEIGHT)); break;
					case 2: itemManager.addItem(Item.knifeItem.createNew(x*Tile.TILEWIDTH, y*Tile.TILEHEIGHT)); break;
					case 3: itemManager.addItem(Item.ghostAshItem.createNew(x*Tile.TILEWIDTH, y*Tile.TILEHEIGHT)); break;
					case 4: itemManager.addItem(Item.goldItem.createNew(x*Tile.TILEWIDTH, y*Tile.TILEHEIGHT)); break;
					default: itemManager.addItem(Item.ghostAshItem.createNew(x*Tile.TILEWIDTH, y*Tile.TILEHEIGHT)); break;
				}
			}
			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Mengembalikan lebar world.
	 * @return lebar world.
	 */
	
	public int getWidth() {
		return width;
	}
	
	/**
	 * Mengembalikan tinggi world.
	 * @return tinggi world.
	 */
	
	public int getHeight() {
		return height;
	}

	/**
	 * Mengembalikan manager entitas.
	 * @return manager entitas.
	 */
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * Mengembalikan handler game.
	 * @return handler game.
	 */
	
	public Handler getHandler() {
		return handler;
	}

	/**
	 * Mengubah handler game.
	 * @param handler handler game.
	 */
	
	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	/**
	 * Mengembalikan manager item.
	 * @return manager item.
	 */
	
	public ItemManager getItemManager() {
		return itemManager;
	}

	/**
	 * Mengubah manager item
	 * @param itemManager manager item.
	 */
	
	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}
}








