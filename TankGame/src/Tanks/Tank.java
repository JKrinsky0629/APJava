/*parent class to enemyTank, SpeedTank, HeavyTank and NormalTank used as a basis to all other types of tanks abstract class
 * the abstract methods are drawTank, speed and Lives*/
package Tanks;

import java.awt.Graphics;

public abstract class Tank {
	private int location_x;
	private int location_y;
	private int direction;
	
	public Tank(int x, int y)
	{
		location_x = x;
		location_y = y;
		direction =1;
	}
	//move in certain direction
	public abstract int Speed();
	
	public void moveUp()
	{
		location_y-=Speed();
		direction =1;
	}
	public void moveDown()
	{
		location_y+=Speed();
		direction = 2;
	}
	public void moveLeft()
	{
		location_x-=Speed();
		direction =3;
	}
	public void moveRight()
	{
		location_x+=Speed();
		direction =4;
	}
	public int getLocation_x()
	{
		return location_x;
	}
	public int getLocation_y()
	{
		return location_y;
	}
	public void setLocation_x(int a)
	{
		location_x = a;
	}
	public void setLocation_y(int a)
	{
		location_y= a;
	}
	public abstract int Lives();
	
	public abstract void drawTank(Graphics G, int a);
	
	public int getDirec()
	{
		return direction;
	}
}
