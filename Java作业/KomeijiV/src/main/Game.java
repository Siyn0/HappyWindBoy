package main;


import javax.swing.JFrame;
import javax.swing.JTextField;

public class Game {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setBounds(0,0,640,800);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		GamePanel panel = new GamePanel();
		
		frame.add(panel);


		
		frame.setVisible(true);
		
	}
	
}