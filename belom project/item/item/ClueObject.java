package item;

/**
  * File : ClueObject.java 
  * Kelas ClueObject merupakan kelas abstrak yang merepresentasikan 
  * barang-barang yang memberikan petunjuk dalam permainan.
  * @author Catherine Almira - 13515111
  */

public abstract class ClueObject extends Item {
  
  /**
    * Constructor tanpa parameter.
    */
  
  public ClueObject() {
  	super("ClueObject", 0, 0);
  }
  
  /**
    * Constructor dengan parameter.
    * @param name parameter nama dari Item.
    * @param locationX lokasi item dalam koordinat X.
    * @param locationY lokasi item dalam koordinat Y.
    */
  
  public ClueObject(String name, int locationX, int locationY) {
  	super(name, locationX, locationY);
  }

  /**
    * Mengembalikan string yang merupakan bentuk interaksi Player
    * dengan Item.
    * @return String yang merupakan keterangan Item.
    */

  public abstract String interaction();

}