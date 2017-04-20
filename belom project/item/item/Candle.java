package item;

/**
  * File : Candle.java
  * Kelas Candle merupakan kelas real yang merepresentasikan 
  * lilin dan interaksinya.
  * @author Catherine Almira - 13515111
  */

public class Candle extends Pickable {
  private int timeLeft;
  private boolean light;

  /**
    * Constructor tanpa parameter.
    */
  
  public Candle() {
  	super("Candle", 0, 0);
  	timeLeft = 0;
  	light = false;
  }
  
  /**
    * Constructor dengan parameter.
    * @param name parameter nama dari Item.
    * @param locationX lokasi item dalam koordinat X.
    * @param locationY lokasi item dalam koordinat Y.
    * @param timeLeft waktu yang tersisa untuk lilin tetap menyala.
    * @param light status candle apakah menyala atau tidak.
    */
  
  public Pickable(String name, int locationX, int locationY, int timeLeft, boolean light) {
  	super(name, locationX, locationY);
  	this.timeLeft = timeLeft;
  	this.light = light;
  }

  /**
    * Mengembalikan string yang merupakan bentuk interaksi Player
    * dengan Item.
    * @return String yang merupakan keterangan Item.
    */

  public String interaction() {
  	System.out.println("You got a candle");
  }

}