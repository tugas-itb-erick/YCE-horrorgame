package item;

/**
  * File : Door.java
  * Kelas Door merupakan kelas real yang merepresentasikan 
  * pintu dan interaksinya.
  * @author Catherine Almira - 13515111
  */

public class Door extends Unpickable {
  
  private boolean locked;

  /**
    * Constructor tanpa parameter.
    */
  
  public Door() {
  	super("Door", 0, 0);
  	locked = true;
  }
  
  /**
    * Constructor dengan parameter.
    * @param name parameter nama dari Item.
    * @param locationX lokasi item dalam koordinat X.
    * @param locationY lokasi item dalam koordinat Y.
    * @param locked status apakah pintu terkunci atau tidak.
    */
  
  public Door(String name, int locationX, int locationY, boolean locked) {
  	super(name, locationX, locationY);
  	this.locked = locked;
  }

  /**
    * Mengembalikan status pintu apakah terkunci atau tidak.
    * @return locked true jika pintu terkunci.
    */

  public boolean isLocked() {
  	return locked;
  }

  /**
    * I.S. locked sembarang.
    * F.S. locked diisi dengan nilai locked yang baru.
    */

  public void setLocked(boolean locked) {
  	this.locked = locked;
  }

  /**
    * Mengembalikan string yang merupakan bentuk interaksi Player
    * dengan Item.
    * @return String yang merupakan keterangan Item.
    */

  public String interaction() {
  	if (isLocked()) {
  	  System.out.println("This door is locked.");
  	}
  }
}