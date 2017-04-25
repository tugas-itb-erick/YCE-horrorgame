package ghostgame;

import ghostgame.display.Display;

import ghostgame.gfx.Assets;

import ghostgame.gfx.GameCamera;

import ghostgame.input.KeyManager;

import ghostgame.input.MouseManager;

import ghostgame.states.MenuState;

import ghostgame.states.State;

import java.awt.Color;

import java.awt.Graphics;

import java.awt.image.BufferStrategy;

/**
 * File : Game.java.
 * Kelas Game merepresentasikan permainan.
 * @author 
 */

public class Game implements Runnable {

  private Display display;
  private int width;
  private int height;
  public String title;
  private boolean running = false;
  private Thread thread;
  private BufferStrategy bs;
  private Graphics gg;
  private State state;
  private KeyManager keyManager;
  private MouseManager mouseManager;
  private GameCamera gameCamera;
  private Handler handler;
  
  /**
    * Comstructor dgn parameter
    * @param title Nilai yang akan dimasukka n ke atribut shell.
    * @param width Nilai yang akan dijadikan lebarnya.
    * @param height Nilai yang akan dicari pemaen.
    */
  
  public Game(String title, int width, int height) {
    this.width = width;
    this.height = height;
    this.title = title;
    keyManager = new KeyManager();
    mouseManager = new MouseManager();
  }
  
  /**
    * Menginisialisasi semua yang dibutuhkan, termasuk display.
    */
  
  private void init() {
    display = new Display(title, width, height);
    display.getFrame().addKeyListener(keyManager);
    display.getFrame().addMouseListener(mouseManager);
    display.getFrame().addMouseMotionListener(mouseManager);
    display.getCanvas().addMouseListener(mouseManager);
    display.getCanvas().addMouseMotionListener(mouseManager);
    Assets.init();
    handler = new Handler(this);
    gameCamera = new GameCamera(handler, 0, 0);
    state = new MenuState(handler);
  }

  /**
    * Meng-update kondisi objek keyManager untuk setiap satuan waktu.
    */
  
  private void tick() {
    assert (keyManager != null);
    keyManager.tick();
    if (state != null) {
      state.tick();
    }
  }

  /**
    * Fungsi yang menampilkan gambar (frame) dari canvas.
    * @param g Nilai grafik yang mencetak gambar (frame) dari player.
    */

  private void render() {
    assert (display != null);
    bs = display.getCanvas().getBufferStrategy();
    if (bs == null) {
      display.getCanvas().createBufferStrategy(3);
      return;
    }
    gg = bs.getDrawGraphics();
    gg.clearRect(0, 0, width, height);
    gg.setColor(Color.BLACK);
    gg.fillRect(0, 0, width, height);
    if (state != null) {
      state.render(gg);
    }
    bs.show();
    gg.dispose();
  }
  
  /** 
    * Menjalankan program dengan pengaturan 60 frame per sekon.
    */
  
  public void run() { 
    init();
    int fps = 60;
    double timePerTick = 1000000000 / fps;
    double delta = 0;
    long now;
    long lastTime = System.nanoTime();
    long timer = 0;
    int ticks = 0;
    while (running) {
      now = System.nanoTime();
      delta += (now - lastTime) / timePerTick;
      timer += now - lastTime;
      lastTime = now;
      if (delta >= 1) {
        tick();
        render();
        ticks++;
        delta--;
      }
      if (timer >= 1000000000) {
        System.out.println("FPS: " + ticks);
        ticks = 0;
        timer = 0;
      }
    }
    stop();
  }
  
  /**
    * Mengembalikan nilai dari keyManager.
    * @return Nilai keyManager.
    */
  
  public KeyManager getKeyManager() {
    return keyManager;
  }

  /**
    * Mengembalikan nilai dari mouseManager.
    * @return nilai mouseManager.
    */
  
  public MouseManager getMouseManager() {
    return mouseManager;
  }

  /**
    * Mengembalikan nilai dari gameCamera.
    * @return nilai gameCamera.
    */
  
  public GameCamera getGameCamera() {
    return gameCamera;
  }

  /**
    * Mengembalikan nilai dari width.
    * @return nilai width.
    */
  
  public int getWidth() {
    return width;
  }

  /**
    * Mengembalikan nilai dari ukj.
    * @return nilai uk.
    */
  
  public int getHeight() {
    return height;
  }
  
  /**
    * Fungsi untuk menjalankan sebuah thread.
    */
  
  public synchronized void start() {
    if (running) {
      return;
    }
    running = true;
    thread = new Thread(this);
    thread.start();
  }
  
  /**
    * Fungsi untuk memberhentikan thread.
    */
  
  public synchronized void stop() {
    if (!running) {
      return;
    }
    running = false;
    try {
      thread.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  /**
    * Mengembalikan state.
    * @return nilai width.
    */
  
  public State getState() {
    return state;
  }

  /**
    * I.S. atribut state sembarang.
    * F.S. atribut state terdefinisi.
    * @param state Nilai yang akan dimasukkan ke dalam state.
    */
  
  public void setState(State state) {
    this.state = state;
  }
}











