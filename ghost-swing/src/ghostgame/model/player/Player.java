import additional.Point;

/** 
  * File Player.java.
  * Kelas Player merepresentasikan karakter yang akan dimainkan dalam game ini.
  * @author Kevin Iswara - 13515086.
  */
public class Player {
	private String name;
	private int hp;
	private Point position;
	private Inventory inventory;
	private boolean haveCandle;

  /** 
    * Constructor.
    */

	public Player() {
		name = "noname";
		inventory = new Inventory();
		hp = 1;
		position = new Point(0,0);
		haveCandle = False;
	}

  /** 
    * Constructor.
    * @param name Nilai yang akan diisikan ke atribut name.
	* @param hp Nilai yang akan diisikan ke atribut hp.
	* @param x Nilai yang akan diisikan ke absis pada atribut position.
	* @param y Nilai yang akan diisikan ke ordinat pada atribut position.
    */

	public Player(String name, int hp, int x, int y) {
		this.name = name;
		inventory = new Inventory();
		this.hp = hp;
		position = new Point(x,y);
		haveCandle = False;
	}

  /** 
    * I.S. atribut name sembarang.
    * F.S. atribut name terdefinisi.
    * @param name Nilai yang akan dimasukkan ke atribut name.
    */

	public void setName(String name) {
		this.name = name;
	}

  /** 
    * Mengembalikan name dari sebuah objek Player.
    * @return Nilai dari atribut name.
    */

	public String getName() {
		return name;
	}

  /** 
    * I.S. atribut hp sembarang.
    * F.S. atribut hp terdefinisi.
    * @param hp Nilai yang akan diisikan ke atribut hp.
    */

	public void setHp(int hp) {
		this.hp = hp;
	}

  /** 
    * Mengembalikan nilai dari atribut hp.
    * @return Nilai dari atribut hp.
    */

	public int getHp() {
		return hp;
	}

  /** 
    * I.S. atribut position sembarang.
    * F.S. atribut position terdefinisi.
    * @param p Nilai yang akan dimasukkan ke atribut position.
    */

	public void setPosition(Point p) {
		position.setX(p.getX());
		position.setY(p.getY());
	}

  /** 
    * Mengembalikan atribut position.
    * @return Nilai dari atribut position.
    */

	public Point getPosition() {
		return position;
	}

  /** 
    * I.S. atribut haveCandle sembarang.
    * F.S. atribut haveCandle terdefinisi.
    * @param haveCandle Nilai yang akan dimasukkan ke atribut haveCandle.
    */

	public void setHaveCandle(boolean haveCandle) {
		this.haveCandle = haveCandle;
	}

  /** 
    * Mengembalikan atribut haveCandle.
    * @return Nilai dari atribut haveCandle.
    */

	public boolean getHaveCandle() {
		return haveCandle;
	}

  /** 
    * Mengembalikan objek Inventory.
    * @return Nilai dari atribut inventory.
    */

	public Inventory getInventory() {
		return inventory;
	}
}