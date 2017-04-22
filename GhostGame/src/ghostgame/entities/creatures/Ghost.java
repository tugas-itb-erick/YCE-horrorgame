package ghostgame.entities.creatures;

/** 
  * File : Ghost.java
  * Kelas abstrak yang merepresentasikan hantu-hantu yang ada pada game ini
  * @author Kevin Iswara - 13515085
  */

import ghostgame.entities.Entity;

import ghostgame.gfx.Animation;

import ghostgame.gfx.Assets;

import ghostgame.Handler;

import ghostgame.inventory.Inventory;

import ghostgame.inventory.InventoryController;

import ghostgame.inventory.InventoryView;

import java.awt.Graphics;

import java.awt.image.BufferedImage;

import java.awt.Rectangle;

public abstract class Ghost extends Creature {
	
	// Animations
	private Animation ghostDown, ghostUp, ghostLeft, ghostRight;
	// Attack
	private int atk;
	
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
	  * Meng-update kondisi objek Ghost untuk setiap satuan waktu.
	  */

	@Override
	public void tick() {
		//Animations
		ghostDown.tick();
		ghostUp.tick();
		ghostRight.tick();
		ghostLeft.tick();
		//Finding movement
		changeMovement();
		//Movement
		move();
		//Attack
		checkCollision();
	}

	/**
	  * Menghapus objek Ghost.
	  */

	@Override
	public void die(){
		handler.getWorld().getEntityManager().deleteEntity(this);
	}

	/**
	  * Fungsi yang menampilkan gambar (frame) dari ghost.
	  * @param g Nilai grafik yang mencetak gambar (frame) dari ghost.
	  */

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()),
		(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}
	
	/**
	  * Fungsi yang mengembalikan gambar (frame) dari ghost sesuai dengan arah geraknya.
	  * Jika arah gerak sedang ke atas (yMove negatif) maka mengembalikan frame dari 
	  * ghostUp.
	  * Jika arah gerak sedang ke bawah (yMove positif) maka mengembalikan frame dari 
	  * ghostDown.
	  * Jika arah gerak sedang ke kanan (xMove positif) maka mengembalikan frame dari 
	  * ghostRight.
	  * Jika arah gerak sedang ke kiri (xMove negatif) maka mengembalikan frame dari 
	  * ghostLeft.
	  * @return Frame yang bersesuaian dengan ghost yang akan ditampilkan.
	  */

	private BufferedImage getCurrentAnimationFrame(){
		if(xMove < 0){
			return ghostLeft.getCurrentFrame();
		}else if(xMove > 0){
			return ghostRight.getCurrentFrame();
		}else if(yMove < 0){
			return ghostUp.getCurrentFrame();
		}else{
			return ghostDown.getCurrentFrame();
		}
	}

  /** 
    * I.S. atribut atk sembarang.
    * F.S. atribut atk terdefinisi.
    * @param atk Nilai yang akan dimasukkan ke atribut atk.
    */

	public void setAtk(String atk) {
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

	public abstract void changeMovement() {

	}
}