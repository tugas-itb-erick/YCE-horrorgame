package ghostgame.states;

import ghostgame.Handler;
import ghostgame.gfx.Assets;
import ghostgame.ui.ClickListener;
import ghostgame.ui.UIimage;
import ghostgame.ui.UIimageButton;
import ghostgame.ui.UImanager;

import java.awt.Graphics;

/**
  * File : LostState.java.
  * Kelas LostState merepresentasikan tampilan lost game.
  * @author Veren Iliana K - 13515057.
  */

public class LostState extends State {

  private UImanager uimanager;

  /**
   * Constructor dengan parameter.
   * @param handler Menghubungkan world dengan lost state.
   */

  public LostState(final Handler handler) {
    super(handler);
    uimanager = new UImanager(handler);
    handler.getMouseManager().setUImanager(uimanager);
    
    for (int x = 0; x < handler.getGame().getWidth(); x += 128) {
      for (int y = 0; y < handler.getGame().getHeight(); y += 128) {
        uimanager.addObject(new UIimage((int)x, (int)y, 128, 128, Assets.mainMenuBackground));
      }
    }
    // pos
    uimanager.addObject(new UIimage(200, 200, 128, 64, Assets.lostScreen));

    uimanager.addObject(new UIimageButton(425, 400, 192, 64, Assets.btn_back, new ClickListener() {
      @Override
      public void onClick() {
        handler.getMouseManager().setUImanager(null);
        handler.getGame().setState(new MenuState(handler));
      }
    }));
    
    if (Assets.bgmusic != null) {
      Assets.bgmusic.stop();
      Assets.bgmusic.flush();
      Assets.bgmusic.setFramePosition(0);
    }
    if (Assets.scream != null) {
      Assets.scream.setFramePosition(0);
      Assets.scream.start();
    }
  }
  
  /**
   * Mengupdate kondisi lost state setiap satuan waktu.
   */

  @Override
  public void tick() {
    assert (uimanager != null);
    uimanager.tick();
  }

  /**
   * Menampilkan gambar lost state sesuai dengan jenisnya.
   */

  @Override
  public void render(Graphics g) {
    assert (uimanager != null);
    uimanager.render(g);
  }

}
