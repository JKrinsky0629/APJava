/*defines lives as 4 and spped to five draw image drawns based on direction of tank*/
package Tanks;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class HeavyTank extends TankPlayer {

	private int lives;
	private BufferedImage heavyTank;
	private BufferedImage heavyTank_down;
	private BufferedImage heavyTank_left;
	private BufferedImage heavyTank_right;
	public HeavyTank(int x, int y) {
		super(x, y);
		lives = 4;
		try
		{
			//all images
			heavyTank = ImageIO.read(new File("/Users/joshuakrinsky/eclipse-workspace/TankGame/src/Tanks/heavy_tank.png"));
			heavyTank_down = ImageIO.read(new File("/Users/joshuakrinsky/eclipse-workspace/TankGame/src/Tanks/heavy_tank_down.png"));
			heavyTank_left = ImageIO.read(new File("/Users/joshuakrinsky/eclipse-workspace/TankGame/src/Tanks/heavy_tank_left.png"));
			heavyTank_right = ImageIO.read(new File("/Users/joshuakrinsky/eclipse-workspace/TankGame/src/Tanks/heavy_tank_right.png"));
		}
		catch(Exception e)
		{
			System.out.println("img heavy tank Doesn't exist");
		}
	}

	public int Speed() {
		return 5;
	}

	public void loseLives() {
		lives--;
	}

	public int Lives() {
		return lives;
	}

	public void drawTank(Graphics g, int a) {
		if(a==1)
			g.drawImage(heavyTank, super.getLocation_x(), super.getLocation_y(), null);
		if(a==2)
			g.drawImage(heavyTank_down, super.getLocation_x(), super.getLocation_y(), null);
		if(a==3)
			g.drawImage(heavyTank_left, super.getLocation_x(), super.getLocation_y(), null);
		if(a==4)	
			g.drawImage(heavyTank_right, super.getLocation_x(), super.getLocation_y(), null);
	}
	public void setLives(int a) {
		lives =a;
		
	}
}
