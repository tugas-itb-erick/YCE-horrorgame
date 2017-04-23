package ghostgame.states;

import java.awt.Graphics;

import ghostgame.Handler;


public abstract class State {

  private static State currentState = null;
  protected Handler handler;
  
  /**
   * Constructor dengan parameter.
   * @param handler Menghubungkan world dengan state.
   */
  
  public State(Handler handler){
    this.handler = handler;
  }
  
  /**
   * Mengubah currentstate dengan state.
   */

  public static void setState(State state){
    currentState = state;
  }
  
  /**
   * Mengembalikan current state.
   */
  
  public static State getState(){
    return currentState;
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