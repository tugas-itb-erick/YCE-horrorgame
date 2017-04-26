package ghostgame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Kelas KeyManager mengatur input dari keyboard.
 * @author Erick Wijaya - 13515057
 */

public class KeyManager implements KeyListener {
  
  private boolean[] keys;
  private boolean[] justPressed;
  private boolean[] cantPress;
  public boolean up;
  public boolean down;
  public boolean left;
  public boolean right;
  public boolean aup;
  public boolean adown;
  public boolean aleft;
  public boolean aright;
  
  /**
    * Constructor.
    */
  
  public KeyManager() {
    keys = new boolean[256];
    justPressed = new boolean[keys.length];
    cantPress = new boolean[keys.length];
  }
  
  /**
     * Meng-update kondisi keyboard untuk setiap satuan waktu.
     */

  public void tick() {
    for (int i = 0;i < keys.length;i++) {
      if (cantPress[i] && !keys[i]) {
        cantPress[i] = false;
      } else if (justPressed[i]) {
        cantPress[i] = true;
        justPressed[i] = false;
      }
      if (!cantPress[i] && keys[i]) {
        justPressed[i] = true;
      }
    }
    up = keys[KeyEvent.VK_W];
    down = keys[KeyEvent.VK_S];
    left = keys[KeyEvent.VK_A];
    right = keys[KeyEvent.VK_D];
    aup = keys[KeyEvent.VK_UP];
    adown = keys[KeyEvent.VK_DOWN];
    aleft = keys[KeyEvent.VK_LEFT];
    aright = keys[KeyEvent.VK_RIGHT];
  }
  
  /**
    * @param keyCode Nilai yang akan di cek.
    * @return mengembalikan false jika keyCode melebihi batas dan true jika sebaliknya
    */
  
  public boolean keyJustPressed(int keyCode) {
    if (keyCode < 0 || keyCode >= keys.length) {
      return false;
    }
    return justPressed[keyCode];
  }

  @Override
  public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() < 0 || e.getKeyCode() >= keys.length) {
      return;
    }
    keys[e.getKeyCode()] = true;
  }

  /* (non-Javadoc)
   * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
   */
  @Override
  public void keyReleased(KeyEvent e) {
    if (e.getKeyCode() < 0 || e.getKeyCode() >= keys.length) {  
      return;
    }
    keys[e.getKeyCode()] = false;
  }

  /**
    * Meng-update kondisi objek Ghost untuk setiap satuan waktu.
    */

  @Override
  public void keyTyped(KeyEvent e) {
    
  }

}
