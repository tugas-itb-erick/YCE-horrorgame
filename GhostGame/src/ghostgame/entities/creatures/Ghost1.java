package ghostgame.entities.creatures;

/** 
  * File : Ghost1.java.
  * Kelas yang merepresentasikan hantu pertama yang ada pada game ini.
  * @author Kevin Iswara - 13515085.
  */

import ghostgame.entities.Entity;

import ghostgame.gfx.Animation;

import ghostgame.gfx.Assets;

import ghosgame.entities.Ghost;

import ghostgame.Handler;

import ghostgame.inventory.Inventory;

import ghostgame.inventory.InventoryController;

import ghostgame.inventory.InventoryView;

import java.awt.Graphics;

import java.awt.image.BufferedImage;

import java.awt.Rectangle;

public abstract class Ghost1 extends Ghost {
	
	/**
	  * Constructor.
	  * @param handler Nilai yang menghubungkan World dengan Entity.
	  * @param x Nilai absis (posisi) dari Ghost1.
	  * @param y Nilai ordinar (posisi) dari Ghost1.
	  */

	public Ghost1(Handler handler, float x, float y) {
		super(handler, x, y);
		speed = 2.5f;
		//damage
		atk = 1;
		//Animatons
		ghostDown = new Animation(500, Assets.Ghost1_down);
		ghostUp = new Animation(500, Assets.Ghost1_up);
		ghostLeft = new Animation(500, Assets.Ghost1_left);
		ghostRight = new Animation(500, Assets.Ghost1_right);
	}

	/**
	  * Fungsi abstrak untuk mengubah xMove atau yMove.
	  */

	public abstract void changeMovement() {

	}
}