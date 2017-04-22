package ghostgame.gfx;

import java.awt.Font;

import java.awt.image.BufferedImage;

/**
  * File : Assets.java
  * Kelas Assets adalah kelas untuk menyimpan gambar-gambar yang digunakan
  * dalam permainan.
  * @author 
  */

public class Assets {
  
  private static final int WIDTH = 32;
  private static final int HEIGHT = 32;
  
  // Gambar untuk background main menu.
  public static BufferedImage mainMenuBackground;
  // Gambar untuk item.
  public static BufferedImage knife;
  public static BufferedImage grenade;
  public static BufferedImage bed;
  public static BufferedImage wardrobe;
  public static BufferedImage key;
  public static BufferedImage chair;
  public static BufferedImage candle;
  public static BufferedImage refrigerator;
  public static BufferedImage television;
  public static BufferedImage table;
  public static BufferedImage sofa;
  public static BufferedImage doorHorizontal;
  public static BufferedImage doorVertical;
  
  /**
    * I.S. objek terdefinsi.
    * F.S. gambar yang akan mengimplementasikan setiap objek berhasil disimpan
    * dalam program.
    */
  
  public static void init() {
  	//PATH ASSETS.PNG MASIH BELOM BENER
    SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/assets.png"));
    // Keterangan : sheet.crop(X, Y, lebarGambar, panjangGambar)
    // X dan Y adalah posisi ujung kiri atas gambar dalam file "assets.png".
    mainMenuBackground = sheet.crop(0, HEIGHT * 5, WIDTH * 2, HEIGHT * 2);
    knife = sheet.crop(0, 0, WIDTH, HEIGHT);
    grenade = sheet.crop(0, HEIGHT, WIDTH, HEIGHT);
    bed = sheet.crop(WIDTH, HEIGHT, WIDTH * 2, HEIGHT);
    wardrobe = sheet.crop(0, HEIGHT * 2, WIDTH, HEIGHT * 2);
    key = sheet.crop(WIDTH, HEIGHT * 2, WIDTH, HEIGHT);
    chair = sheet.crop(WIDTH * 2, HEIGHT * 2, WIDTH, HEIGHT);
    candle = sheet.crop(WIDTH * 3, HEIGHT, WIDTH, HEIGHT * 2);
    refrigerator = sheet.crop(WIDTH, HEIGHT * 3, WIDTH, HEIGHT);
    television = sheet.crop(WIDTH * 2, HEIGHT * 3, WIDTH, HEIGHT);
    table = sheet.crop(WIDTH * 3, HEIGHT * 3, WIDTH, HEIGHT);
    sofa = sheet.crop(0, HEIGHT * 4, WIDTH * 2, HEIGHT);
    doorHorizontal = sheet.crop(WIDTH * 3, HEIGHT * 4, WIDTH, HEIGHT);
    doorVertical = sheet.crop(WIDTH * 2, HEIGHT * 4, WIDTH, HEIGHT);
  }
} 