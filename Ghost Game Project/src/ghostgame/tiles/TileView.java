package ghostgame.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import ghostgame.gfx.Assets;

public class TileView {

	public void render(Tile tile, Graphics g, int x, int y){
		BufferedImage texture;
		switch (tile.getId()) {
			case 0: texture = Assets.grass; break;
			case 1: texture = Assets.dirt; break;
			case 2: texture = Assets.stone; break;
			default: texture = Assets.grass; break;
		}
		g.drawImage(texture, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT, null);
	}
	
}
