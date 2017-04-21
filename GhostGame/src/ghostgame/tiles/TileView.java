package ghostgame.tiles;

import java.awt.Graphics;

public class TileView {

	public void render(Tile tile, Graphics g, int x, int y){
		g.drawImage(tile.getTexture(), x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT, null);
	}
	
}
