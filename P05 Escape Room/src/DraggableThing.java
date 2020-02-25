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

public class DraggableThing extends VisibleThing {

	private boolean mouseWasPressed; // similar to use in ClickableThing
	private boolean isDragging; // true when this object is being dragged by the user
	private int oldMouseX; // horizontal position of mouse during last update
	private int oldMouseY; // vertical position of mouse during last update

	/**
	 * constructor for type draggable thing
	 * 
	 * @param name, x, y
	 */
	public DraggableThing(String name, int x, int y) {
		// calls parent constructor
		super(name, x, y);
		// sets fields
		isDragging = false;
		mouseWasPressed = false;
		oldMouseX = x;
		oldMouseY = y;

	} // initialize new thing

	/**
	 * updates the image being processed
	 * 
	 * @return type action
	 */
	@Override
	public Action update() {
		// calls the parent update
		Action act = super.update();
		// gets processing
		PApplet process = getProcessing();
		// checks if mouse was previously pressed, checks if the mouse is currently
		// pressed, checks is the mouse is on the object
		if (mouseWasPressed == false && process.mousePressed
				&& isOver(process.mouseX, process.mouseY) == true) {
			// resets fields
			mouseWasPressed = true;
			isDragging = true;
		}
		// checks if ifDragging is true
		else if (isDragging == true) {
			// initializes location fields
			int mouseLocX = process.mouseX;
			int mouseLocY = process.mouseY;
			int dx = process.mouseX - oldMouseX;
			int dy = process.mouseY - oldMouseY;
			// calls for the object to be moved with the mouse
			move(dx, dy);
			// checks if the item is still being dragged
			isDragging = process.mousePressed;
			
			// re-initializes field
			oldMouseX = mouseLocX;
			oldMouseY = mouseLocY;
		}
		// checks if mouse was not pressed
		else if (!process.mousePressed) {
			// re-initializes fields
			mouseWasPressed = false;
			isDragging = false;
			// calls drop
			return drop();
		}

		return null;

	} // calls VisibleThing update(), then moves according to mouse drag
// each time isDragging changes from true to false, the drop() method below will be called once
// and any action objects returned from that method should then be returned from update()

	/**
	 * drop method that gets overridden
	 * 
	 */
	protected Action drop() {
		return null;
	} // this method returns null
// subclass types will override this drop() method to do more interesting things
}
