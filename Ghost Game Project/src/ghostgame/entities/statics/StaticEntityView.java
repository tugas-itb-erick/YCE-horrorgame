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
		
		if (se instanceof Rock)
			texture = Assets.stone;
		else if (se instanceof Tree)
			texture = Assets.tree;
		else
			texture = Assets.tree;
		
		int xStart = (int) (se.getX() - se.getHandler().getGameCamera().getxOffset());
		int yStart = (int) (se.getY() - se.getHandler().getGameCamera().getyOffset());
		int sightX = se.getHandler().getWorld().getEntityManager().getPlayer().getSightX();
		int sightY = se.getHandler().getWorld().getEntityManager().getPlayer().getSightY();
		
		/*System.out.println((int)se.getHandler().getGameCamera().getxOffset() / Tile.TILEWIDTH - sightX - 1 + " " + xStart / Tile.TILEWIDTH);
		System.out.println((int)se.getHandler().getGameCamera().getyOffset() / Tile.TILEHEIGHT - sightX - 1 + " " + yStart / Tile.TILEHEIGHT);
		if (((int)se.getHandler().getGameCamera().getxOffset() / Tile.TILEWIDTH - sightX - 1 <= xStart / Tile.TILEWIDTH) &&
		((int)se.getHandler().getGameCamera().getyOffset() / Tile.TILEHEIGHT - sightY - 1 <= yStart / Tile.TILEHEIGHT) &&
		((int)se.getHandler().getGameCamera().getxOffset() / Tile.TILEWIDTH + sightX + 2>= xStart / Tile.TILEWIDTH) &&
		((int)se.getHandler().getGameCamera().getyOffset() / Tile.TILEHEIGHT + sightY + 2>= yStart / Tile.TILEHEIGHT))*/
			
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
