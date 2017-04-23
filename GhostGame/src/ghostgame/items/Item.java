package ghostgame.items;

import ghostgame.gfx.Assets;

import ghostgame.Handler;

import java.awt.Graphics;

import java.awt.image.BufferedImage;

import java.awt.Rectangle;

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
  public static Item grenadeItem = new Item(Assets.grenade, "Grenade", 1);
  public static Item keyItem = new Item(Assets.key, "Key", 2);
  public static Item candleItem = new Item(Assets.candle, "Candle", 3);
  
  // Class

  public static final int ITEMWIDTH = 32, ITEMHEIGHT = 32;
  
  protected Handler handler;
  protected BufferedImage texture;
  protected String name;
  protected final int id;

  protected Rectangle bounds;
  
  protected int x;
  protected int y;
  protected int count;
  protected boolean pickedUp;

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
    pickedUp = false;
    bounds = new Rectangle(x, y, ITEMWIDTH, ITEMHEIGHT);
    items[id] = this;
  }
  
  /**
    * Mengembalikan handler.
    * @return handler
    */

  public Handler getHandler() {
    return handler;
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
    * I.S. handler sembarang.
    * F.S. handler objek terdefinisi sesuai dengan handler.
    * @param handler nilai handler yang baru.
    */

  public void setHandler(Handler handler) {
    this.handler = handler;
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

  public int getX() {
    return x;
  }

  /**
    * I.S. locationX sembarang.
    * F.S. locationX diisi dengan nilai locationX yang baru.
    * @param x posisi x yang baru.
    */

  public void setX(int x) {
    this.x = x;
  }

  /**
    * Mengembalikan koordinat Y lokasi.
    * @return lokasi item dalam koordinat Y.
    */

  public int getY() {
    return y;
  }

  /**
    * I.S. locationY sembarang.
    * F.S. locationY diisi dengan nilai locationY yang baru.
    * @param y posisi y yang baru.
    */

  public void setY(int y) {
    this.y = y;
  }

  /**
    * Mengembalikan jumlah item yang diperoleh.
    * @return jumlah item yang diperoleh.
    */

  public int getCount() {
    return count;
  }

  /**
    * I.S. count sembarang.
    * F.S. count diisi dengan nilai count yang baru.
    * @param y posisi y yang baru.
    */

  public void setCount(int count) {
    this.count = count;
  }

  /**
    * Mengembalikan id item.
    * @return id item.
    */

  public int getId() {
    return id;
  }

  /**
    * Mengembalikan bounds dari item.
    * @return bounds item.
    */

  public Rectangle getBounds() {
    return bounds;
  }
  
  /**
    * Mengembalikan status keterambilan item.
    * @return true jika item bisa diambil.
    */

  public boolean isPickedUp() {
    return pickedUp;
  }
  
  /**
    * I.S. locationX dan locationY sembarang.
    * F.S. locationX dan locationY diisi dengan nilai x, y yang baru.
    * @param x lokasi pada sumbu x yang baru.
    * @param y lokasi pada sumbu y yang baru.
    */

  public void setPosition(int x, int y){
    this.x = x;
    this.y = y;
    bounds.x = x;
    bounds.y = y;
  }
}
