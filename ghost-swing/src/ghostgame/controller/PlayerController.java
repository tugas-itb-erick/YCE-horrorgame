/** 
  * File PlayerController.java.
  * Kelas PlayerController merepresentasikan keseluruhan pengaturan-
  * pengaturan yang berhubungan dengan object Player.
  * @author Kevin Iswara - 13515086.
  */
public class PlayerController {
	private Player model;
	private PlayerView view;

  /** 
    * Constructor.
    */

	public PlayerController() {
		model = new Player();
		view = new PlayerView();
	}

  /** 
    * Constructor.
    * @param name Nilai yang akan diisikan ke atribut name.
	* @param hp Nilai yang akan diisikan ke atribut hp.
	* @param x Nilai yang akan diisikan ke absis pada atribut position.
	* @param y Nilai yang akan diisikan ke ordinat pada atribut position.
    */

	public PlayerController(String name, int hp, int x, int y) {
		model = new Player(name,hp,x,y);
		view = new PlayerView();
	}

  /** 
    * I.S. atribut name pada model sembarang.
    * F.S. atribut name pada model terdefinisi.
    * @param name Nilai yang akan dimasukkan ke atribut name.
    */

	public void setPlayerName(String name) {
		model.setName(name);
	}

  /** 
    * Mengembalikan name dari model.
    * @return Nilai dari atribut name pada model.
    */

	public String getPlayerName() {
		return model.getName();
	}

  /** 
    * I.S. atribut hp pada model sembarang.
    * F.S. atribut hp pada model terdefinisi.
    * @param hp Nilai yang akan diisikan ke atribut hp.
    */

	public void setPlayerHp(int hp) {
		model.setHp(hp);
	}

  /** 
    * Mengembalikan nilai dari atribut hp dari model.
    * @return Nilai dari atribut hp pada model.
    */

	public int getPlayerHp() {
		return model.getHp();
	}

  /** 
    * I.S. atribut position pada model sembarang.
    * F.S. atribut position pada model terdefinisi.
    * @param p Nilai yang akan dimasukkan ke atribut position pada model.
    */

	public void setPlayerPosition(Point p) {
		model.setPosition(p);
	}

  /** 
    * Mengembalikan atribut position dari model.
    * @return Nilai dari atribut position pada model.
    */

	public Point getPlayerPosition() {
		return model.getPosition();
	}

  /** 
    * I.S. atribut haveCandle pada model sembarang.
    * F.S. atribut haveCandle pada model terdefinisi.
    * @param haveCandle Nilai yang akan dimasukkan ke atribut haveCandle pada
    * model.
    */

	public void setPlayerCandleStatus(boolean haveCandle) {
		model.setHaveCandle(haveCandle);
	}

  /** 
    * Mengembalikan atribut haveCandle dri model.
    * @return Nilai dari atribut haveCandle pada model.
    */

	public boolean getPlayerCandleStatus() {
		return model.getHaveCandle();
	}

  /** 
    * Mengembalikan objek Inventory dari model.
    * @return Nilai dari atribut inventory pada model.
    */

	public Inventory getPlayerInventory() {
		return model.getInventory();
	}

  /** 
    * I.S. atribut Inventory pada model terdefinisi.
    * F.S. ditambahkan item pada Inventory jika Inventory belum penuh dan
    * item merupakan item yang 'pickable' atau dapat diambil.
    * @param item Nilai yang akan ditambahkan pada atribut Inventory yang ada
    * pada model.
    */

	public void takeItem(Item item) {
		if(item.getPickable() == True) {
			model.getPlayerInventory().addItem(item);
		}
	}

  /** 
	* I.S. atribut Inventory pada model terdefinisi.
    * F.S. menjatuhkan item yang sesuai yang terdapat pada inventory.
    * Jika item tidak terdapat pada inventory, akan memberikan pesan
    * kesalahan.
    * @param item Nilai yang akan dikurangi dari atribut Inventory.
    */
  
	public void dropItem(Item item) {
		if(model.getPlayerInventory().isItemHere(item)) {
			model.getPlayerInventory().deleteItem(item);
			//menambahkan object Item pada map
		}
		else {
			//pesan kesalahan
		}
	}

  /** 
	* I.S. atribut  pada model terdefinisi.
    * F.S. mengganti senjata yang digunakan oleh model menjadi weapon.
    * @param weapon Nilai yang akan mengganti senjata pada model.
    */
  
	public void changeWeapon (Weapon weapon) {

	}
}