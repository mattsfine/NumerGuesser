import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Window {
	static JLabel guess = new JLabel("");
	static JButton yes = new JButton("Yes");
	static JButton no = new JButton("No");
	static JLabel question = new JLabel("Is the number on the list? (1-100)", SwingConstants.CENTER);
	public Window() {
		JFrame frame = new JFrame("Think of a number 1-100...");
		frame.setSize(700,500);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		question.setFont(new Font("Serif", Font.PLAIN, 35));
		question.setBounds(50, 50, 600, 50);
		frame.add(question);

		guess.setFont(new Font("Serif", Font.PLAIN, 30));
		frame.add(guess);
		guess.setBounds(200,75,400,250);
		frame.setVisible(true);
		
		
		yes.setBounds(400,350, 100, 50);
		frame.add(yes);
		
		
		no.setBounds(150,350, 100, 50);
		frame.add(no);
		
		yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NumberGuesser.addGuesses();
				NumberGuesser.guessWindow();
			}});
		no.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NumberGuesser.removeGuesses();
				NumberGuesser.guessWindow();
			}});
	}
	
	public static void setGuess(String guessi) {
		guess.setText(guessi);
	}
}
	
	
	
	

