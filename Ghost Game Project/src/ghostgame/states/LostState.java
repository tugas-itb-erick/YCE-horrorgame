package ghostgame.states;

/**
  * File : LostState.java.
  * Kelas LostState merepresentasikan tampilan lost game.
  * @author Veren Iliana K - 13515057.
  */

import ghostgame.Handler;
import ghostgame.gfx.Assets;
import ghostgame.ui.ClickListener;
import ghostgame.ui.UIimage;
import ghostgame.ui.UIimageButton;
import ghostgame.ui.UImanager;

import java.awt.Graphics;

public class LostState extends State {

  private UImanager UImanager;

  /**
   * Constructor dengan parameter.
   * @param handler Menghubungkan world dengan lost state.
   */

  public LostState(final Handler handler) {
    super(handler);
    UImanager = new UImanager(handler);
    handler.getMouseManager().setUImanager(UImanager);
    
    for (int x = 0; x < handler.getGame().getWidth(); x += 128) {
      for (int y = 0; y < handler.getGame().getHeight(); y += 128) {
        UImanager.addObject(new UIimage((int)x, (int)y, 128, 128, Assets.mainMenuBackground));
      }
    }
    // pos
    UImanager.addObject(new UIimage(200, 200, 128, 64, Assets.lostScreen));

    UImanager.addObject(new UIimageButton(425, 400, 192, 64, Assets.btn_back, new ClickListener() {
      @Override
      public void onClick() {
        handler.getMouseManager().setUImanager(null);
        handler.getGame().setState(new MenuState(handler));
      }
    }));
  }
  
  /**
   * Mengupdate kondisi lost state setiap satuan waktu.
   */

  @Override
  public void tick() {
    UImanager.tick();
  }

  /**
   * Menampilkan gambar lost state sesuai dengan jenisnya.
   */

  @Override
  public void render(Graphics g) {
    UImanager.render(g);
  }

}
