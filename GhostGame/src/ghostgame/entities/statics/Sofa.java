package ghostgame.entities.statics;

/**
  * File : Sofa.java 
  * Kelas Sofa merupakan kelas yang merepresentasikan
  * sofa.
  * @author Catherine Almira - 13515111
  */

import ghostgame.gfx.Assets;

import ghostgame.Handler;

import ghostgame.items.Item;

import ghostgame.items.ItemController;

import ghostgame.items.ItemView;

import ghostgame.tiles.Tile;

public class Sofa extends StaticEntity {
  
  /**
    * Constructor dengan parameter untuk menciptakan Sofa.
    * @param handler penghubung world dengan entitas.
    * @param x posisi dalam koordinat x.
    * @param y posisi dalam koordinat y.
    */

  public Sofa(Handler handler, float x, float y) {
  	super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT * 2);
  	bounds.x = 3;
	  bounds.y = (int) (height / 2f);
	  bounds.width = width - 6;
	  bounds.height = (int) (height - height / 2f);
  }
}