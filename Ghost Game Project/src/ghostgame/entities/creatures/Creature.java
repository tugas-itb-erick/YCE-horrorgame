package ghostgame.entities.creatures;

import ghostgame.entities.Entity;

import ghostgame.Handler;

import ghostgame.tiles.Tile;

/**
  * Kelas abstrak Creature yang merepresentasikan Entity yang dapat bergerak.
  * @author 
  */

public abstract class Creature extends Entity {
  
  public static final float DEFAULT_SPEED = 3.0f;
  public static final int DEFAULT_CREATURE_WIDTH = 64,
                          DEFAULT_CREATURE_HEIGHT = 64;
  protected float speed;
  protected float xMove, yMove;

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
    xMove = 0;
    yMove = 0;
  }
  
  public abstract void die();
  
  @Override
  public void hurt(int amt) {
    health -= amt;
    if(health <= 0){
      active = false;
      die();
    }
  }
  
  /** 
    * Memeriksa apakah sebuah Creature akan menabrak dengan Entity yang solid atau tidak.
    * Jika tidak akan bergerak sesuai dengan xMove dan yMove.
    */
  
  public void move() {
    if(!checkEntityCollisions(xMove, 0f))
      moveX();
    if(!checkEntityCollisions(0f, yMove))
      moveY();
  }
  
  /**
    * Menggerakan Creature sesuai dengan xMovenya.
    * Jika xMove bernilai positif, maka akan bergerak ke kanan.
    * Sebaliknya jika xMove bernilai negatif, maka akan bergerak ke kiri.
    */
  
  public void moveX() {
    if (xMove > 0) {//Moving right
      int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
      if (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
          !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
        x += xMove;
      } else {
        x = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1;
      }
    } else if (xMove < 0) {//Moving left
      int tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;
      if (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
          !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
        x += xMove;
      } else {
        x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;
      }      
    }
  }

  /**
    * Menggerakan Creature sesuai dengan yMovenya.
    * Jika yMove bernilai positif, maka akan bergerak ke bawah.
    * Sebaliknya jika yMove bernilai negatif, maka akan bergerak ke atas.
    */
  
  public void moveY() {
    if (yMove < 0) {//Up
      int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;
      if (!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
          !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
        y += yMove;
      } else {
        y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
      }
    } else if (yMove > 0) {//Down
      int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
      if (!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
          !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
        y += yMove;
      } else {
        y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;
      }
    }
  }
  
  /**
    * Mengecek apakah pada koordinat x, y ada entity yang solid / tidak.
    * @param x Nilai absis yang akan diperiksa.
    * @param y Nilai ordinat yang akan diperiksa.
    * @return mengembalikan true jika ada entity yang solid pada tile x, y
    * dan false jika tidak.
    */
  
  protected boolean collisionWithTile(int x, int y) {
    return handler.getWorld().getTile(x, y).isSolid();
  }

  /**
    * Mengembalikan xMove dari sebuah Creature.
    * @return Nilai xMove dari sebuah Creature.
    */
  
  public float getxMove() {
    return xMove;
  }

  /**
    * I.S. nilai xMove sembarang.
    * F.S. nilai xMove terdefinisi.
    * @param xMove Nilai yang akan dimasukan ke dalam atribut xMove.
    */
  
  public void setxMove(float xMove) {
    this.xMove = xMove;
  }

  /**
    * Mengembalikan yMove dari sebuah Creature.
    * @return Nilai yMove dari sebuah Creature.
    */
  
  public float getyMove() {
    return yMove;
  }

  /**
    * I.S. nilai yMove sembarang.
    * F.S. nilai yMove terdefinisi.
    * @param yMove Nilai yang akan dimasukan ke dalam atribut yMove.
    */
  
  public void setyMove(float yMove) {
    this.yMove = yMove;
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
