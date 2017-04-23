package ghostgame.entities.creatures;

/** 
  * File : Ghost3.java.
  * Kelas yang merepresentasikan hantu kedua yang ada pada game ini.
  * @author Kevin Iswara - 13515085.
  */

import ghostgame.entities.Entity;

import ghostgame.Handler;

import java.util.ArrayList;

public class Ghost3 extends Ghost {
	
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
	}

	/**
	  * Fungsi untuk mengubah xMove atau yMove.
	  */

	public void changeMovement() {
		xMove = 0;
		yMove = 0;
		boolean up, down, left, right;
		up = false;
		down = false;
		left = false;
		right = false;
		int upInt, downInt, leftInt, rightInt;
		boolean [][] mapTemp = new boolean[handler.getWorld().getWidth()][handler.getWorld().getHeight()] ;
		int xPlayer, yPlayer;
		for (int i = 0; i < handler.getWorld().getWidth(); i++) {
			for (int j = 0; i < handler.getWorld().getHeight(); j++) {
				mapTemp[i][j] = handler.getWorld().getTile(i,j).isSolid();
			}
		}
		for (Entity temp : handler.getWorld().getEntityManager().getEntities()) {
			mapTemp[(int)(temp.getX() / 32)][(int)(temp.getY() / 32)] = true;
		}
		xPlayer = (int)(handler.getWorld().getEntityManager().getPlayer().getX() / 32);
		yPlayer = (int)(handler.getWorld().getEntityManager().getPlayer().getY() / 32);
		try {
			upInt = bfs((int)x, (int)(y - 1), (int)xPlayer, (int)yPlayer, mapTemp);
		} catch (ArrayIndexOutOfBoundsException e) {
			upInt = 999;
		}
		try {
			downInt = bfs((int)x, (int)(y + 1), (int)xPlayer, (int)yPlayer, mapTemp);
		} catch (ArrayIndexOutOfBoundsException e) {
			downInt = 999;
		}
		try {
			leftInt = bfs((int)(x-1), (int)y, (int)xPlayer, (int)yPlayer, mapTemp);
		} catch (ArrayIndexOutOfBoundsException e) {
			leftInt = 999;
		}
		try {
			rightInt = bfs((int)(x+1), (int)y, (int)xPlayer, (int)yPlayer, mapTemp);
		} catch (ArrayIndexOutOfBoundsException e) {
			rightInt = 999;
		}
		if (upInt >= downInt) {
			if (upInt >= leftInt) {
				 if (upInt >= rightInt) {
				 	up = true;
				 } else {
				 	right = true;
				 }
			} else {
				if (leftInt >= rightInt) {
					left = true;
				} else {
					right = true;
				}
			}
		} else {
			if (downInt >= leftInt) {
				 if (downInt >= rightInt) {
				 	down = true;
				 } else {
				 	right = true;
				 }
			} else {
				if (leftInt >= rightInt) {
					left = true;
				} else {
					right = true;
				}
			}	
		}
		if ((up) && (upInt != 999)) {
			yMove = -speed;
		}
		if ((down) && (downInt != 999)) {
			yMove = speed;
		}
		if ((left) && (leftInt != 999)) {
			xMove = -speed;
		}
		if ((right) && (rightInt != 999)) {
			xMove = speed;
		}
	}

	/**
	  * Mengembalikan jumlah jalan terdekat menuju posisi yang akan dituju.
	  * @param x absis dri posisi awal.
	  * @param y ordinat dari posisi awal.
	  * @param playerPositionX absis dari posisi yang akan dituju.
	  * @param playerPositionY ordinat dari posisi yang akan dituju.
	  * @param map matriks yang berisi boolean yang dapat dilalui dan tidak.
	  * @return Nilai jumlah jalan yang dihasilkan.
	  */

	private int bfs(int x, int y, int playerPositionX, int playerPositionY, boolean[][] map) {
		ArrayList<Integer> tempX = new ArrayList<Integer>();
		ArrayList<Integer> tempY = new ArrayList<Integer>();
		ArrayList<Integer> range = new ArrayList<Integer>();
		tempX.add(x);
		tempY.add(y);
		range.add(0);
		int i = 0;
		map[tempX.get(i)][tempY.get(i)] = true;
		boolean found = false;
		while ((i < tempX.size()) && (!found)) {
			if ((tempX.get(i) != playerPositionX) && (tempY.get(i) != playerPositionY)) {
				if ((tempX.get(i) + 1) < handler.getWorld().getWidth()) {
					if ((map[tempX.get(i) + 1][tempY.get(i)]) == false) {
						tempX.add(tempX.get(i) + 1);
						tempY.add(tempY.get(i));
						range.add(range.get(i) + 1);
						map[tempX.get(i) + 1][tempY.get(i)] = true;
					}
				} 
				if ((tempX.get(i) - 1) >= 0) {
					if ((map[tempX.get(i) - 1][tempY.get(i)]) == false) {
						tempX.add(tempX.get(i) - 1);
						tempY.add(tempY.get(i));
						range.add(range.get(i) + 1);
						map[tempX.get(i) - 1][tempY.get(i)] = true;
					}
				}
				if ((tempY.get(i) + 1) < handler.getWorld().getHeight()) {
					if ((map[tempX.get(i)][tempY.get(i) + 1]) == false) {
						tempX.add(tempX.get(i));
						tempY.add(tempY.get(i) + 1);
						range.add(range.get(i) + 1);
						map[tempX.get(i)][tempY.get(i) + 1] = true;
					}
				}
				if ((tempY.get(i) - 1) >= 0) {
					if ((map[tempX.get(i)][tempY.get(i) - 1]) == false) {
						tempX.add(tempX.get(i));
						tempY.add(tempY.get(i) - 1);
						range.add(range.get(i) + 1);
						map[tempX.get(i)][tempY.get(i) - 1] = true;
					}
				}
				i++;
			} else {
				found = true;
			}
		}
		if (found) {
			return range.get(i);
		} else {
			return 999;
		}
	}
}