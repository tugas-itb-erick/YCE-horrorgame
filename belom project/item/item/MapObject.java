package item;

/**
  * File : MapObject.java 
  * Kelas MapObject merupakan kelas real yang merepresentasikan 
  * barang-barang yang tidak dapat memberikan petunjuk dalam permainan.
  * @author Catherine Almira - 13515111
  */

public class MapObject extends Item {
  /**
    * Constructor tanpa parameter.
    */

  public MapObject() {
    super("MapObject", 0, 0);
  }

  /**
    * Constructor dengan parameter.
    * @param name String yang merupakan nama object.
    * @param locationX lokasi item dalam koordinat X.
    * @param locationY lokasi item dalam koordinat Y.
    */

  public MapObject(String name, int locationX, int locationY) {
    super(name, locationX, locationY);
  }

  /**
    * Mengembalikan string yang merupakan bentuk interaksi Player
    * dengan Item.
    * @return String yang merupakan keterangan Item.
    */

  public String interaction() {
  	System.out.println("You can't take this object.");
  }
}