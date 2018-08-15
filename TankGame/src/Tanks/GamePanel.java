package Tanks;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JPanel;



public class GamePanel extends JPanel implements JavaArcade, KeyListener, ActionListener { //polymorphism

	private javax.swing.Timer game_timer;
	private boolean isRunning;
	private EnemyTank enemy;
	private TankPlayer player;
	private Bullet bullet;
	private Bullet enemyBullet;
	private int points = 0;
	private int changes = 0;
	private boolean isPause = true;
	private boolean isStopped = false;
	private BufferedReader highScore; 
	private FileWriter fileWriter; 
	private boolean up = false;
	private boolean down = false;
	private boolean left = false;
	private boolean right = false;
	private boolean hit_box_horz = false;
           

	public GamePanel(int x, int y)

	{

		enemy = new EnemyTank(60,30);
		player = new NormalTank(30,555);
		bullet = new Bullet(0,590);
		enemyBullet = new Bullet(0,0);

		setPreferredSize(new Dimension(600,600));
		setFocusable(true);
		requestFocusInWindow();

	    game_timer = new javax.swing.Timer(50, this); //runs timer every 50 ms
	    //game_timer.start();
	    
	    addKeyListener(this);

	}

		public void actionPerformed(ActionEvent e) //sets all methods that will be run every 50 ms
		{
			move();
			check();
			move_and_fire();
			checkBullet();
			checkHit_me();
			checkHit_enemy();
			repaint();

		}

	  public void paintComponent(Graphics g) //overloads the repaint()

	  {

		  super.paintComponent(g);

		  ArrayList<Tile> Tiles = new ArrayList<Tile>(); //arraylist
		  int cnt =0;
			for(int i=0; i<600; i+=30)
			{
				for(int j=0; j<600; j+=30)
				{
					Tiles.add(new EmptyTile(i,j));
					
					Tiles.get(cnt).drawTile(g);
					cnt++;
				}
			}
			player.drawTank(g, player.getDirec()); //polymorphism
			enemy.drawTank(g, enemy.getDirec()); //polymorphism but never changed
			bullet.drawBullet(g);
			enemyBullet.drawBullet(g);
			g.drawString(player.Lives()+" Lives", 300, 590);
	  }
	

	public boolean running() {
		if(game_timer.isRunning())
		{
			isPause = false;
			return true;
		}
		else
			return false;
	}



	public void startGame() {
		game_timer.start();
		isPause = false;
		if(isStopped == true)
			restart();
	}



	public String getGameName() {
		return "Tanks";
	}



	public void pauseGame() {
		game_timer.stop();
		isPause = true;
	}



	public String getInstructions() {

		return "You must kill the enemy tank every kill is one point\n"
				+ "You can ghange your tank type with 1,2,3 but you only get 3 changes per point\n"
				+ "you move with w,a,s,d and shoot with the arrow keys enjoy ! :)";

	}



	public String getCredits() {

		return "Joshua Krinsky - head developer\n"
				+ "Timmy Retelle - constant thorn in my side";

	}



	public String getHighScore() {
		try {
			highScore = new BufferedReader(new FileReader("/Users/joshuakrinsky/eclipse-workspace/TankGame/src/Tanks/highScore.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		String score_no_parsed = ""+0;
		int score;
		try {
			score_no_parsed = highScore.readLine();
			score = Integer.parseInt(score_no_parsed);
			highScore.close();
		} catch (IOException e) {
			return score_no_parsed;
		}

		
		if(score < points)
		{
			try {
				fileWriter = new FileWriter("/Users/joshuakrinsky/eclipse-workspace/TankGame/src/Tanks/highScore.txt");
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				fileWriter.write(points+"");
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return score_no_parsed;

	}



	public void stopGame() {
		game_timer.stop();
		isPause = true;
		isStopped = true;
	}

	public int getPoints() {
		return points;

	}

	public void checkBullet() { //checks bullet is still on the screen for both enemyBullet and Bullet

		if(bullet.getDirection() == 1 && bullet.getLocation_x() > 0)
			bullet.shootLeft();

		else if(bullet.getDirection() == 2 && bullet.getLocation_x() < 600)
			bullet.shootRight();

		
		else if(bullet.getDirection() == 3 && bullet.getLocation_y() > 0)
			bullet.shootUp();


		else if(bullet.getDirection() == 4 && bullet.getLocation_y() < 600)
			bullet.shootDown();

		else
			bullet.shot_finished();
		
		if(enemyBullet.getDirection() == 1 && enemyBullet.getLocation_x() > 0)
			enemyBullet.shootLeft();	
		

		else if(enemyBullet.getDirection() == 2 && enemyBullet.getLocation_x() < 600)
			enemyBullet.shootRight();

		

		else if(enemyBullet.getDirection() == 3 && enemyBullet.getLocation_y() > 0)
			enemyBullet.shootUp();

		

		else if(enemyBullet.getDirection() == 4 && enemyBullet.getLocation_y() < 600)
			enemyBullet.shootDown();

		else
			enemyBullet.shot_finished(0,0);
		
	}

	

	public void keyTyped(KeyEvent e) {
	}
	public void keyPressed(KeyEvent e) {
		
		if(!isPause)
		{
			switch(e.getKeyCode()) //wasd set a boolean true and change the horz hit box boolean
	
		    {
			    	case KeyEvent.VK_W:
					up = true;
					hit_box_horz = false;
					break;

				case KeyEvent.VK_S:
					down = true;
					hit_box_horz = false;
					break;
	
				case	 KeyEvent.VK_A:
					left = true;
					hit_box_horz = true;
					break;
	
				case KeyEvent.VK_D:
					right = true;
					hit_box_horz = true;
					break;
					
				//up down left and right decide which direction the bullet shoots	
				
				case KeyEvent.VK_UP:
	
					if(bullet.isShot())
						break;
	
					bullet.setLocation_x(player.getLocation_x()+5);
					bullet.setLocation_y(player.getLocation_y()+10);
					bullet.shootUp();
					break;
	
					
	
				case KeyEvent.VK_DOWN:
	
					if(bullet.isShot())
						break;
	
					bullet.setLocation_x(player.getLocation_x()+5);
					bullet.setLocation_y(player.getLocation_y()+10);
					bullet.shootDown();
					break;
	
				case KeyEvent.VK_LEFT:
					if(bullet.isShot())
						break;
	
					bullet.setLocation_x(player.getLocation_x()+5);
					bullet.setLocation_y(player.getLocation_y()+10);
					bullet.shootLeft();
					break;
	
				case KeyEvent.VK_RIGHT:
					if(bullet.isShot())
						break;
	
					bullet.setLocation_x(player.getLocation_x()+5);
					bullet.setLocation_y(player.getLocation_y()+10);
					bullet.shootRight();
					break;
					
				//1,2, and 3 change the tank	
				case KeyEvent.VK_1: //polymorphism
					if(changes > 3)
						break;
					int x = player.getLocation_x();
					int y = player.getLocation_y();
					player = new HeavyTank(x,y);
					player.setLives(4);
					repaint();
					changes++;
					break;
					
				case KeyEvent.VK_2: //polymorphism
					if(changes > 3)
						break;
					int x_light = player.getLocation_x();
					int y_light = player.getLocation_y();
					player = new SpeedTank(x_light,y_light);
					player.setLives(2);
					repaint();
					changes++;
					break;
					
				case KeyEvent.VK_3: //polymorphism
					if(changes > 3)
						break;
					int x_norm = player.getLocation_x();
					int y_norm = player.getLocation_y();
					player = new NormalTank(x_norm,y_norm);
					player.setLives(3);
					repaint();
					changes++;
					break;
	
				default:
					
		    }
		}

	}
	public void keyReleased(KeyEvent e) { //set booleans for wasd to false
		if(!isPause)
		{
			switch(e.getKeyCode())
			{
			case KeyEvent.VK_W:
				up = false;
				break;

			case KeyEvent.VK_S:
				down = false;
				break;

			case	 KeyEvent.VK_A:
				left = false;
				break;

			case KeyEvent.VK_D:
				right = false;
				break;
				
			default:
				
			}
		}	

	}
	public void move_and_fire() //decides how and when the enemy shoots and moves
	{
		//if its perfectly lined up in x or y coord then shots
		if(enemy.getLocation_x() <= player.getLocation_x() + 20  && enemy.getLocation_x() >= player.getLocation_x())
		{
			if(enemy.getLocation_y() > player.getLocation_y() && !enemyBullet.isShot())
			{
				enemyBullet.setLocation_x(enemy.getLocation_x()+5);
				enemyBullet.setLocation_y(enemy.getLocation_y()+10);
				enemyBullet.shootUp();
			}
			else if(!enemyBullet.isShot())
			{
				enemyBullet.setLocation_x(enemy.getLocation_x()+5);
				enemyBullet.setLocation_y(enemy.getLocation_y()+10);
				enemyBullet.shootDown();
			}	
		}
		//enemy will move closer in the coordinate it is further away from
		else if(enemy.getLocation_y()<= player.getLocation_y() + 40 && enemy.getLocation_y() >= player.getLocation_y())
		{
			if(enemy.getLocation_x() > player.getLocation_x() && !enemyBullet.isShot())
			{
				enemyBullet.setLocation_x(enemy.getLocation_x()+5);
				enemyBullet.setLocation_y(enemy.getLocation_y()+10);
				enemyBullet.shootLeft();
			}
			else if(!enemyBullet.isShot())
			{
				enemyBullet.setLocation_x(enemy.getLocation_x()+5);
				enemyBullet.setLocation_y(enemy.getLocation_y()+10);
				enemyBullet.shootRight();
			}
				
		}
		else if(Math.abs(enemy.getLocation_y() - player.getLocation_y()) < Math.abs(enemy.getLocation_x() - player.getLocation_x()) 
				&& (enemy.getLocation_x() > player.getLocation_x() + 20  || enemy.getLocation_x() < player.getLocation_x()))
		{
			if(enemy.getLocation_x() > player.getLocation_x())
				enemy.moveLeft();
			else
				enemy.moveRight();
		}
		else if (enemy.getLocation_y() > player.getLocation_y() + 40 || enemy.getLocation_y() < player.getLocation_y())
		{
			if(enemy.getLocation_y() > player.getLocation_y())
				enemy.moveUp();
			
			else
				enemy.moveDown();
		}
	}
	
	public void checkHit_me() //checks to see if enemy bullet hit the player
	{
		if(!hit_box_horz)
		{
			if((enemyBullet.getLocation_x() >= player.getLocation_x() && enemyBullet.getLocation_x() <= player.getLocation_x() + 20)
					&& (enemyBullet.getLocation_y() >= player.getLocation_y() && enemyBullet.getLocation_y() <= player.getLocation_y() + 40))
			{
				player.loseLives();
				player.setLocation_x(30);
				player.setLocation_y(555);
				if(player.Lives() <= 0)
					stopGame();
			}
			else
				return;
		}
		else
		{
			if((enemyBullet.getLocation_x() >= player.getLocation_x() && enemyBullet.getLocation_x() <= player.getLocation_x() + 40)
					&& (enemyBullet.getLocation_y() >= player.getLocation_y() && enemyBullet.getLocation_y() <= player.getLocation_y() + 20))
			{
				player.loseLives();
				player.setLocation_x(30);
				player.setLocation_y(555);
				if(player.Lives() <= 0)
					stopGame();
			}
			else
				return;
		}
	}
	public void checkHit_enemy() //checks if bullt hits the enemy
	{
		if(enemy.getDirec() == 3 || enemy.getDirec() == 4 )
		{
			if((bullet.getLocation_x() >= enemy.getLocation_x() && bullet.getLocation_x() <= enemy.getLocation_x() + 40)
					&& (bullet.getLocation_y() >= enemy.getLocation_y() && bullet.getLocation_y() <= enemy.getLocation_y() + 20))
			{
				enemy.setLocation_x((int)(Math.random()*580));
				enemy.setLocation_y((int)(Math.random()*500));
				points++;
				changes = 0;
				System.out.println("hit");
			}
			else
				return;
		}
		else
		{
			if((bullet.getLocation_x() >= enemy.getLocation_x() && bullet.getLocation_x() <= enemy.getLocation_x() + 40)
					&& (bullet.getLocation_y() >= enemy.getLocation_y() && bullet.getLocation_y() <= enemy.getLocation_y() + 20))
			{
				enemy.setLocation_x((int)(Math.random()*580));
				enemy.setLocation_y((int)(Math.random()*500));
				points++;
				changes = 0;
				System.out.println("hit");
			}
			else
				return;
		}
	}
	public void restart() //resets all positions
	{
		enemy.setLocation_x(60);
		enemy.setLocation_y(30);
		
		player.setLocation_x(30);
		player.setLocation_y(555);
		
		enemyBullet.shot_finished(0, 0);
		
		bullet.setLocation_x(0);
		bullet.setLocation_y(590);
		bullet.shot_finished();
		
	}
	public void move() //moves based on what boolean value is true
	{
		if(down)
			player.moveDown();
		if(up)
			player.moveUp();
		if(left)
			player.moveLeft();
		if(right)
			player.moveRight();
	}
	public void check() //checks if the values are within bounds
	{
		if(player.getLocation_y() <= 0)
		{
			player.setLocation_y(1);
		}
		if(player.getLocation_y() >= 560)
		{
			player.setLocation_y(559);
		}
		if(player.getLocation_x() <= 0)
		{
			player.setLocation_x(1);
		}
		if(player.getLocation_x() >= 560)
			player.setLocation_x(559);
	}
}