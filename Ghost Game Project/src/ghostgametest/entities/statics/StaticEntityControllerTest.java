package ghostgametest.entities.statics;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ghostgame.Handler;
import ghostgame.entities.statics.StaticEntity;
import ghostgame.entities.statics.StaticEntityController;
import ghostgame.entities.statics.StaticEntityView;

public class StaticEntityControllerTest {
  Handler handler = new Handler(null);
	StaticEntity se = new StaticEntity(handler, 0, 1, 2, 3, 4);
	StaticEntityView view;
	
	@Test
	public void testStaticEntityController() {
		StaticEntityController sec = new StaticEntityController(se, view);
		assertEquals(se, sec.getStaticEntity());
	}

	@Test
	public void testSetStaticEntity() {
		StaticEntityController sec = new StaticEntityController(se, view);
		StaticEntity se2 = new StaticEntity(handler, 1, 2, 3, 4, 5);
		sec.setStaticEntity(se2);
		assertEquals(se2, sec.getStaticEntity());
	}

}
