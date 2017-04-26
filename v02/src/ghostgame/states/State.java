package ghostgame.states;

import ghostgame.Handler;
import java.awt.Graphics;

public abstract class State {

  protected Handler handler;
  
  /**
   * Constructor dengan parameter.
   * @param handler Menghubungkan world dengan state.
   */
  
  public State(Handler handler) {
    this.handler = handler;
    assert (this.handler != null);
  }
  
  /**
   * Mengupdate kondisi state setiap satuan waktu.
   */
  
  public abstract void tick();
  
  /**
   * Menampilkan gambar state sesuai dengan jenisnya.
   */
  
  public abstract void render(Graphics g);
  
}