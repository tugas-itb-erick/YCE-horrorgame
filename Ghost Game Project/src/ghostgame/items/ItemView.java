package ghostgame.items;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import ghostgame.gfx.Assets;

/**
 * File : ItemView.java 
 * Kelas ItemView merupakan kelas yang merepresentasikan tampilan dari
 * barang-barang yang terdapat dalam permainan.
 * @author Catherine Almira - 13515111
 */

public class ItemView {
  
  /**
   * Menggambar item ke layar.
   * @param item jenis item yang akan digambar di layar.
   * @param g grafik yang menyatakan item yang bersesuaian.
   */
  
  public void render(Item item, Graphics g){
    if(item.getHandler() == null)
      return;
    render(item, g, (int) (item.getX() - item.getHandler().getGameCamera().getxOffset()), 
    (int) (item.getY() - item.getHandler().getGameCamera().getyOffset()));
  }
  
  /**
   * Menggambar item ke layar.
   * @param item jenis item yang akan digambar di layar.
   * @param g grafik yang menyatakan item yang bersesuaian.
   * @param x posisi dalam koordinat x.
   * @param y posisi dalam koordinat y.
   */
  
  public void render(Item item, Graphics g, int x, int y){
    BufferedImage texture;
    switch (item.getId()) {
      case 0: texture = Assets.key; break;
      case 1: texture = Assets.candle; break;
      case 2: texture = Assets.knife; break;
      case 3: texture = Assets.gold; break;
      case 4: texture = Assets.ghostAsh; break;
      default: texture = Assets.ghostAsh; break;
    }
    g.drawImage(texture, x, y, item.getWidth(), item.getHeigth(), null);
  }
  
}
