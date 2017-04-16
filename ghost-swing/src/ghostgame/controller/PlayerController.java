/** 
  * File PlayerController.java.
  * Kelas PlayerController 
  * @author Kevin Iswara - 13515086.
  */
public class PlayerController {
	private Player model;
	private PlayerView view;

	public PlayerController() {
		model = new Player();
		view = new PlayerView();
	}

	public PlayerController(String name, int hp, int x, int y) {
		model = new Player(name,hp,x,y);
	}

	public void setPlayerName(String name) {
		model.setName(name);
	}

	public String getPlayerName() {
		return model.getName();
	}

	public void setPlayerHp(int hp) {
		model.setHp(hp);
	}

	public int getPlayerHp() {
		return model.getHp();
	}

	public void setPlayerPosition(Point p) {
		model.setPosition(p);
	}

	public Point getPlayerPosition() {
		return model.getPosition();
	}
}