package cse360assign2;


/*
 * @author Yogendra Awatramani
 * Class ID 437
 * Assignment 1: Creates a simple list class that adds up to ten integers into an array. 
 * The array has methods that count the amount of integers in the array, 
 * remove an element from the array and search an element.
 * and tests the methods using JUnit.
 */


/**
 * SimpleList Class
 */ 

public class SimpleList {

	private int count; //integer to count number of elements in the array
	private int list[]; //array to store numbers

	
	/*
	 * Constructor
	 */
	public SimpleList() {
		this.count = 0;
		this.list = new int[10];
	}

	
/**
 * Adds a number to the list(array). If list has no elements, adds the element to the head. If an 
 * element needs to be added and there would be more than ten integers, it removes the last element
 * and adds the element to the head. Moreover, as it adds a integer to the list, 
 * the index of the previous element increases. 
 * @param number an integer that gets added into the array of numbers
 */
	
	public void add(int number) {

		//adds element to the head if list is empty
		if (count == 0) {
			list[count] = number;
			count++;

		}

		
		//adds element to the front of the list
		else if (count < 10) {

			for (int index = count; index >= 0; index--) {
				list[index + 1] = list[index];
			}

			list[0] = number;

			count++;

		}
		
		
		//removes last element if more than ten elements and adds to the front
		else {
			remove(list[list.length-1]);
			for (int index = count; index >= 0; index--) {
				list[index + 1] = list[index];
			}

			list[0] = number;
			
		}

	}

	/**
	 * Removes the element specified in the parameter. If number does not exist it does not remove the element.
	 * @param number the integer that gets removed from the array of numbers
	 */
	public void remove(int number) {

		int index = 0;

		int remIndex = search(number);

		//Check if number exists in the list and only then removes element
		if (remIndex != -1) {

			for (index = remIndex; index < (count - 1); index++) {
				list[index] = list[index + 1];
			}

			count--;
		}
	}

	/**
	 * Returns the number of elements in the array
	 * @return returns the count variable that stores the number of elements in the array
	 */
	public int count() {
		return count;
	}
	
	
	/**
	 * Returns the index of the needed element
	 * @param number the integer that needs to be searched in the array
	 * @return returns -1 if element parameter does not exist
	 */

	public int search(int number) {

		int index = 0;

		for (index = 0; index < list.length; index++) {
			if (list[index] == number) {
				return index;
			}

		}

		return -1;

	}

	/**
	 * Prints all the element as a string
	 */
	
	public String toString() {

		String strReturn = "";

		int index = 0;

		for (index = 0; index < count; index++) {
			strReturn = strReturn + list[index];

			if (index != count - 1) {
				strReturn = strReturn + " ";
			}
		}

		return strReturn;
	}

}
