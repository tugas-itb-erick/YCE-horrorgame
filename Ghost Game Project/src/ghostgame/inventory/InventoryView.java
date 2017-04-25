package ghostgame.inventory;

import ghostgame.gfx.Assets;
import ghostgame.gfx.Text;
import ghostgame.items.Item;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * File : InventoryView.java
 * Kelas Inventory merupakan kelas real yang merepresentasikan 
 * inventory dan interaksinya.
 * @author Catherine Almira - 13515111
 */

public class InventoryView {

  private int invX = 64;
  private int invY = 48;
  private int invWidth = 512;
  private int invHeight = 384;
  private int invListCenterX = invX + 171;
  private int invListCenterY = invY + invHeight / 2 + 5;
  private int invListSpacing = 30;
  
  private int invImageX = 452;
  private int invImageY = 82;
  private int invImageWidth = 64;
  private int invImageHeight = 64;
  
  private int invCountX = 484;
  private int invCountY = 172;
  
  /**
   * Menampilkan gambar inventory.
   * @param inventory yang akan dicetak.
   * @param g grafik yang akan ditampilkan sebagai inventory.
   */
  
  public void render(Inventory inventory, Graphics g) {
    int selectedItem = inventory.getSelectedItem();
    
    if (!inventory.isActive()) {
      return;
    }
    
    g.drawImage(Assets.inventoryScreen, invX, invY, invWidth, invHeight, null);
    
    int len = inventory.getInventoryItems().size();
    if (len == 0) {
      return;
    }
    
    for (int i = -5;i < 6;i++) {
      if (selectedItem + i < 0 || selectedItem + i >= len) {
        continue;
      }
      if (i == 0) {
        Text.drawString(g, "> " + inventory.getInventoryItems().get(selectedItem + i).getName()
            + " <", invListCenterX, invListCenterY
            + i * invListSpacing, true, Color.YELLOW, Assets.font28);
      } else {
        Text.drawString(g, inventory.getInventoryItems().get(selectedItem + i).getName(),
            invListCenterX, invListCenterY + i * invListSpacing, true, Color.WHITE, Assets.font28);
      }
    }
    
    Item item = inventory.getInventoryItems().get(selectedItem);
    BufferedImage texture;
    switch (item.getId()) {
      case 0: texture = Assets.key;
      break;
      case 1: texture = Assets.candle;
      break;
      case 2: texture = Assets.knife;
      break;
      case 3: texture = Assets.gold;
      break;
      case 4: texture = Assets.ghostAsh;
      break;
      default: texture = Assets.ghostAsh;
      break;
    }
    g.drawImage(texture, invImageX, invImageY, invImageWidth, invImageHeight, null);
    Text.drawString(g, Integer.toString(item.getCount()), invCountX, invCountY,
        true, Color.WHITE, Assets.font28);
  }
}
