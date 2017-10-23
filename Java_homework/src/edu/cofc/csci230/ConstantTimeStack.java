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
		list.add(t);
		
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
/*
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

    	// Test Case 4: Remove an element from the top of the stack
        System.out.print("\nTest case 4:\n");
        hwList.pop();
        System.out.print(hwList.peek()+"\n");
        
    // Test Case 5: Add several more elements to the stack, then use the peek() method
        System.out.print("\nTest case 5:\n");
        hwList.push("string1");
        hwList.push("string2");
        hwList.push("string3");
        hwList.push("string4");
        System.out.print(hwList.peek()+"\n");

    	// Test Case 6: Remove a couple elements, then use the peek() method
        System.out.print("\nTest case 6:\n");
        hwList.pop();
        hwList.pop();
        System.out.print(hwList.peek()+"\n");

    	// Test Case 7: Remove a couple elements, then use the peek() method
        System.out.print("\nTest case 7:\n");        
        hwList.pop();
        hwList.pop();
        System.out.print(hwList.peek()+"\n");

        
	} // end main method

} // end ConstantTimeStack class definition
*/
		
/////////////////////////////////////////
//////////////// Stack //////////////////
/////////////////////////////////////////

int points = 0;
boolean passed;

java.util.Stack<Integer> javaStack = new java.util.Stack<Integer>();
ConstantTimeStack<Integer> stack = new ConstantTimeStack<Integer>();

System.out.println("-------------------------------------------------------------------");
System.out.println("ConstantTimeStack.java");
System.out.println("-------------------------------------------------------------------");
System.out.println("----------------------------------");
System.out.println("Test Case_1:");

try{
stack.pop();
System.out.println("[Failed]");
} catch (EmptyStackException e){
System.out.println("[Passed]");
points += 10;
} catch (Exception e) {
System.out.println("[Failed]");
}



System.out.println("----------------------------------");
System.out.println("Test Case_2:");

try{
stack.peek();
System.out.println("[Failed]");
} catch (EmptyStackException e){
System.out.println("[Passed]");
points += 10;
} catch (Exception e) {
System.out.println("[Failed]");
}



System.out.println("----------------------------------");
System.out.println("Test Case_3:");

try{
for(int i = 10; i > 5; i--){
javaStack.push(i);
stack.push(new Integer(i));
}
System.out.println("[Passed]");
points += 10;
} catch (Exception e){
System.out.println("[Failed]");
}



System.out.println("----------------------------------");
System.out.println("Test Case_4:");

passed = true;

try {
if (!javaStack.peek().equals( stack.peek() ) ){
passed = false;
} 

if (!javaStack.pop().equals( stack.pop() ) ) {
passed = false;
}

if (!javaStack.peek().equals( stack.peek() ) ){
passed = false;
} 

} catch (Exception e){
passed = false;
}

if (passed){
System.out.println("[Passed]");
points += 10;
} else {
System.out.println("[Failed]");
}



System.out.println("----------------------------------");
System.out.println("Test Case_5:");

try {
if (javaStack.pop().equals( stack.pop() ) && 
javaStack.pop().equals( stack.pop() ) &&
javaStack.pop().equals( stack.pop() ) &&
javaStack.pop().equals( stack.pop() ) ){

System.out.println("[Passed]");
points += 10;
} else {
System.out.println("[Failed]");
}
} catch (Exception e){ 
System.out.println("[Failed]");
}



System.out.println("----------------------------------");
System.out.println("Test Case_6:");

try{
stack.pop();
System.out.println("[Failed]");
} catch (Exception e){
System.out.println("[Passed]");
points += 10;
}



System.out.println("----------------------------------");
System.out.println("Test Case_7:");

java.util.Stack<Integer> javaStack2 = new java.util.Stack<Integer>();
ConstantTimeStack<Integer> stack2 = new ConstantTimeStack<Integer>();

passed = true;

try{
for(int i = 20; i >= 5; i--){
javaStack2.push(i);
stack2.push(new Integer(i));
}

if (!javaStack2.pop().equals( stack2.pop() ) ||
!javaStack2.pop().equals( stack2.pop() ) ){
passed = false;
}

for(int i = 6; i <= 8; i++){
javaStack2.push(i);
stack2.push(new Integer(i));
}

if (!javaStack2.pop().equals( stack2.pop() ) ||
!javaStack2.pop().equals( stack2.pop() ) ||
!javaStack2.pop().equals( stack2.pop() ) ||
!javaStack2.pop().equals( stack2.pop() ) ||
!javaStack2.pop().equals( stack2.pop() ) ){
passed = false;
}

} catch (Exception e){
passed = false;
}

if (passed){
System.out.println("[Passed]");
points += 10;
} else {
System.out.println("[Failed]");
}


System.out.println("----------------------------------");
System.out.println("----------------------------------");
System.out.println("-------------------------------------------------------------------");
System.out.println("                                 Points Possible    Points Received");
System.out.println("ConstantTimeStack Compiles             10                 10  ");
System.out.println("ConstantTimeStack Meets...");
System.out.println("   Time Complexity                     15                     ");
System.out.println("Thorough test cases                     5                     ");
System.out.println("Instructor Test Cases                  70                 " + points);
System.out.println("   (7 @ 10pts each)");
System.out.println("                                                  Total points: " + (points+10));
System.out.println("-------------------------------------------------------------------");



/////////////////////////////////////////
//////////////// Queue //////////////////
/////////////////////////////////////////

points = 0;

java.util.concurrent.ArrayBlockingQueue<Integer> javaQueue = new java.util.concurrent.ArrayBlockingQueue<Integer>(100);
SemiConstantTimeQueue<Integer> queue = new SemiConstantTimeQueue<Integer>();

System.out.println();
System.out.println();
System.out.println();
System.out.println("-------------------------------------------------------------------");
System.out.println("SemiConstantTimeQueue.java");
System.out.println("-------------------------------------------------------------------");
System.out.println("----------------------------------");
System.out.println("Test Case_1:");

try{
queue.add(null);
System.out.println("[Failed]");
} catch (NullPointerException e){
System.out.println("[Passed]");
points += 10;
} catch (Exception e) {
System.out.println("[Failed]");
}



System.out.println("----------------------------------");
System.out.println("Test Case_2:");

try{
queue.remove();
System.out.println("[Failed]");
} catch (NoSuchElementException e){
System.out.println("[Passed]");
points += 10;
} catch (Exception e) {
System.out.println("[Failed]");
}



System.out.println("----------------------------------");
System.out.println("Test Case_3:");

try{
for(int i = 10; i >= 0; i--){
javaQueue.add(i);
queue.add(i);
}
System.out.println("[Passed]");
points += 10;
} catch (Exception e){
System.out.println("[Failed]");
}



System.out.println("----------------------------------");
System.out.println("Test Case_4:");

passed = true;

try {
if (!javaQueue.peek().equals( queue.peek() ) ){
passed = false;
} 

if (!javaQueue.remove().equals( queue.remove())){
passed = false;
}

if (!javaQueue.peek().equals( queue.peek() )){
passed = false;
} 

} catch (Exception e){
passed =false;
}

if (passed){
System.out.println("[Passed]");
points += 10;
} else {
System.out.println("[Failed]");
}



System.out.println("----------------------------------");
System.out.println("Test Case_5:");

try {
if (javaQueue.remove().equals( queue.remove() ) && 
javaQueue.remove().equals( queue.remove() ) &&
javaQueue.remove().equals( queue.remove() ) &&
javaQueue.remove().equals( queue.remove() ) ){

System.out.println("[Passed]");
points += 10;
} else {
System.out.println("[Failed]");
}
} catch (Exception e){ 
System.out.println("[Failed]");
}



System.out.println("----------------------------------");
System.out.println("Test Case_6:");

try{
queue.add(null);
System.out.println("[Failed]");
} catch (Exception e){
System.out.println("[Passed]");
points += 10;
}



System.out.println("----------------------------------");
System.out.println("Test Case_7:");

java.util.concurrent.ArrayBlockingQueue<Integer> javaQueue2 = new java.util.concurrent.ArrayBlockingQueue<Integer>(100);
SemiConstantTimeQueue<Integer> queue2 = new SemiConstantTimeQueue<Integer>();

passed = true;

try{
for(int i = 20; i >= 5; i--){
javaQueue2.add(i);
queue2.add(i);
}

if (!javaQueue2.remove().equals( queue2.remove() ) ||
!javaQueue2.remove().equals( queue2.remove() ) ){
passed = false;
}

for(int i = 6; i <= 8; i++){
javaQueue2.add(i);
queue2.add(i);
}

if (!javaQueue2.remove().equals( queue2.remove() ) ||
!javaQueue2.remove().equals( queue2.remove() ) ||
!javaQueue2.remove().equals( queue2.remove() ) ||
!javaQueue2.remove().equals( queue2.remove() ) ||
!javaQueue2.remove().equals( queue2.remove() ) ){
passed = false;
}

} catch (Exception e){
passed = false;
}

if (passed){
System.out.println("[Passed]");
points += 10;
} else {
System.out.println("[Failed]");
}

System.out.println("----------------------------------");
System.out.println("----------------------------------");
System.out.println("-------------------------------------------------------------------");
System.out.println("                                 Points Possible    Points Received");
System.out.println("SemiConstantTimeQueue Compiles         10                 10  ");
System.out.println("SemiConstantTimeQueue Meets...");
System.out.println("   Time Complexity                     15                     ");
System.out.println("Thorough test cases                     5                     ");
System.out.println("Instructor Test Cases                  70                 " + points);
System.out.println("   (7 @ 10pts each)");
System.out.println("                                                  Total points: " + (points+10));
System.out.println("-------------------------------------------------------------------");

}

}