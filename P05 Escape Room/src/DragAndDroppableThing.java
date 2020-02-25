
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

public class DragAndDroppableThing extends DraggableThing {
	private VisibleThing target; // object over which this object can be dropped
	private Action action; // action that results from dropping this object over target

	/**
	 * constructor for a drag and droppable item
	 * 
	 * @param name, x, y, target image, action to be performed
	 */
	public DragAndDroppableThing(String name, int x, int y, VisibleThing target, Action action) {
		// calls the parent constructor
		super(name, x, y);
		// initializes variables
		this.target = target;
		this.action = action;

	} // initialize new object

	/**
	 * calls for an image to be dropped
	 * 
	 * @return an action to be performed
	 */
	@Override
	protected Action drop() {
		// gets processing
		PApplet process = getProcessing();
		// checks if the target is the object is inside of the target
		if (target.isActive() && this.isOver(target)) {
			// deactivates both objects
			target.deactivate();
			this.deactivate();
			// return the action
			return action;
		}
		return null;
	} // returns action and deactivates objects in response to successful drop
		// When this object is over its target and its target is active:
		// deactivate both this object and the target object, and return action,
		// otherwise return null
}
