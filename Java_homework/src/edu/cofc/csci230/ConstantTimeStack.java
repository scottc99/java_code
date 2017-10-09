package edu.cofc.csci230;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/**
 * A LIFO stack that has constant time complexity O(1) for
 * all three stack interface methods (i.e., push, pop, and 
 * peek).
 * 
 * This data structure was discussed in class along with the 
 * operations, please review your notes.
 * 
 * @author CSCI 230: Data Structures and Algorithms Fall 2017
 *
 * @param <AnyType>
 */
public class ConstantTimeStack<AnyType extends Comparable<AnyType>> implements Stack<AnyType> {
	
	/**
	 * private instance variables
	 */
	private SinglyLinkedList<AnyType> list = new SinglyLinkedList<AnyType>();

	/**
	 * Pushes an item onto the top of this stack in constant 
	 * time O(1)
	 * 
	 * @param t the item to be pushed onto this stack.
	 */
	public void push(AnyType t) {
		int size = list.size();
		if(size==0) {
			list.add(t);
		}
		else {
			list.add(size-1, t);
		}
		/**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         * Note: Your push solution must be a constant 
         * time O(1) operation
         * 
         */
		
		
		
	} // end push() method

	/**
	 * Removes the object at the top of this stack and return the 
	 * item in constant time O(1)
	 * .
	 * @return The item at the top of this stack
	 * @throws EmptyStackException - if this stack is empty.
	 */
	public AnyType pop() throws EmptyStackException {
		int size = list.size();
		if(size==0) {
			throw new EmptyStackException();
		}
		AnyType temp = list.get(size-1);
		
		list.remove(size-1);
		return temp;
		
		/**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         * Note: Your pop solution must be a constant 
         * time O(1) operation
         * 
         */
		
		
		
	} // end pop() method

	/**
	 * Looks at the item at the top of this stack without removing it 
	 * from the stack in constant time O(1)
	 * 
	 * @return the item at the top of this stack
	 * @throws EmptyStackException  - if this stack is empty.
	 */
	public AnyType peek() throws EmptyStackException {
		int size = list.size();
		if(size==0) {
			throw new EmptyStackException();
		}
		
		AnyType temp = list.get(size-1);
		return temp;
		
		
		/**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         * Note: Your peek solution must be a constant 
         * time O(1) operation
         * 
         */
		
		
		
	} // end peek() method
	
	/**
	 * 
	 * @param args
	 */
	public static void main( String[] args ) {
		
		ConstantTimeStack<String> hwList = new ConstantTimeStack<String>();

	// Test Case 1: Using peek() method when stack is empty
        System.out.print("Test case 1:\n");
    		
        try {
        		hwList.peek();
        }catch (EmptyStackException e) {
        		System.out.print("The stack is empty!\n");
        }
        
    // Test Case 2: Using pop() method when stack is empty
        System.out.print("\nTest case 2:\n");
        try {
			hwList.pop();
        	}catch (EmptyStackException e) {
			System.out.print("The stack is empty! No elements to remove\n");
        	}
        
    // Test Case 3: Add elements to the empty stack
        System.out.print("\nTest case 3:\n");     
        hwList.push("First");
        hwList.push("Second");
        hwList.push("Third");
        hwList.push("Fourth");
        System.out.print(hwList.peek()+"\n");
        hwList.pop();        
        System.out.print(hwList.peek()+"\n");
        hwList.pop();        
        System.out.print(hwList.peek());
    	// Test Case 4: 
        System.out.print("\nTest case 4:\n");
        
    // Test Case 5: 
        System.out.print("Test case 5:\n");

    	// Test Case 6: 
        System.out.print("\nTest case 6:\n");
        
    // Test Case 7: 
        System.out.print("\nTest case 7:\n");        

    // Test Case 8: 
        System.out.print("\nTest case 8:\n");
       
    // Test Case 9:
        System.out.print("\nTest case 9:\n");
        
		
		
		
	} // end main method

} // end ConstantTimeStack class definition
