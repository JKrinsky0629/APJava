package Tanks;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet {
	private int location_x;
	private int location_y;
	private int direction;
	private boolean shot;
	
	public Bullet(int x, int y) //constructor
	{
		location_x = x;
		location_y = y;
		direction = 0;
		
	}

	public int getLocation_x() {

		return location_x;
	}
	public void setLocation_x(int a) {

		location_x =a;
	}
	public void setLocation_y(int a) {

		location_y =a;
	}

	//shoot in directions sets a int direction value and a boolean true
	public void shootLeft() {
		direction =1;
		shot = true;
		location_x-= 10;
	}
	public void shootRight() {
		direction =2;
		shot = true;
		location_x+= 10;
	}
	public int getLocation_y() {
		return location_y;
	}

	public void shootUp() {
		direction =3;
		shot = true;
		location_y -= 10;
	}
	public void shootDown() {
		direction = 4;
		shot = true;
		location_y += 10;
	}
	public int getDirection()
	{
		return direction;
	}
	//draws a circle
	public void drawBullet(Graphics g)
	{
		g.fillOval(getLocation_x(), getLocation_y(), 5, 5);
		g.setColor(Color.GRAY);
	}
	//sets to a x-coord and y-coor and changes bool to false
	public void shot_finished()
	{
		location_x = 20;
		location_y = 590;
		shot= false;
		direction =0;
	}
	//overloads the shot_finsihed
	public void shot_finished(int x, int y)
	{
		location_x = x;
		location_y = y;
		shot= false;
		direction =0;
	}
	public boolean isShot()
	{
		return shot;
	}
	

}
