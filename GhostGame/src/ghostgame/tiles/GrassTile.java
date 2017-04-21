package ghostgame.tiles;

import ghostgame.gfx.Assets;

public class GrassTile extends Tile {

	public GrassTile(int id) {
		super(Assets.grass, id);
	}

	@Override
	public boolean isSolid() {
		// TODO Auto-generated method stub
		return false;
	}

}
