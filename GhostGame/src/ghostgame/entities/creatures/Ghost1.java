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
		xMove = 0;
		yMove = 0;
		boolean up, down, left, right;
		boolean [][] mapTemp;
		int xPlayer, yPlayer;
		for (int i = 0; i < handler.getWorld().getWidth(); i++) {
			for (int j = 0; i < handler.getWorld().getHeight(); j++) {
				mapoTemp[i][j] = handler.getWorld().getTile(i,j).isSolid();
			}
		}
		for (Entity temp : handler.getWorld().getEntityManager().getEntities()) {
			mapTemp[(int)(temp.getX()/32)][(int)(temp.getY()/32)] = true;
		}
		xPlayer = (int)(handler.getworld().getEntityManager().getPlayer().getX()/32);
		yPlayer = (int)(handler.getworld().getEntityManager().getPlayer().getY()/32);
		int i = 0;
		boolean found = false;


		if (up)
			yMove = -speed;
		if (down)
			yMove = speed;
		if (left)
			xMove = -speed;
		if (right)
			xMove = speed;
	}

	private int bfs(int x, int y, int playerPositionX, int playerPositionY, boolean[][] map) {
		ArrayList<Integer> tempX = new ArrayList<Integer>();
		ArrayList<Integer> tempY = new ArrayList<Integer>();
		ArrayList<Integer> jarak = new ArrayList<Integer>();
		tempX.add(x);
		tempY.add(y);
		int i = 0;
		int range = 0;
		boolean found;
		while ((i < tempX.size()) && (!found)) {
			if((tempX[i] != playerPositionX) && (tempY[i] != playerPositionY)) {
				mapTemp[tempX[i]][tempY[i]] = true;
				if ((tempX[i]+1) < handler.getWorld().getWidth()) {

				}
			}
			else {
				found = true;
			}
			i++;
		}
	}
}