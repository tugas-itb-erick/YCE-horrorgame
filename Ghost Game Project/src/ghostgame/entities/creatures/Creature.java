package ghostgame.entities.creatures;

import ghostgame.Handler;

import ghostgame.entities.Entity;

import ghostgame.tiles.Tile;

/**
  * Kelas abstrak Creature yang merepresentasikan Entity yang dapat bergerak.
  * @author 
  */

public abstract class Creature extends Entity {
  
  public static final float DEFAULT_SPEED = 3.0f;
  public static final int DEFAULT_CREATURE_WIDTH = 64;
  public static final int DEFAULT_CREATURE_HEIGHT = 64;
  protected float speed;
  protected float xmove;
  protected float ymove;

  /**
    * Constructor dengan parameter.
    * @param handler Nilai yang menghubungkan World dengan Creature.
    * @param x Nilai absis (posisi) dari Creature.
    * @param y Nilai ordinar (posisi) dari Creature.
    * @param width Nilai lebar entitas.
    * @param height Nilai panjang entitas.
    */
  
  public Creature(Handler handler, float x, float y, int width, int height) {
    super(handler, x, y, width, height);
    speed = DEFAULT_SPEED;
    xmove = 0;
    ymove = 0;
  }
  
  public abstract void die();
  
  @Override
  public void hurt(int amt) {
    health -= amt;
    if (health <= 0) {
      active = false;
      die();
    }
  }
  
  /** 
    * Memeriksa apakah sebuah Creature akan menabrak dengan Entity yang solid atau tidak.
    * Jika tidak akan bergerak sesuai dengan xmove dan ymove.
    */
  
  public void move() {
    if (!checkEntityCollisions(xmove, 0f)) {
      moveX();
    }
    if (!checkEntityCollisions(0f, ymove)) {
      moveY();
    }
  }
  
  /**
    * Menggerakan Creature sesuai dengan xmovenya.
    * Jika xmove bernilai positif, maka akan bergerak ke kanan.
    * Sebaliknya jika xmove bernilai negatif, maka akan bergerak ke kiri.
    */
  
  public void moveX() {
    if (xmove > 0) { //Moving right
      int tx = (int) (xpos + xmove + bounds.x + bounds.width) / Tile.TILEWIDTH;
      if (!collisionWithTile(tx, (int) (ypos + bounds.y) / Tile.TILEHEIGHT)
          && !collisionWithTile(tx, (int) (ypos + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
        xpos += xmove;
      } else {
        xpos = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1;
      }
    } else if (xmove < 0) { //Moving left
      int tx = (int) (xpos + xmove + bounds.x) / Tile.TILEWIDTH;
      if (!collisionWithTile(tx, (int) (ypos + bounds.y) / Tile.TILEHEIGHT) 
          && !collisionWithTile(tx, (int) (ypos + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
        xpos += xmove;
      } else {
        xpos = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;
      }      
    }
  }

  /**
    * Menggerakan Creature sesuai dengan ymovenya.
    * Jika ymove bernilai positif, maka akan bergerak ke bawah.
    * Sebaliknya jika ymove bernilai negatif, maka akan bergerak ke atas.
    */
  
  public void moveY() {
    if (ymove < 0) { //Up
      int ty = (int) (ypos + ymove + bounds.y) / Tile.TILEHEIGHT;
      if (!collisionWithTile((int) (xpos + bounds.x) / Tile.TILEWIDTH, ty) 
          && (!collisionWithTile((int) (xpos + bounds.x + bounds.width) / Tile.TILEWIDTH, ty))) {
        ypos += ymove;
      } else {
        ypos = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
      }
    } else if (ymove > 0) { //Down
      int ty = (int) (ypos + ymove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
      if (!collisionWithTile((int) (xpos + bounds.x) / Tile.TILEWIDTH, ty)
          && (!collisionWithTile((int) (xpos + bounds.x + bounds.width) / Tile.TILEWIDTH, ty))) {
        ypos += ymove;
      } else {
        ypos = ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;
      }
    }
  }
  
  /**
    * Mengecek apakah pada koordinat x, y ada entity yang solid / tidak.
    * @param x Nilai absis yang akan diperiksa.
    * @param y Nilai ordinat yang akan diperiksa.
    * @return mengembalikan true jika ada entity yang solid pada tile x, y dan false jika tidak.
    */
  
  protected boolean collisionWithTile(int x, int y) {
    return handler.getWorld().getTile(x, y).isSolid();
  }

  /**
    * Mengembalikan xmove dari sebuah Creature.
    * @return Nilai xmove dari sebuah Creature.
    */
  
  public float getxmove() {
    return xmove;
  }

  /**
    * I.S. nilai xmove sembarang.
    * F.S. nilai xmove terdefinisi.
    * @param xmove Nilai yang akan dimasukan ke dalam atribut xmove.
    */
  
  public void setxmove(float xmove) {
    this.xmove = xmove;
  }

  /**
    * Mengembalikan ymove dari sebuah Creature.
    * @return Nilai ymove dari sebuah Creature.
    */
  
  public float getymove() {
    return ymove;
  }

  /**
    * I.S. nilai ymove sembarang.
    * F.S. nilai ymove terdefinisi.
    * @param ymove Nilai yang akan dimasukan ke dalam atribut ymove.
    */
  
  public void setymove(float ymove) {
    this.ymove = ymove;
  }

  /**
    * Mengembalikan health dari sebuah Creature.
    * @return Nilai health dari sebuah Creature.
    */
  
  public int getHealth() {
    return health;
  }

  /**
    * I.S. nilai health sembarang.
    * F.S. nilai health terdefinisi.
    * @param health Nilai yang akan dimasukan ke dalam atribut health.
    */
  
  public void setHealth(int health) {
    this.health = health;
  }

  /**
    * Mengembalikan speed dari sebuah Creature.
    * @return Nilai speed dari sebuah Creature.
    */
  
  public float getSpeed() {
    return speed;
  }

  /**
    * I.S. nilai speed sembarang.
    * F.S. nilai speed terdefinisi.
    * @param speed Nilai yang akan dimasukan ke dalam atribut speed.
    */
  
  public void setSpeed(float speed) {
    this.speed = speed;
  }  
}
