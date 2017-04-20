package item;

/**
  * File : Door.java
  * Kelas Door merupakan kelas real yang merepresentasikan 
  * pintu dan interaksinya.
  * @author Catherine Almira - 13515111
  */

public class Wardrobe extends Unpickable {
  
  /**
    * Constructor tanpa parameter.
    */
  
  public Wardrobe() {
  	super("Wardrobe", 0, 0);
  }
  
  /**
    * Constructor dengan parameter.
    * @param name parameter nama dari Item.
    * @param locationX lokasi item dalam koordinat X.
    * @param locationY lokasi item dalam koordinat Y.
    */
  
  public Wardrobe(String name, int locationX, int locationY) {
  	super(name, locationX, locationY);
  }

  /**
    * Mengembalikan string yang merupakan bentuk interaksi Player
    * dengan wardrobe.
    * @return String yang merupakan keterangan wardrobe.
    */

  public String interaction() {
  	System.out.println("Old wardrobe");
  }

}