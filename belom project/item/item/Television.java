package item;

/**
  * File : Television.java
  * Kelas Television merupakan kelas real yang merepresentasikan 
  * pintu dan interaksinya.
  * @author Catherine Almira - 13515111
  */

public class Television extends Unpickable {
  
  /**
    * Constructor tanpa parameter.
    */
  
  public Television() {
  	super("Television", 0, 0);
  }
  
  /**
    * Constructor dengan parameter.
    * @param name parameter nama dari Item.
    * @param locationX lokasi item dalam koordinat X.
    * @param locationY lokasi item dalam koordinat Y.
    */
  
  public Television(String name, int locationX, int locationY) {
  	super(name, locationX, locationY);
  }

  /**
    * Mengembalikan string yang merupakan bentuk interaksi Player
    * dengan Television.
    * @return String yang merupakan keterangan Television.
    */

  public String interaction() {
  	System.out.println("Old television");
  }
}