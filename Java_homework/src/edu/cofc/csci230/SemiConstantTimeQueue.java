package edu.cofc.csci230;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/**
 * A semi-constant time FIFO queue. The time complexity for 
 * the interface methods are:
 * ----------------------------------
 * 1) add: O(1) - not considering capacity resize operations
 * 2) remove: O(n) - not considering capacity resize operations
 * 3) peek: O(1)
 * 
 * Please note: the above time complexities do not factor in
 * capacity resize (grow and shrink) operations. Even though
 * capacity resize operations will occur, for this assignment 
 * you may assume the are negligible.
 * 
 * This data structure was discussed in class along with the 
 * operations, please review your notes.
 * 
 * @author CSCI 230: Data Structures and Algorithms Fall 2017
 *
 * @param <AnyType>
 */
public class SemiConstantTimeQueue<AnyType extends Comparable<AnyType>> implements Queue<AnyType> {
	
	/**
	 * private instance variables
	 */
	private ArrayList<AnyType> list = new ArrayList<AnyType>();


	/**
	 * Inserts the specified element at the end of the queue in 
	 * constant time O(1)
	 * 
	 * @param t element to add
	 * @throws NullPointerException- if the specified element is null 
	 *                               (queue does not permit null elements)
	 */
	public void add(AnyType t) throws NullPointerException {
		
		if(list.size()==0) {
			list.add(t);
		}
		else {
			list.add(0,t);
		}
		
		/**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         * Note: Your add solution must be a constant 
         * time O(1) operation (*** not considering capacity 
         * resize operations ***)
         * 
         */
		
		
		
	} // end add() method

	/**
	 * Retrieves and removes the head of the queue in
	 * linear time O(n).
	 * 
	 * Hint: shift operations will make this a linear time
	 * operation.
	 * 
	 * @return the head of the queue
	 * @throws NoSuchElementException - if this queue is empty
	 */
	public AnyType remove() throws NoSuchElementException {
		int size = list.size();
		if(size==0) {
			throw new NoSuchElementException("There are no elements in the list");
		}
		
		AnyType temp = list.get(size-1);
		list.remove(size-1);
		return temp;
		
		/**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         * Note: Your push solution must be a linear 
         * time O(n) operation. See hint above.
         * 
         *
         */
		
		
		
	} // end remove() method

	/**
	 * Retrieves, but does not remove, the head of the queue, 
	 * or returns null if this queue is empty.
	 * 
	 * @return the head of this queue, or null if this queue is empty
	 */
	public AnyType peek() {
		int size = list.size();
		if(size==0) {
			throw new NoSuchElementException("There are no elements in the list");
		}
		
		AnyType temp = list.get(size-1);
		return temp;
		
		/**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         * Note: Your add solution must be a constant 
         * time O(1) operation 
         * 
         */
		
		
		
	} // end peek() method
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		SemiConstantTimeQueue<String> quList = new SemiConstantTimeQueue<String>();
		
	// Test Case 1: Using peek() method when queue is empty
        System.out.print("Test case 1:\n");
        try {
    			quList.peek();
        }catch (NoSuchElementException e) {
    			System.out.print("The queue is empty!\n");
        }
    
    // Test Case 2: Using remove() method when queue is empty
        System.out.print("\nTest case 2:\n");
        try {
			quList.remove();
        	}catch (NoSuchElementException e) {
			System.out.print("The queue is empty! No elements to remove\n");
        	}
        
    // Test Case 3: Add elements to the queue
        System.out.print("\nTest case 3:\n");        
        quList.add("First");
        quList.add("Second");
        quList.add("Third");
        quList.add("Fourth");
        quList.add("5th");
        
        System.out.print(quList.peek()+"\n");
        
    	// Test Case 4: Peek at the first element in queue, then remove element and peek again
        System.out.print("\nTest case 4:\n");
        System.out.print(quList.peek()+"\n");
        quList.remove();
        System.out.print(quList.peek()+"\n");

    // Test Case 5: Remove one more element and use peek() method
        System.out.print("\nTest case 5:\n");
        quList.remove();
        System.out.print(quList.peek()+"\n");

    	// Test Case 6: Add several more elements to queue, then peek at the first element
        System.out.print("\nTest case 6:\n");
        quList.add("string1");
        quList.add("string2");
        quList.add("string3");
        quList.add("string4");
        System.out.print(quList.peek()+"\n");
        
    // Test Case 7: Remove 3 elements from the queue and use the peek method
        System.out.print("\nTest case 7:\n");        
        quList.remove();
        quList.remove();
        quList.remove();
        System.out.print(quList.peek()+"\n");
        
	} // end main() method

} // end SemiConstantTimeQueue class definition

