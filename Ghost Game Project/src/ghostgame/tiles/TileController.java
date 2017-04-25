package ghostgame.tiles;

import java.awt.Graphics;

/**
 * File : TileController.java.
 * Kelas TileController merepresentasikan tile controller.
 * @author 
 */

public class TileController {
	
	private Tile tile;
	private TileView view;
	
	/**
   * Constructor dengan parameter.
   * @param tile Nilai yang akan dimasukkan ke atribut tile.
   * @param view Nilai yang akan dimasukkan ke atribut view.
   */
	
	public TileController(Tile tile, TileView view) {
		this.tile = tile;
		this.view = view;
	}
	
	/**
   * Menampilkan gambar sesuai dengan jenisnya.
   */
	
	public void render(Graphics g, int x, int y) {
		view.render(tile, g, x, y);
	}
	
	/**
	 * Mengembalikan jenis tile (solid atau tidak).
	 * @return true jika tile solid.
	 */
	
	public boolean isTileSolid() {
		return tile.isSolid();
	}

	/**
	 * Mengembalikan tile.
	 * @return tile.
	 */
	
	public Tile getTile() {
		return tile;
	}
	
	/**
	 * Mengubah nilai tile.
	 * @param tile.
	 */
	
	public void setTile(Tile tile) {
		this.tile = tile;
	}
}
