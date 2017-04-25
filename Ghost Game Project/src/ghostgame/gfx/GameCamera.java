package ghostgame.gfx;

import ghostgame.Handler;
import ghostgame.entities.Entity;
import ghostgame.tiles.Tile;

/**
  * Kelas GameCamera yang mengatur posisi pusat (bagian mana yang ditampilkan).
  * @author 
  */

public class GameCamera {
  
  private Handler handler;
  private float xoffset;
  private float yoffset;
  
  /**
    * Constructor dengan parameter.
    * @param handler Nilai yang menghubungkan World dengan kelas yang berhubungan.
    * @param xoffset Nilai yang menentukan offset horizontal.
    * @param yoffset Nilai yang menentukan offset vertikal.
    */
  
  public GameCamera(Handler handler, float xoffset, float yoffset) {
    this.handler = handler;
    this.xoffset = xoffset;
    this.yoffset = yoffset;
  }
  
  /**
    * Mengecek apakah ada space kosong.
    */
  
  public void checkBlankSpace() {
    if (xoffset < 0) {
      xoffset = 0;
    } else if (xoffset > handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth()) {
      xoffset = handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth();
    }
    if (yoffset < 0) {
      yoffset = 0;
    } else if (yoffset > handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getHeight()) {
      yoffset = handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getHeight();
    }
  }
  
  /**
    * Mengubah xoffset dan yoffset sesuai dengan posisi e.
    * @param e Nilai object yang akan dijadikan pusat kamera.
    */
  
  public void centerOnEntity(Entity e) {
    xoffset = e.getX() - handler.getWidth() / 2 + e.getWidth() / 2;
    yoffset = e.getY() - handler.getHeight() / 2 + e.getHeight() / 2;
    checkBlankSpace();
  }
  
  /**
    * Mengubah xoffset dan yoffset sesuai dengan inputan.
    * @param xamt Nilai pergerakan dari xoffset.
    * @param yamt Nilai pergerakan dari yoffset.
    */
  
  public void move(float xamt, float yamt) {
    xoffset += xamt;
    yoffset += yamt;
    checkBlankSpace();
  }

  /**
    * Mengembalikan nilai xoffset dari GameCamera.
    * @return Nilai xoffset dari GameCamera.
    */
  
  public float getxOffset() {
    return xoffset;
  }

  /**
    * I.S. Nilai xoffset sembarang.
    * F.S. Nilai xoffset terdefinisi.
    * @param xoffset Nilai yang akan dimasukan ke dalam xoffset.
    */
  
  public void setxOffset(float xoffset) {
    this.xoffset = xoffset;
  }

  /**
    * Mengembalikan nilai yoffset dari GameCamera.
    * @return Nilai yoffset dari GameCamera.
    */

  public float getyOffset() {
    return yoffset;
  }

  /**
    * I.S. Nilai yoffset sembarang.
    * F.S. Nilai yoffset terdefinisi.
    * @param yoffset Nilai yang akan dimasukan ke dalam yoffset.
    */
  
  public void setyOffset(float yoffset) {
    this.yoffset = yoffset;
  }

}
