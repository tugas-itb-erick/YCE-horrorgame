package ghostgame.tiles;

public class Tile {
	
	// Static Instances
	public static Tile[] tiles = new Tile[256];
	public static Tile grassTile = new Tile("Grass", 0, false);
	public static Tile dirtTile = new Tile("Dirt", 1, false);
	public static Tile rockTile = new Tile("Stone", 2, true);
	
	// Class Body
	private String name;
	private boolean solid;
	private final int id; // unique id
	
	public static final int TILEWIDTH = 64; 
	public static final int TILEHEIGHT = 64;
	
	public Tile(String name, int id, boolean solid) {
		this.name = name;
		this.id = id;
		
		tiles[id] = this;
		this.solid = solid;
	}

	public boolean isSolid() {
		return solid;
	}

	public void setSolid(boolean solid) {
		this.solid = solid;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
