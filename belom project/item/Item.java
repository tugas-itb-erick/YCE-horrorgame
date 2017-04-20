import java.awt.Graphics;

import java.awt.Rectangle;

import java.awt.image.BufferedImage;

/**
  * File : Item.java 
  * Kelas item merupakan kelas abstrak yang merepresentasikan 
  * barang-barang yang terdapat dalam permainan.
  * @author Catherine Almira - 13515111
  */

public class Item {
  
  // Handler

  public static Item[] items = new Item[256];
  public static Item knifeItem = new Item(Assets.knife, "Knife", 0);
  public static Item knifeItem = new Item(Assets.grenade, "Grenade", 1);
  public static Item knifeItem = new Item(Assets.bed, "Bed", 2);
  public static Item knifeItem = new Item(Assets.wardrobe, "Wardrobe", 3);
  public static Item knifeItem = new Item(Assets.key, "Key", 4);
  public static Item knifeItem = new Item(Assets.chair, "Chair", 5);
  public static Item knifeItem = new Item(Assets.candle, "Candle", 6);
  public static Item knifeItem = new Item(Assets.refrigerator, "Refrigerator", 7);
  public static Item knifeItem = new Item(Assets.television, "Television", 8);
  public static Item knifeItem = new Item(Assets.table, "Table", 9);
  public static Item knifeItem = new Item(Assets.sofa, "Sofa", 10);
  public static Item knifeItem = new Item(Assets.doorHorizontal, "Door Horizontal", 11);
  public static Item knifeItem = new Item(Assets.doorVertical, "Door Vertical", 12);
  //tambahan item jika ada

  // Class
  public static final int ITEMWIDTH = 32;
  public static final int ITEMHEIGHT = 32;

  protected BufferedImage texture;
  protected String name;
  protected final int id;

  protected Rectangle bounds;

  protected int locationX;
  protected int locationY;
  protected int count;
  protected boolean pickedUp = false;

  /**
    * Constructor.
    * Menciptakan objek Item.
    * @param texture gambar yang merepresentasikan Item.
    * @param name nama Item.
    * @param id id yang membedakan satu Item dengan Item yang lain.
    */
  
  public Item(BufferedImage texture, String name, int id) {
    this.texture = texture;
    this.name = name;
    this.id = id;
    count = 1;
    bounds = new Rectangle(x, y, ITEMWIDTH, ITEMHEIGHT);
    items[id] = this;
  }

  /**
    * Menampilkan gambar Item pada posisi x, y.
    * @param g
    * @param x
    * @param y
    */

  public void render(Graphics g, int x, int y) {
    g.drawImage(texture, x, y, ITEMWIDTH, ITEMHEIGHT, null);
  }
  
  /**
    * Menciptakan Item dengan jumlah yang ditentukan.
    * @param count jumlah item yang akan dibuat.
    * @return item dengan jumlah yang baru.
    */

  public Item createNew(int count) {
    Item i = new Item(texture, name, id);
    i.setPickedUp(true);
    i.setCount(count);
    return i;
  }

  /**
    * Menciptakan Item dengan posisi yang ditentukan.
    * @param x posisi Item dalam sumbu x.
    * @param y posisi Item dalam sumbu y.
    * @return item dengan posisi x, y.
    */

  public Item createNew(int x, int y) {
    Item i = new Item(texture, name, id);
    i.setPosition(x, y);
    return i;
  }
  
  /**
    * I.S. locationX dan locationY sembarang.
    * F.S. locationX dan locationY diisi dengan nilai x, y yang baru.
    * @param x lokasi pada sumbu x yang baru.
    * @param y lokasi pada sumbu y yang baru.
    */

  public void setPosition(int x, int y) {
    locationX = x;
    locationY = y;
    bounds.x = x;
    bounds.y = y;
  }

  /**
    * I.S. pickedUp sembarang.
    * F.S. pickedUp diisi dengan status pickedUp yang baru.
    * @param pickedUp status keterambilan Item.
    */

  public void setPickedUp(boolean pickedUp) {
    this.pickedUp = pickedUp;
  }

  /**
    * Mengembalikan gambar yang merepresentasikan Item.
    * @return gambar yang merepresentasikan Item.
    */

  public BufferedImage getTexture() {
    return texture;
  }
  
  /**
    * I.S. texture sembarang.
    * F.S. texture diisi dengan gambar texture yang baru.
    * @param pickedUp gambar yang merepresentasikan Item.
    */

  public void setTexture(BufferedImage texture) {
    this.texture = texture;
  }
  
  /**
    * Mengembalikan nama Item.
    * @return nama Item.
    */

  public String getName() {
      return name;
  }
  
  /**
    * I.S. name sembarang.
    * F.S. name diisi dengan nilai name yang baru.
    * @param name nama item.
    */

  public void setName(String name) {
    this.name = name;
  }

  /**
    * Mengembalikan koordinat X lokasi.
    * @return lokasi item dalam koordinat X.
    */

  public int getLocationX() {
    return locationX;
  }

  /**
    * I.S. locationX sembarang.
    * F.S. locationX diisi dengan nilai locationX yang baru.
    * @param x posisi x yang baru.
    */

  public void setLocationX(int x) {
    locationX = x;
  }

  /**
    * Mengembalikan koordinat Y lokasi.
    * @return lokasi item dalam koordinat Y.
    */

  public int getLocationY() {
    return locationY;
  }
  
  /**
    * I.S. locationY sembarang.
    * F.S. locationY diisi dengan nilai locationY yang baru.
    * @param y posisi y yang baru.
    */

  public void setLocationY(int y) {
    locationY = y;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public int getId() {
    return id;
  }

  public boolean isPickedUp() {
    return pickedUp;
  }
}