package ghostgame.items;

import java.awt.Graphics;

public class ItemView {
	
	public void render(Item item, Graphics g){
		if(item.getHandler() == null)
			return;
		render(item, g, (int) (item.getX() - item.getHandler().getGameCamera().getxOffset()), 
				(int) (item.getY() - item.getHandler().getGameCamera().getyOffset()));
	}
	
	public void render(Item item, Graphics g, int x, int y){
		g.drawImage(item.getTexture(), x, y, Item.ITEMWIDTH, Item.ITEMHEIGHT, null);
	}
	
}
