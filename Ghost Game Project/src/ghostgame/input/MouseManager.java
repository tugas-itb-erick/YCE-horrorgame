package ghostgame.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import ghostgame.ui.UIManager;

/**
 * File : MouseManager.java.
 * Kelas MouseManager mengatur input dari mouse.
 * @author 
 */

public class MouseManager implements MouseListener, MouseMotionListener {

	private boolean leftPressed, rightPressed;
	private int mouseX, mouseY;
	private UIManager uiManager;
	
	/**
	  * Constructor
	  */

	public MouseManager() {
		
	}
	
  /** 
    * I.S. atribut uiManager sembarang.
    * F.S. atribut uiManager terdefinisi.
    * @param atk Nilai yang akan dimasukkan ke atribut uiManager.
    */

	public void setUIManager(UIManager uiManager) {
		this.uiManager = uiManager;
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
	
	public int getMouseY(){
		return mouseY;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1)
			leftPressed = true;
		else if(e.getButton() == MouseEvent.BUTTON3)
			rightPressed = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1)
			leftPressed = false;
		else if(e.getButton() == MouseEvent.BUTTON3)
			rightPressed = false;
		
		if(uiManager != null)
			uiManager.onMouseRelease(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		
		if(uiManager != null)
			uiManager.onMouseMove(e);
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
