package item;

/**
  * File : Weapon.java
  * Kelas Weapon merupakan kelas abstrak yang merepresentasikan 
  * senjata yang dapat digunakan player untuk menyerang ghost.
  * @author Catherine Almira - 13515111
  */

public abstract class Weapon extends Pickable {
  protected int attackPower;
  protected int range;

  /**
    * Constructor tanpa parameter.
    */
  
  public Weapon() {
    super("Weapon", 0, 0);
    attackPower = 0;
    range = 0;
  }
  
  /**
    * Constructor dengan parameter.
    * @param name parameter nama dari Item.
    * @param locationX lokasi item dalam koordinat X.
    * @param locationY lokasi item dalam koordinat Y.
    * @param attackPower nilai attack dari weapon.
    * @param range jarak efek dari weapon.
    */
  
  public Weapon(String name, int locationX, int locationY, int attackPower, int range) {
    super(name, locationX, locationY);
    this.attackPower = attackPower;
    this.range = range;
  }

  /**
    * Mengembalikan string yang merupakan bentuk interaksi Player
    * dengan Item.
    * @return String yang merupakan keterangan Item.
    */

  public abstract String interaction();

}