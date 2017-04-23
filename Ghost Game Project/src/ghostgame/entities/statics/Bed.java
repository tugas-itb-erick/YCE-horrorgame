package ghostgame.entities.statics;

/**
  * File : Bed.java 
  * Kelas Bed merupakan kelas yang merepresentasikan
  * ranjang.
  * @author Catherine Almira - 13515111
  */

import ghostgame.Handler;

import ghostgame.tiles.Tile;

public class Bed extends StaticEntity {
  
  /**
    * Constructor dengan parameter untuk menciptakan Bed.
    * @param handler penghubung world dengan entitas.
    * @param x posisi dalam koordinat x.
    * @param y posisi dalam koordinat y.
    */

  public Bed(Handler handler, float x, float y) {
  	super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT * 2);
  	bounds.x = 3;
	  bounds.y = (int) (height / 2f);
	  bounds.width = width - 6;
  	bounds.height = (int) (height - height / 2f);
  }

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}
}