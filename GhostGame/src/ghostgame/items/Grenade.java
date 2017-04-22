package ghostgame.items;

/**
  * File : Grenade.java
  * Kelas Grenade merupakan kelas real yang merepresentasikan 
  * senjata pisau dan interaksinya.
  * @author Catherine Almira - 13515111
  */

public class Grenade extends Item {
  private int attackPower;
  private int range;

  /**
    * Constructor dengan parameter.
    * Menciptakan objek Grenade.
    * @param texture gambar yang merepresentasikan Grenade.
    * @param name nama Grenade.
    * @param id id yang membedakan Grenade dengan Item yang lain.
    * @param attackPower nilai attack dari weapon.
    * @param range jarak efek dari weapon.
    */

  public Grenade(BufferedImage texture, String name, int id, int attackPower, int range) {
  	super(texture, name, id);
  	this.attackPower = attackPower;
  	this.range = range;
  }
}