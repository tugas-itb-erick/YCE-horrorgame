package ghostgame.entities.creatures;

import ghostgame.entities.Entity;

import ghostgame.Handler;

import ghostgame.tiles.Tile;

import ghostgame.tiles.TileController;

import ghostgame.tiles.TileView;

/**
  * File : Creature.java
  * Kelas abstrak Creature merepresentasikan makhluk-makhluk
  * yang terdapat dalam permainan.
  * @author
  */

public abstract class Creature extends Entity {
  
  public static final float DEFAULT_SPEED = 3.0f;
  public static final int DEFAULT_CREATURE_WIDTH = 64;
  public static final int DEFAULT_CREATURE_HEIGHT = 64;
  
  protected float speed;
  protected float xMove, yMove;

  /**
    * Constructor dengan parameter.
    * @param handler nilai handler untuk creature.
    * @param x posisi koordinat x.
    * @param y posisi koordinat y.
    * @param width lebar creature.
    * @param height panjang creature.
    */

  public Creature(Handler handler, float x, float y, int width, int height) {
    super(handler, x, y, width, height);
    speed = DEFAULT_SPEED;
    xMove = 0;
    yMove = 0;
  }
  
  /**
    * Menggerakkan creature selama berada dalam range peta.
    */

  public void move(){
    if (!checkEntityCollisions(xMove, 0f)) {
      moveX();
    }
    if (!checkEntityCollisions(0f, yMove)) {
      moveY();
    }
  }
  
  /**
    * Menggerakkan creature selama berada dalam range peta dalam sumbu x.
    */

  public void moveX(){
    if (xMove > 0) {//Moving right
      int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
      
      if (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
          !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
        x += xMove;
      }else{
        x = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1;
      }
      
    }else if(xMove < 0) {//Moving left
      int tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;
      
      if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
          !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){
        x += xMove;
      }else{
        x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;
      }
      
    }
  }

  /**
    * Menggerakkan creature selama berada dalam range peta dalam sumbu y.
    */
  
  public void moveY(){
    if(yMove < 0){//Up
      int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;
      
      if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
          !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){
        y += yMove;
      }else{
        y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
      }
      
    }else if(yMove > 0){//Down
      int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
      
      if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
          !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){
        y += yMove;
      }else{
        y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;
      }
      
    }
  }

  /**
    * Mengecek apakah posisi player menabrak tile.
    * @param x posisi dalam koordinat x.
    * @param y posisi dalam koordinat y.
    * @return true jika menambrak tile.
    */
  
  protected boolean collisionWithTile(int x, int y){
    TileController tileController = new TileController(handler.getWorld().getTile(x, y), new TileView());
    return tileController.isTileSolid();
  }
  
  /**
    * Mengembalikan perpindahan creature pada sumbu x.
    * @return perpindahan creature pada sumbu x.
    */

  public float getxMove() {
    return xMove;
  }

  /**
    * Mengubah perpindahan creature pada sumbu x.
    */

  public void setxMove(float xMove) {
    this.xMove = xMove;
  }

  /**
    * Mengembalikan perpindahan creature pada sumbu y.
    * @return perpindahan creature pada sumbu y.
    */

  public float getyMove() {
    return yMove;
  }

  /**
    * Mengubah perpindahan creature pada sumbu y.
    */

  public void setyMove(float yMove) {
    this.yMove = yMove;
  }

  /**
    * Mengembalikan health dari creature.
    * @return nilai health.
    */

  public int getHealth() {
    return health;
  }

  /**
    * Mengubah nilai health creature.
    * @param nilai health yang baru.
    */

  public void setHealth(int health) {
    this.health = health;
  }

  /**
    * Mengembalikan nilai speed creature.
    * @return nilai speed dari creature. 
    */

  public float getSpeed() {
    return speed;
  }

  /**
    * Mengubah kecepatan creature.
    * @param speed nilai speed yang baru.
    */

  public void setSpeed(float speed) {
    this.speed = speed;
  }
  
}
