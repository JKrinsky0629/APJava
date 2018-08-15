/*quickest tank fastest variation of the tank class*/
package Tanks;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class SpeedTank extends TankPlayer {

	private int lives;
	private BufferedImage speedTank;
	private BufferedImage speedTank_down;
	private BufferedImage speedTank_left;
	private BufferedImage speedTank_right;
	public SpeedTank(int x, int y) {
		super(x, y);
		lives = 2;
		try
		{
			speedTank = ImageIO.read(new File("/Users/joshuakrinsky/eclipse-workspace/TankGame/src/Tanks/light_tank.png"));
			speedTank_down = ImageIO.read(new File("/Users/joshuakrinsky/eclipse-workspace/TankGame/src/Tanks/light_tank_down.png"));
			speedTank_left = ImageIO.read(new File("/Users/joshuakrinsky/eclipse-workspace/TankGame/src/Tanks/light_tank_left.png"));
			speedTank_right = ImageIO.read(new File("/Users/joshuakrinsky/eclipse-workspace/TankGame/src/Tanks/light_tank_right.png"));
		}
		catch(Exception e)
		{
			System.out.println("img speed tank Doesn't exist");
		}
	}

	public int Speed() {
		return 15;
	}

	public void loseLives() {
		lives--;
	}

	public int Lives() {
		return lives;
	}
	
	public void drawTank(Graphics g, int a) {
		if(a == 1)
			g.drawImage(speedTank, super.getLocation_x(), super.getLocation_y(), null);
		 if(a == 2)
			 g.drawImage(speedTank_down, super.getLocation_x(), super.getLocation_y(), null);
		 if(a==3)
			 g.drawImage(speedTank_left, super.getLocation_x(), super.getLocation_y(), null);
		 if(a==4)
			 g.drawImage(speedTank_right, super.getLocation_x(), super.getLocation_y(), null);
			 
			 
	}


	public void setLives(int a) {
		lives =a;
		
	}
	
}
