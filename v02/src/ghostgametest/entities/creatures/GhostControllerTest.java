package ghostgametest.entities.creatures;

import static org.junit.Assert.*;

import org.junit.Test;

import ghostgame.Handler;
import ghostgame.entities.creatures.Ghost1;
import ghostgame.entities.creatures.GhostController;
import ghostgame.entities.creatures.GhostView;

public class GhostControllerTest {
	
	Handler handler = new Handler(null);
	Ghost1 ghost = new Ghost1(handler, 1, 1);
	GhostView view = new GhostView();
	GhostController gc = new GhostController(ghost,view);
	
	@Test
	public void testGhostController() {
		System.out.println("Test if GhostController created correctly...");
    assertEquals(gc.getGhost(), ghost);
	}

	@Test
	public void testGetGhost() {
		System.out.println("Test if gc returns ghost correctly...");
    assertEquals(gc.getGhost(), ghost);
	}

	@Test
	public void testGetGhostView() {
		System.out.println("Test if gc returns view correctly...");
    assertEquals(gc.getGhostView(), view);
	}

	@Test
	public void testGetGhostAtk() {
		System.out.println("Test if gc returns ghost's atk correctly...");
    assertTrue(gc.getGhostAtk() == 1);
	}

	@Test
	public void testDie() {
		System.out.println("Test if ghost died correctly...");
		gc.getGhost().die();
    assertFalse(gc.getGhost().getActive());
	}
}
