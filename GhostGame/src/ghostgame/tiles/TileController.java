package ghostgame.tiles;

import java.awt.Graphics;

public class TileController {
	
	private Tile tile;
	private TileView view;
	
	public TileController(Tile tile, TileView view) {
		this.tile = tile;
		this.view = view;
	}
	
	public void render(Graphics g, int x, int y) {
		view.render(tile, g, x, y);
	}
	
	public boolean isTileSolid() {
		return tile.isSolid();
	}
	
	public void tick(){
		
	}

}
