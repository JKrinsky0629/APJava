/*sets speed to 10 lives to 3 another variation of tank*/
package Tanks;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class NormalTank extends TankPlayer{

	private int lives;
	private BufferedImage normalTank;
	private BufferedImage normalTank_down;
	private BufferedImage normalTank_left;
	private BufferedImage normalTank_right;
	public NormalTank(int x, int y) {
		super(x, y);
		lives = 3;
		try
		{
			normalTank = ImageIO.read(new File("/Users/joshuakrinsky/eclipse-workspace/TankGame/src/Tanks/norm_tank.png"));
			normalTank_down = ImageIO.read(new File("/Users/joshuakrinsky/eclipse-workspace/TankGame/src/Tanks/norm_tank_down.png"));
			normalTank_left = ImageIO.read(new File("/Users/joshuakrinsky/eclipse-workspace/TankGame/src/Tanks/norm_tank_left.png"));
			normalTank_right = ImageIO.read(new File("/Users/joshuakrinsky/eclipse-workspace/TankGame/src/Tanks/norm_tank_right.png"));
		}
		catch(Exception e)
		{
			System.out.println("img normal tank Doesn't exist");
		}
	}

	public int Speed() {
		return 10;
	}

	public void loseLives() {
		lives--;
		
	}

	public int Lives() {
		return lives;
	}

	public void drawTank(Graphics G, int a) {
		if(a==1)
			G.drawImage(normalTank, super.getLocation_x(), super.getLocation_y(), null);
		if(a==2)
			G.drawImage(normalTank_down, super.getLocation_x(), super.getLocation_y(), null);
		if(a==3)
			G.drawImage(normalTank_left, super.getLocation_x(), super.getLocation_y(), null);
		if(a==4)
			G.drawImage(normalTank_right, super.getLocation_x(), super.getLocation_y(), null);
	}
	public void setLives(int a) {
		lives =a;
		
	}
}
