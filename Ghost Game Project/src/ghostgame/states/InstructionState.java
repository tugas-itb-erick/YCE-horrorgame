package ghostgame.states;

/**
  * File : InstructionState.java.
  * Kelas InstructionState merepresentasikan tampilan instruction 
  * @author Veren Iliana K - 13515057
  */

import ghostgame.Handler;
import ghostgame.gfx.Assets;
import ghostgame.ui.ClickListener;
import ghostgame.ui.UIImage;
import ghostgame.ui.UIImageButton;
import ghostgame.ui.UIManager;

import java.awt.Graphics;

public class InstructionState extends State {

  private UIManager uiManager;

  /**
   * Constructor dengan parameter.
   * @param handler Menghubungkan world dengan instruction state.
   */

  public InstructionState(final Handler handler) {
    super(handler);
    uiManager = new UIManager(handler);
    handler.getMouseManager().setUIManager(uiManager);
    
    for(int x=0; x<handler.getGame().getWidth(); x += 128){
    	for(int y=0; y<handler.getGame().getHeight(); y += 128){
    		uiManager.addObject(new UIImage((int)x, (int)y, 128, 128, Assets.mainMenuBackground));
    	}
    }
    
    //uiManager.addObject(new UIImage(200, 200, 128, 64, Assets.instructionScreen));

    uiManager.addObject(new UIImageButton(425, 400, 192, 64, Assets.btn_back, new ClickListener() {
      @Override
      public void onClick() {
        handler.getMouseManager().setUIManager(null);
        handler.getGame().setState(new MenuState(handler));
      }
    }));
  }
  
  /**
   * Mengupdate kondisi instruction state setiap satuan waktu.
   */

  @Override
  public void tick() {
    uiManager.tick();
  }

  /**
   * Menampilkan gambar instruction state sesuai dengan jenisnya.
   */

  @Override
  public void render(Graphics g) {
    uiManager.render(g);
  }
}
