package ghostgame.entities.creatures;

import java.util.Iterator;

import ghostgame.Handler;
import ghostgame.entities.Entity;
import ghostgame.inventory.Inventory;
import ghostgame.states.LostState;
import ghostgame.states.WinState;
import ghostgame.tiles.Tile;

/** 
 * File : Player.java.
 * Kelas yang merepresentasikan pemain yang ada pada game ini.
 * @author Erick Wijaya - 13515057.
 */

public class Player extends Creature {
  
  private boolean hasWeapon;
  private boolean hasKey;
  private int sightX;
  private int sightY;
  private Inventory inventory;
  
  /**
    * Constructor dengan parameter.
    * @param handler Nilai yang menghubungkan World dengan Entity.
    * @param x Nilai absis (posisi) untuk Player.
    * @param y Nilai ordinat (posisi) untuk Player.
    */
  
  public Player(Handler handler, float x, float y) {
    super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
    
    health = 3;
    bounds.x = 22;
    bounds.y = 44;
    bounds.width = 19;
    bounds.height = 19;
    
    inventory = new Inventory(handler);
    hasWeapon = false;
    hasKey = false;
    sightX = 4; //4,3 3,2 2,1
    sightY = 3;
  }
  
  /**
    * Mengubah current state menjadi lostState.
    */
  
  @Override
  public void die() {
    handler.getGame().setState(new LostState(handler));
  }
  
  /**
   * Mengubah posisi player apabila bounds milik player tidak
   * bertabrakan dengan entitas lain. 
   */
  
  @Override
  public void move() {
    if (!checkEntityCollisions(xmove, 0f)) {
      moveX();
    }
    if (!checkEntityCollisions(0f, ymove)) {
      moveY();
    }
  }
  
  /**
   * Memeriksa apakah posisi player bersinggungan dengan entitas lain.
   * @param xoffset perubahan jarak absis player dari posisi terawal player.
   * @param yoffset perubahan jarak ordinat player dari posisi terawal player.
   * @return true apabila posisi player bersinggungan dengan entitas lain.
   */
  
  @Override
  public boolean checkEntityCollisions(float xoffset, float yoffset) {
    Iterator<Entity> it = handler.getWorld().getEntityManager().getEntities().iterator();
    while (it.hasNext()) {
      Entity e = it.next();
      if (e.equals(this)) {
        continue;
      }
      if (e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xoffset, yoffset))) {
        if (e instanceof Ghost) {
          hurt(((Ghost) e).getAtk());
          e.setActive(false);
        }
        return true;
      }
    }
    return false;
  }
  
  /**
   * Mengembalikan inventory player.
   * @return inventory player.
   */

  public Inventory getInventory() {
    return inventory;
  }
  
  /**
   * Mengubah inventory player.
   * @param inventory.
   */

  public void setInventory(Inventory inventory) {
    this.inventory = inventory;
  }
  
  /**
   * Memeriksa apakah player memiliki candle pada inventory.
   * Bila ya, nilai SightX dan SightY diturunkan.
   * Bila tidak, nilai default.
   */
  
  public void checkCandle() {
    assert (inventory != null);
    if (inventory.containItem("Candle")) {
      sightX = 3;
      sightY = 2;
    }
  }
  
  /**
   * Memeriksa apakah player memiliki weapon pada inventory.
   * Bila ya, nilai hasWeapon diset menjadi true.
   * Bila tidak, nilai tetap.
   */
  
  public void checkWeapon() {
    assert (inventory != null);
    hasWeapon = inventory.containItem("Knife");
  }
  
  /**
   * Memeriksa apakah player memiliki key pada inventory.
   * Bila ya, nilai hasKey diset menjadi true.
   * Bila tidak, nilai tetap.
   */
  
  public void checkKey() {
    assert (inventory != null);
    hasKey = inventory.containItem("Key");
  }
  
  /**
   * Mengembalikan nilai jarak seberapa dekat penglihatan player terhadap absis.
   * @return sightX.
   */

  public int getSightX() {
    return sightX;
  }
  
  /**
   * Mengubah nilai jarak seberapa dekat penglihatan player terhadap absis.
   * @param sightX Nilai dari sightX.
   */

  public void setSightX(int sightX) {
    this.sightX = sightX;
  }
  
  /**
   * Mengembalikan nilai jarak seberapa dekat penglihatan player terhadap ordinat.
   * @return sightY.
   */

  public int getSightY() {
    return sightY;
  }
  
  /**
   * Mengubah nilai jarak seberapa dekat penglihatan player terhadap ordinat.
   * @param sightY Nilai dari sightY.
   */

  public void setSightY(int sightY) {
    this.sightY = sightY;
  }
  
  /**
   * Mengembalikan nilai hasWeapon.
   * @return nilai hasWeapon.
   */
  
  public boolean isHasWeapon() {
    return hasWeapon;
  }
  
  /**
   * Mengembalikan nilai hasKey.
   * @return nilai hasKey.
   */
  
  public boolean isHasKey() {
    return hasKey;
  }
  
  public void checkWin() {
  	if (((int) (xpos / Tile.TILEWIDTH) == handler.getWorld().getWinX()-1) &&
  			((int) (ypos / Tile.TILEHEIGHT) == handler.getWorld().getWinY()-1)) {
  		handler.getGame().setState(new WinState(handler));
  	}
  }
}
