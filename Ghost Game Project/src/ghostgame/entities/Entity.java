package ghostgame.entities;

import java.awt.Rectangle;

import ghostgame.Handler;

/**
 * Kelas Entity merupakan kelas yang menggambarkan entitas-entitas
 * yang terdapat dalam permainan.
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
   * @param handler nilai yang menyatakan keterhubungan world dengan entitas.
   * @param x posisi entitas dalam sumbu x.
   * @param y posisi entitas dalam sumbu y.
   * @param width lebar entitas.
   * @param height panjang entitas.
   */
  
  public Entity(Handler handler, float x, float y, int width, int height) {
    this.handler = handler;
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    health = DEFAULT_HEALTH;
    
    bounds = new Rectangle(0, 0, width, height);
  }
  
  /**
   * Mengurangi health dari suatu entitas.
   * @param amt nilai pengurangan health yang terjadi.
   */
  
  public abstract void hurt(int amt);
  
  /**
   * Mengecek apakah suatu entitas menabarak entitas yang lain.
   * @param xOffset perpindahan dalam sumbu x.
   * @param yOffset perpindahan dalam sumbu y.
   * @return true jika terjadi tabrakan antarentitas.
   */
  
  public boolean checkEntityCollisions(float xOffset, float yOffset) {
    for(Entity e : handler.getWorld().getEntityManager().getEntities()){
      if (e.equals(this))
        continue;
      if (e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset)))
        return true;
    }
    return false;
  }
  
  /**
   * Mengembalikan nilai Rectangle yang menyatakan bounds.
   * @param xOffset perpindahan dalam sumbu x.
   * @param yOffset perpindahan dalam sumbu y.
   * @return rectangle yang menyatakan nilai bound.
   */
  
  public Rectangle getCollisionBounds(float xOffset, float yOffset) {
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
   * I.S. x sembarang.
   * F.S. x terdefinisi sesuai dengan nilai x yang baru.
   * @param x nilai x yang baru.
   */
  
  public void setX(float x) {
    this.x = x;
  }

  /**
   * Mengembalikan posisi dalam sumbu y.
   * @return posisi dalam sumbu y.
   */
  
  public float getY() {
    return y;
  }

  /**
   * I.S. y sembarang.
   * F.S. y terdefinisi sesuai dengan nilai y yang baru.
   * @param y nilai y yang baru.
   */
  
  public void setY(float y) {
    this.y = y;
  }

  /**
   * Mengembalikan lebar dari objek yang merepresentasikan entitas.
   * @return lebar dalam integer.
   */
  
  public int getWidth() {
    return width;
  }

  /**
   * I.S. width sembarang.
   * F.S. width terdefinisi sesuai dengan nilai width yang baru.
   * @param width nilai width yang baru.
   */
  
  public void setWidth(int width) {
    this.width = width;
  }

  /**
   * Mengembalikan panjang dari objek yang merepresentasikan entitas.
   * @return panjang dalam integer.
   */
  
  public int getHeight() {
    return height;
  }

  /**
   * I.S. height sembarang.
   * F.S. height terdefinisi sesuai dengan nilai height yang baru.
   * @param height nilai height yang baru.
   */
  
  public void setHeight(int height) {
    this.height = height;
  }

  /**
   * Mengembalikan nilai health dari suatu entitas. Apabila health habis, objek
   * akan hilang (mati).
   * @return nilai health.
   */
  
  public int getHealth() {
    return health;
  }
  
  /**
   * I.S. health sembarang.
   * F.S. health terdefinisi sesuai dengan nilai health yang baru.
   * @param health nilai health yang baru.
   */

  public void setHealth(int health) {
    this.health = health;
  }

  /**
   * Mengembalikan status aktif atau tidaknya entitas.
   * @return true jika entitas aktif.
   */
  
  public boolean isActive() {
    return active;
  }

  /**
   * I.S. active sembarang.
   * F.S. active terdefinisi sesuai dengan nilai active yang baru.
   * @param active nilai active yang baru.
   */
  
  public void setActive(boolean active) {
    this.active = active;
  }

  /**
    * Mengembalikan active dari sebuah entitas.
    * @return Nilai active yang ada pada entitas.
    */
  public boolean getActive() {
    return active;
  }

  /**
    * Mengembalikan handler yang merupakan pengubung antara world dengan entitas.
    * @return penghubung antara world dengan item.
    */
  
  public Handler getHandler() {
    return handler;
  }

  /**
   * I.S. handler sembarang.
   * F.S. handler terdefinisi sesuai dengan nilai handler yang baru.
   * @param handler nilai active yang baru.
   * @param handler nilai active yang baru.
   */
  
  public void setHandler(Handler handler) {
    this.handler = handler;
  }

  /**
   * Mengembalikan nilai bounds dari entitas yang menyatakan daerah yang solid (tidak
   * dapat dilewati oleh Player).
   * @return nilai bounds item.
   */
  
  public Rectangle getBounds() {
    return bounds;
  }

  /**
   * I.S. bound sembarang.
   * F.S. bound terdefinisi sesuai dengan nilai bound yang baru.
   * @param bound nilai bound yang baru.
   * @param bound nilai bound yang baru.
   */
  
  public void setBounds(Rectangle bounds) {
    this.bounds = bounds;
  }
}
