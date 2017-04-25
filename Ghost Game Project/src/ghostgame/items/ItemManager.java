package ghostgame.items;

import ghostgame.Handler;
import ghostgame.tiles.Tile;

import java.awt.Graphics;

import java.util.ArrayList;

import java.util.Iterator;

/**
 * Kelas ItemManager merupakan kelas yang melakukan penanganan terhadap seluruh
 * Item yang terdapat pada permainan.
 * @author Catherine Almira - 13515111
 */

public class ItemManager {
  
  private Handler handler;
  private ArrayList<Item> items;
  private ItemController ic;
  
  /**
   * Constructor dengan parameter.
   * @param handler nilai yang menyatakan keterhubungan item dengan world.
   */
  
  public ItemManager(Handler handler) {
    this.handler = handler;
    items = new ArrayList<Item>();
    ic = new ItemController(null, new ItemView());
  }
  
  /**
   * Mengupdate ItemManager setiap satuan waktu.
   */
  
  public void tick() {
    assert (ic != null);
    
    Iterator<Item> it = items.iterator();
    while (it.hasNext()) {
      ic.setItem(it.next());
      ic.tick();
      if (ic.isItemPickedUp()) {
        it.remove();
      }
    }
  }
  
  /**
   * Mencetak ItemManager ke layar.
   * @param g grafik yang menyatakan ItemManager.
   */
  
  public void render(Graphics g, int xstart, int ystart, int xend, int yend) {
    assert (ic != null);
    
    for (Item i : items) {
      if (i.getX()/Tile.TILEWIDTH >= xstart && i.getX()/Tile.TILEWIDTH < xend
      && i.getY()/Tile.TILEWIDTH >= ystart && i.getY()/Tile.TILEWIDTH < yend) {
	      ic.setItem(i);
	      ic.render(g);
      }
    }
  }
  
  /**
   * Menambahkan Item ke dalam daftar Item.
   * @param i item yang akan ditambahkan.
   */
  
  public void addItem(Item i) {
    assert (ic != null);
    
    ic.setItem(i);
    ic.setHandler(handler);
    items.add(ic.getItem());
  }
  
  /**
   * Mengembalikan handler yang merupakan nilai yang menyatakan keterhubungan
   * world dengan item.
   * @return nilai yang menyatakan keterhubungan world dengan Item.
   */

  public Handler getHandler() {
    return handler;
  }

  /**
   * I.S. handler sembarang.
   * F.S. handler terdefinisi sesuai dengan handler yang baru.
   * @param handler yang baru.
   */
  
  public void setHandler(Handler handler) {
    this.handler = handler;
  }

}
