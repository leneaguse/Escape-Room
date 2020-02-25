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
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import processing.core.PApplet;
import processing.core.PImage;

public class EscapeRoom extends PApplet {
	private PImage backgroundImage; // creates the image instance for the background
	private ArrayList<Thing> allThings;// creates the array of things that are created

	/**
	 * Allows for the program to run through PApplet
	 * 
	 * @param none
	 * @return none
	 */
	public static void main(String[] args) {
		PApplet.main("EscapeRoom");
	}

	/**
	 * Initializes the size of the screen
	 * 
	 * @return none
	 */
	public void settings() {
		size(800, 600);
	}

	/**
	 * Initializes fields for the program to run
	 * 
	 * @return none
	 */
	public void setup() {
		// initializes the allThings list
		allThings = new ArrayList<Thing>();
		// sets the processing
		Thing.setProcessing(this);
		// loads the room setup
		loadRoom("rooms" + File.separator + "computerCenter.room");

	}

	/**
	 * calls methods for the images to be drawn removes deactivated images from the
	 * list
	 * 
	 * @return none
	 */
	public void draw() {
		// initializes action
		Action act = null;
		// draws the background image at position 0, 0
		image(backgroundImage, 0, 0);

		// iterates through the allThings arraylist
		for (int i = 0; i < allThings.size(); i++) {
			// calls update on the thing
			act = allThings.get(i).update();
			// checks if the action is not null
			if (!(act == null)) {
				// calls for the item to be initialized and added to the action arraylist
				act.act(allThings);
			}
		}
		// iterates through the allThings arraylist
		for (int j = 0; j < allThings.size(); j++) {
			// checks if the thing is active
			if (!allThings.get(j).isActive()) {
				// removes the thing is it is not active
				allThings.remove(j);
			}
		}
	}

	/**
	 * This method loads a background image, prints out some introductory text, and
	 * then reads in a set of thing descriptions from a text file with the provided
	 * name. The image is stored in this.backgroundImage, and the activated things
	 * are added to the this.allThings list.
	 * 
	 * @param filename - relative path of file to load, relative to current working
	 *                 directory
	 */
	private void loadRoom(String filename) {
		// start reading file contents
		Scanner fin = null;
		int lineNumber = 1; // report first line in file as lineNumber 1
		try {
			fin = new Scanner(new File(filename));

			// read and store background image
			String backgroundImageFilename = fin.nextLine().trim();
			backgroundImageFilename = "images" + File.separator + backgroundImageFilename + ".png";
			backgroundImage = loadImage(backgroundImageFilename);
			lineNumber++;

			// read and print out introductoy text
			String introductoryText = fin.nextLine().trim();
			System.out.println(introductoryText);
			lineNumber++;

			// then read and create new things, one line per thing
			while (fin.hasNextLine()) {
				String line = fin.nextLine().trim();
				if (line.length() < 1)
					continue;

				// fields are delimited by colons within a given line
				String[] parts = line.split(":");
				Thing newThing = null;

				// first letter in line determines the type of thing to create
				if (Character.toUpperCase(line.charAt(0)) == 'C')
					newThing = loadNewClickableThing(parts);
				else if (Character.toUpperCase(line.charAt(0)) == 'D')
					newThing = loadNewDragAndDroppableThing(parts);

				// even deactivated object references are being added to allThings, so they can
				// be found
				// these deactivated object references will be removed, when draw() is first
				// called
				allThings.add(newThing);
				if (Character.isLowerCase(line.charAt(0))) // lower case denotes non-active object
					newThing.deactivate();
				lineNumber++;
			}

			// catch and report warnings related to any problems experienced loading this
			// file
		} catch (FileNotFoundException e) {
			System.out.println("WARNING: Unable to find or load file: " + filename);
		} catch (RuntimeException e) {
			System.out.println("WARNING: Problem loading file: " + filename + " line: "
					+ lineNumber);
			e.printStackTrace();
		} finally {
			if (fin != null)
				fin.close();
		}
	}

	/**
	 * Helper method to retrieve thing references from allThings, based on their
	 * names. If multiple things have that name, this method will return the first
	 * (lowest-index) reference found.
	 * 
	 * @param name is the name of the object that is being found
	 * @return a reference to a thing with the specified name, or null when none is
	 *         found
	 */
	private Thing findThingByName(String name) {
		for (int i = 0; i < allThings.size(); i++)
			if (allThings.get(i).hasName(name)) {
				return allThings.get(i);
			}
		System.out.println("WARNING: Failed to find thing with name: " + name);
		return null;
	}

	/**
	 * This method creates and returns a new ClickableThing based on the properties
	 * specified as strings within the provided parts array.
	 * 
	 * @param parts contains the following strings in this order: - C: indicates
	 *              that a ClickableThing is being created - name: the name of the
	 *              newly created thing - x: the starting x position (as an int) for
	 *              this thing - y: the starting y position (as an int) for this
	 *              thing - message: a string of text to display when this thing is
	 *              clicked - name of thing to activate (optional): activates this
	 *              thing when clicked
	 * @return the newly created object
	 */
	private ClickableThing loadNewClickableThing(String[] parts) {
		// C: name: x: y: message: name of object to activate (optional)
		String name = parts[1].trim();
		int x = Integer.parseInt(parts[2].trim());
		int y = Integer.parseInt(parts[3].trim());
		String message = parts[4].trim();
		Thing activate = null;
		if (parts.length > 5)
			activate = findThingByName(parts[5].trim());
		// create new thing
		ClickableThing newThing = new ClickableThing(name, x, y, new Action(message, activate));
		return newThing;
	}

	/**
	 * This method creates and returns a new DragAndDroppableThing based on the
	 * properties specified as strings within the provided parts array.
	 * 
	 * @param parts contains the following strings in this order: - D: indicates
	 *              that a DragAndDroppableThing is being created - name: the name
	 *              of the newly created thing - x: the starting x position (as an
	 *              int) for this thing - y: the starting y position (as an int) for
	 *              this thing - message: a string of text to display when this
	 *              thing is dropped on target - name of thing to activate
	 *              (optional): activates this thing when dropped on target
	 * @return the newly created object
	 */
	private DragAndDroppableThing loadNewDragAndDroppableThing(String[] parts) {
		// D: name: x: y: target: message: name of object to activate (optional)
		String name = parts[1].trim();
		int x = Integer.parseInt(parts[2].trim());
		int y = Integer.parseInt(parts[3].trim());
		Thing dropTarget = findThingByName(parts[4].trim());
		if (!(dropTarget instanceof VisibleThing))
			dropTarget = null;
		String message = parts[5].trim();
		Thing activate = null;
		if (parts.length > 6)
			activate = findThingByName(parts[6].trim());
		// create new thing
		DragAndDroppableThing newThing = new DragAndDroppableThing(name, x, y, (VisibleThing)
				dropTarget,new Action(message, activate));
		return newThing;
	}
}
