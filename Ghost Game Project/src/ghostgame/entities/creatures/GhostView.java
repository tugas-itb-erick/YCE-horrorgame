package ghostgame.entities.creatures;

import java.awt.Graphics;

/**
  * Kelas yang mengatur view dari Ghost.
  * @author Kevin Iswara - 13515085.
  */

public class GhostView {
	
	private GhostController gc;
	
	/**
	  * Constructor dengan parameter.
	  * @param gc Nilai yang digunakan untuk mengakses keterangan gambar ghost.
	  */
	
	public void setGhostController(GhostController gc) {
		this.gc = gc;
	}

	/**
	  * Fungsi yang menampilkan gambar (frame) dari ghost.
	  * @param g Nilai grafik yang mencetak gambar (frame) dari ghost.
	  */

	public void render(Ghost ghost, Graphics g) {
		g.drawImage(gc.getCurrentAnimationFrame(), (int) (ghost.getX() - ghost.getHandler().getGameCamera().getxOffset()),
		(int) (ghost.getY() - ghost.getHandler().getGameCamera().getyOffset()), ghost.getWidth(), ghost.getHeight(), null);
	}
}
