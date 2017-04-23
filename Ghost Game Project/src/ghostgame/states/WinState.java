package ghostgame.states;

/**
  * File : WinState.java.
  * Kelas WinState merepresentasikan tampilan win game 
  * @author Veren Iliana K - 13515057
  */

import ghostgame.Handler;
import ghostgame.gfx.Assets;
import ghostgame.ui.ClickListener;
import ghostgame.ui.UIImage;
import ghostgame.ui.UIImageButton;
import ghostgame.ui.UIManager;

import java.awt.Graphics;

public class WinState extends State {

  private UIManager uiManager;

  /**
   * Constructor dengan parameter.
   * @param handler Menghubungkan world dengan win state.
   */

  public WinState(Handler handler) {
    super(handler);
    uiManager = new UIManager(handler);
    handler.getMouseManager().setUIManager(uiManager);
    //posisi blm diganti
    uiManager.addObject(new UIImage(200, 200, 128, 64, Assets.winScreen));

    //posisi blm diganti
    uiManager.addObject(new UIImageButton(200, 200, 128, 64, Assets.btn_back, new ClickListener() {
      @Override
      public void onClick() {
        handler.getMouseManager().setUIManager(null);
        State.setState(handler.getGame().menuState);
      }
    }));
  }
  
  /**
   * Mengupdate kondisi win state setiap satuan waktu.
   */

  @Override
  public void tick() {
    uiManager.tick();
  }

  /**
   * Menampilkan gambar win state sesuai dengan jenisnya.
   */

  @Override
  public void render(Graphics g) {
    uiManager.render(g);
  }

}
