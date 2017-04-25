package ghostgame.states;

import java.awt.Graphics;

import ghostgame.Handler;
import ghostgame.gfx.Assets;
import ghostgame.ui.ClickListener;
import ghostgame.ui.UIImage;
import ghostgame.ui.UIImageButton;
import ghostgame.ui.UIManager;

/**
 * File : MenuState.java.
 * Kelas MenuState merepresentasikan tampilan main menu.
 * @author Veren Iliana K - 13515057.
 */

public class MenuState extends State {

  private UIManager uiManager;

  /**
   * Constructor dengan parameter.
   * @param handler Menghubungkan world dengan menu state.
   */

  public MenuState(final Handler handler) {
    super(handler);
    uiManager = new UIManager(handler);
    handler.getMouseManager().setUIManager(uiManager);
    
    for (int x=0; x<handler.getGame().getWidth(); x += 128) {
    	for (int y=0; y<handler.getGame().getHeight(); y += 128) {
    		uiManager.addObject(new UIImage((int)x, (int)y, 128, 128, Assets.mainMenuBackground));
    	}
    }

    uiManager.addObject(new UIImageButton(200, 200, 192, 60, Assets.btn_start, new ClickListener() {
      @Override
      public void onClick() {
        handler.getMouseManager().setUIManager(null);
        handler.getGame().setState(new GameState(handler));
      }
    }));

    uiManager.addObject(new UIImageButton(200, 270, 192, 60, Assets.btn_instruction, new ClickListener() {
      @Override
      public void onClick() {
        handler.getMouseManager().setUIManager(null);
        handler.getGame().setState(new InstructionState(handler));
      }
    }));
    
    uiManager.addObject(new UIImageButton(200, 340, 192, 60, Assets.btn_credit, new ClickListener() {
      @Override
      public void onClick() {
        handler.getMouseManager().setUIManager(null);
        handler.getGame().setState(new InstructionState(handler));
      }
    }));
    
    uiManager.addObject(new UIImageButton(200, 410, 192, 60, Assets.btn_quit, new ClickListener() {
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
