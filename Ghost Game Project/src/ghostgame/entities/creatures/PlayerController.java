package ghostgame.entities.creatures;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import ghostgame.entities.Entity;
import ghostgame.entities.statics.StaticEntity;
import ghostgame.gfx.Animation;
import ghostgame.gfx.Assets;
import ghostgame.inventory.InventoryController;
import ghostgame.inventory.InventoryView;
import ghostgame.items.Item;

/** 
  * File : PlayerController.java.
  * Kelas yang merepresentasikan pengatur pemain yang ada pada game ini.
  * @author Erick Wijaya - 13515057.
  */

public class PlayerController {

  private Player player;
  private PlayerView view;
  private long lastAttackTimer, attackCooldown = 800, attackTimer = attackCooldown;
  private Animation animDown, animUp, animLeft, animRight;
  private InventoryController ic;

  /**
    * Constructor dengan parameter.
    * @param player Nilai Player yang akan dimasukkan ke player.
    * @param view Nilai PlayerView yang akan dimasukkan ke view.
    */
  
  public PlayerController(Player player, PlayerView view) {
    this.player = player;
    this.view = view;
    view.setPlayerController(this);
    animDown = new Animation(300, Assets.player_down);
    animUp = new Animation(300, Assets.player_up);
    animLeft = new Animation(300, Assets.player_left);
    animRight = new Animation(300, Assets.player_right);
    ic = new InventoryController(player.getInventory(), new InventoryView());
  }
  
  /**
    * Mengubah player pada PlayerController.
    * @param player Nilai baru yang akan dimasukkan ke player.
     */

  public void setPlayer(Player player) {
    this.player = player;
  }
  
  /**
    * Mengembalikan player dari PlayerController.
    * @return player yang diatur oleh PlayerController.
    */

  public Player getPlayer() {
    return player;
  }
  
  /**
    * Mengubah view pada PlayerController.
    * @param view Nilai baru yang akan dimasukkan ke view.
     */

  public void setPlayerView(PlayerView view) {
    this.view = view;
  }
  
  /**
    * Mengembalikan view dari PlayerController.
    * @return view yang diatur oleh PlayerController.
    */

  public PlayerView getPlayerView() {
    return view;
  }
  
/**
  * Meng-update kondisi objek Player untuk setiap satuan waktu.
  */
  
  public void tick() {
    //Animations
    player.checkCandle();
    animDown.tick();
    animUp.tick();
    animRight.tick();
    animLeft.tick();
    //Movement
    getInput();
    player.move();
    player.getHandler().getGameCamera().centerOnEntity(player);
    // Attack
    player.checkWeapon();
    player.checkKey();
    checkAttacks();
    // Inventory
    ic.tick();
  }
  
  /**
    * Fungsi yang mengembalikan gambar (frame) dari player sesuai dengan arah geraknya.
    * Jika arah gerak sedang ke atas (yMove negatif) maka mengembalikan frame dari 
    * animUp.
    * Jika arah gerak sedang ke bawah (yMove positif) maka mengembalikan frame dari 
    * animDown.
    * Jika arah gerak sedang ke kanan (xMove positif) maka mengembalikan frame dari 
    * animRight.
    * Jika arah gerak sedang ke kiri (xMove negatif) maka mengembalikan frame dari 
    * animLeft.
    * @return Frame yang bersesuaian dengan player yang akan ditampilkan.
    */
  
  public BufferedImage getCurrentAnimationFrame(){
    if(player.getxMove() < 0){
      return animLeft.getCurrentFrame();
    }else if(player.getxMove() > 0){
      return animRight.getCurrentFrame();
    }else if(player.getyMove() < 0){
      return animUp.getCurrentFrame();
    }else{
      return animDown.getCurrentFrame();
    }
  }
  
  /**
    * Menerima input dari KeyManager dan merubah xMove atau yMove nya.
    */
  
  private void getInput(){
    player.setxMove(0);
    player.setyMove(0);
    if(ic.isInventoryActive())
      return;
    if(player.getHandler().getKeyManager().up)
      player.setyMove(-player.getSpeed());
    if(player.getHandler().getKeyManager().down)
      player.setyMove(player.getSpeed());
    if(player.getHandler().getKeyManager().left)
      player.setxMove(-player.getSpeed());
    if(player.getHandler().getKeyManager().right)
      player.setxMove(player.getSpeed());
  }
  
  /**
    * Memeriksa apakah ada entity lain yang berpotongan dengan rectangle yang diciptakan
    * player saat menyerang.
    * Jika ada, maka akan terserang, jika tidak, tidak terjadi apa-apa.
    */
  
  private void checkAttacks(){

    attackTimer += System.currentTimeMillis() - lastAttackTimer;
    lastAttackTimer = System.currentTimeMillis();
    if(attackTimer < attackCooldown)
      return;
    if(ic.isInventoryActive())
      return;
    Rectangle cb = player.getCollisionBounds(0, 0);
    Rectangle ar = new Rectangle();
    int arSize = 20;
    ar.width = arSize;
    ar.height = arSize;
    if(player.getHandler().getKeyManager().aUp){
      ar.x = cb.x + cb.width / 2 - arSize / 2;
      ar.y = cb.y - arSize;
    }else if(player.getHandler().getKeyManager().aDown){
      ar.x = cb.x + cb.width / 2 - arSize / 2;
      ar.y = cb.y + cb.height;
    }else if(player.getHandler().getKeyManager().aLeft){
      ar.x = cb.x - arSize;
      ar.y = cb.y + cb.height / 2 - arSize / 2;
    }else if(player.getHandler().getKeyManager().aRight){
      ar.x = cb.x + cb.width;
      ar.y = cb.y + cb.height / 2 - arSize / 2;
    }else{
      return;
    }
    attackTimer = 0;
    for(Entity e : player.getHandler().getWorld().getEntityManager().getEntities()){
      if(e.equals(this))
        continue;
      if(e.getCollisionBounds(0, 0).intersects(ar)){
        if ((e instanceof StaticEntity) && player.isHasKey()){
          if (((StaticEntity)e).getId() == 2){
            e.hurt(2);
            player.getInventory().removeItem(Item.keyItem);
            return;
          }
        }
        if ((e instanceof Ghost) && player.isHasWeapon()) {
          e.hurt(2);
          return;
        }
      }
    }
  }

  /**
    * Fungsi yang menampilkan gambar (frame) dari player.
    * @param g Nilai grafik yang mencetak gambar (frame) dari player.
    */

  public void render(Graphics g) {
    view.render(player, g);  
  }

  /**
    * Fungsi yang menampilkan gambar (frame) dari inventory.
    * @param g Nilai grafik yang mencetak gambar (frame) dari inventoryr.
    */
  
  public void postRender(Graphics g){
    view.postRender(player, g);
  }

  /**
    * Fungsi yang menampilkan gambar (frame) dari ItemController.
    * @param g Nilai grafik yang mencetak gambar (frame) dari inventory player.
    */

  public InventoryController getInventoryController() {
    return ic;
  }
}
