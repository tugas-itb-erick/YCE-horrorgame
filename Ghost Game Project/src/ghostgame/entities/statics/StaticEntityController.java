package ghostgame.entities.statics;

import java.awt.Graphics;

/**
 * File : StaticEntityController.java 
 * Kelas abstrak StaticEntityController merupakan kelas yang mengatasi
 * interaksi pada StaticEntity.
 * @author Catherine Almira - 13515111
 */

public class StaticEntityController {

  private StaticEntity se;
  private StaticEntityView view;
  
  /**
   * Constructor dengan parameter.
   * @param se Model StaticEntity yang dikontrol.
   * @param view View StaticEntity yang dikontrol.
   */
  
  public StaticEntityController(StaticEntity se, StaticEntityView view) {
    this.se = se;
    this.view = view;
  }
  
  /**
   * I.S. StaticEntity sembarang.
   * F.S. StaticEntity terdefinisi sesuai dengan StaticEntity yang baru.
   * @param se StaticEntity yang baru.
   */
  
  public void setStaticEntity(StaticEntity se) {
    this.se = se;
  }
  
  /**
   * Mengembalikan Model StaticEntity.
   * @return model StaticEntity.
   */
  
  public StaticEntity getStaticEntity() {
    return se;
  }
  
  /**
   * Menggambar StaticEntity sesuai dengan grafiknya.
   * @param g grafik yang menyatakan StaticEntity yang akan dicetak.
   */
  
  public void render(Graphics g) {
    assert (se != null);
    view.render(se, g);
  }
  
}
