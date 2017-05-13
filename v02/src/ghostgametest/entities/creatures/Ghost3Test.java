package ghostgametest.entities.creatures;

import static org.junit.Assert.*;

import org.junit.Test;

import ghostgame.Handler;
import ghostgame.entities.creatures.Ghost3;

public class Ghost3Test {

	Handler handler = new Handler(null);
	Ghost3 ghost = new Ghost3(handler, 1, 2);
	
	@Test
	public void testGhost3() {
		System.out.println("Test if ghost created correctly");
    assertTrue(ghost.getX() == 1);
    assertTrue(ghost.getY() == 2);
    assertTrue(ghost.getSpeed() == 3f);
    assertTrue(ghost.getAtk() == 3);
	}

}
