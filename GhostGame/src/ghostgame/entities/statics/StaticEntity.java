package ghostgame.entities.statics;

/**
  * File : StaticEntity.java 
  * Kelas abstrak StaticEntity merupakan kelas yang merepresentasikan objek-objek statik
  * yang ada pada game.
  * @author Catherine Almira - 13515111
  */

import ghostgame.entities.Entity;

import ghostgame.Handler;

public abstract class StaticEntity extends Entity {
	
  /**
    * Constructor dengan parameter untuk menciptakan StaticEntity.
    * @param handler penghubung world dengan entitas.
    * @param x posisi dalam koordinat x.
    * @param y posisi dalam koordinat y.
    * @param width lebar gambar yang akan dicetak.
    * @param height panjang gambar yang akan dicetak.
    */
  
  public StaticEntity(Handler handler, float x, float y, int width, int height){
	super(handler, x, y, width, height);
  }

}