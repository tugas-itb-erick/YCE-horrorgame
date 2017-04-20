package item;

/**
  * File : Pickable.java 
  * Kelas Pickable merupakan kelas abstrak yang merepresentasikan 
  * barang-barang yang memberikan petunjuk dalam permainan dan dapat
  * dibawa oleh player.
  * @author Catherine Almira - 13515111
  */

public abstract class Pickable extends ClueObject {
  
  /**
    * Constructor tanpa parameter.
    */
  
  public Pickable() {
  	super("PickableObject", 0, 0);
  }
  
  /**
    * Constructor dengan parameter.
    * @param name parameter nama dari Item.
    * @param locationX lokasi item dalam koordinat X.
    * @param locationY lokasi item dalam koordinat Y.
    */
  
  public Pickable(String name, int locationX, int locationY) {
  	super(name, locationX, locationY);
  }

  /**
    * Mengembalikan string yang merupakan bentuk interaksi Player
    * dengan Item.
    * @return String yang merupakan keterangan Item.
    */

  public abstract String interaction();
}