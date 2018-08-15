/*abstract class extends Tank and extends to the three variations of tanks a player can play as
 * abstract classes are lose Lives, Lives, setLives and drawTank*/
package Tanks;

import java.awt.Graphics;

public abstract class TankPlayer extends Tank {

	public TankPlayer(int x, int y) {
		super(x, y);
	}
	public abstract int Speed();
	
	public abstract void loseLives();

	public abstract int Lives();
	
	public abstract void setLives(int a);
	
	//not needed just used it to help remind me I need to implement to the various Tanks
	public abstract void drawTank(Graphics g, int a);
}
