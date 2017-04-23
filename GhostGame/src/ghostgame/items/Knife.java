package ghostgame.items;

/**
  * File : Knife.java
  * Kelas Knife merupakan kelas real yang merepresentasikan 
  * senjata pisau dan interaksinya.
  * @author Catherine Almira - 13515111
  */

public class Knife extends Item {
  private int attackPower;

  /**
    * Constructor dengan parameter.
    * Menciptakan objek Grenade.
    * @param texture gambar yang merepresentasikan Grenade.
    * @param name nama Grenade.
    * @param id id yang membedakan Grenade dengan Item yang lain.
    * @param attackPower nilai attack dari weapon.
    */

  public Knife(BufferedImage texture, String name, int id, int attackPower) {
  	super(texture, name, id);
  	this.attackPower = attackPower;
  }
}