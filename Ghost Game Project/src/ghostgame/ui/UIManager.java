package ghostgame.ui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import ghostgame.Handler;

public class UIManager {

  private Handler handler;
  private ArrayList<UIObject> objects;
  
  /**
   * Constructor dengan parameter.
   * @param handler Menghubungkan world dengan UI manager.
   */
  
  public UIManager(Handler handler){
    this.handler = handler;
    objects = new ArrayList<UIObject>();
  }
  
  /**
   * Mengupdate kondisi state setiap satuan waktu.
   */

  public void tick(){
    for(UIObject o : objects)
      o.tick();
  }

  /**
   * Menampilkan gambar sesuai dengan jenisnya.
   * @param g Gambar.
   */
  
  public void render(Graphics g){
    for(UIObject o : objects)
      o.render(g);
  }
  
  /**
   * Mengubah state ketika mouse bergerak.
   * @param e MouseEvent.
   */

  public void onMouseMove(MouseEvent e){
    for(UIObject o : objects)
      o.onMouseMove(e);
  }
  
  /**
   * Mengubah state ketika mouse dilepas.
   * @param e MouseEvent.
   */

  public void onMouseRelease(MouseEvent e){
    for(UIObject o : objects)
      o.onMouseRelease(e);
  }
  
  /**
   * Menambah object.
   * @param e object.
   */

  public void addObject(UIObject o){
    objects.add(o);
  }
  
  /**
   * Menghapus object.
   * @param o object.
   */
  public void removeObject(UIObject o){
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
  public ArrayList<UIObject> getObjects() {
    return objects;
  }

  /**
   * Mengubah array of UI object.
   * @param array of UI object.
   */
  public void setObjects(ArrayList<UIObject> objects) {
    this.objects = objects;
  }
  
}
