package ghostgame.ui;

import ghostgame.Handler;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/** 
 * File : UImanager.java.
 * Kelas yang merepresentasikan array of object interface yang ada pada game ini.
 * @author
 */

public class UImanager {

  private Handler handler;
  private ArrayList<UIobject> objects;
  
  /**
   * Constructor dengan parameter.
   * @param handler Menghubungkan world dengan UI manager.
   */
  
  public UImanager(Handler handler) {
    this.handler = handler;
    objects = new ArrayList<UIobject>();
  }
  
  /**
   * Mengupdate kondisi state setiap satuan waktu.
   */

  public void tick() {
    for (UIobject o : objects) {
      o.tick();
    }
  }

  /**
   * Menampilkan gambar sesuai dengan jenisnya.
   * @param g Gambar.
   */
  
  public void render(Graphics g) {
    for (UIobject o : objects) {
      o.render(g);
    }
  }
  
  /**
   * Mengubah state ketika mouse bergerak.
   * @param e MouseEvent.
   */

  public void onMouseMove(MouseEvent e) {
    for (UIobject o : objects) {      
      o.onMouseMove(e);
    }
  }
  
  /**
   * Mengubah state ketika mouse dilepas.
   * @param e MouseEvent.
   */

  public void onMouseRelease(MouseEvent e) {
    for (UIobject o : objects) {
      o.onMouseRelease(e);
    }
  }
  
  /**
   * Menambah object.
   * @param o object.
   */

  public void addObject(UIobject o) {
    objects.add(o);
  }
  
  /**
   * Menghapus object.
   * @param o object.
   */
  public void removeObject(UIobject o) {
    objects.remove(o);
  }

  /**
   * Mengembalikan handler.
   * @return handler Menghubungkan world dengan UI manager.
   */
  public Handler getHandler() {
    return handler;
  }

  /**
   * Mengubah handler.
   * @param handler Menghubungkan world dengan UI manager.
   */
  public void setHandler(Handler handler) {
    this.handler = handler;
  }

  /**
   * Mengembalikan array of UI object.
   * @return array of UI object.
   */
  public ArrayList<UIobject> getObjects() {
    return objects;
  }

  /**
   * Mengubah array of UI object.
   * @param objects array of UI object.
   */
  public void setObjects(ArrayList<UIobject> objects) {
    this.objects = objects;
  }
  
}
