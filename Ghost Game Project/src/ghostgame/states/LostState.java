package ghostgame.states;

/**
  * File : LostState.java.
  * Kelas LostState merepresentasikan tampilan lost game 
  * @author Veren Iliana K - 13515057
  */

import ghostgame.Handler;
import ghostgame.gfx.Assets;
import ghostgame.ui.ClickListener;
import ghostgame.ui.UIImage;
import ghostgame.ui.UIImageButton;
import ghostgame.ui.UIManager;

import java.awt.Graphics;

public class LostState extends State {

  private UIManager uiManager;

  /**
   * Constructor dengan parameter.
   * @param handler Menghubungkan world dengan lost state.
   */

  public LostState(final Handler handler) {
    super(handler);
    uiManager = new UIManager(handler);
    handler.getMouseManager().setUIManager(uiManager);
    //posisi blm diganti
    uiManager.addObject(new UIImage(200, 200, 128, 64, Assets.lostScreen));

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
   * Mengupdate kondisi lost state setiap satuan waktu.
   */

  @Override
  public void tick() {
    uiManager.tick();
  }

  /**
   * Menampilkan gambar lost state sesuai dengan jenisnya.
   */

  @Override
  public void render(Graphics g) {
    uiManager.render(g);
  }

}
