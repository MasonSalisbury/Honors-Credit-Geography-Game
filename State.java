import java.awt.Image;

//Name: Mason Salisbury
//StudentID: 1209176029
//Lecture: MWF 9:00-9:50
//Description: This manages the information for all 50 states. It holds the state name and two images of the state

public class State {

	private String name;
	private Image fullSize, smallSize;

	public State (String name, Image state){ //Receives the state's name and a 250x250 image of it

		this.name = name;
		fullSize = state; //the fullSize image is what is used in the "States by Name" game mode
		smallSize = fullSize.getScaledInstance(75, 75, 1); //this scales the fullSize image down to 75x75 and is used as a multiple choice option in the "States by Shape" game mode

	}

	public String getName() {

		return name;

	}

	public Image getFullSize() {

		return fullSize;

	}

	public Image getSmallSize() {

		return smallSize;

	}

}