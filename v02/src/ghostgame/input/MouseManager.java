package ghostgame.input;

import ghostgame.ui.UImanager;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;



/**
 * Kelas MouseManager mengatur input dari mouse.
 * @author Erick Wijaya - 13515057
 */

public class MouseManager implements MouseListener, MouseMotionListener {

  private boolean leftPressed;
  private boolean rightPressed;
  private int mouseX;
  private int mouseY;
  private UImanager uimanager;
  
  /**
    * Constructor.
    */

  public MouseManager() {
    
  }
  
  /** 
    * I.S. atribut UImanager sembarang.
    * F.S. atribut UImanager terdefinisi.
    * @param uimanager Nilai yang akan dimasukkan ke atribut UImanager.
    */

  public void setUImanager(UImanager uimanager) {
    this.uimanager = uimanager;
  }
  
  /**
    * Fungsi yang mengembalikan true jika mouse kiri di klick
    * dan false jika tidak.
    * @return Nilai dari leftPressed;
    */
  
  public boolean isLeftPressed() {
    return leftPressed;
  }

  /**
    * Fungsi yang mengembalikan true jika mouse kanan di klick
    * dan false jika tidak.
    * @return Nilai dari rightPressed;
    */
  
  public boolean isRightPressed() {
    return rightPressed;
  }
  
  /**
    * Fungsi yang mengembalikan nilai mouseX.
    * @return Nilai dari mouseX.
    */
  
  public int getMouseX() {
    return mouseX;
  }

  /**
    * Fungsi yang mengembalikan nilai mouseY.
    * @return Nilai dari mouseY.
    */
  
  public int getMouseY() {
    return mouseY;
  }
  
  @Override
  public void mousePressed(MouseEvent e) {
    if (e.getButton() == MouseEvent.BUTTON1) {
      leftPressed = true;
    } else if (e.getButton() == MouseEvent.BUTTON3) {
      rightPressed = true;
    }
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    if (e.getButton() == MouseEvent.BUTTON1) {
      leftPressed = false;
    } else if (e.getButton() == MouseEvent.BUTTON3) {
      rightPressed = false;
    }
    if (uimanager != null) {
      uimanager.onMouseRelease(e);
    }
  }

  @Override
  public void mouseMoved(MouseEvent e) {
    mouseX = e.getX();
    mouseY = e.getY();
    
    if (uimanager != null) {
      uimanager.onMouseMove(e);
    }
  }
  
  @Override
  public void mouseDragged(MouseEvent e) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void mouseEntered(MouseEvent e) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void mouseExited(MouseEvent e) {
    // TODO Auto-generated method stub
    
  }
}
