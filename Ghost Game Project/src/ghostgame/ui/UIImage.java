package ghostgame.ui;

/**
  * File : UIImage.java.
  * Kelas UIImage merepresentasikan objek gambar.
  * @author Veren Iliana K - 13515057.
  */

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/** 
 * File : UIImage.java.
 * Kelas yang merepresentasikan object gambar interface yang ada pada game ini.
 * @author
 */

public class UIImage extends UIObject {

  private BufferedImage image;
  
  /**
   * Constructor dengan parameter.
   * @param x Posisi sumbu x.
   * @param y Posisi sumbu y.
   * @param width Lebar uiimage.
   * @param height Tinggi uiimage.
   * @param image gambar uiimage.
   */

  public UIImage(float x, float y, int width, int height, BufferedImage image) {
    super(x, y, width, height);
    this.image = image;
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
    g.drawImage(image, (int) x, (int) y, width, height, null);
  }

  /**
   * Mengubah state ketika click.
   */

  @Override
  public void onClick() {
  }

}
