package ghostgame.entities.creatures;

/** 
  * File : Ghost2.java.
  * Kelas yang merepresentasikan hantu kedua yang ada pada game ini.
  * @author Kevin Iswara - 13515085.
  */

import ghostgame.entities.Entity;
import ghostgame.tiles.Tile;
import ghostgame.Handler;

import java.util.ArrayList;

public class Ghost2 extends Ghost {
	
	/**
	  * Constructor.
	  * @param handler Nilai yang menghubungkan World dengan Entity.
	  * @param x Nilai absis (posisi) dari Ghost2.
	  * @param y Nilai ordinar (posisi) dari Ghost2.
	  */

	public Ghost2(Handler handler, float x, float y) {
		super(handler, x, y);
		//damage
		atk = 2;
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
			for (int j = 0; j < handler.getWorld().getHeight(); j++) {
				mapTemp[i][j] = handler.getWorld().getTile(i,j).isSolid();
			}
		}
		for (Entity temp : handler.getWorld().getEntityManager().getEntities()) {
			mapTemp[(int)(temp.getX() / Tile.TILEWIDTH)][(int)(temp.getY() / Tile.TILEHEIGHT)] = true;
		}
		mapTemp[(int)(handler.getWorld().getEntityManager().getPlayer().getX() / Tile.TILEWIDTH)]
		[(int)(handler.getWorld().getEntityManager().getPlayer().getY() / Tile.TILEHEIGHT)] = false;
		xPlayer = (int)(handler.getWorld().getEntityManager().getPlayer().getX() / Tile.TILEWIDTH);
		yPlayer = (int)(handler.getWorld().getEntityManager().getPlayer().getY() / Tile.TILEHEIGHT);
		try {
			if(mapTemp[(int)x / Tile.TILEWIDTH][(int)(y / Tile.TILEHEIGHT) - 1] == false) {
				upInt = bfs((int)x / Tile.TILEWIDTH, (int)(y / Tile.TILEHEIGHT) - 1, (int)xPlayer, (int)yPlayer, mapTemp);
			} else {
				upInt = 999;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			upInt = 999;
		}
		try {
			if(mapTemp[(int)x / Tile.TILEWIDTH][(int)(y / Tile.TILEHEIGHT) + 1] == false) {
				downInt = bfs((int)x / Tile.TILEWIDTH, (int)(y / Tile.TILEHEIGHT) + 1, (int)xPlayer, (int)yPlayer, mapTemp);
			} else {
				downInt = 999;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			downInt = 999;
		}
		try {
			if(mapTemp[(int)(x / Tile.TILEWIDTH) - 1][(int)y / Tile.TILEHEIGHT] == false) {
				leftInt = bfs((int)(x / Tile.TILEWIDTH) - 1, (int)y / Tile.TILEHEIGHT, (int)xPlayer, (int)yPlayer, mapTemp);
			} else {
				leftInt = 999;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			leftInt = 999;
		}
		try {
			if(mapTemp[(int)(x / Tile.TILEWIDTH) + 1][(int)y / Tile.TILEHEIGHT] == false) {
				rightInt = bfs((int)(x / Tile.TILEWIDTH) + 1, (int)y / Tile.TILEHEIGHT, (int)xPlayer, (int)yPlayer, mapTemp);
			} else {
				rightInt = 999;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			rightInt = 999;
		}
		if (upInt <= downInt) {
			if (upInt <= leftInt) {
				 if (upInt <= rightInt) {
				 	up = true;
				 } else {
				 	right = true;
				 }
			} else {
				if (leftInt <= rightInt) {
					left = true;
				} else {
					right = true;
				}
			}
		} else {
			if (downInt <= leftInt) {
				 if (downInt <= rightInt) {
				 	down = true;
				 } else {
				 	right = true;
				 }
			} else {
				if (leftInt <= rightInt) {
					left = true;
				} else {
					right = true;
				}
			}	
		}
		if ((up) && (upInt < 5)) {
			yMove = -speed;
		}
		if ((down) && (downInt < 5)) {
			yMove = speed;
		}
		if ((left) && (leftInt < 5)) {
			xMove = -speed;
		}
		if ((right) && (rightInt < 5)) {
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
		boolean[][] mapTemp = new boolean [map.length][map[map.length-1].length];
		for (int i = 0; i < map.length; i++) {
			mapTemp[i][i] = map[i][i];
		}
		tempX.add(x);
		tempY.add(y);
		range.add(0);
		int i = 0;
		mapTemp[tempX.get(i)][tempY.get(i)] = true;
		boolean found = false;
		while ((i < tempX.size()) && (!found)) {
			if ((tempX.get(i) != playerPositionX) || (tempY.get(i) != playerPositionY)) {
				if ((tempX.get(i) + 1) < handler.getWorld().getWidth()) {
					if ((mapTemp[tempX.get(i) + 1][tempY.get(i)]) == false) {
						tempX.add(tempX.get(i) + 1);
						tempY.add(tempY.get(i));
						range.add(range.get(i) + 1);
						mapTemp[tempX.get(i) + 1][tempY.get(i)] = true;
					}
				} 
				if ((tempX.get(i) - 1) >= 0) {
					if ((mapTemp[tempX.get(i) - 1][tempY.get(i)]) == false) {
						tempX.add(tempX.get(i) - 1);
						tempY.add(tempY.get(i));
						range.add(range.get(i) + 1);
						mapTemp[tempX.get(i) - 1][tempY.get(i)] = true;
					}
				}
				if ((tempY.get(i) + 1) < handler.getWorld().getHeight()) {
					if ((mapTemp[tempX.get(i)][tempY.get(i) + 1]) == false) {
						tempX.add(tempX.get(i));
						tempY.add(tempY.get(i) + 1);
						range.add(range.get(i) + 1);
						mapTemp[tempX.get(i)][tempY.get(i) + 1] = true;
					}
				}
				if ((tempY.get(i) - 1) >= 0) {
					if ((mapTemp[tempX.get(i)][tempY.get(i) - 1]) == false) {
						tempX.add(tempX.get(i));
						tempY.add(tempY.get(i) - 1);
						range.add(range.get(i) + 1);
						mapTemp[tempX.get(i)][tempY.get(i) - 1] = true;
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