package pingpong;

import javax.swing.*;

public class Ping  {
	

	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		Pong pong = new Pong();
		
		frame.setTitle("Ping Pong Game");
		frame.setResizable(false);
		frame.add(pong);
		frame.setSize(600,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(400, 80);
		frame.setVisible(true);
		
	}
}
