package ghostgame.entities.statics;

import java.awt.Graphics;

/**
 * File : StaticEntityController.java 
 * Kelas abstrak StaticEntityController merupakan kelas yang mengatasi
 * interaksi pada StaticEntity.
 * @author Catherine Almira - 13515111
 */

public class StaticEntityController {

	private StaticEntity se;
	private StaticEntityView view;
	
	public StaticEntityController(StaticEntity se, StaticEntityView view) {
		this.se = se;
		this.view = view;
	}
	
	public void setStaticEntity(StaticEntity se) {
		this.se = se;
	}
	
	public void render(Graphics g) {
		assert(se != null);
		view.render(se, g);
	}
	
}
