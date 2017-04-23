package ghostgame.entities.creatures;

import java.awt.Graphics;

public class PlayerView {
	
	private PlayerController pc;
	
	/*public PlayerView(PlayerController pc) {
		this.pc = pc;
	}*/
	
	public void setPlayerController(PlayerController pc) {
		this.pc = pc;
	}
	
	public void render(Player player, Graphics g) {
		g.drawImage(pc.getCurrentAnimationFrame(), (int) (player.getX() - player.getHandler().getGameCamera().getxOffset()), 
		(int) (player.getY() - player.getHandler().getGameCamera().getyOffset()), player.getWidth(), player.getHeight(), null);
	}
	
	public void postRender(Player player, Graphics g) {
		pc.getInventoryController().render(g);
	}
}
