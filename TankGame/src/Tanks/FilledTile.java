/*never used plan was to be blocking block*/
package Tanks;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class FilledTile extends Tile {
	public FilledTile(int x, int y) {
		super(x, y);
	}
	
	public void drawTile(Graphics g) {
		g.fillRect(super.getPosition_x(), super.getPosition_x(), 30, 30);
		g.setColor(Color.BLACK);
	} 
	public boolean IsFilled()
	{
		return true;
	}

}
