package ghostgame.entities.creatures;

import ghostgame.Handler;

import ghostgame.entities.Entity;

import java.util.Iterator;

/** 
  * File : Ghost.java
  * Kelas abstrak yang merepresentasikan hantu-hantu yang ada pada game ini
  * @author Kevin Iswara - 13515085
  */

public abstract class Ghost extends Creature {
  
  protected int atk;
  
  /**
    * Constructor dengan parameter.
    * @param handler Nilai yang menghubungkan World dengan Entity.
    * @param x Nilai absis (posisi) dari Ghost.
    * @param y Nilai ordinar (posisi) dari Ghost.
    */

  public Ghost(Handler handler, float x, float y) {
    super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
    
    bounds.x = 22;
    bounds.y = 44;
    bounds.width = 19;
    bounds.height = 19;
  }
  
  /**
   * Memeriksa apakah posisi ghost bersinggungan dengan entitas lain.
   * @param xoffset perubahan jarak absis ghost dari posisi awal ghost.
   * @param yoffset perubahan jarak ordinat player dari posisi awal ghostr.
   * @return true apabila posisi ghost bersinggungan dengan entitas lain.
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
        if (e instanceof Player) {
          e.hurt(this.getAtk());
          die();
        }
        return true;
      }
    }
    return false;
  }

  /**
    * Menghapus objek Ghost dari layar dengan cara mengubah status active dari ghost.
    */

  @Override
  public void die() {
    setActive(false);
  }
  
  /** 
    * I.S. atribut atk sembarang.
    * F.S. atribut atk terdefinisi.
    * @param atk Nilai yang akan dimasukkan ke atribut atk.
    */

  public void setAtk(int atk) {
    this.atk = atk;
  }

  /** 
    * Mengembalikan atk dari sebuah objek Ghost.
    * @return Nilai dari atribut atk.
    */

  public int getAtk() {
    return atk;
  }

  /**
    * Fungsi abstrak untuk mengubah xMove atau yMove.
    */

  public abstract void changeMovement();
}