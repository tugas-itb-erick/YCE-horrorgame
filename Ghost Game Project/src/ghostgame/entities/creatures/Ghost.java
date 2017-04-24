package ghostgame.entities.creatures;

/** 
  * File : Ghost.java
  * Kelas abstrak yang merepresentasikan hantu-hantu yang ada pada game ini
  * @author Kevin Iswara - 13515085
  */

import ghostgame.Handler;
import ghostgame.items.Item;

public abstract class Ghost extends Creature {
	
	protected int atk;
	
	/**
	  * Constructor dengan parameter.
	  * @param handler Nilai yang menghubungkan World dengan Entity.
	  * @param x Nilai absis (posisi) dari Ghost.
	  * @param y Nilai ordinar (posisi) dari Ghost.
	  */

	public Ghost(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		bounds.x = 22;
		bounds.y = 44;
		bounds.width = 19;
		bounds.height = 19;
	}

	/**
	  * Menghapus objek Ghost.
	  */

	@Override
	public void die() {
		handler.getWorld().getItemManager().addItem(Item.ghostAshItem.createNew(2));
	}
	
  /** 
    * I.S. atribut atk sembarang.
    * F.S. atribut atk terdefinisi.
    * @param atk Nilai yang akan dimasukkan ke atribut atk.
    */

	public void setAtk(int atk) {
		this.atk = atk;
	}

  /** 
    * Mengembalikan atk dari sebuah objek Ghost.
    * @return Nilai dari atribut atk.
    */

	public int getAtk() {
		return atk;
	}

	/**
	  * Fungsi abstrak untuk mengubah xMove atau yMove.
	  */

	public abstract void changeMovement();
}