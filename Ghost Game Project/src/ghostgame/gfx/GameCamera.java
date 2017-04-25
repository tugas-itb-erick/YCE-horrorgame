package ghostgame.gfx;

import ghostgame.Handler;
import ghostgame.entities.Entity;
import ghostgame.tiles.Tile;

/**
  * Kelas GameCamera yang mengatur posisi pusat (bagian mana yang ditampilkan).
  * @author 
  */

public class GameCamera {
	
	private Handler handler;
	private float xOffset, yOffset;
	
	/**
	  * Constructor dengan parameter.
	  * @param handler Nilai yang menghubungkan World dengan kelas yang
	  * berhubungan.
	  * @param xOffset Nilai yang menentukan offset horizontal.
	  * @param yOffset Nilai yang menentukan offset vertikal.
	  */
	
	public GameCamera(Handler handler, float xOffset, float yOffset) {
		this.handler = handler;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	/**
	  * Mengecek apakah ada space kosong.
	  */
	
	public void checkBlankSpace() {
		if (xOffset < 0) {
			xOffset = 0;
		} else if (xOffset > handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth()) {
			xOffset = handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth();
		}
		if(yOffset < 0) {
			yOffset = 0;
		} else if (yOffset > handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getHeight()) {
			yOffset = handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getHeight();
		}
	}
	
	/**
	  * Mengubah xOffset dan yOffset sesuai dengan posisi e.
	  * @param e Nilai object yang akan dijadikan pusat kamera.
	  */
	
	public void centerOnEntity(Entity e) {
		xOffset = e.getX() - handler.getWidth() / 2 + e.getWidth() / 2;
		yOffset = e.getY() - handler.getHeight() / 2 + e.getHeight() / 2;
		checkBlankSpace();
	}
	
	/**
	  * Mengubah xOffset dan yOffset sesuai dengan inputan.
	  * @param xAmt Nilai pergerakan dari xOffset.
	  * @param yAmt Nilai pergerakan dari yOffset.
	  */
	
	public void move(float xAmt, float yAmt) {
		xOffset += xAmt;
		yOffset += yAmt;
		checkBlankSpace();
	}

	/**
	  * Mengembalikan nilai xOffset dari GameCamera.
	  * @return Nilai xOffset dari GameCamera.
	  */
	
	public float getxOffset() {
		return xOffset;
	}

	/**
	  * I.S. Nilai xOffset sembarang.
	  * F.S. Nilai xOffset terdefinisi.
	  * @param xOffset Nilai yang akan dimasukan ke dalam xOffset.
	  */
	
	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	/**
	  * Mengembalikan nilai yOffset dari GameCamera.
	  * @return Nilai yOffset dari GameCamera.
	  */

	public float getyOffset() {
		return yOffset;
	}

	/**
	  * I.S. Nilai yOffset sembarang.
	  * F.S. Nilai yOffset terdefinisi.
	  * @param yOffset Nilai yang akan dimasukan ke dalam yOffset.
	  */
	
	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}

}
