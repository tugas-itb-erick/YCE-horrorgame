package ghostgame.entities;

import ghostgame.Handler;

import java.awt.Graphics;

import java.awt.Rectangle;

/**
  * File : Entity.java
  * Kelas abstrak Entity merepresentasikan entitas yang terdapat dalam permainan.
  * @author
  */

public abstract class Entity {

  public static final int DEFAULT_HEALTH = 3;
  protected Handler handler;
  protected float x, y;
  protected int width, height;
  protected int health;
  protected boolean active = true;
  protected Rectangle bounds;
  
  /**
    * Constructor dengan parameter.
    * @param handler nilai yang menghubungkan world dengan entity.
    * @param x posisi dalam koordinat x.
    * @param y posisi dalam koordinat y.
    * @param width lebar entity.
    * @param height panjang entity.
    */

  public Entity(Handler handler, float x, float y, int width, int height){
    this.handler = handler;
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    health = DEFAULT_HEALTH;
    
    bounds = new Rectangle(0, 0, width, height);
  }
  
  /**
    * Mengembalikan rectangle.
    * @param xOffset.
    * @param yOffset.
    * @return rectangle yang merupakan bounds.
    */

  public Rectangle getCollisionBounds(float xOffset, float yOffset){
    return new Rectangle((int) (x + bounds.x + xOffset), (int) (y + bounds.y + yOffset), bounds.width, bounds.height);
  }

  /**
    * Mengembalikan posisi dalam koordinat x.
    * @return posisi dalam koordinat x.
    */

  public float getX() {
    return x;
  }

  /**
    * Mengupdate posisi dalam koordinat x.
    * @param posisi dalam koordinat x.
    */

  public void setX(float x) {
    this.x = x;
  }

  /**
    * Mengembalikan posisi dalam koordinat y.
    * @return posisi dalam koordinat y.
    */

  public float getY() {
    return y;
  }

  /**
    * Mengupdate posisi dalam koordinat y.
    * @param posisi dalam koordinat y.
    */

  public void setY(float y) {
    this.y = y;
  }

  

  public int getWidth() {
    return width;
  }

  /**
    * Mengupdate lebar gambar.
    * @param lebar gambar.
    */

  public void setWidth(int width) {
    this.width = width;
  }

  

  public int getHeight() {
    return height;
  }

  /**
    * Mengupdate panjang gambar.
    * @param panjang gambar.
    */

  public void setHeight(int height) {
    this.height = height;
  }

  

  public int getHealth() {
    return health;
  }

  

  public void setHealth(int health) {
    this.health = health;
  }

  

  public boolean isActive() {
    return active;
  }

  

  public void setActive(boolean active) {
    this.active = active;
  }

  

  public Handler getHandler() {
    return handler;
  }
}
