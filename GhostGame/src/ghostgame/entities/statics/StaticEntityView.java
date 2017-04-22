package ghostgame.entities.statics;

/**
  * File : StaticEntityView.java 
  * Kelas StaticEntityView merupakan kelas yang menampilkan StaticEntity.
  * @author Catherine Almira - 13515111
  */

import java.awt.Graphics;

import ghostgame.entities.Entity;

public class StaticEntityView extends EntityView {
	
  /**
    * Menampilkan gambar StaticEntity sesuai dengan jenisnya.
    * @param se StaticEntity yang akan dicetak.
    * @param g grafik yang mencetak StaticEntity.
    */
  
  public void render(StaticEntity se, Graphics g) {
    if (se instanceof(Television)) {
      g.drawImage(Assets.television, (int) (x - handler.getGameCamera().getxOffset()),
        (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
    } else if (se instanceof(Bed)) {
      g.drawImage(Assets.bed, (int) (x - handler.getGameCamera().getxOffset()),
        (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
    } else if (se instanceof(Wardrobe)) {
      g.drawImage(Assets.wardrobe, (int) (x - handler.getGameCamera().getxOffset()),
        (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
    } else if (se instanceof(Chair)) {
      g.drawImage(Assets.chair, (int) (x - handler.getGameCamera().getxOffset()),
        (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
    } else if (se instanceof(Refrigerator)) {
      g.drawImage(Assets.refrigerator, (int) (x - handler.getGameCamera().getxOffset()),
        (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
    } else if (se instanceof(Table)) {
      g.drawImage(Assets.table, (int) (x - handler.getGameCamera().getxOffset()),
        (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
    } else if (se instanceof(Sofa)) {
      g.drawImage(Assets.sofa, (int) (x - handler.getGameCamera().getxOffset()),
        (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
    } else if (se instanceof(Door)) {
      //PINTU SIALAN
      g.drawImage(Assets.doorHorizontal, (int) (x - handler.getGameCamera().getxOffset()),
        (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
    } else {

    }
  }

  
}