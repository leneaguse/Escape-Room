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
import java.util.ArrayList;

public class Action {
	private String message; // message printed by this action (or null to do nothing)
	private Thing thing;

	/**
	 * constructor that takes in the parameter thing
	 * 
	 * @param thing
	 */
	public Action(Thing thing) {
		this.thing = thing;
	}

	/**
	 * constructor that takes parameters message, and thing
	 * 
	 * @param String message, thing
	 */
	public Action(String message, Thing thing) {
		this.message = message;
		this.thing = thing;
	}

	/**
	 * constructor that takes message as its parameter
	 * 
	 * @param String message
	 */
	public Action(String message) {
		this.message = message;
	} // initialize this new action

	/**
	 * preforms the action passed in
	 * 
	 * @param ArrayList of type thing
	 */
	public void act(ArrayList<Thing> ArrThing) {
		// checks if thing is null
		if (thing != null) {
			// activates thing
			thing.activate();
			// adds thing to the arraylist
			ArrThing.add(thing);
			// sets thing to null
			thing = null;
		}
		// checks if message is null
		if (message != null) {
			// prints out message
			System.out.println(message);
		}
	} // when message is not null, message is printed to System.out
}
