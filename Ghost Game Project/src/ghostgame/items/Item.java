package ghostgame.items;

import java.awt.Rectangle;

import ghostgame.Handler;

/**
  * File : Item.java 
  * Kelas item merupakan kelas yang merepresentasikan 
  * barang-barang yang terdapat dalam permainan.
  * @author Catherine Almira - 13515111
  */

public class Item {
  
  // Static Instances
  public static Item keyItem = new Item("Key", 0);
  public static Item candleItem = new Item("Candle", 1);
  public static Item knifeItem = new Item("Knife", 2);
  public static Item ghostAshItem = new Item("Ghost Ash", 3);
  public static Item goldItem = new Item("Gold", 4);
  
  // Class Body
  public static final int ITEMWIDTH = 32, ITEMHEIGHT = 32;
  
  private Handler handler;
  private String name;
  private final int id;
  
  private Rectangle bounds;
  
  private int x, y, count;
  private int width, heigth;
  private boolean pickedUp = false;
  
  public Item(String name, int id) {
    this.name = name;
    this.id = id;
    count = 1;
    
    width = ITEMWIDTH;
    heigth = ITEMHEIGHT;
    
    bounds = new Rectangle(x, y, width, heigth);
  }
  
  /**
    * Constructor.
    * Menciptakan objek Item.
    * @param texture gambar yang merepresentasikan Item.
    * @param name nama Item.
    * @param id id yang membedakan satu Item dengan Item yang lain.
    */
  
  public Item(String name, int id, int width, int height) {
    this.name = name;
    this.id = id;
    count = 1;
    
    bounds = new Rectangle(x, y, width, heigth);
  }
  
  /**
    * Menciptakan Item dengan jumlah yang ditentukan.
    * @param count jumlah item yang akan dibuat.
    * @return item dengan jumlah yang baru.
    */
  
  public Item createNew(int count) {
    Item i = new Item(name, id);
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
    Item i = new Item(name, id);
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
    this.x = x;
    this.y = y;
    bounds.x = x;
    bounds.y = y;
  }
  
  /**
    * Mengembalikan handler yang merupakan pengubung antara world dengan item.
    * @return penghubung antara world dengan item.
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
    * F.S. handler terdefinisi sesuai dengan handler baru yang diharapkan.
    * @param handler nilai pengubung item dengan world.
    */
  
  public void setHandler(Handler handler) {
    this.handler = handler;
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
   * Mengembalikan banyaknya item.
   * @return banyaknya item.
   */

  public int getCount() {
    return count;
  }

  /**
   * I.S. count sembarang.
   * F.S. count diisi dengan nilai count yang baru.
   * @param count
   */
  
  public void setCount(int count) {
    this.count = count;
  }

  /**
   * Mengembalikan id dari suatu item.
   * @return id dari item.
   */
  
  public int getId() {
    return id;
  }

  /**
   * Mengembalikan status keterambilan item.
   * @return status keterambilan item.
   */
  
  public boolean isPickedUp() {
    return pickedUp;
  }

  /**
   * Mengembalikan nilai bounds dari item yang menyatakan daerah yang solid (tidak
   * dapat dilewati oleh Player).
   * @return nilai bounds item.
   */
  
  public Rectangle getBounds() {
    return bounds;
  }

  /**
   * Mengubah nilai yang menyatakan daerah yang solid.
   * @param bounds nilai bounds yang baru.
   */
  
  public void setBounds(Rectangle bounds) {
    this.bounds = bounds;
  }
  
  /**
   * Mengembalikan lebar item yang akan dicetak.
   * @return mengembalikan lebar item.
   */

  public int getWidth() {
    return width;
  }

  /**
   * Mengembalikan panjang item yang akan dicetak.
   * @return mengembalikan panjang item.
   */
  
  public int getHeigth() {
    return heigth;
  }
}
