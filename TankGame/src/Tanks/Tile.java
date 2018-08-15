/*abstract class fully defined by its child classes Filled and Empty Tile*/
package Tanks;

import java.awt.Graphics;

public abstract class Tile {
	private int position_x;
	private int position_y;
	
	public Tile(int x, int y)
	{
		position_x =x;
		position_y= y;
	}

	public int getPosition_x() {
		return position_x;
	}

	public int getPosition_y() {
		return position_y;
	}
	//draw is abstract
	public abstract void drawTile(Graphics g);
	
	//isFillied is abstract
	public abstract boolean IsFilled(); 
}
