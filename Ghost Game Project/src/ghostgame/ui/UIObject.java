package ghostgame.ui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

/** 
 * File : UIObject.java.
 * Kelas yang merepresentasikan object interface yang ada pada game ini.
 * @author
 */

public abstract class UIObject {
  
  protected float x, y;
  protected int width, height;
  protected Rectangle bounds;
  protected boolean hovering = false;
  
  /**
   * @param x Posisi sumbu x.
   * @param y Posisi sumbu y.
   * @param width lebah UI Object.
   * @param height tinggi UI Object.
   */
  
  public UIObject(float x, float y, int width, int height){
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    bounds = new Rectangle((int) x, (int) y, width, height);
  }
  
  /**
   * Mengupdate kondisi state setiap satuan waktu.
   */
  
  public abstract void tick();
  
  /**
   * Menampilkan gambar sesuai dengan jenisnya.
   * @param g Gambar.
   */
  
  public abstract void render(Graphics g);
  
  /**
   * Mengubah state ketika click.
   */
  
  public abstract void onClick();
  
  /**
   * Mengubah state ketika mouse bergerak.
   * @param e MouseEvent.
   */
  
  public void onMouseMove(MouseEvent e){
    if(bounds.contains(e.getX(), e.getY()))
      hovering = true;
    else
      hovering = false;
  }
  
  /**
   * Mengubah state ketika mouse dilepas.
   * @param e MouseEvent.
   */
  
  public void onMouseRelease(MouseEvent e){
    if (hovering) {
      onClick();
    }
  }

  /**
   * Mengembalikan x.
   * @return x.
   */
  
  public float getX() {
    return x;
  }
  
  /**
   * Mengubah x
   * @param x Posisi x.
   */
  
  public void setX(float x) {
    this.x = x; }

  /**
   * Mengembalikan y.
   * @return y.
   */
   
  public float getY() {
    return y;
  }

   /**
     * Mengubah y
     * @param y Posisi y.
     */
  
  public void setY(float y) {
    this.y = y;
  }

  /**
   * Mengembalikan width.
   * @return width.
   */
  
  public int getWidth() {
    return width;
  }

  /**
   * Mengubah width.
   * @param width Lebar.
   */
  
  public void setWidth(int width) {
    this.width = width;
  }
  
  /**
   * Mengembalikan height.
   * @return height.
   */
  
  public int getHeight() {
    return height;
  }

  /**
   * Mengubah height.
   * @param height Tinggi.
   */
  
  public void setHeight(int height) {
    this.height = height;
  }

  /**
   * Mengembalikan kondisi hovering.
   * @return true jika mouse menyentuh object.
   */
  
  public boolean isHovering() {
    return hovering;
  }

  /**
   * Mengubah kondisi hovering
   * @param hovering Kondisi mouse da object (bersentuhan atau tidak).
   */
  public void setHovering(boolean hovering) {
    this.hovering = hovering;
  }

}
