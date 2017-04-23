package ghostgame.entities.statics;

/**
  * File : StaticEntityView.java 
  * Kelas StaticEntityView merupakan kelas yang menampilkan StaticEntity.
  * @author Catherine Almira - 13515111
  */

import java.awt.Graphics;

import ghostgame.entities.Entity;
import ghostgame.entities.EntityView;
import ghostgame.gfx.Assets;

public class StaticEntityView {
	
  /**
    * Menampilkan gambar StaticEntity sesuai dengan jenisnya.
    * @param se StaticEntity yang akan dicetak.
    * @param g grafik yang mencetak StaticEntity.
    */
  
  public void render(StaticEntity se, Graphics g) {
    if (se instanceof Television) {
      g.drawImage(Assets.television, (int) (se.getX() - se.getHandler().getGameCamera().getxOffset()),
        (int) (se.getY() - se.getHandler().getGameCamera().getyOffset()), se.getWidth(), se.getHeight(), null);
    } else if (se instanceof Bed) {
      g.drawImage(Assets.bed, (int) (se.getX() - se.getHandler().getGameCamera().getxOffset()),
        (int) (se.getY() - se.getHandler().getGameCamera().getyOffset()), se.getWidth(), se.getHeight(), null);
    } else if (se instanceof Wardrobe) {
      g.drawImage(Assets.wardrobe, (int) (se.getX() - se.getHandler().getGameCamera().getxOffset()),
        (int) (se.getY() - se.getHandler().getGameCamera().getyOffset()), se.getWidth(), se.getHeight(), null);
    } else if (se instanceof Chair) {
      g.drawImage(Assets.chair, (int) (se.getX() - se.getHandler().getGameCamera().getxOffset()),
        (int) (se.getY() - se.getHandler().getGameCamera().getyOffset()), se.getWidth(), se.getHeight(), null);
    } else if (se instanceof Refrigerator) {
      g.drawImage(Assets.refrigerator, (int) (se.getX() - se.getHandler().getGameCamera().getxOffset()),
        (int) (se.getY() - se.getHandler().getGameCamera().getyOffset()), se.getWidth(), se.getHeight(), null);
    } else if (se instanceof Table) {
      g.drawImage(Assets.table, (int) (se.getX() - se.getHandler().getGameCamera().getxOffset()),
        (int) (se.getY() - se.getHandler().getGameCamera().getyOffset()), se.getWidth(), se.getHeight(), null);
    } else if (se instanceof Sofa) {
      g.drawImage(Assets.sofa, (int) (se.getX() - se.getHandler().getGameCamera().getxOffset()),
        (int) (se.getY() - se.getHandler().getGameCamera().getyOffset()), se.getWidth(), se.getHeight(), null);
    } else if (se instanceof Door) {
      //PINTU SIALAN
      g.drawImage(Assets.doorHorizontal, (int) (se.getX() - se.getHandler().getGameCamera().getxOffset()),
        (int) (se.getY() - se.getHandler().getGameCamera().getyOffset()), se.getWidth(), se.getHeight(), null);
    } else {

    }
  }
  
}