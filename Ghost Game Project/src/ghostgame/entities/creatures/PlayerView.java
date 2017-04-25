package ghostgame.entities.creatures;

import java.awt.Graphics;

/**
  * Kelas yang mengatur view dari Player.
  * @author Erick Wijaya - 13515057.
  */

public class PlayerView {
  
  private PlayerController pc;

  /**
    * Constructor dengan parameter.
    * @param pc Nilai yang digunakan untuk mengakses keterangan gambar player.
    */
  
  public void setPlayerController(PlayerController pc) {
    this.pc = pc;
  }

  /**
    * Fungsi yang menampilkan gambar (frame) dari player.
    * @param g Nilai grafik yang mencetak gambar (frame) dari player.
    */

  public void render(Player player, Graphics g) {
    g.drawImage(pc.getCurrentAnimationFrame(),
        (int) (player.getX() - player.getHandler().getGameCamera().getxOffset()),
        (int) (player.getY() - player.getHandler().getGameCamera().getyOffset()),
        player.getWidth(), player.getHeight(), null);
  }

  /**
    * Fungsi yang menampilkan gambar (frame) dari inventory player.
    * @param g Nilai grafik yang mencetak gambar (frame) dari inventory player.
    */
  
  public void postRender(Player player, Graphics g) {
    pc.getInventoryController().render(g);
  }
}
