package ghostgametest.entities.statics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ghostgame.Handler;
import ghostgame.entities.statics.StaticEntity;

public class StaticEntityTest {
  Handler handler = new Handler(null);
  
	@Test
	public void testHurt() {
		StaticEntity se = new StaticEntity(handler, 0, 1, 2, 3, 4);
		se.hurt(10);
		assertTrue(se.isActive());
	}

	@Test
	public void testStaticEntity() {
		StaticEntity se = new StaticEntity(handler, 0, 1, 2, 3, 4);
		assertEquals(se.getId(), 0);
	}

	@Test
	public void testGetId() {
		StaticEntity se = new StaticEntity(handler, 3, 1, 2, 3, 4);
		assertEquals(se.getId(), 3);
	}

}
