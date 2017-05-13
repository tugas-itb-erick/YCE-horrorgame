package ghostgame.states;

import ghostgame.Handler;
import ghostgame.worlds.World;

import java.awt.Graphics;

/**
 * File : GameState.java.
 * Kelas GameState merepresentasikan tampilan game. 
 * @author Veren Iliana K - 13515057.
 */

public class GameState extends State {
  
  private World world;
  
  /**
   * Constructor dengan parameter.
   * @param handler Menghubungkan world dengan game state.
   */

  public GameState(Handler handler) {
    super(handler);
    world = new World(handler, "res/worlds/world1.txt");
    handler.setWorld(world);
  }
  
  /**
   * Mengupdate kondisi intruction state setiap satuan waktu.
   */
  
  @Override
  public void tick() {
    assert (world != null);
    world.tick();
  }

  /**
   * Menampilkan gambar state sesuai dengan jenisnya.
   */

  @Override
  public void render(Graphics g) {
    assert (world != null);
    world.render(g);
  }

}
