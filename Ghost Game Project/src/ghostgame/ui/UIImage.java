package ghostgame.ui;

/**
  * File : UIImage.java.
  * Kelas UIImage merepresentasikan objek gambar 
  * @author Veren Iliana K - 13515057
  */

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class UIImage extends UIObject {

  private BufferedImage image;
  
  /**
   * Constructor dengan parameter.
   * @param handler Menghubungkan world dengan state.
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
   */

  @Override
  public void render(Graphics g) {
    g.drawImage(image, (int) x, (int) y, width, height, null);
  }

  /**
   * Mengubah state.
   */
  @Override
  public void onClick() {
  }

}
