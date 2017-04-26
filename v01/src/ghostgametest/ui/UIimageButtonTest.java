package ghostgametest.ui;

import static org.junit.Assert.assertTrue;
import ghostgame.ui.UIimageButton;

import java.awt.image.BufferedImage;

import org.junit.Test;

public class UIimageButtonTest {

	BufferedImage images[];
	UIimageButton o = new UIimageButton(2, 3, 4, 5, images, null);

	@Test
	public void testGetX() {
		System.out.println("Test if getX returns x correctly...");
	  assertTrue(o.getX() == 2);
	}
	
	@Test
	public void testSetX() {
		System.out.println("Test if setX is correct ...");
	  o.setX((float)3.1);
	  assertTrue(o.getX() == (float)3.1);
	}
	
	@Test
	public void testGetY() {
			System.out.println("Test if getY returns y correctly...");
	    assertTrue(o.getY() == 3);
	}
	
	@Test
	public void testSetY() {
		System.out.println("Test if setY is correct ...");
	  o.setY((float)5.2);
	  assertTrue(o.getY() == (float)5.2);
	}
	
	@Test
	public void testGetWidth() {
		System.out.println("Test if getWidth returns width correctly...");
	  assertTrue(o.getWidth() == 4);
	}
	
	@Test
	public void testSetWidth() {
		System.out.println("Test if setWidth is correct ...");
	  o.setWidth(2);
	  assertTrue(o.getWidth() == 2);
	}
	
	@Test
	public void testGetHeight() {
		System.out.println("Test if geHeight returns height correctly...");
	  assertTrue(o.getHeight() == 5);
	}
	
	@Test
	public void testSetHeight() {
		System.out.println("Test if setHeight is correct ...");
	  o.setHeight(4);
	  assertTrue(o.getHeight() == 4);
	}
}
