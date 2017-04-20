package item;

/**
  * File : Granat.java
  * Kelas Granat merupakan kelas abstrak yang merepresentasikan 
  * senjata granat dan interaksinya.
  * @author Catherine Almira - 13515111
  */

public abstract class Granat extends Weapon {
  
  /**
    * Constructor tanpa parameter.
    */
  
  public Granat() {
    super("Granat", 0, 0, 0, 0);
  }
  
  /**
    * Constructor dengan parameter.
    * @param name parameter nama dari Item.
    * @param locationX lokasi item dalam koordinat X.
    * @param locationY lokasi item dalam koordinat Y.
    * @param attackPower nilai attack dari weapon.
    * @param range jarak efek dari weapon.
    */
  
  public Granat(String name, int locationX, int locationY, int attackPower, int range) {
    super(name, locationX, locationY, attackPower, range);
  }

  /**
    * Mengembalikan string yang merupakan bentuk interaksi Player
    * dengan Item.
    * @return String yang merupakan keterangan Item.
    */

  public String interaction() {
  	System.out.println("You got a Granat!");
  }

}