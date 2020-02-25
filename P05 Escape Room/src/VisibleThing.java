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
import processing.core.PApplet;
import processing.core.PImage;

public class VisibleThing extends Thing {
	private PImage image; // the graphical representation of this thing
	private int x; // the horizontal position (in pixels of this thing's left side)
	private int y; // the vertical position (in pixels of this thing's top side)

	/**
	 * constructor that initializes fields
	 * 
	 * @param name, x, y
	 */
	public VisibleThing(String name, int x, int y) {
		// calls the super constructor with the name
		super(name);
		// gets processing
		PApplet process = getProcessing();
		// loads the image with the name given
		this.image = process.loadImage("images" + File.separator + name + ".png");
		// sets x
		this.x = x;
		// sets y
		this.y = y;

	} // initialize this new thing
		// the image for this visible thing should be loaded from :
		// "images"+File.separator+ name +".png"e

	/**
	 * updates the image
	 * 
	 * @return null
	 */
	@Override
	public Action update() {
		// gets processing
		PApplet process = getProcessing();
		// displays the image
		process.image(this.image, x, y);
		return null;
	} // draws image at its position before returning null

	/**
	 * moves the image to a new position
	 * 
	 * @param dx, dy (the change for where the image should be next)
	 * @return none
	 */
	public void move(int dx, int dy) {
		this.x = x + dx;
		this.y = y + dy;
	} // changes x by adding dx to it (and y by dy)

	/**
	 * checks to see if x and y positions passed in are over the image
	 * 
	 * @param x position, y position
	 * @return boolean true if they coordinates overlap
	 */
	public boolean isOver(int x, int y) {
		boolean overImage = true;
		// dimensions of the image
		int xImLeft = this.x;
		int yImTop = this.y;
		int xImRight = image.width + xImLeft;
		int yImBottom = image.height + yImTop;
		// checks the provided x and y are over the image
		if (x < xImLeft) {
			overImage = false;
		} else if (y < yImTop) {
			overImage = false;
		} else if (x > xImRight) {
			overImage = false;
		} else if (y > yImBottom) {
			overImage = false;
		}
		return overImage;
	} // return true only when point x,y is over image

	/**
	 * checks if an thing passed through is within a target image
	 * 
	 * @param other (the target image)
	 * @return a boolean, true if the image is within the target image
	 */
	public boolean isOver(VisibleThing other) {
		boolean overImage = false;
		// initializes the dimensions for the image being dragged
		int thisImLeft = this.x;
		int thisImRight = this.x + this.image.width;
		int thisImTop = this.y;
		int thisImBottom = this.y + this.image.height;
		// initializes the dimensions of the target image
		int otherImLeft = other.x;
		int otherImRight = other.x + other.image.width;
		int otherImTop = other.y;
		int otherImBottom = other.y + other.image.height;
		// checks conditions if the two images are overlapping
		if (thisImLeft >= otherImLeft && thisImTop >= otherImTop && thisImRight <= otherImRight
				&& thisImBottom <= otherImBottom) {
			overImage = true;
		}
		return overImage;
	} // return true only when other's image overlaps this one's

}
