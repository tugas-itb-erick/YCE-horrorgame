package ghostgame.entities.statics;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import ghostgame.gfx.Assets;

/**
 * File : StaticEntityView.java 
 * Kelas StaticEntityView merupakan kelas yang menampilkan StaticEntity.
 * @author Catherine Almira - 13515111
 */

public class StaticEntityView {

  /**
   * Menampilkan gambar StaticEntity sesuai dengan jenisnya.
   * @param se StaticEntity yang akan dicetak.
   * @param g grafik yang mencetak StaticEntity.
   */
	
	public void render(StaticEntity se, Graphics g) {
		BufferedImage texture;
		
		/*if (se instanceof Rock)
			texture = Assets.stone;
		else if (se instanceof Tree)
			texture = Assets.tree;
		else
			texture = Assets.tree;
		*/
		
		/*System.out.println((int)se.getHandler().getGameCamera().getxOffset() / Tile.TILEWIDTH - sightX - 1 + " " + xStart / Tile.TILEWIDTH);
		System.out.println((int)se.getHandler().getGameCamera().getyOffset() / Tile.TILEHEIGHT - sightX - 1 + " " + yStart / Tile.TILEHEIGHT);
		if (((int)se.getHandler().getGameCamera().getxOffset() / Tile.TILEWIDTH - sightX - 1 <= xStart / Tile.TILEWIDTH) &&
		((int)se.getHandler().getGameCamera().getyOffset() / Tile.TILEHEIGHT - sightY - 1 <= yStart / Tile.TILEHEIGHT) &&
		((int)se.getHandler().getGameCamera().getxOffset() / Tile.TILEWIDTH + sightX + 2>= xStart / Tile.TILEWIDTH) &&
		((int)se.getHandler().getGameCamera().getyOffset() / Tile.TILEHEIGHT + sightY + 2>= yStart / Tile.TILEHEIGHT))*/
		
		int xStart = (int) (se.getX() - se.getHandler().getGameCamera().getxOffset());
		int yStart = (int) (se.getY() - se.getHandler().getGameCamera().getyOffset());
		int sightX = se.getHandler().getWorld().getEntityManager().getPlayer().getSightX();
		int sightY = se.getHandler().getWorld().getEntityManager().getPlayer().getSightY();
		
		/*
		 * Jika id = 0, maka StaticEntity adalah Bed.
		 * Jika id = 1, maka StaticEntity adalah Chair.
		 * Jika id = 2, maka StaticEntity adalah Door.
		 * Jika id = 3, maka StaticEntity adalah Refrigerator.
		 * Jika id = 4, maka StaticEntity adalah Sofa.
		 * Jika id = 5, maka StaticEntity adalah Table.
		 * Jika id = 6, maka StaticEntity adalah Television.
		 * Jika id = 7, maka StaticEntity adalah Wardrobe.
		 */
		if (se.getId() == 0) {
			texture = Assets.bed;
		} else if (se.getId() == 1) {
			texture = Assets.chair;
		} else if (se.getId() == 2) {
			texture = Assets.doorVertical;
			texture = Assets.doorHorizontal;
		} else if (se.getId() == 3) {
			texture = Assets.refrigerator;
		} else if (se.getId() == 4) {
			texture = Assets.sofa;
		} else if (se.getId() == 5) {
			texture = Assets.table;
		} else if (se.getId() == 6) {
			texture = Assets.television;
		} else if (se.getId() == 7) {
			texture = Assets.wardrobe;
		} else {
			texture = Assets.wardrobe;
		}
		g.drawImage(texture, xStart, yStart, se.getWidth(), se.getHeight(), null);
	}
	
}

/*
    if (se instanceof Television) {
      g.drawImage(Assets.television, (int) (se.getX() - se.getHandler().getGameCamera().getxOffset()),
        (int) (se.getY() - se.getHandler().getGameCamera().getyOffset()), se.getWidth(), se.getHeight(), null);
    } else if (se instanceof Bed) {
      g.drawImage(Assets.bed, (int) (se.getX() - se.getHandler().getGameCamera().getxOffset()),
        (int) (se.getY() - se.getHandler().getGameCamera().getyOffset()), se.getWidth(), se.getHeight(), null);
    } else if (se instanceof Wardrobe) {
      g.drawImage(Assets.wardrobe, (int) (se.getX() - se.getHandler().getGameCamera().getxOffset()),
        (int) (se.getY() - se.getHandler().getGameCamera().getyOffset()), se.getWidth(), se.getHeight(), null);
    } else if (se instanceof Chair) {
      g.drawImage(Assets.chair, (int) (se.getX() - se.getHandler().getGameCamera().getxOffset()),
        (int) (se.getY() - se.getHandler().getGameCamera().getyOffset()), se.getWidth(), se.getHeight(), null);
    } else if (se instanceof Refrigerator) {
      g.drawImage(Assets.refrigerator, (int) (se.getX() - se.getHandler().getGameCamera().getxOffset()),
        (int) (se.getY() - se.getHandler().getGameCamera().getyOffset()), se.getWidth(), se.getHeight(), null);
    } else if (se instanceof Table) {
      g.drawImage(Assets.table, (int) (se.getX() - se.getHandler().getGameCamera().getxOffset()),
        (int) (se.getY() - se.getHandler().getGameCamera().getyOffset()), se.getWidth(), se.getHeight(), null);
    } else if (se instanceof Sofa) {
      g.drawImage(Assets.sofa, (int) (se.getX() - se.getHandler().getGameCamera().getxOffset()),
        (int) (se.getY() - se.getHandler().getGameCamera().getyOffset()), se.getWidth(), se.getHeight(), null);
    } else if (se instanceof Door) {
      //PINTU SIALAN
      g.drawImage(Assets.doorHorizontal, (int) (se.getX() - se.getHandler().getGameCamera().getxOffset()),
        (int) (se.getY() - se.getHandler().getGameCamera().getyOffset()), se.getWidth(), se.getHeight(), null);
    } else {

    }
*/
