/* enemy tank is just normal tank but but controlled*/
package Tanks;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class EnemyTank extends Tank {

	private BufferedImage enemyTank;
	private BufferedImage enemyTank_down;
	private BufferedImage enemyTank_left;
	private BufferedImage enemyTank_right;

	private int lives;
	public EnemyTank(int x, int y) {
		super(x, y);
		lives = 3;
		try
		{
			//files for all images
			enemyTank = ImageIO.read(new File("/Users/joshuakrinsky/eclipse-workspace/TankGame/src/Tanks/enemy_tank.png"));
			enemyTank_down = ImageIO.read(new File("/Users/joshuakrinsky/eclipse-workspace/TankGame/src/Tanks/enemy_tank_down.png"));
			enemyTank_left = ImageIO.read(new File("/Users/joshuakrinsky/eclipse-workspace/TankGame/src/Tanks/enemy_tank_left.png"));
			enemyTank_right = ImageIO.read(new File("/Users/joshuakrinsky/eclipse-workspace/TankGame/src/Tanks/enemy_tank_right.png"));
		}
		catch(Exception e)
		{
			System.out.println("img enemy tank Doesn't exist");
		}
	}
	public int Speed() {
		return 3;
	}

	public void loseLives() {
		lives--;
	}

	public int Lives() {
		return lives;
	}
//draw based on direction
	public void drawTank(Graphics g, int a) {
		if(a==1)
			g.drawImage(enemyTank, super.getLocation_x(), super.getLocation_y(), null);
		if(a==2)
			g.drawImage(enemyTank_down, super.getLocation_x(), super.getLocation_y(), null);
		if(a==3)
			g.drawImage(enemyTank_left, super.getLocation_x(), super.getLocation_y(), null);
		if(a==4)
			g.drawImage(enemyTank_right, super.getLocation_x(), super.getLocation_y(), null);
			
	}
}
