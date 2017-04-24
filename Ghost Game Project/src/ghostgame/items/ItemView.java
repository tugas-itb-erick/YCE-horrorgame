package ghostgame.items;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import ghostgame.gfx.Assets;

public class ItemView {
		
	public void render(Item item, Graphics g){
		if(item.getHandler() == null)
			return;
		render(item, g, (int) (item.getX() - item.getHandler().getGameCamera().getxOffset()), 
		(int) (item.getY() - item.getHandler().getGameCamera().getyOffset()));
	}
	
	public void render(Item item, Graphics g, int x, int y){
		BufferedImage texture;
		switch (item.getId()) {
			case 0: texture = Assets.key; break;
			case 1: texture = Assets.candle; break;
			case 2: texture = Assets.knife; break;
			case 3: texture = Assets.knife; break;
			case 4: texture = Assets.knife; break;
			default: texture = Assets.knife; break;
		}
		g.drawImage(texture, x, y, item.getWidth(), item.getHeigth(), null);
	}
	
}
