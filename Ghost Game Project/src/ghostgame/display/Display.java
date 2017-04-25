package ghostgame.display;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * File : Display.java.
 * Kelas Display merepresentasikan tampilan.
 * @author 
 */

public class Display {

  private JFrame frame;
  private Canvas canvas;
  private String title;
  private int width, height;
  
  /**
   * Constructor.
   * @param title Nama display.
   * @param width Lebar display.
   * @param height Tinggi display.
   */

  public Display(String title, int width, int height) {
    this.title = title;
    this.width = width;
    this.height = height;
    
    createDisplay();
  }
  
  /**
   * Membuat display.
   */

  private void createDisplay() {
    frame = new JFrame(title);
    frame.setSize(width, height);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    
    canvas = new Canvas();
    canvas.setPreferredSize(new Dimension(width, height));
    canvas.setMaximumSize(new Dimension(width, height));
    canvas.setMinimumSize(new Dimension(width, height));
    canvas.setFocusable(false);
    
    frame.add(canvas);
    frame.pack();
  }

  /**
   * Mengembalikan canvas.
   * @return canvas.
   */

  public Canvas getCanvas() {
    return canvas;
  }
  
  /**
   * Mengembalikan frame.
   * @return frame.
   */
  
  public JFrame getFrame() {
    return frame;
  }
  
}
