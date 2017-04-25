package ghostgame.entities.creatures;

import ghostgame.Handler;

/** 
  * File : Ghost1.java.
  * Kelas yang merepresentasikan hantu pertama yang ada pada game ini.
  * @author Kevin Iswara - 13515085.
  */

public class Ghost1 extends Ghost {
  
  /**
    * Constructor.
    * @param handler Nilai yang menghubungkan World dengan Entity.
    * @param x Nilai absis (posisi) dari Ghost1.
    * @param y Nilai ordinar (posisi) dari Ghost1.
    */

  public Ghost1(Handler handler, float x, float y) {
    super(handler, x, y);
    speed = 2.5f;
    //damage
    atk = 1;
  }

  /**
    * Fungsi untuk mengubah xmove atau ymove.
    * Pada Ghost1, xmove dan ymove tidak perlu diubah karena
    * Ghost tidak dapat bergerak.
    */

  public void changeMovement() {
    
  }
}