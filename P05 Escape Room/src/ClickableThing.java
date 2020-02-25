//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Escape Room
// Files:           (a list of all source files used by that program)
// Course:          Comp Sci 300, Spring 2019
//
// Author:          Lenea Guse
// Email:           laguse@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    (name of your pair programming partner)
// Partner Email:   (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates, 
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:         N/A
// Online Sources:  N/A
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
import processing.core.PApplet;

public class ClickableThing extends VisibleThing {

	private Action action; // action returned from update when this object is clicked
	private boolean mouseWasPressed; // tracks whether the mouse was pressed during the last update()

	/**
	 * Constructor to initialize a clickable thing
	 * 
	 * @param name, x, y, and the action
	 */
	public ClickableThing(String name, int x, int y, Action action) {
		// calls the parent constructor
		super(name, x, y);
		mouseWasPressed = false;
		this.action = action;
	} // initializes this new object

	/**
	 * updates the image being processed
	 * 
	 * @return an action
	 */
	@Override
	public Action update() {
		// calls the parent update
		Action act = super.update();
		// gets processing
		PApplet process = getProcessing();
		// checks if the mouse was previously not pressed, is currently pressed,
		// and the mouse is over the object
		if (mouseWasPressed == false && process.mousePressed
				&& isOver(process.mouseX, process.mouseY) == true) {
			// sets the mouse was pressed to if the mouse is currently pressed
			mouseWasPressed = process.mousePressed;
			return action;
		}
		// sets the mouse was pressed to if the mouse if currently pressed
		mouseWasPressed = process.mousePressed;
		return null;
	} // calls VisibleThing update, then returns action only when mouse is first
		// clicked

}
