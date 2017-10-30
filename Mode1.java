import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

//Name: Mason Salisbury
//Description: This is a free response game mode where the picture of a random state is shown to the user and they have three attempts to enter the correct name into the text field

public class Mode1 extends JFrame{

	private JButton closeButton, submit;
	private JLabel title, message, statePicture;
	private JTextField input;
	private JPanel contentPane;
	private ImageIcon stateImage;
	private Font boldFont;
	private ArrayList<State> notUsed, used;
	private State current;
	private Random ran;
	private int numIncorrect = 0;
	
	public Mode1(ArrayList<State> states){

		notUsed = new ArrayList<State>();
		notUsed.addAll(states);
		
		used = new ArrayList<State>();
		
		ran = new Random();
		
		chooseNext(); //chooses the first state
		
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
		submit = new JButton("Enter");
		submit.setBounds(435, 345, 80, 30);
		submit.addActionListener(new ButtonListener());
		contentPane.add(submit);

		closeButton = new JButton("Main Menu");
		closeButton.addActionListener(new ButtonListener());
		closeButton.setBounds(5, 5, 100, 40);
		contentPane.add(closeButton);
		
		stateImage = new ImageIcon(current.getFullSize());
		statePicture = new JLabel(stateImage);
		statePicture.setBounds(175, 75, 250, 250);
		statePicture.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		contentPane.add(statePicture);
		
		title = new JLabel("Enter the state's name");
		boldFont = new Font(title.getFont().getFontName(), Font.BOLD, 20);
		title.setBounds(175, 50, 250, 25);
		title.setFont(boldFont);
		title.setHorizontalAlignment(0);
		contentPane.add(title);
		
		message = new JLabel(" ");
		boldFont = new Font(message.getFont().getFontName(), Font.BOLD, 14);
		message.setBounds(50, 345, 110, 30);
		message.setFont(boldFont);
		message.setHorizontalAlignment(message.RIGHT);
		contentPane.add(message);
		
		input = new JTextField();
		input.setBounds(175, 345, 250, 30);
		input.setBorder(BorderFactory.createLineBorder(Color.lightGray, 2));
		input.addActionListener(new ButtonListener());
		contentPane.add(input);
		
	}
	
	public void create(){
		
		setVisible(true); //makes the window visible
		
	}
	
	public void close(){ //resets the game mode and closes the window
		
		notUsed.addAll(used);
		used.clear();
		chooseNext();
		message.setText("");
		input.setText("");
		update();
		dispose();
		
	}
	
	public void chooseNext(){ //chooses a random new state that hasn't been used before
		
		if (notUsed.isEmpty()){ //if every state has been used
			
			if (JOptionPane.showConfirmDialog(null, "You have been through all of the states, would you like to go through them again?") == 0){ //resets the game mode if "yes" is chosen
				
				notUsed.addAll(used);
				used.clear();
				
			}
			
			else {
				
				close();
				return;
				
			}
			
		}
		
		current = notUsed.get(ran.nextInt(notUsed.size()));
		used.add(current);
		notUsed.remove(current);
		
	}
	
	public void update(){ //makes the UI use the image of the current state and updates the screen
		
		stateImage.setImage(current.getFullSize());
		statePicture.setIcon(stateImage);
		repaint();
		
	}
	
	private class ButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent event) {
			
			if (event.getSource() == closeButton) //if the "main menu" button is pressed it closes the game mode's window
				close();
			
			else {
				
				if (input.getText().trim().toLowerCase().equals(current.getName().toLowerCase())){ //if the correct name is entered (not case sensitive)
					
					message.setForeground(Color.green.darker());
					message.setText("Correct!");
					input.setText("");
					chooseNext();
					update();
					numIncorrect = 0;
					
				}
				
				else { //if the wrong name is entered
					
					message.setForeground(Color.red.darker());
					message.setText("Incorrect!");
					input.setText("");
					numIncorrect++;
					
					if (numIncorrect == 3){ //if the wrong name has been entered three times in a row it tells the user the right answer and moves to the next state
						
						message.setText(current.getName());
						chooseNext();
						update();
						numIncorrect = 0;
						
					}
					
					
				}
				
			}
			
		}
		
	}
	
}
