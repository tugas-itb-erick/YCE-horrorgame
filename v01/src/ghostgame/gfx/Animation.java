package ghostgame.gfx;

import java.awt.image.BufferedImage;

/**
  * Kelas Animation yang merepresentasikan animasi atau pergantian 
  * gambar sesuai dengan satuan waktu tertentu.
  * @author Erick Wijaya - 13515057
  */

public class Animation {
  
  private int speed;
  private int index;
  private long lastTime;
  private long timer;
  private BufferedImage[] frames;
  
  /**
    * Constructor dengan parameter.
    * @param speed Nilai kecepatan pergantian antar gambar yang akan dimasukkan ke atribut speed.
    * @param frames Array of gambar (BufferedImage) yang akan dimasukkan ke dalam frames.
    */
  
  public Animation(int speed, BufferedImage[] frames) {
    this.speed = speed;
    this.frames = frames;
    index = 0;
    timer = 0;
    lastTime = System.currentTimeMillis();
  }
  
  /**
    * Constructor dengan parameter.
    * @param speed Nilai kecepatan pergantian antar gambar yang akan dimasukkan ke atribut speed.
    * @param frames Array of gambar (BufferedImage) yang akan dimasukkan ke dalam frames.
    */
 
  public Animation(int speed, BufferedImage[] frames, int index) {
    this.speed = speed;
    this.frames = frames;
    this.index = index;
    timer = 0;
    lastTime = System.currentTimeMillis();
  }
  
  /**
    * Meng-update kondisi objek untuk setiap satuan waktu.
    */
  
  public void tick() {
    timer += System.currentTimeMillis() - lastTime;
    lastTime = System.currentTimeMillis();
    
    if (timer > speed) {
      index++;
      timer = 0;
      if (index >= frames.length) {
        index = 0;
      }
    }
  }
  
  /**
    * Mengembalikan frames dengan atribut indeks yang bersesuaian.
    * @return Nilai BufferedImage yang bersesuaian dengan atribut indeks sekarang.
    */
  
  public BufferedImage getCurrentFrame() {
    return frames[index];
  }
}
