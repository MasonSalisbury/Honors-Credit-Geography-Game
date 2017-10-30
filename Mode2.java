import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

//Name: Mason Salisbury
//Description: This is a multiple choice game mode that gives the user a random state name and they have to choose the correct state from four random state images

public class Mode2 extends JFrame{

	private JButton closeButton, submit;
	private JRadioButton optionA, optionB, optionC, optionD;
	private ButtonGroup options;
	private JLabel title, message, statePicture1, statePicture2, statePicture3, statePicture4, stateName;
	private JPanel contentPane;
	private ImageIcon stateImage1, stateImage2, stateImage3, stateImage4;
	private Font boldFont;
	private ArrayList<State> fullList, notUsed, mcOptions;
	private State current;
	Random ran;
	
	public Mode2(ArrayList<State> states){
		
		ran = new Random();
		
		fullList = new ArrayList<State>();
		notUsed = new ArrayList<State>();
		mcOptions = new ArrayList<State>();
		
		fullList.addAll(states);
		notUsed.addAll(states);
		
		stateImage1 = new ImageIcon();
		stateImage2 = new ImageIcon();
		stateImage3 = new ImageIcon();
		stateImage4 = new ImageIcon();
		
		contentPane = new JPanel();
		
		//setting up the window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		setVisible(false);
		setResizable(false);
		setContentPane(contentPane);
		setLayout(null);
		setLocationRelativeTo(null);
		setTitle("Geography Challenge!");

		//setting up UI elements and adding them to the window
		closeButton = new JButton("Main Menu");
		closeButton.addActionListener(new ButtonListener());
		closeButton.setBounds(5, 5, 100, 40);
		contentPane.add(closeButton);
		
		submit = new JButton("Submit");
		submit.addActionListener(new ButtonListener());
		submit.setBounds(260, 410, 80, 40);
		contentPane.add(submit);
		
		statePicture1 = new JLabel(stateImage1);
		statePicture1.setBounds(100, 275, 75, 75);
		statePicture1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		contentPane.add(statePicture1);
		
		statePicture2 = new JLabel(stateImage2);
		statePicture2.setBounds(208, 275, 75, 75);
		statePicture2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		contentPane.add(statePicture2);
		
		statePicture3 = new JLabel(stateImage3);
		statePicture3.setBounds(316, 275, 75, 75);
		statePicture3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		contentPane.add(statePicture3);
		
		statePicture4 = new JLabel(stateImage4);
		statePicture4.setBounds(425, 275, 75, 75);
		statePicture4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		contentPane.add(statePicture4);
		
		title = new JLabel("Choose the correct state");
		boldFont = new Font(title.getFont().getFontName(), Font.BOLD, 20);
		title.setBounds(175, 25, 250, 25);
		title.setFont(boldFont);
		title.setHorizontalAlignment(0);
		contentPane.add(title);
		
		stateName = new JLabel();
		boldFont = new Font(stateName.getFont().getFontName(), Font.BOLD, 26);
		stateName.setBounds(150, 150, 300, 35);
		stateName.setFont(boldFont);
		stateName.setHorizontalAlignment(0);
		contentPane.add(stateName);
		
		message = new JLabel(" ");
		boldFont = new Font(message.getFont().getFontName(), Font.BOLD, 14);
		message.setBounds(255, 225, 90, 30);
		message.setFont(boldFont);
		message.setHorizontalAlignment(0);
		contentPane.add(message);
		
		optionA = new JRadioButton("A.");
		optionA.setBounds(120, 350, 50, 50);
		contentPane.add(optionA);
		
		optionB = new JRadioButton("B.");
		optionB.setBounds(228, 350, 50, 50);
		contentPane.add(optionB);
		
		optionC = new JRadioButton("C.");
		optionC.setBounds(336, 350, 50, 50);
		contentPane.add(optionC);
		
		optionD = new JRadioButton("D.");
		optionD.setBounds(445, 350, 50, 50);
		contentPane.add(optionD);
		
		//adding the radio buttons to a ButtonGroup
		options = new ButtonGroup();
		options.add(optionA);
		options.add(optionB);
		options.add(optionC);
		options.add(optionD);
		
		//chooses the first state and multiple choice options
		update();
		
	}
	
	public void create(){
		
		setVisible(true); //makes the window visible
		
	}
	
	public void close(){ //resets the game mode and closes the window
		
		notUsed.clear();
		notUsed.addAll(fullList);
		update();
		message.setText("");
		dispose();
		
	}
	
	public void update(){
		
		if (notUsed.isEmpty()){ //if every state has been used
			
			if (JOptionPane.showConfirmDialog(null, "You have been through all of the states, would you like to go through them again?") == 0){ //if "yes" is chosen it resets the game mode
				
				notUsed.addAll(fullList);
				
			}
			
			else {
				
				close();
				return;
				
			}
			
		}
		
		//chooses a new state and adds the correct state to the multiple choice options
		current = notUsed.get(ran.nextInt(notUsed.size()));
		notUsed.remove(current);
		stateName.setText(current.getName());
		mcOptions.clear();
		mcOptions.add(current); 
		
		int ranIndex;
		
		for (int index = 0; index < 3; index++){ //adds three random states to the multiple choice options as long as they are not already options
			
			ranIndex = ran.nextInt(fullList.size());
			
			while (mcOptions.contains(fullList.get(ranIndex)))
				ranIndex = ran.nextInt(fullList.size());
			
			mcOptions.add(fullList.get(ranIndex));
			
		}
		
		shuffle();
		
		//updates all of the images on the screen
		stateImage1.setImage(mcOptions.get(0).getSmallSize());
		stateImage2.setImage(mcOptions.get(1).getSmallSize());
		stateImage3.setImage(mcOptions.get(2).getSmallSize());
		stateImage4.setImage(mcOptions.get(3).getSmallSize());
		
		statePicture1.setIcon(stateImage1);
		statePicture2.setIcon(stateImage2);
		statePicture3.setIcon(stateImage3);
		statePicture4.setIcon(stateImage4);
		
		//the program uses ActionCommands to figure out if the correct state has been chosen
		optionA.setActionCommand(mcOptions.get(0).getName());
		optionB.setActionCommand(mcOptions.get(1).getName());
		optionC.setActionCommand(mcOptions.get(2).getName());
		optionD.setActionCommand(mcOptions.get(3).getName());
		
		repaint(); //updates the screen graphics
		
	}
	
	public void shuffle(){ //makes the multiple choice options be in a random order
		
		State temp;
		int ranIndex;
		
		for (int index = 0; index < mcOptions.size(); index++){
			
			temp = mcOptions.get(index);
			ranIndex = ran.nextInt(4);
			mcOptions.set(index, mcOptions.get(ranIndex));
			mcOptions.set(ranIndex, temp);
			
		}
		
	}
	
	private class ButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent event) {
			
			if (event.getSource() == closeButton) //if the "main menu" button is pressed it closes the window
				close();
			
			else {
				
				if (options.getSelection().getActionCommand().equals(current.getName())){ //if the correct state is chosen
					
					message.setForeground(Color.green.darker());
					message.setText("Correct!");
					options.clearSelection();
					update();
					
				}
				
				else { //if the wrong state is chosen
					
					message.setForeground(Color.red);
					message.setText("Incorrect");
					
				}
				
			}
			
		}
		
	}
	
}
