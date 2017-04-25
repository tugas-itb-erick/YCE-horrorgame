package ghostgame;

import ghostgame.gfx.GameCamera;
import ghostgame.input.KeyManager;
import ghostgame.input.MouseManager;
import ghostgame.worlds.World;

/**
 * File : Handler.java.
 * Kelas Handler menghubungkan World dengan kelas lain.
 * @author 
 */

public class Handler {
  
  private Game game;
  private World world;
  
  /**
   * Constructor dengan parameter.
   * @param game Game.
   */
  
  public Handler(Game game) {
    this.game = game;
  }
  
  /**
   * Mengembalikan game camera.
   * @return game camera.
   */
  
  public GameCamera getGameCamera() {
    return game.getGameCamera();
  }
  
  /**
   * Mengembalikan key manager.
   * @return key manager.
   */
  
  public KeyManager getKeyManager() {
    return game.getKeyManager();
  }
  
  /**
   * Mengembalikan mouse manager.
   * @return mouse manager.
   */
  
  public MouseManager getMouseManager() {
    return game.getMouseManager();
  }
  
  /**
   * Mengembalikan width.
   * @return width.
   */
  
  public int getWidth() {
    return game.getWidth();
  }
  
  /**
   * Mengembalikan height.
   * @return height.
   */
  
  public int getHeight() {
    return game.getHeight();
  }

  /**
   * Mengembalikan game.
   * @return game.
   */
  public Game getGame() {
    return game;
  }

  /**
   * Mengubah game.
   * @param game Game.
   */
  public void setGame(Game game) {
    this.game = game;
  }

  /**
   * Mengembalikan world.
   * @return world.
   */
  public World getWorld() {
    return world;
  }

  /**
   * Mengubah world.
   * @param world World.
   */
  public void setWorld(World world) {
    this.world = world;
  }

}
