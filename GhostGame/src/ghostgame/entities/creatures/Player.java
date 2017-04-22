package ghostgame.entities.creatures;

/** 
  * File : Player.java
  * Kelas yang merepresentasikan pemain yang ada pada game ini
  * @author 
  */

import ghostgame.entities.Entity;

import ghostgame.gfx.Animation;

import ghostgame.gfx.Assets;

import ghostgame.Handler;

import ghostgame.inventory.Inventory;

import ghostgame.inventory.InventoryController;

import ghostgame.inventory.InventoryView;

import java.awt.Graphics;

import java.awt.image.BufferedImage;

import java.awt.Rectangle;

public class Player extends Creature {
	
	//Animations
	private Animation animDown, animUp, animLeft, animRight;
	// Attack timer
	private long lastAttackTimer, attackCooldown = 800, attackTimer = attackCooldown;
	// Inventory
	private Inventory inventory;
	
	/**
	  * Constructor dengan parameter.
	  * @param handler Nilai yang menghubungkan World dengan Entity.
	  * @param x Nilai absis (posisi) dari Ghost.
	  * @param y Nilai ordinar (posisi) dari Ghost.
	  */

	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		bounds.x = 22;
		bounds.y = 44;
		bounds.width = 19;
		bounds.height = 19;
		
		//Animatons
		animDown = new Animation(500, Assets.player_down);
		animUp = new Animation(500, Assets.player_up);
		animLeft = new Animation(500, Assets.player_left);
		animRight = new Animation(500, Assets.player_right);
		
		inventory = new Inventory(handler);
	}

	/**
	  * Meng-update kondisi objek Ghost untuk setiap satuan waktu.
	  */

	@Override
	public void tick() {
		//Animations
		animDown.tick();
		animUp.tick();
		animRight.tick();
		animLeft.tick();
		//Movement
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
		// Attack
		checkAttacks();
		// Inventory
		InventoryController ic = new InventoryController(inventory, new InventoryView());
		ic.tick();
	}
	
	/**
	  * Memeriksa apakah ada entity lain yang berpotongan dengan serangan yang diluncurkan.
	  * Jika ada, maka akan terserang, jika tidak, tidak terjadi apa-apa.
	  */

	private void checkAttacks() {
		attackTimer += System.currentTimeMillis() - lastAttackTimer;
		lastAttackTimer = System.currentTimeMillis();
		if (attackTimer < attackCooldown) {
			return;
		}
		
		if (inventory.isActive()) {
			return;
		}
		
		Rectangle cb = getCollisionBounds(0, 0);
		Rectangle ar = new Rectangle();
		int arSize = 20;
		ar.width = arSize;
		ar.height = arSize;
		
		if (handler.getKeyManager().aUp) {
			ar.x = cb.x + cb.width / 2 - arSize / 2;
			ar.y = cb.y - arSize;
		} else if (handler.getKeyManager().aDown) {
			ar.x = cb.x + cb.width / 2 - arSize / 2;
			ar.y = cb.y + cb.height;
		} else if (handler.getKeyManager().aLeft) {
			ar.x = cb.x - arSize;
			ar.y = cb.y + cb.height / 2 - arSize / 2;
		} else if (handler.getKeyManager().aRight) {
			ar.x = cb.x + cb.width;
			ar.y = cb.y + cb.height / 2 - arSize / 2;
		} else {
			return;
		}
	 	
		attackTimer = 0;
		
		for (Entity e : handler.getWorld().getEntityManager().getEntities()){
			if (e.equals(this)) {
				continue;
			}
			if (e.getCollisionBounds(0, 0).intersects(ar)) {
				e.hurt(1);
				return;
			}
		}
	}
	
	/**
	  * Mengeluarkan halaman (pesan) kekalahan.
	  */

	@Override
	public void die() {
		System.out.println("You lose");
	}

	/**
	  * Fungsi abstrak untuk mengubah xMove atau yMove.
	  */

	private void getInput() {
		xMove = 0;
		yMove = 0;
		if (inventory.isActive()) {
			return;
		}
		if (handler.getKeyManager().up) {
			yMove = -speed;
		}
		if (handler.getKeyManager().down) {
			yMove = speed;
		}
		if (handler.getKeyManager().left) {
			xMove = -speed;
		}
		if (handler.getKeyManager().right) {
			xMove = speed;
		}
	}

	/**
	  * Fungsi yang menampilkan gambar (frame) dari Player.
	  * @param g Nilai grafik yang mencetak gambar (frame) dari Player.
	  */

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()),
		(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}

	/**
	  * Fungsi yang menampilkan gambar (frame) dari Inventory player.
	  * @param g Nilai grafik yang mencetak gambar (frame) dari Inventory.
	  */

	public void postRender(Graphics g){
		InventoryController ic = new InventoryController(inventory, new InventoryView());
		ic.render(g);
	}

	/**
	  * Fungsi yang mengembalikan gambar (frame) dari ghost sesuai dengan arah geraknya.
	  * Jika arah gerak sedang ke atas (yMove negatif) maka mengembalikan frame dari 
	  * animUp.
	  * Jika arah gerak sedang ke bawah (yMove positif) maka mengembalikan frame dari 
	  * animDown.
	  * Jika arah gerak sedang ke kanan (xMove positif) maka mengembalikan frame dari 
	  * animRight.
	  * Jika arah gerak sedang ke kiri (xMove negatif) maka mengembalikan frame dari 
	  * animLeft.
	  * @return Frame yang bersesuaian dengan ghost yang akan ditampilkan.
	  */

	private BufferedImage getCurrentAnimationFrame(){
		if (xMove < 0) {
			return animLeft.getCurrentFrame();
		} else if (xMove > 0) {
			return animRight.getCurrentFrame();
		} else if (yMove < 0) {
			return animUp.getCurrentFrame();
		} else {
			return animDown.getCurrentFrame();
		}
	}

  /** 
    * Mengembalikan inventory dari sebuah objek Ghost.
    * @return Nilai dari atribut inventory.
    */

	public Inventory getInventory() {
		return inventory;
	}

  /** 
    * I.S. atribut inventory sembarang.
    * F.S. atribut inventory terdefinisi.
    * @param inventory Nilai yang akan dimasukkan ke atribut inventory.
    */

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
}