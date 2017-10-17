import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

//Name: Mason Salisbury
//StudentID: 1209176029
//Lecture: MWF 9:00-9:50
//Description: This creates a main menu inside of the JFrame extended by this class, manages the two game modes, and declares the complete list of State objects

public class GeographyGame extends JFrame {

	private JPanel contentPane;
	private Mode1 gameMode1;
	private Mode2 gameMode2;
	private JLabel mainMenuTitle;
	private JButton mode1, mode2, quit;
	private ArrayList<State> states;
	private Toolkit fetchImage;

	public static void main(String[] args) {
		
		GeographyGame frame = new GeographyGame();
		frame.setVisible(true);
		
	}

	public GeographyGame() {
		
		states = new ArrayList<State>();
		
		//Manual declaration of all 50 state objects
		/*
		 * All state images derived from "Blank US Map.svg" hosted at: https://commons.wikimedia.org/wiki/File:Blank_US_Map.svg
		 * Original map created by wikimedia user Theshibboleth
		 * Revisions by wikimedia users Fibonacci, AMK1211, Howcheng, NuclearVacuum, Wylve, Kencordero, and Michael Jester
		 * This map is covered by Creative Commons Attribution-Share Alike 3.0 Unported license (https://creativecommons.org/licenses/by-sa/3.0/deed.en)
		 * Permission is granted to copy, distribute and/or modify this document under the terms of the GNU Free Documentation License, Version 1.2 or any later version published by the Free Software Foundation; with no Invariant Sections, no Front-Cover Texts, and no Back-Cover Texts. A copy of the license is included in the section entitled GNU Free Documentation License.
		 * I edited the original image by separating it into 50 pictures of individual states which I also colored blue. In some cases states and line borders were erased.
		 * The 50 images I created from the original are covered by the same licenses as the original image
		 */
		
		fetchImage = Toolkit.getDefaultToolkit();
		
		states.add(new State("Alabama", fetchImage.getImage(getClass().getResource("Alabama.png"))));
		states.add(new State("Alaska", fetchImage.getImage(getClass().getResource("Alaska.png"))));
		states.add(new State("Arizona", fetchImage.getImage(getClass().getResource("Arizona.png"))));
		states.add(new State("Arkansas", fetchImage.getImage(getClass().getResource("Arkansas.png"))));
		states.add(new State("California", fetchImage.getImage(getClass().getResource("California.png"))));
		states.add(new State("Colorado", fetchImage.getImage(getClass().getResource("Colorado.png"))));
		states.add(new State("Connecticut", fetchImage.getImage(getClass().getResource("Connecticut.png"))));
		states.add(new State("Delaware", fetchImage.getImage(getClass().getResource("Delaware.png"))));
		states.add(new State("Florida", fetchImage.getImage(getClass().getResource("Florida.png"))));
		states.add(new State("Georgia", fetchImage.getImage(getClass().getResource("Georgia.png"))));
		states.add(new State("Hawaii", fetchImage.getImage(getClass().getResource("Hawaii.png"))));
		states.add(new State("Idaho", fetchImage.getImage(getClass().getResource("Idaho.png"))));
		states.add(new State("Illinois", fetchImage.getImage(getClass().getResource("Illinois.png"))));
		states.add(new State("Indiana", fetchImage.getImage(getClass().getResource("Indiana.png"))));
		states.add(new State("Iowa", fetchImage.getImage(getClass().getResource("Iowa.png"))));
		states.add(new State("Kansas", fetchImage.getImage(getClass().getResource("Kansas.png"))));
		states.add(new State("Kentucky", fetchImage.getImage(getClass().getResource("Kentucky.png"))));
		states.add(new State("Louisiana", fetchImage.getImage(getClass().getResource("Louisiana.png"))));
		states.add(new State("Maine", fetchImage.getImage(getClass().getResource("Maine.png"))));
		states.add(new State("Maryland", fetchImage.getImage(getClass().getResource("Maryland.png"))));
		states.add(new State("Massachusetts", fetchImage.getImage(getClass().getResource("Massachusetts.png"))));
		states.add(new State("Michigan", fetchImage.getImage(getClass().getResource("Michigan.png"))));
		states.add(new State("Minnesota", fetchImage.getImage(getClass().getResource("Minnesota.png"))));
		states.add(new State("Mississippi", fetchImage.getImage(getClass().getResource("Mississippi.png"))));
		states.add(new State("Missouri", fetchImage.getImage(getClass().getResource("Missouri.png"))));
		states.add(new State("Montana", fetchImage.getImage(getClass().getResource("Montana.png"))));
		states.add(new State("Nebraska", fetchImage.getImage(getClass().getResource("Nebraska.png"))));
		states.add(new State("Nevada", fetchImage.getImage(getClass().getResource("Nevada.png"))));
		states.add(new State("New Hampshire", fetchImage.getImage(getClass().getResource("New Hampshire.png"))));
		states.add(new State("New Jersey", fetchImage.getImage(getClass().getResource("New Jersey.png"))));
		states.add(new State("New Mexico", fetchImage.getImage(getClass().getResource("New Mexico.png"))));
		states.add(new State("New York", fetchImage.getImage(getClass().getResource("New York.png"))));
		states.add(new State("North Carolina", fetchImage.getImage(getClass().getResource("North Carolina.png"))));
		states.add(new State("North Dakota", fetchImage.getImage(getClass().getResource("North Dakota.png"))));
		states.add(new State("Ohio", fetchImage.getImage(getClass().getResource("Ohio.png"))));
		states.add(new State("Oklahoma", fetchImage.getImage(getClass().getResource("Oklahoma.png"))));
		states.add(new State("Oregon", fetchImage.getImage(getClass().getResource("Oregon.png"))));
		states.add(new State("Pennsylvania", fetchImage.getImage(getClass().getResource("Pennsylvania.png"))));
		states.add(new State("Rhode Island", fetchImage.getImage(getClass().getResource("Rhode Island.png"))));
		states.add(new State("South Carolina", fetchImage.getImage(getClass().getResource("South Carolina.png"))));
		states.add(new State("South Dakota", fetchImage.getImage(getClass().getResource("South Dakota.png"))));
		states.add(new State("Tennessee", fetchImage.getImage(getClass().getResource("Tennessee.png"))));
		states.add(new State("Texas", fetchImage.getImage(getClass().getResource("Texas.png"))));
		states.add(new State("Utah", fetchImage.getImage(getClass().getResource("Utah.png"))));
		states.add(new State("Vermont", fetchImage.getImage(getClass().getResource("Vermont.png"))));
		states.add(new State("Virginia", fetchImage.getImage(getClass().getResource("Virginia.png"))));
		states.add(new State("Washington", fetchImage.getImage(getClass().getResource("Washington.png"))));
		states.add(new State("West Virginia", fetchImage.getImage(getClass().getResource("West Virginia.png"))));
		states.add(new State("Wisconsin", fetchImage.getImage(getClass().getResource("Wisconsin.png"))));
		states.add(new State("Wyoming", fetchImage.getImage(getClass().getResource("Wyoming.png"))));
		
		//creating the game modes and the content pane
		gameMode1 = new Mode1(states);
		gameMode2 = new Mode2(states);
		contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		//Setting up the JFrame
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		setTitle("Geography Challenge!");
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		//creating the main menu UI
		mainMenuTitle = new JLabel("Geography Challenge!");
		mainMenuTitle.setBounds(150, 55, 300, 45);
		mainMenuTitle.setFont(new Font("Arial Black", 1, 20));
		mainMenuTitle.setHorizontalAlignment(0);
		contentPane.add(mainMenuTitle);
		
		mode1 = new JButton("States by Name");
		mode1.addActionListener(new ButtonListener());
		mode1.setBounds(235, 135, 130, 45);
		contentPane.add(mode1);
		
		mode2 = new JButton("States by Shape");
		mode2.addActionListener(new ButtonListener());
		mode2.setBounds(235, 205, 130, 45);
		contentPane.add(mode2);
		
		quit = new JButton("Quit");
		quit.addActionListener(new ButtonListener());
		quit.setBounds(235, 275, 130, 45);
		contentPane.add(quit);
		
	}
	
	private class ButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent event) {
			
			if (event.getSource() == mode1) //click on states by name
				gameMode1.create();
			
			else if (event.getSource() == mode2) //click on states by shape
				gameMode2.create();
			
			else { //click on quit button
				
				if (JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?") == 0)
					System.exit(0);
				
			}
			
		}	
		
	}
}