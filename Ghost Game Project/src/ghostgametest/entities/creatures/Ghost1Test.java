package ghostgametest.entities.creatures;

import static org.junit.Assert.*;

import org.junit.Test;

import ghostgame.Handler;
import ghostgame.entities.creatures.Ghost1;

public class Ghost1Test {
	
	Handler handler = new Handler(null);
	Ghost1 ghost = new Ghost1(handler, 1, 2);
	
	@Test
	public void testChangeMovement() {
		System.out.println("Test if ghost returns xMove and yMove correctly...");
		ghost.changeMovement();
    assertTrue(ghost.getxmove() == 0);
    assertTrue(ghost.getymove() == 0);
	}

	@Test
	public void testGhost1() {
		System.out.println("Test if ghost created correctly");
    assertTrue(ghost.getX() == 1);
    assertTrue(ghost.getY() == 2);
    assertTrue(ghost.getSpeed() == 2.5f);
    assertTrue(ghost.getAtk() == 1);
	}

}
