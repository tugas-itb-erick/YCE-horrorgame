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
			case 0: texture = Assets.wood; break;
			case 1: texture = Assets.rock; break;
			default: texture = Assets.wood; break;
		}
		g.drawImage(texture, x, y, item.getWidth(), item.getHeigth(), null);
	}
	
}
