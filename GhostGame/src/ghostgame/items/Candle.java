package ghostgame.items;

/**
  * File : Candle.java
  * Kelas Candle merupakan kelas real yang merepresentasikan 
  * senjata pisau dan interaksinya.
  * @author Catherine Almira - 13515111
  */

public class Candle extends Item {

  /**
    * Constructor dengan parameter.
    * Menciptakan objek Candle.
    * @param texture gambar yang merepresentasikan candle.
    * @param name nama candle.
    * @param id id yang membedakan candle dengan Item yang lain.
    */

  public Candle(BufferedImage texture, String name, int id) {
  	super(texture, name, id);
  }