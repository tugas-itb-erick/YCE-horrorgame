package ghostgametest.entities.creatures;

import static org.junit.Assert.*;

import org.junit.Test;

import ghostgame.Handler;
import ghostgame.entities.creatures.Player;
import ghostgame.entities.creatures.PlayerController;
import ghostgame.entities.creatures.PlayerView;

public class PlayerControllerTest {

	Handler handler = new Handler(null);
	Player player = new Player(handler, 1, 1);
	PlayerView view = new PlayerView();
	PlayerController pc = new PlayerController(player, view);
	
	@Test
	public void testPlayerController() {
		System.out.println("Test if GhostController created correctly...");
    assertEquals(pc.getPlayer(), player);
	}

	@Test
	public void testGetPlayer() {
		System.out.println("Test if GhostController return Player correctly...");
    assertEquals(pc.getPlayer(), player);
	}

	@Test
	public void testGetPlayerView() {
		System.out.println("Test if GhostController return PlayerView correctly...");
    assertEquals(pc.getPlayerView(), view);
	}

}
