/*tiles work as a background they are drawn and set as being not filled*/
package Tanks;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class EmptyTile extends Tile {

	BufferedImage emptyTileImg;
	public EmptyTile(int x, int y) {
		super(x, y);
		try{
			emptyTileImg = ImageIO.read(new File("/Users/joshuakrinsky/eclipse-workspace/TankGame/src/Tanks/GreenBlock.png"));
		}
		catch(Exception e)
		{
			System.out.println("img normal tank Doesn't exist");
		}
	}

	public void drawTile(Graphics g) { //draws a background block
		g.drawImage(emptyTileImg, super.getPosition_x(), super.getPosition_y(), null);
	}
	public boolean IsFilled()
	{
		return false;
	}
}
