package ghostgame.states;

import ghostgame.Handler;
import ghostgame.gfx.Assets;
import ghostgame.ui.ClickListener;
import ghostgame.ui.UIImageButton;
import ghostgame.ui.UIManager;

import java.awt.Graphics;

public class MenuState extends State {

  private UIManager uiManager;

  /**
   * Constructor dengan parameter.
   * @param handler Menghubungkan world dengan menu state.
   */

  public MenuState(Handler handler) {
    super(handler);
    uiManager = new UIManager(handler);
    handler.getMouseManager().setUIManager(uiManager);

    uiManager.addObject(new UIImageButton(200, 200, 192, 64, Assets.btn_start, new ClickListener() {
      @Override
      public void onClick() {
        handler.getMouseManager().setUIManager(null);
        State.setState(handler.getGame().gameState);
      }
    }));

    uiManager.addObject(new UIImageButton(200, 300, 192, 64, Assets.btn_instruction, new ClickListener() {
      @Override
      public void onClick() {
        handler.getMouseManager().setUIManager(null);
        State.setState(handler.getGame().instructionState);
      }
    }));
  }

  /**
   * Mengupdate kondisi menu state setiap satuan waktu.
   */

  @Override
  public void tick() {
    uiManager.tick();
    
    // Temporarily just go directly to the GameState, skip the menu state!
    //handler.getMouseManager().setUIManager(null);
    //State.setState(handler.getGame().gameState);
  }

  /**
   * Menampilkan gambar menu state sesuai dengan jenisnya.
   */

  @Override
  public void render(Graphics g) {
    uiManager.render(g);
  }

}
