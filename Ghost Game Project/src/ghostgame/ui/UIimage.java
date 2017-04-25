package ghostgame.ui;

/**
  * File : UIimage.java.
  * Kelas UIimage merepresentasikan objek gambar.
  * @author Veren Iliana K - 13515057.
  */

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/** 
 * File : UIimage.java.
 * Kelas yang merepresentasikan object gambar interface yang ada pada game ini.
 * @author
 */

public class UIimage extends UIobject {

  private BufferedImage image;
  
  /**
   * Constructor dengan parameter.
   * @param x Posisi sumbu x.
   * @param y Posisi sumbu y.
   * @param width Lebar UIimage.
   * @param height Tinggi UIimage.
   * @param image gambar UIimage.
   */

  public UIimage(float x, float y, int width, int height, BufferedImage image) {
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
    g.drawImage(image, (int) posX, (int) posY, width, height, null);
  }

  /**
   * Mengubah state ketika click.
   */

  @Override
  public void onClick() {
  }

}
