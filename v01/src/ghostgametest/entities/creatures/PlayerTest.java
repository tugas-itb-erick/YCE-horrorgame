package ghostgametest.entities.creatures;

import static org.junit.Assert.*;

import org.junit.Test;

import ghostgame.Handler;
import ghostgame.entities.creatures.Player;

public class PlayerTest {
	
	Handler handler = new Handler(null);
	Player p = new Player(handler, 0, 0);

	@Test
	public void testPlayer() {
		System.out.println("Test if ghost created correctly");
    assertTrue(p.getX() == 0);
    assertTrue(p.getY() == 0);
    assertTrue(p.getSpeed() == 3f);
    assertTrue(p.getHealth() == 3);
    assertEquals(p.getSightX(), 4);
    assertEquals(p.getSightY() , 3);
    assertFalse(p.isHasWeapon());
    assertFalse(p.isHasKey());
	}

	@Test
	public void testGetInventory() {
		System.out.println("Test if Player returns inventory correctly...");
    assertTrue(p.getInventory() != null);
	}

	@Test
	public void testCheckCandle() {
		System.out.println("Test if Player change sightX and sightY correctly...");
    assertEquals(p.getSightX(), 4);
    assertEquals(p.getSightY() , 3);
	}

	@Test
	public void testCheckWeapon() {
		System.out.println("Test if Player check weapon correctly...");
    assertFalse(p.isHasWeapon());
	}

	@Test
	public void testCheckKey() {
		System.out.println("Test if Player check key correctly...");
    assertFalse(p.isHasKey());
	}

	@Test
	public void testGetSightX() {
		System.out.println("Test if Player returns sightX correctly...");
    assertEquals(p.getSightX(), 4);
	}

	@Test
	public void testGetSightY() {
		System.out.println("Test if Player returns sightY correctly...");
    assertEquals(p.getSightY() , 3);
	}

	@Test
	public void testIsHasWeapon() {
		System.out.println("Test if Player returns hasWeapon correctly...");
    assertFalse(p.isHasWeapon());
	}

	@Test
	public void testIsHasKey() {
		System.out.println("Test if Player returns hasKey correctly...");
    assertFalse(p.isHasKey());
	}
}
