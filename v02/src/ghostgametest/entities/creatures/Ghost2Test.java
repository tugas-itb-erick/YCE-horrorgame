package ghostgametest.entities.creatures;

import static org.junit.Assert.*;

import org.junit.Test;

import ghostgame.Handler;
import ghostgame.entities.creatures.Ghost2;

public class Ghost2Test {

	Handler handler = new Handler(null);
	Ghost2 ghost = new Ghost2(handler, 1, 2);

	@Test
	public void testGhost2() {
		System.out.println("Test if ghost created correctly");
    assertTrue(ghost.getX() == 1);
    assertTrue(ghost.getY() == 2);
    assertTrue(ghost.getSpeed() == 2.3f);
    assertTrue(ghost.getAtk() == 2);
	}

}
