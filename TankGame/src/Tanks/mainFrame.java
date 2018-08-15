package Tanks;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class mainFrame {
	public static void main(String args[])
	{
		JFrame arcade = new JFrame();
	      arcade.setTitle("AP Java Game Room");
	      arcade.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  
	      JPanel panel = new GamePanel(600, 600);
	      
	      Container pane = arcade.getContentPane();
	      pane.setLayout(new GridLayout(1, 1));
	      pane.add(panel);

	      arcade.pack();
	      arcade.setVisible(true);
	}

}
