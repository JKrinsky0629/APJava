package TypingGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TypeGameInterface
{
	//declare all the global variables
	static String word;
	static JFrame frame = new JFrame();
	static JLabel label_word= new JLabel();
	static Player a = new Player("Jose");
	static Problems problem = new Problems();
	static JTextField input = new JTextField("type prompted word");
	static JPanel panel = new JPanel();
	static Timer time = new Timer();
	static JLabel playerPoints = new JLabel();
	static int cnt = 0;
	static JLabel reason = new JLabel();
	static JLabel time_left = new JLabel();
	static Timer timer_left = new Timer();
	static int time_start = 15000;
	public static void main(String args[])
	{
		try {
			problem.place();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//intialize all panels, frames, textBoxes, and labels
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(panel);

		label_word.setText(word = problem.return_word_random());
		label_word.setFont(new Font("Serif", Font.PLAIN, 150));
		panel.setBackground(Color.GRAY);

		panel.add(BorderLayout.CENTER,input);
		input.setFont(new Font("Serif", Font.PLAIN, 125));
		input.setHorizontalAlignment(JTextField.CENTER);
		input.setPreferredSize(new Dimension(1200,150));
		input.setEditable(true);
		playerPoints.setHorizontalAlignment(JLabel.CENTER);
		playerPoints.setFont(new Font("Serif", Font.PLAIN, 100));
		reason.setHorizontalAlignment(JLabel.CENTER);
		reason.setFont(new Font("Serif", Font.PLAIN, 75));
		reason.setPreferredSize(new Dimension(1200,150));
		time_left.setHorizontalAlignment(JLabel.CENTER);
		time_left.setFont(new Font("Serif", Font.PLAIN, 100));
		time_left.setPreferredSize(new Dimension(1000,150));
		/*input.addKeyListener(new KeyAdapter()
		{
			public void enterPressed(KeyEvent e)
			{
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					if(!(word.equals(input.getText())))
					{
						a.loseLife();
						System.out.println("Wrong");
					}
					label_word.setText(word = problem.return_word_random());
					frame.repaint();
				}
			}
		});*/
		//adds all pieces to the panel then the panel to the frame
		label_word.setVisible(true);
		panel.add(label_word);
		panel.add(input);
		panel.add(playerPoints);
		panel.add(reason);
		panel.add(time_left);
		frame.setVisible(true);
		frame.setBounds(0, 0, 1280, 800);
		frame.setTitle("Welcome to Typing Game");
		//implements the keylistener
		input.addKeyListener(keyListener);
		

	}
	static KeyListener keyListener = new KeyListener() {
		public void keyTyped(KeyEvent e) {
			
		}
		public void keyPressed(KeyEvent e) {
			reason.setText("");
			TimerTask task = new TimerTask() { //subtracts life and changes frame
				public void run() {
					a.loseLife();
					panel.setBackground(Color.PINK);
					reason.setText("out of time -1 life " + a.getLife()+" lives left");
					if(a.getLife() <= 0)
					{
						JOptionPane.showMessageDialog(frame,
							    "You have lost all three lives you got "+a.getPoints()+" points");
						System.exit(0);
					}
				}
			};
			TimerTask timer_task = new TimerTask() { //subtract time and updates frame
				public void run() {
					time_start = time_start - 100;
					if(time_start >=0)
						time_left.setText(time_start/100+"");
					else
						time_left.setText("0");
					frame.repaint();
				}
			};
			if(e.getKeyCode() == KeyEvent.VK_ENTER) //if the key enter is pressed
			{
				if(!(word.equals(input.getText()))) //and word doesn't equal want person texted
				{
					a.loseLife(); 
					panel.setBackground(Color.RED);
					Toolkit.getDefaultToolkit().beep();
					reason.setText("Wrong word -1 life " + a.getLife()+" lives left");
					
				}
				else if(word.equals(input.getText()))
				{
					panel.setBackground(Color.GREEN);
					//cancels timers and then schedueles them to be run at every interval
					time.cancel();
					time = new Timer();
					cnt+=100;
					time.schedule(task, 15000 - cnt);
					timer_left.cancel();
					timer_left = new Timer();
					time_start = 15100-cnt;
					timer_left.scheduleAtFixedRate(timer_task, 0, 100);
					a.gainPoint();
				}
				label_word.setText(word = problem.return_word_random());
				input.setText("");
				frame.repaint();
				//displays loss screen
				if(a.getLife() <= 0)
				{
					JOptionPane.showMessageDialog(frame,
						    "You have lost all three lives you got "+a.getPoints()+" points");
					System.exit(0);
				}
				playerPoints.setText("Points: "+a.getPoints()); //updates points on the screen
			}
		}
		
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
		}
	};	
}