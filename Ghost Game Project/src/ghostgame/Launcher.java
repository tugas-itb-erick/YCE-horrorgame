package ghostgame;

/**
 * Kelas Launcher adalah kelas yang menjalankan permainan.
 * @author 
 */

public class Launcher {

  public static void main(String[] args) {
    Game game = new Game("You Can't Escape!", 640, 480);
    game.start();
  }
  
}
