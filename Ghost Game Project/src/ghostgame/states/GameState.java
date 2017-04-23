package ghostgame.states;

import ghostgame.Handler;
import ghostgame.worlds.World;

import java.awt.Graphics;

public class GameState extends State {
  
  private World world;
  
  /**
   * Constructor dengan parameter.
   * @param handler Menghubungkan world dengan game state.
   */

  public GameState(Handler handler){
    super(handler);
    world = new World(handler, "res/worlds/world1.txt");
    handler.setWorld(world);
  }
  
  /**
   * Mengupdate kondisi intruction state setiap satuan waktu.
   */
  
  @Override
  public void tick() {
    world.tick();
  }

  /**
   * Menampilkan gambar state sesuai dengan jenisnya.
   */

  @Override
  public void render(Graphics g) {
    world.render(g);
  }

}
