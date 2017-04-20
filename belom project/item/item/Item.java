package item;

/**
  * File : Item.java 
  * Kelas item merupakan kelas abstrak yang merepresentasikan 
  * barang-barang yang terdapat dalam permainan.
  * @author Catherine Almira - 13515111
  */

public abstract class Item {
  protected String name;
  protected int locationX;
  protected int locationY;

  /**
    * Constructor tanpa parameter.
    */

  public Item() {
    name = "Tembok";
    locationX = 0;
    locationY = 0;
  }

  /**
    * Constructor dengan parameter.
    * @param name parameter nama dari Item.
    * @param locationX lokasi item dalam koordinat X.
    * @param locationY lokasi item dalam koordinat Y.
    */

  public Item(String name, int locationX, int locationY) {
    this.name = name;
    this.locationX = locationX;
    this.locationY = locationY;
  }

  /**
    * Mengembalikan nama Item.
    * @return nama Item.
    */

  public String getName() {
    return name;
  }

  /**
    * Mengembalikan koordinat X lokasi.
    * @return lokasi item dalam koordinat X.
    */

  public int getLocationX() {
    return locationX;
  }

  /**
    * Mengembalikan koordinat Y lokasi.
    * @return lokasi item dalam koordinat Y.
    */

  public int getLocationY() {
    return locationY;
  }

  /**
    * I.S. name sembarang.
    * F.S. name diisi dengan nilai name yang baru.
    */

  public void setName(String name) {
    this.name = name;
  }

  /**
    * I.S. locationX sembarang.
    * F.S. locationX diisi dengan nilai locationX yang baru.
    */

  public void setLocationX(int locationX) {
    this.locationX = locationX;
  }

  /**
    * I.S. locationY sembarang.
    * F.S. locationY diisi dengan nilai locationY yang baru.
    */

  public void setLocationY(int locationY) {
    this.locationY = locationY;
  }

  /**
    * Mengembalikan string yang merupakan bentuk interaksi Player
    * dengan Item.
    * @return String yang merupakan keterangan Item.
    */

  public abstract String interaction();
}