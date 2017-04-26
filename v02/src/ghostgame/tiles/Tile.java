package ghostgame.tiles;

/**
 * File : Tile.java.
 * Kelas Tile merepresentasikan object tile pada game.
 * @author 
 */

public class Tile {
  
  // Static Instances
  public static Tile[] tiles = new Tile[10];
  public static Tile floorTile = new Tile("Floor", 0, false);
  public static Tile wallTile = new Tile("Wall", 1, true);
  
  // Class Body
  private String name;
  private boolean solid;
  private final int id; // unique id
  
  public static final int TILEWIDTH = 64; 
  public static final int TILEHEIGHT = 64;
  
  /**
   * Constructor dengan parameter.
   * @param name Nama tile.
   * @param id Id tile.
   * @param solid Jenis tile.
   */
  
  public Tile(String name, int id, boolean solid) {
    this.name = name;
    this.id = id;
    
    tiles[id] = this;
    this.solid = solid;
  }

  /**
   * Mengembalikan jenis tile (solid atau tidak).
   * @return true jika tile solid.
   */
  
  public boolean isSolid() {
    return solid;
  }

  /**
   * Mengubah nilai solid.
   * @param solid.
   */
  
  public void setSolid(boolean solid) {
    this.solid = solid;
  }

  /**
   * Mengembalikan id.
   * @return id.
   */
  
  public int getId() {
    return id;
  }

  /**
   * Mengembalikan name.
   * @return name.
   */
  
  public String getName() {
    return name;
  }

  /**
   * Mengubah nilai name.
   * @param name.
   */
  
  public void setName(String name) {
    this.name = name;
  }
}
