package ghostgame.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/** 
 * File : UIImageButton.java.
 * Kelas yang merepresentasikan object button interface yang ada pada game ini.
 * @author
 */

public class UIImageButton extends UIObject {

  private BufferedImage[] images;
  private ClickListener clicker;
  
  /**
   * Constructor dengan parameter.
   * @param x Posisi sumbu x.
   * @param y Posisi sumbu y.
   * @param width Lebar image button.
   * @param height Tinggi image button.
   * @param image Gambar image button.
   * @param clicker ClickListener. 
   */
  
  public UIImageButton(float x, float y, int width, int height, BufferedImage[] images, ClickListener clicker) {
    super(x, y, width, height);
    this.images = images;
    this.clicker = clicker;
  }

  /**
   * Mengupdate kondisi state setiap satuan waktu.
   */

  @Override
  public void tick() {}

  /**
   * Menampilkan gambar sesuai dengan jenisnya.
   * @param g Gambar.
   */

  @Override
  public void render(Graphics g) {
    if(hovering)
      g.drawImage(images[1], (int) x, (int) y, width, height, null);
    else
      g.drawImage(images[0], (int) x, (int) y, width, height, null);
  }

  /**
   * Mengubah state ketika click.
   */

  @Override
  public void onClick() {
    clicker.onClick();
  }

}
