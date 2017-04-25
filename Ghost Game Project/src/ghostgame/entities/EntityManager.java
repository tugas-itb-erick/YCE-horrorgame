package ghostgame.entities;

import ghostgame.Handler;

import ghostgame.entities.creatures.Ghost;

import ghostgame.entities.creatures.Ghost1;

import ghostgame.entities.creatures.Ghost2;

import ghostgame.entities.creatures.Ghost3;

import ghostgame.entities.creatures.GhostController;

import ghostgame.entities.creatures.GhostView;

import ghostgame.entities.creatures.Player;

import ghostgame.entities.creatures.PlayerController;

import ghostgame.entities.creatures.PlayerView;

import ghostgame.entities.statics.StaticEntity;

import ghostgame.entities.statics.StaticEntityController;

import ghostgame.entities.statics.StaticEntityView;

import ghostgame.tiles.Tile;

import java.awt.Graphics;

import java.util.ArrayList;

import java.util.Comparator;

import java.util.Iterator;

/**
 * Kelas EntityManager merupakan kelas yang melakukan penanganan terhadap seluruh
 * Entity yang terdapat pada permainan.
 * @author Erick Wijaya - 13515057
 */

public class EntityManager {
  
  private Handler handler;
  private Player player;
  private ArrayList<Entity> entities;
  private Comparator<Entity> renderSorter = new Comparator<Entity>() {
    @Override
    public int compare(Entity a, Entity b) {
      if (a.getY() + a.getHeight() < b.getY() + b.getHeight()) {
        return -1;
      }
      return 1;
    }
  };
  private PlayerController pc;
  private StaticEntityController sc;
  private GhostController gc;
  
  /**
   * Constructor dengan parameter.
   * @param handler nilai yang menyatakan keterhubungan entitas dengan world.
   * @param player pemain yang ada dalam permainan.
   */
  
  public EntityManager(Handler handler, Player player) {
    this.handler = handler;
    this.player = player;
    entities = new ArrayList<Entity>();
    addEntity(player);
    pc = new PlayerController(player, new PlayerView());
    sc = new StaticEntityController(null, new StaticEntityView());
    gc = new GhostController(null, new GhostView());
  }
  
  /**
   * Mengupdate Entitas dalam setiap satuan waktu.
   */
  
  public void tick() {
    Iterator<Entity> it = entities.iterator();
    while (it.hasNext()) {
      Entity e = it.next();
      if (e instanceof StaticEntity) {
        sc.setStaticEntity((StaticEntity)e);
        //sc.tick();
      } else if (e instanceof Player) {
        pc.tick();
      } else if (e instanceof Ghost) {
        if (e instanceof Ghost1) {
          gc.setGhost((Ghost1) e);
        } else if (e instanceof Ghost2) {
          gc.setGhost((Ghost2) e);
        } else {
          gc.setGhost((Ghost3) e);
        }
        // gc = new GhostController((Ghost) e, new GhostView());
        // gc.setGhost((Ghost) e);
        gc.tick();
      }
      if (!e.isActive()) {
        it.remove();
      }
    }
    entities.sort(renderSorter);
  }
  
  /**
   * Mencetak gambar entitas ke layar.
   * @param g grafik yang menggambarkan entitas.
   * @param xstart posisi awal dalam sumbu x yang akan dirender.
   * @param ystart posisi awal dalam sumbu y yang akan dirender.
   * @param xend posisi akhir dalam sumbu x yang akan dirender.
   * @param yend posisi akhir dalam sumbu y yang akan dirender.
   */
  
  public void render(Graphics g, int xstart, int ystart, int xend, int yend) {
    for (Entity e : entities) {
      if (e instanceof Player) {
        pc.render(g);
      } else {
        if (e.getX() / Tile.TILEWIDTH >= xstart && e.getX() / Tile.TILEWIDTH < xend
            && e.getY() / Tile.TILEWIDTH >= ystart && e.getY() / Tile.TILEWIDTH < yend) {
          if (e instanceof StaticEntity) {
            sc.setStaticEntity((StaticEntity) e);
            sc.render(g);
          } else if (e instanceof Ghost) {
            gc.setGhost((Ghost) e);
            gc.render(g);
          }
        }
      }
    }
    pc.postRender(g);
  }
  
  /**
   * Menambahkan entitas baru ke dalam EntityManager.
   * @param e entitas baru yang akan ditambahkan.
   */
  
  public void addEntity(Entity e) {
    entities.add(e);
  }
  
  /**
   * Menghapus entitas e dari EntityManager.
   * @param e entitas yang akan dihapus.
   */
  
  public void deleteEntity(Entity e) {
    //entities.remove(e);
  }
  
  //GETTERS SETTERS

  /**
   * Mengembalikan handler yang merupakan nilai yang menghubungkan entitas dengan
   * world.
   * @return nilai yang menghubungkan entitas dengan world.
   */
  
  public Handler getHandler() {
    return handler;
  }

  /**
   * I.S. handler sembarang.
   * F.S. handler terdefinisi sesuai dengan handler yang baru.
   * @param handler yang baru.
   */
  
  public void setHandler(Handler handler) {
    this.handler = handler;
  }

  /**
   * Mengembalikan pemain yang terlibat dalam permainan.
   * @return pemain yang terlibat dalam permainan.
   */
  
  public Player getPlayer() {
    return player;
  }
  
  /**
   * I.S. player sembarang.
   * F.S. player terdefinisi sesuai dengan player yang baru.
   * @param player yang baru.
   */

  public void setPlayer(Player player) {
    this.player = player;
  }

  /**
   * Mengembalikan list entitas.
   * @return list entitas.
   */
  
  public ArrayList<Entity> getEntities() {
    return entities;
  }

  /**
   * I.S. entities sembarang.
   * F.S. entities terdefinisi sesuai dengan entities yang baru.
   * @param entities yang baru.
   */
  
  public void setEntities(ArrayList<Entity> entities) {
    this.entities = entities;
  }
}
