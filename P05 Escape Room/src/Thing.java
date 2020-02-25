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
import java.io.File;
import processing.core.PImage;
import processing.core.PApplet;

public class Thing {
	private final String NAME; // the constant name identifying this object
	private boolean isActive; // active means thing is visible and can be interacted with
	private static PApplet processing; // sets the processing field

	/**
	 * Constructor that sets the name for type thing
	 * 
	 * @param name is the name of the object
	 */
	public Thing(String name) {
		this.NAME = name;
		isActive = true;
	} // initialize name, and set isActive to true

	/**
	 * checks if the name is the same as the name passed in
	 * 
	 * @param name is the name of the object that is being found
	 * @return a boolean if the two strings are equal
	 */
	public boolean hasName(String name) {
		if (this.NAME.equals(name)) {
			return true;
		}
		return false;
	} // returns true only when contents of name equal NAME

	/**
	 * checks if the thing is active
	 * 
	 * @return a boolean that returns true if isActive is true
	 */
	public boolean isActive() {
		if (this.isActive == true) {
			return true;
		}
		return false;
	} // returns true only when isActive is true

	/**
	 * changes the isActive field to true
	 * 
	 * @return none
	 */
	public void activate() {
		isActive = true;
	} // changes isActive to true

	/**
	 * changes isActive field to false
	 * 
	 * @return none
	 */
	public void deactivate() {
		isActive = false;
	} // changes isActive to false

	/**
	 * Overriden class
	 * 
	 * @return an Action
	 */
	public Action update() {
		return null;
	} // this method returns null
	// subclass types will override this update() method to do more interesting
	// things

	/**
	 * sets the processing field
	 * 
	 * @param processing variable from PApplet
	 * @return none
	 */
	public static void setProcessing(PApplet processing) {
		Thing.processing = processing;
	} // initializes processing field

	/**
	 * Gets the value from the processing field
	 *
	 * @return the processing variable
	 */
	protected static PApplet getProcessing() {
		return processing;
	} // accessor method to retrieve this static field

}
