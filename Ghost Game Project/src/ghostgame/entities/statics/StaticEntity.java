package ghostgame.entities.statics;

import ghostgame.Handler;
import ghostgame.entities.Entity;

/**
 * File : StaticEntity.java 
 * Kelas abstrak StaticEntity merupakan kelas yang merepresentasikan objek-objek statik
 * yang ada pada game.
 * @author Catherine Almira - 13515111
 */

public class StaticEntity extends Entity {
	
	private int id;
	
  /**
   * Constructor dengan parameter untuk menciptakan StaticEntity.
   * @param handler penghubung world dengan entitas.
   * @param x posisi dalam koordinat x.
   * @param y posisi dalam koordinat y.
   * @param width lebar gambar yang akan dicetak.
   * @param height panjang gambar yang akan dicetak.
   */
	
	public StaticEntity(Handler handler, int id, float x, float y, int width, int height){
		super(handler, x, y, width, height);
		this.id = id;
		bounds.x = 3;
	  bounds.y = (int) (height / 2f);
	  bounds.width = width - 6;
	  bounds.height = (int) (height - height / 2f);
	}

	/**
	 * Mengembalikan id dari StaticEntity.
	 * @return id dari StaticEntity.
	 */
	
	public int getId() {
		return id;
	}
	
	@Override
	public void hurt(int amt){
		if (id == 2)
			active = false;
	}
	
}
