package ghostgame.gfx;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Assets {
	
	private static final int WIDTH = 32, HEIGHT = 32;
	
	public static Font font28;
	
	private static BufferedImage sheet;
	private static BufferedImage ghost;
	
  // main menu background image
  public static BufferedImage mainMenuBackground;
  // written images
  public static BufferedImage instructionScreen;
  public static BufferedImage lostScreen;
  public static BufferedImage winScreen;
  
	// button images
	public static BufferedImage[] btn_start, btn_instruction, btn_credit, btn_back, btn_quit;
  
	// static item images
	public static BufferedImage candle;
	public static BufferedImage key;
	public static BufferedImage knife;
	public static BufferedImage gold;
	public static BufferedImage ghostAsh;
	
	// static entities
	public static BufferedImage bed;
	public static BufferedImage wardrobe;
	public static BufferedImage chair;
	public static BufferedImage refrigerator;
	public static BufferedImage television;
	public static BufferedImage table;
	public static BufferedImage sofa;
	public static BufferedImage doorHorizontal;
	public static BufferedImage doorVertical;
	
  // player animation images
  public static BufferedImage[] player_down, player_up, player_left, player_right;
  // ghost animation images
  public static BufferedImage[] ghost1_down, ghost1_up, ghost1_left, ghost1_right;
  public static BufferedImage[] ghost2_down, ghost2_up, ghost2_left, ghost2_right;
  public static BufferedImage[] ghost3_down, ghost3_up, ghost3_left, ghost3_right;
	
	public static BufferedImage dirt, grass, stone, tree, rock;
	public static BufferedImage wood;
	public static BufferedImage inventoryScreen;

	public static void init(){
		
		try {
			Font.createFont(Font.TRUETYPE_FONT, new File("res/fonts/slkscr.ttf")).deriveFont(Font.PLAIN, 28);
			sheet = ImageIO.read(new File("res/textures/asset.png"));
			ghost = ImageIO.read(new File("res/textures/ghost.png"));
			inventoryScreen = ImageIO.read(new File("res/textures/inventoryScreen.png"));
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
    // Keterangan : sheet.getSubimage(X, Y, lebarGambar, panjangGambar)
    // X dan Y adalah posisi ujung kiri atas gambar dalam file "assets.png".
    mainMenuBackground = sheet.getSubimage(0, HEIGHT * 5, WIDTH * 2, HEIGHT * 2);
    knife = sheet.getSubimage(0, 0, WIDTH, HEIGHT);
    bed = sheet.getSubimage(WIDTH, HEIGHT, WIDTH * 2, HEIGHT);
    wardrobe = sheet.getSubimage(0, HEIGHT * 2, WIDTH, HEIGHT * 2);
    key = sheet.getSubimage(WIDTH, HEIGHT * 2, WIDTH, HEIGHT);
    chair = sheet.getSubimage(WIDTH * 2, HEIGHT * 2, WIDTH, HEIGHT);
    candle = sheet.getSubimage(WIDTH * 3, HEIGHT, WIDTH, HEIGHT * 2);
    refrigerator = sheet.getSubimage(WIDTH, HEIGHT * 3, WIDTH, HEIGHT);
    television = sheet.getSubimage(WIDTH * 2, HEIGHT * 3, WIDTH, HEIGHT);
    table = sheet.getSubimage(WIDTH * 3, HEIGHT * 3, WIDTH, HEIGHT);
    sofa = sheet.getSubimage(0, HEIGHT * 4, WIDTH * 2, HEIGHT);
    doorHorizontal = sheet.getSubimage(WIDTH * 3, HEIGHT * 4, WIDTH, HEIGHT);
    doorVertical = sheet.getSubimage(WIDTH * 2, HEIGHT * 4, WIDTH, HEIGHT); 
    
		btn_start = new BufferedImage[2];
		btn_start[0] = sheet.getSubimage(WIDTH * 2, HEIGHT * 5, WIDTH * 3, HEIGHT);
		btn_start[1] = sheet.getSubimage(WIDTH * 4, HEIGHT * 4, WIDTH * 3, HEIGHT);
		
		btn_instruction = new BufferedImage[2];
		btn_instruction[0] = sheet.getSubimage(WIDTH * 2, HEIGHT * 6, WIDTH * 3, HEIGHT);
		btn_instruction[1] = sheet.getSubimage(WIDTH * 3, HEIGHT * 7, WIDTH * 3, HEIGHT);
		
		btn_back = new BufferedImage[2];
		btn_back[0] = sheet.getSubimage(WIDTH * 5, HEIGHT * 6, WIDTH * 2, HEIGHT);
		btn_back[1] = sheet.getSubimage(WIDTH * 5, HEIGHT * 6, WIDTH * 2, HEIGHT);
		
		btn_credit = new BufferedImage[2];
		btn_credit[0] = sheet.getSubimage(WIDTH * 2, HEIGHT * 5, WIDTH * 3, HEIGHT);
		btn_credit[1] = sheet.getSubimage(WIDTH * 4, HEIGHT * 4, WIDTH * 3, HEIGHT);
		
		btn_quit = new BufferedImage[2];
		btn_quit[0] = sheet.getSubimage(WIDTH * 2, HEIGHT * 5, WIDTH * 3, HEIGHT);
		btn_quit[1] = sheet.getSubimage(WIDTH * 4, HEIGHT * 4, WIDTH * 3, HEIGHT);
				
    player_down = new BufferedImage[3];
    player_up = new BufferedImage[3];
    player_left = new BufferedImage[3];
    player_right = new BufferedImage[3];
    player_down[0] = sheet.getSubimage(WIDTH * 4, 0, WIDTH, HEIGHT);
    player_down[1] = sheet.getSubimage(WIDTH * 5, 0, WIDTH, HEIGHT);
    player_down[2] = sheet.getSubimage(WIDTH * 6, 0, WIDTH, HEIGHT);
    player_up[0] = sheet.getSubimage(WIDTH * 4, HEIGHT, WIDTH, HEIGHT);
    player_up[1] = sheet.getSubimage(WIDTH * 5, HEIGHT, WIDTH, HEIGHT);
    player_up[2] = sheet.getSubimage(WIDTH * 6, HEIGHT, WIDTH, HEIGHT);
    player_right[0] = sheet.getSubimage(WIDTH * 4, HEIGHT * 2, WIDTH, HEIGHT);
    player_right[1] = sheet.getSubimage(WIDTH * 5, HEIGHT * 2, WIDTH, HEIGHT);
    player_right[2] = sheet.getSubimage(WIDTH * 6, HEIGHT * 2, WIDTH, HEIGHT);
    player_left[0] = sheet.getSubimage(WIDTH * 4, HEIGHT * 3, WIDTH, HEIGHT);
    player_left[1] = sheet.getSubimage(WIDTH * 5, HEIGHT * 3, WIDTH, HEIGHT);
    player_left[2] = sheet.getSubimage(WIDTH * 6, HEIGHT * 3, WIDTH, HEIGHT);
		
    ghost1_down = new BufferedImage[2];
    ghost1_up = new BufferedImage[2];
    ghost1_left = new BufferedImage[2];
    ghost1_right = new BufferedImage[2];
    ghost1_down[0] = ghost.getSubimage(0, 0, WIDTH, HEIGHT);
    ghost1_down[1] = ghost.getSubimage(WIDTH, 0, WIDTH, HEIGHT);
    ghost1_up[0] = ghost.getSubimage(0, HEIGHT, WIDTH, HEIGHT);
    ghost1_up[1] = ghost.getSubimage(WIDTH, HEIGHT, WIDTH, HEIGHT);
    ghost1_right[0] = ghost.getSubimage(0, HEIGHT * 2, WIDTH, HEIGHT);
    ghost1_right[1] = ghost.getSubimage(WIDTH, HEIGHT * 2, WIDTH, HEIGHT);
    ghost1_left[0] = ghost.getSubimage(0, HEIGHT * 3, WIDTH, HEIGHT);
    ghost1_left[1] = ghost.getSubimage(WIDTH, HEIGHT * 3, WIDTH, HEIGHT);
    
    ghost2_down = new BufferedImage[2];
    ghost2_up = new BufferedImage[2];
    ghost2_left = new BufferedImage[2];
    ghost2_right = new BufferedImage[2];
    ghost2_down[0] = ghost.getSubimage(WIDTH * 2, 0, WIDTH, HEIGHT);
    ghost2_down[1] = ghost.getSubimage(WIDTH * 3, 0, WIDTH, HEIGHT);
    ghost2_up[0] = ghost.getSubimage(WIDTH * 2, HEIGHT, WIDTH, HEIGHT);
    ghost2_up[1] = ghost.getSubimage(WIDTH * 3, HEIGHT, WIDTH, HEIGHT);
    ghost2_right[0] = ghost.getSubimage(WIDTH * 2, HEIGHT * 2, WIDTH, HEIGHT);
    ghost2_right[1] = ghost.getSubimage(WIDTH * 3, HEIGHT * 2, WIDTH, HEIGHT);
    ghost2_left[0] = ghost.getSubimage(WIDTH * 2, HEIGHT * 3, WIDTH, HEIGHT);
    ghost2_left[1] = ghost.getSubimage(WIDTH * 3, HEIGHT * 3, WIDTH, HEIGHT);
    
    ghost3_down = new BufferedImage[2];
    ghost3_up = new BufferedImage[2];
    ghost3_left = new BufferedImage[2];
    ghost3_right = new BufferedImage[2];
    ghost3_down[0] = ghost.getSubimage(WIDTH * 4, 0, WIDTH, HEIGHT);
    ghost3_down[1] = ghost.getSubimage(WIDTH * 5, 0, WIDTH, HEIGHT);
    ghost3_up[0] = ghost.getSubimage(WIDTH * 4, HEIGHT, WIDTH, HEIGHT);
    ghost3_up[1] = ghost.getSubimage(WIDTH * 5, HEIGHT, WIDTH, HEIGHT);
    ghost3_right[0] = ghost.getSubimage(WIDTH * 4, HEIGHT * 2, WIDTH, HEIGHT);
    ghost3_right[1] = ghost.getSubimage(WIDTH * 5, HEIGHT * 2, WIDTH, HEIGHT);
    ghost3_left[0] = ghost.getSubimage(WIDTH * 4, HEIGHT * 3, WIDTH, HEIGHT);
    ghost3_left[1] = ghost.getSubimage(WIDTH * 5, HEIGHT * 3, WIDTH, HEIGHT);
    
		dirt = sheet.getSubimage(WIDTH, 0, WIDTH, HEIGHT);
		grass = sheet.getSubimage(WIDTH * 2, 0, WIDTH, HEIGHT);
		stone = sheet.getSubimage(WIDTH * 3, 0, WIDTH, HEIGHT);
		tree = sheet.getSubimage(0, 0, WIDTH, HEIGHT * 2);
		rock = sheet.getSubimage(0, HEIGHT * 2, WIDTH, HEIGHT);
	}
	
}
