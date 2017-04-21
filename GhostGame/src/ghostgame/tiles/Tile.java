package ghostgame.tiles;

import java.awt.image.BufferedImage;

public abstract class Tile {
	
	//STATIC STUFF HERE
	public static Tile[] tiles = new Tile[256];
	public static Tile grassTile = new GrassTile(0);
	public static Tile dirtTile = new DirtTile(1);
	public static Tile rockTile = new RockTile(2);
	
	//CLASS
	public static final int TILEWIDTH = 64, TILEHEIGHT = 64;
	
	protected BufferedImage texture;
	protected final int id;
	
	public Tile(BufferedImage texture, int id){
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	public int getId(){
		return id;
	}

	public BufferedImage getTexture() {
		return texture;
	}
	
	public abstract boolean isSolid();
	
}
