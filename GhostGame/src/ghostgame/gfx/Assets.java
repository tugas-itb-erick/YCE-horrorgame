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
  
  public static Font font28;
	
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
  // Animasi Player
  public static BufferedImage[] player_down, player_up, player_left, player_right;
  // Animasi Ghost
  public static BufferedImage[] ghost1_down, ghost1_up, ghost1_left, ghost1_right;
  public static BufferedImage[] ghost2_down, ghost2_up, ghost2_left, ghost2_right;
  public static BufferedImage[] ghost3_down, ghost3_up, ghost3_left, ghost3_right;
  
  /**
    * I.S. objek terdefinsi.
    * F.S. gambar yang akan mengimplementasikan setiap objek berhasil disimpan
    * dalam program.
    */
  
  public static void init() {
  	//PATH ASSETS.PNG MASIH BELOM BENER
	font28 = FontLoader.loadFont("res/fonts/slkscr.ttf", 28);
    SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/assets.png"));
    SpriteSheet ghost_sheet = new SpriteSheet(ImageLoader.loadImage("/textures/ghost_sheet.png"));
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
    
    player_down = new BufferedImage[3];
    player_up = new BufferedImage[3];
    player_left = new BufferedImage[3];
    player_right = new BufferedImage[3];
    player_down[0] = sheet.crop(WIDTH * 4, 0, WIDTH, HEIGHT);
    player_down[1] = sheet.crop(WIDTH * 5, 0, WIDTH, HEIGHT);
    player_down[2] = sheet.crop(WIDTH * 6, 0, WIDTH, HEIGHT);
    player_up[0] = sheet.crop(WIDTH * 4, HEIGHT, WIDTH, HEIGHT);
    player_up[1] = sheet.crop(WIDTH * 5, HEIGHT, WIDTH, HEIGHT);
    player_up[2] = sheet.crop(WIDTH * 6, HEIGHT, WIDTH, HEIGHT);
    player_right[0] = sheet.crop(WIDTH * 4, HEIGHT * 2, WIDTH, HEIGHT);
    player_right[1] = sheet.crop(WIDTH * 5, HEIGHT * 2, WIDTH, HEIGHT);
    player_right[2] = sheet.crop(WIDTH * 6, HEIGHT * 2, WIDTH, HEIGHT);
    player_left[0] = sheet.crop(WIDTH * 4, HEIGHT * 3, WIDTH, HEIGHT);
    player_left[1] = sheet.crop(WIDTH * 5, HEIGHT * 3, WIDTH, HEIGHT);
    player_left[2] = sheet.crop(WIDTH * 6, HEIGHT * 3, WIDTH, HEIGHT);
    
    ghost1_down = new BufferedImage[2];
    ghost1_up = new BufferedImage[2];
    ghost1_left = new BufferedImage[2];
    ghost1_right = new BufferedImage[2];
    ghost1_down[0] = sheet.crop(0, 0, WIDTH, HEIGHT);
    ghost1_down[1] = sheet.crop(WIDTH, 0, WIDTH, HEIGHT);
    ghost1_up[0] = sheet.crop(0, HEIGHT, WIDTH, HEIGHT);
    ghost1_up[1] = sheet.crop(WIDTH, HEIGHT, WIDTH, HEIGHT);
    ghost1_right[0] = sheet.crop(0, HEIGHT * 2, WIDTH, HEIGHT);
    ghost1_right[1] = sheet.crop(WIDTH, HEIGHT * 2, WIDTH, HEIGHT);
    ghost1_left[0] = sheet.crop(0, HEIGHT * 3, WIDTH, HEIGHT);
    ghost1_left[1] = sheet.crop(WIDTH, HEIGHT * 3, WIDTH, HEIGHT);
    
    ghost2_down = new BufferedImage[2];
    ghost2_up = new BufferedImage[2];
    ghost2_left = new BufferedImage[2];
    ghost2_right = new BufferedImage[2];
    ghost2_down[0] = sheet.crop(WIDTH * 2, 0, WIDTH, HEIGHT);
    ghost2_down[1] = sheet.crop(WIDTH * 3, 0, WIDTH, HEIGHT);
    ghost2_up[0] = sheet.crop(WIDTH * 2, HEIGHT, WIDTH, HEIGHT);
    ghost2_up[1] = sheet.crop(WIDTH * 3, HEIGHT, WIDTH, HEIGHT);
    ghost2_right[0] = sheet.crop(WIDTH * 2, HEIGHT * 2, WIDTH, HEIGHT);
    ghost2_right[1] = sheet.crop(WIDTH * 3, HEIGHT * 2, WIDTH, HEIGHT);
    ghost2_left[0] = sheet.crop(WIDTH * 2, HEIGHT * 3, WIDTH, HEIGHT);
    ghost2_left[1] = sheet.crop(WIDTH * 3, HEIGHT * 3, WIDTH, HEIGHT);
    
    ghost3_down = new BufferedImage[2];
    ghost3_up = new BufferedImage[2];
    ghost3_left = new BufferedImage[2];
    ghost3_right = new BufferedImage[2];
    ghost3_down[0] = sheet.crop(WIDTH * 4, 0, WIDTH, HEIGHT);
    ghost3_down[1] = sheet.crop(WIDTH * 5, 0, WIDTH, HEIGHT);
    ghost3_up[0] = sheet.crop(WIDTH * 4, HEIGHT, WIDTH, HEIGHT);
    ghost3_up[1] = sheet.crop(WIDTH * 5, HEIGHT, WIDTH, HEIGHT);
    ghost3_right[0] = sheet.crop(WIDTH * 4, HEIGHT * 2, WIDTH, HEIGHT);
    ghost3_right[1] = sheet.crop(WIDTH * 5, HEIGHT * 2, WIDTH, HEIGHT);
    ghost3_left[0] = sheet.crop(WIDTH * 4, HEIGHT * 3, WIDTH, HEIGHT);
    ghost3_left[1] = sheet.crop(WIDTH * 5, HEIGHT * 3, WIDTH, HEIGHT);
  }
}