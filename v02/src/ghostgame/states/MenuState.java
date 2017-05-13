package ghostgame.states;

import ghostgame.Handler;
import ghostgame.gfx.Assets;
import ghostgame.ui.ClickListener;
import ghostgame.ui.UIimage;
import ghostgame.ui.UIimageButton;
import ghostgame.ui.UImanager;
import java.awt.Graphics;

import javax.sound.sampled.Clip;

/**
 * File : MenuState.java.
 * Kelas MenuState merepresentasikan tampilan main menu.
 * @author Veren Iliana K - 13515057.
 */

public class MenuState extends State {

  private UImanager uimanager;

  /**
   * Constructor dengan parameter.
   * @param handler Menghubungkan world dengan menu state.
   */

  public MenuState(final Handler handler) {
    super(handler);
    uimanager = new UImanager(handler);
    handler.getMouseManager().setUImanager(uimanager);
    
    for (int x = 0; x < handler.getGame().getWidth(); x += 128) {
      for (int y = 0; y < handler.getGame().getHeight(); y += 128) {
        uimanager.addObject(new UIimage((int)x, (int)y, 128, 128, Assets.mainMenuBackground));
      }
    }
    
    uimanager.addObject(new UIimage(90, 80, 64 * 7, 75, Assets.mainTitle));

    uimanager.addObject(new UIimageButton(200, 200, 192, 60, Assets.btn_start, new ClickListener() {
      @Override
      public void onClick() {
        handler.getMouseManager().setUImanager(null);
        handler.getGame().setState(new GameState(handler));
      }
    }));

    uimanager.addObject(new UIimageButton(200, 270, 192, 60, Assets.btn_instruction, 
                        new ClickListener() {
        @Override
        public void onClick() {
          handler.getMouseManager().setUImanager(null);
          handler.getGame().setState(new InstructionState(handler));
        }
      }));
    
    uimanager.addObject(new UIimageButton(200, 340, 192, 60, Assets.btn_credit, 
                        new ClickListener() {
        @Override
        public void onClick() {
          handler.getMouseManager().setUImanager(null);
          handler.getGame().setState(new CreditState(handler));
        }
      }));
    
    uimanager.addObject(new UIimageButton(200, 410, 192, 60, Assets.btn_quit, new ClickListener() {
      @Override
      public void onClick() {
        System.exit(1);
      }
    }));
    
    if (Assets.bgmusic != null) {
      Assets.bgmusic.start();
      Assets.bgmusic.loop(Clip.LOOP_CONTINUOUSLY);
    }
  }

  /**
   * Mengupdate kondisi menu state setiap satuan waktu.
   */

  @Override
  public void tick() {
    assert (uimanager != null);
    uimanager.tick();
  }

  /**
   * Menampilkan gambar menu state sesuai dengan jenisnya.
   */

  @Override
  public void render(Graphics g) {
    assert (uimanager != null);
    uimanager.render(g);
  }

}
