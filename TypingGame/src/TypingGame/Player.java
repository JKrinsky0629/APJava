package TypingGame;

public class Player {
	private String name;
	private int lives;
	private int points;
	public Player(String n)
	{
		//constructs player with a name 3 lives and no points
		name = n;
		lives = 3;
		points = 0;
	}
	public void loseLife() //subtract life
	{
		lives--;
	}
	public int getLife() //return number of life
	{
		return lives;
	}
	public String getName()
	{
		return name;
	}
	public void gainPoint() //add a point
	{
		points++;
	}
	public int getPoints() //returns number of points
	{
		return points;
	}
}
