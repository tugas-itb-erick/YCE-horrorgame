package ghostgame.items;

/**
  * File : Key.java
  * Kelas Key merupakan kelas real yang merepresentasikan 
  * senjata pisau dan interaksinya.
  * @author Catherine Almira - 13515111
  */

public class Key extends Item {

  /**
    * Constructor dengan parameter.
    * Menciptakan objek Key.
    * @param texture gambar yang merepresentasikan Key.
    * @param name nama Key.
    * @param id id yang membedakan Key dengan Item yang lain.
    */

  public Key(BufferedImage texture, String name, int id) {
  	super(texture, name, id);
  }