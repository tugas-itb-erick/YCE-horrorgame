package ghostgame.states;

import ghostgame.Handler;
import ghostgame.gfx.Assets;
import ghostgame.ui.ClickListener;
import ghostgame.ui.UIimage;
import ghostgame.ui.UIimageButton;
import ghostgame.ui.UImanager;
import java.awt.Graphics;

/**
 * File : MenuState.java.
 * Kelas MenuState merepresentasikan tampilan main menu.
 * @author Veren Iliana K - 13515057.
 */

public class MenuState extends State {

  private UImanager UImanager;

  /**
   * Constructor dengan parameter.
   * @param handler Menghubungkan world dengan menu state.
   */

  public MenuState(final Handler handler) {
    super(handler);
    UImanager = new UImanager(handler);
    handler.getMouseManager().setUImanager(UImanager);
    
    for (int x = 0; x < handler.getGame().getWidth(); x += 128) {
      for (int y = 0; y < handler.getGame().getHeight(); y += 128) {
        UImanager.addObject(new UIimage((int)x, (int)y, 128, 128, Assets.mainMenuBackground));
      }
    }

    UImanager.addObject(new UIimageButton(200, 200, 192, 60, Assets.btn_start, new ClickListener() {
      @Override
      public void onClick() {
        handler.getMouseManager().setUImanager(null);
        handler.getGame().setState(new GameState(handler));
      }
    }));

    UImanager.addObject(new UIimageButton(200, 270, 192, 60, Assets.btn_instruction, 
                        new ClickListener() {
        @Override
        public void onClick() {
          handler.getMouseManager().setUImanager(null);
          handler.getGame().setState(new InstructionState(handler));
        }
      }));
    
    UImanager.addObject(new UIimageButton(200, 340, 192, 60, Assets.btn_credit, 
                        new ClickListener() {
        @Override
        public void onClick() {
          handler.getMouseManager().setUImanager(null);
          handler.getGame().setState(new InstructionState(handler));
        }
      }));
    
    UImanager.addObject(new UIimageButton(200, 410, 192, 60, Assets.btn_quit, new ClickListener() {
      @Override
      public void onClick() {
        System.exit(1);
      }
    }));
  }

  /**
   * Mengupdate kondisi menu state setiap satuan waktu.
   */

  @Override
  public void tick() {
    UImanager.tick();
    
    // Temporarily just go directly to the GameState, skip the menu state!
    //handler.getMouseManager().setUImanager(null);
    //State.setState(handler.getGame().gameState);
  }

  /**
   * Menampilkan gambar menu state sesuai dengan jenisnya.
   */

  @Override
  public void render(Graphics g) {
    UImanager.render(g);
  }

}
