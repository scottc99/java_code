package edu.cofc.csci230;
  
 
/**
 * Singly LinkedList Data Structure
 * 
 * @author CSCI 230: Data Structures and Algorithms Fall 2017
 *
 * @param <AnyType>
 */
public class SinglyLinkedList<AnyType extends Comparable<AnyType>> implements List<AnyType> {
     
    // instance variables
    private Node<AnyType> headNode = null;
    private int size = 0;
 
    /**
     * Appends the specified element to the end of this list.
     * 
     * @param t
     */
    public void add( AnyType t) {
         
        addNode( new Node<AnyType>(t) );
         
    } // end add() method
    
    /**
     * implementation for public add(AnyType t) method
     * 
     * @param t
     */
    private void addNode(Node<AnyType> t) {
        
        if ( isEmpty() ) headNode = t;
        else getNode( size-1 ).setNextNode( t );
         
        size++;
         
    } // end addNote() method
 
 
    /**
     * Inserts the specified element at the specified position in this list.
     * 
     * @param index
     * @param t
     * @throws IndexOutOfBoundsException
     */
    public void add(int index, AnyType t) throws IndexOutOfBoundsException {
         
    		addNode( index, new Node<AnyType>(t) );
         
    } // end add() method
    
    /*
     * 
     * Implementation for public add(int index, AnyType t) method
     *
     * @param index
     * @param t
     * @throws IndexOutOfBoundsException
     */
    private void addNode(int index, Node<AnyType> t) throws IndexOutOfBoundsException {

    		// Test to make sure that the index is in range of the list size and greater than 0
    		if(index<0 || index>=size)
			throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");

    		// If the index is 0, then treat initial index value as the headnode
    		if(index==0) {
    			t.setNextNode(getNode(0));
    			headNode=t;
    			size++;
    			return;
    		}
    		// If the index is set to the last index, then move the current
    		// node at that index to null and insert the new node
    		if(index==size-1) {
    			Node<AnyType> x = getNode(index-1);
    			Node<AnyType> y = getNode(index);
    			t.setNextNode(y);
    			x.setNextNode(t);
    			y.setNextNode(null);
    			size++;
    			return;
    			
    		}
    		// If the index entered is greater than 0 and less than (list.size() - 1),
    		// then rearrange the pointers to the appropriate nodes and add new node
    		// into the list
    		Node<AnyType> x = getNode(index-1);
    		Node<AnyType> y = getNode(index);
    		t.setNextNode(y);
    		x.setNextNode(t);
    		size++;
    		return;
        
    } // end addNode() method
 
    /**
     * Replaces the element at the specified position in this list with the specified element.
     * 
     * @param index
     * @param t
     * @throws IndexOutOfBoundsException
     */
    public void set(int index, AnyType t) throws IndexOutOfBoundsException {
         
        setNode( index, new Node<AnyType>(t) );
         
    } // end set() method
    
    /**
     * 
     * Implementation for public set( int index, AnyType t ) method
     *
     * @param index
     * @param t
     * @throws IndexOutOfBoundsException
     */
    private void setNode( int index, Node<AnyType> t ) throws IndexOutOfBoundsException {
    		
    		//Check to make sure index is in bounds and not less than 0
    		if(index<0 || index>=size)
    			throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
    		
    		// If the index is 0, treat node at current index as headnode
    		if(index==0) {
    			Node<AnyType> x = getNode(index+1);
    			t.setNextNode(x);
    			headNode = t;

    			return;
    		}
    		
    		// If index is set to the final node in the list, replace with the new node and point it to null
    		if(index==size-1) {
    			Node<AnyType> x = getNode(index-1);
    			t.setNextNode(null);
    			x.setNextNode(t);
    			
    			return;
    			
    		}
    		
    		// Index in range, replace current node with new node set by user
    		Node<AnyType> x = getNode(index-1);
    		Node<AnyType> y = getNode(index+1);
    		x.setNextNode(t);
    		t.setNextNode(y);
  
    		return;
    	
    } // end setNode() method
 
    /**
     * Removes the element at the specified position in this list.
     * 
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    public AnyType remove( int index ) throws IndexOutOfBoundsException {
    	
    		return removeNode( index ).getData();
    	
    } // end remove() method
    
    /**
     *
     * Implementation for public remove( int index ) method
     *
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    private Node<AnyType> removeNode( int index ) throws IndexOutOfBoundsException {
		
    		// Check that the index is in range of the list and greater than 0
    		if(index<0 || index>=size)
			throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
    		
    		// If the index equals 0, then change the headnode to the next node after the current index value
    		if(index==0) {
    			Node<AnyType> n = getNode(index);
    			headNode = n.getNextNode();
    			size--;
    			return n;
    		}
    		
    		// If index is in range, then replace the current indexed node with the new node.
    		// Adjust the references so that they point to the new node (and the new node references correctly)
    		Node<AnyType> x = getNode(index-1);
		Node<AnyType> y = getNode(index);
		x.setNextNode(y.getNextNode());
		size--;
		return x;
    		
    } // end removeNode() method
 
    /**
     * Returns the element at the specified position in this list.
     * 
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    public AnyType get( int index ) throws IndexOutOfBoundsException {
    		return getNode( index ).getData();
    	
    } // end get() method
    
    /**
     *
     * Implementation for public get(int index) method
     * 
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    private Node<AnyType> getNode(int index) throws IndexOutOfBoundsException {
		
    		// Check that the index is in range of the list and that it is greater than 0
    		if(index<0 || index>=size)
			throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
    		
    		// If the index is set to 0, return the headnode
    		if(index==0) {
    			return headNode;
    		}
    		
    		// If the the index is in range of the list, then loop through each node until reaching the
    		// node at the desired index
		Node<AnyType> temp = headNode;
    		for(int i = 0; i<index; i++) {
			temp = temp.getNextNode();
		}
        return temp;
         
    } // end get() method
 
    /**
     * Returns the number of elements in this list. 
     * 
     * @return
     */
    public int size() {
         
        return size;
         
    } // end size() method
 
    /**
     * Returns true if this list contains no elements.
     * 
     * @return
     */
    public Boolean isEmpty() {
         
        return ( size == 0 ) ? true : false;
         
    } // end isEmpty() method
     
     
    /**
     * Removes all of the elements from this list.
     * 
     */
    public void clear() {
    		
    		// Putting that the headnode is pointing to null, effectively skipping over any other nodes in
    		// the linked list and erasing them
    		headNode=null;
    		this.size=0;
         
    } // end clear method

 // Hassam's toString method added in
    
    public String toString() {
 		Node<AnyType> temp = headNode; 
 		String rtnString = "";
 		
 		for (int i = 0; i<this.size; i++) {
 			rtnString += temp.getData().toString() + " -> ";
 			temp = temp.getNextNode();
 			
 		}
 		rtnString += "null";
 		
 		return rtnString; 
 		
 	}
     
    /**
     * 
     * @param args
     */
    public static void main( String[] args ) {
        
    // Create a new singly linked list object
        
    		SinglyLinkedList<Integer> hwList = new SinglyLinkedList<Integer>();
        
    	// Test Case 1: Add 4 elements to a list, print out the size of the list
        System.out.print("Test case 1:\n");
    		hwList.add(1);
        hwList.add(2);
        hwList.add(3);
        hwList.add(4);
        
        System.out.println("The list size is: " + hwList.size());
        
    // Test Case 2: Clear the list out completely, then print the size of the list
        System.out.print("\nTest case 2:\n");
        hwList.clear();
        System.out.println("The list size after clearing it out is: " + hwList.size());

    // Test Case 3: Add nodes back into list and print out the structure of linked list
        System.out.print("\nTest case 3:\n");        
        hwList.add(1);
        hwList.add(2);
        hwList.add(3);
        hwList.add(4);
        System.out.print(hwList.toString()+"\n");
        
    	// Test Case 4: Add in another node onto the end of the linked list using the add method, then print
    // the size of the list and it's contents
        
        System.out.print("\nTest case 4:\n");
        hwList.add(99);
        System.out.print(hwList.toString()+"\n");
        
        System.out.println("The list size is: " + hwList.size()+"\n");
        
    // Test Case 5: Check that the nodes are referencing correctly, the last node in particular
        System.out.print("Test case 5:\n");
        System.out.print(hwList.toString()+"\n");

    	// Test Case 6: Check that a node can be added a specific index, then print out the contents
        System.out.print("\nTest case 6:\n");
        hwList.add(4,425);
        hwList.add(2,50);
        System.out.print(hwList.toString()+"\n");

    // Test Case 7: Remove a node from the list at a specific index
        System.out.print("\nTest case 7:\n");        
        hwList.remove(3);
        System.out.print(hwList.toString()+"\n");
        
    // Test Case 8: Set the value of a specific node
        System.out.print("\nTest case 8:\n");
        hwList.set(0, 200);
        hwList.set(4, 1000);
        System.out.print(hwList.toString()+"\n");
        
    // Test Case 9: Use the clear method, then check that the list is empty
        System.out.print("\nTest case 9:\n");
        hwList.clear();
        System.out.print(hwList.isEmpty()+"\n");
        
  
    		/**
         * -------------------------------------------
         * TODO: You put your test cases here
         * 
         */
         
         
    } // end main() method
  
} // end SinglyLinkedList class definition