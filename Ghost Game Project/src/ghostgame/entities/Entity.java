package ghostgame.entities;

import ghostgame.Handler;

import java.awt.Rectangle;

/**
 * Kelas Entity merupakan kelas yang menggambarkan entitas-entitas
 * yang terdapat dalam permainan.
 * @author
 */

public abstract class Entity {

  public static final int DEFAULT_HEALTH = 3;
  protected Handler handler;
  protected float xpos;
  protected float ypos;
  protected int width;
  protected int height;
  protected int health;
  protected boolean active = true;
  protected Rectangle bounds;
  
  /**
   * Constructor dengan parameter.
   * @param handler nilai yang menyatakan keterhubungan world dengan entitas.
   * @param xpos posisi entitas dalam sumbu x.
   * @param ypos posisi entitas dalam sumbu y.
   * @param width lebar entitas.
   * @param height panjang entitas.
   */
  
  public Entity(Handler handler, float xpos, float ypos, int width, int height) {
    this.handler = handler;
    this.xpos = xpos;
    this.ypos = ypos;
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
   * @param xoffset perpindahan dalam sumbu x.
   * @param yoffset perpindahan dalam sumbu y.
   * @return true jika terjadi tabrakan antarentitas.
   */
  
  public boolean checkEntityCollisions(float xoffset, float yoffset) {
    for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
      if (e.equals(this)) {
        continue;
      }
      if (e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xoffset, yoffset))) {
        return true;
      }
    }
    return false;
  }
  
  /**
   * Mengembalikan nilai Rectangle yang menyatakan bounds.
   * @param xoffset perpindahan dalam sumbu x.
   * @param yoffset perpindahan dalam sumbu y.
   * @return rectangle yang menyatakan nilai bound.
   */
  
  public Rectangle getCollisionBounds(float xoffset, float yoffset) {
    return new Rectangle((int) (xpos + bounds.x + xoffset), (int) (ypos + bounds.y + yoffset),
         bounds.width, bounds.height);
  }

  /**
   * Mengembalikan posisi dalam koordinat xpos.
   * @return posisi dalam koordinat xpos.
   */
  
  public float getX() {
    return xpos;
  }

  /**
   * I.S. xpos sembarang.
   * F.S. xpos terdefinisi sesuai dengan nilai xpos yang baru.
   * @param xpos nilai xpos yang baru.
   */
  
  public void setX(float xpos) {
    this.xpos = xpos;
  }

  /**
   * Mengembalikan posisi dalam sumbu ypos.
   * @return posisi dalam sumbu ypos.
   */
  
  public float getY() {
    return ypos;
  }

  /**
   * I.S. ypos sembarang.
   * F.S. ypos terdefinisi sesuai dengan nilai ypos yang baru.
   * @param ypos nilai ypos yang baru.
   */
  
  public void setY(float ypos) {
    this.ypos = ypos;
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
   * I.S. bounds sembarang.
   * F.S. bounds terdefinisi sesuai dengan nilai bounds yang baru.
   * @param bounds nilai bound yang baru.
   */
  
  public void setBounds(Rectangle bounds) {
    this.bounds = bounds;
  }
}
