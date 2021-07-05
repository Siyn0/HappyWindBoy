package main;


import javax.swing.JFrame;

public class Game {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setBounds(0,0,1920,1080);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		GamePanel panel = new GamePanel();
		frame.add(panel);

		
		frame.setVisible(true);
		
	}
	
}