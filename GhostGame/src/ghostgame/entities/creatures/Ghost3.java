package ghostgame.entities.creatures;

/** 
  * File : Ghost2.java.
  * Kelas yang merepresentasikan hantu kedua yang ada pada game ini.
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

public abstract class Ghost3 extends Ghost {
	
	/**
	  * Constructor.
	  * @param handler Nilai yang menghubungkan World dengan Entity.
	  * @param x Nilai absis (posisi) dari Ghost3.
	  * @param y Nilai ordinar (posisi) dari Ghost3.
	  */

	public Ghost3(Handler handler, float x, float y) {
		super(handler, x, y);
		speed = 3.5f;
		//damage
		atk = 3;
		//Animatons
		ghostDown = new Animation(500, Assets.Ghost3_down);
		ghostUp = new Animation(500, Assets.Ghost3_up);
		ghostLeft = new Animation(500, Assets.Ghost3_left);
		ghostRight = new Animation(500, Assets.Ghost3_right);
	}

	/**
	  * Fungsi abstrak untuk mengubah xMove atau yMove.
	  */

	public abstract void changeMovement() {

	} 
}