package edu.cofc.csci230;

/**
 * ArrayList Data Structure
 * 
 * @author CSCI 230: Data Structures and Algorithms Fall 2017
 *
 * @param <AnyType>
 */
public class ArrayList<AnyType extends Comparable<AnyType>> implements List<AnyType> {
     
    // instance variables
    private AnyType[] array;
    private int size = 0;
    private final static int INITIAL_CAPACITY = 10;
    private int capacity = INITIAL_CAPACITY;
    
    /**
     * Constructs an empty list with an initial capacity
     * (for this assignment initial capacity is 10 - see 
     * constant instance variable)
     * 
     */
    public ArrayList() {
        
        array = (AnyType[]) new Comparable[ capacity ];
        
    } // end constructor
 
    /**
     * Appends the specified element to the end of this list.
     * 
     * @param t
     */
    public void add( AnyType t) {
         
        if ( size >= capacity )
            grow();
        
        array[size]=t;
        size++;
         
    } // end add() method
 
    /**
     * Inserts the specified element at the specified position in this list.
     * 
     * @param index
     * @param t
     * @throws IndexOutOfBoundsException
     */
    public void add(int index, AnyType t) throws IndexOutOfBoundsException {
    		if(index<0 || index>=size) {
			throw new IndexOutOfBoundsException("Index "+index+" is out of bounds");
    		} 
    		if(size>=capacity)
    			grow();

    		for(int i=size-1; i>=index; i--) {		
    			array[i+1] = array[i];
   
    		}
    		array[index] = t;
    		
    		size++;
        
    } // end add() method
 
    /**
     * Replaces the element at the specified position in this list with the specified element.
     * 
     * @param index
     * @param t
     * @throws IndexOutOfBoundsException
     */
    public void set(int index, AnyType t) throws IndexOutOfBoundsException {
    		if(index<0 || index>=size) {
			throw new IndexOutOfBoundsException("Index "+index+" is out of bounds");
		}
    		array[index] = t;  
 
    } // end set() method
 
    /**
     * Removes the element at the specified position in this list.
     * 
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    public AnyType remove( int index ) throws IndexOutOfBoundsException {
		if(index<0 || index>=size) {
			throw new IndexOutOfBoundsException("Index "+index+" is out of bounds");
		}
    	
    		for(int i=index; i<size-1; i++) {
			array[i] = array[i+1];
		}
    		
		size--;
    		return array[index];
         
         
    } // end remove() method
 
    /**
     * Returns the element at the specified position in this list.
     * 
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    public AnyType get(int index) throws IndexOutOfBoundsException {
    		if(index<0 || index>=size) {
			throw new IndexOutOfBoundsException("Index "+index+" is out of bounds");
		}
    		return array[index];
  
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
         
        return ( size == 0 );
         
    } // end isEmpty() method
     
     
    /**
     * Removes all of the elements from this list.
     * and the initial capacity is set back to 10
     * 
     */
    public void clear() {
    		capacity=INITIAL_CAPACITY;
    		size=0;
    		/**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         */
        
         
         
    } // end clear method
    
    /**
     * Double the capacity of the array
     * 
     */
    private void grow() {	
    		int i = 0;
    		int cap = capacity;            
    		
        AnyType tempArr[] = (AnyType[]) new Comparable[ cap*2 ];

        while(i<cap) {
    			tempArr[i] = array[i];
    			capacity = capacity+1;
    			i++;
   		}
   		array = tempArr;
   		
    		//System.out.print(tempArr.length+"\n");
    		/**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         * Requirement - you must use loops (i.e. may not use
         * System.arraycopy, or any other array copy operation 
         * available in the Java API)
         * 
         */
        
        
        
    } // end grow() method
    
    
    /**
     * Half the capacity of the array
     * 
     */
    private void shrink() {
    	int i = 0;
    	int cap = capacity;            
		
   		AnyType tempArr[] = (AnyType[]) new Comparable[ cap ];
   		
   		if(capacity==INITIAL_CAPACITY){
   			return;
   		}
   		else {
   			while(i<cap/2) {
   				tempArr[i] = array[i];
   				capacity = capacity-1;
				if(capacity<size) { size--; }
				i++;
   			}
   		}
   		array = tempArr;
   		
        /**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         * Requirement - you must use loops (i.e. may not use
         * System.arraycopy, or any other array copy operation 
         * available in the Java API)
         * 
         */
        
        
    } // end shrink() method
    
    
    /**
     * For debugging purposes :)
     * 
     * Note: this only works for integer values 
     * hence, the %d format specifier in the 
     * string format method. If you want a 
     * different specifier, like string %s, 
     * you can change.
     * 
     */
    public String toString() {
        
        StringBuffer buffer = new StringBuffer();
        
        buffer.append( String.format( "Size=%d, A = [ ", size ) );
        
        if ( !isEmpty() ) {
            
            for ( int i=0; i<size-1; i++ ) {
                buffer.append( String.format( "%d, ", array[i] ) );    
            }
            
            buffer.append( String.format( "%d ]", array[size-1] ) );
            
        } else {
            
            buffer.append( "] " );
        }
        
        return buffer.toString();
        
    } // end toString()
     
     
    /**
     * 
     * @param args
     */
    public static void main( String[] args ) {
         
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        
    // Test Case 1: Add 10 integers into the list and print the size of the list and its contents
        System.out.print("Test case 1:\n");
    	
        for(int i=0; i<10; i++) {
            arrList.add(i);
        }
        System.out.print(arrList.toString()+"\n");
        
    // Test Case 2: Clear the ArrayList out completely, then print the size of the list and its contents
        System.out.print("\nTest case 2:\n");
        
        arrList.clear();
        System.out.print(arrList.toString()+"\n");

    // Test Case 3: Add 10 integers into the list, then add an integer at a specific index
        System.out.print("\nTest case 3:\n");        
        
        for(int i=0; i<10; i++) {
            arrList.add(i);
        }
        
        arrList.add(4,99);
        System.out.print(arrList.toString()+"\n");

    // Test Case 4: Remove one element from the list at a specific index
        System.out.print("\nTest case 4:\n");
        
        arrList.remove(4);
        System.out.print(arrList.toString()+"\n");
        
    // Test Case 5: Print the list capacity, then increase it using the grow() method
        System.out.print("\nTest case 5:\n");
       
        System.out.print("The capacity of the ArrayList is: "+arrList.capacity+"\n");
        arrList.grow();
        System.out.print("The capacity of the ArrayList is: "+arrList.capacity+"\n");
        arrList.grow();
        System.out.print("The capacity of the ArrayList is: "+arrList.capacity+"\n");
        arrList.grow();
        System.out.print("The capacity of the ArrayList is: "+arrList.capacity+"\n");
        
    // Test Case 6: Print the list capacity, then decrease it using the shrink() method
        System.out.print("\nTest case 6:\n");
        
        System.out.print("The capacity of the ArrayList is: "+arrList.capacity+"\n");
        arrList.shrink();
        System.out.print("The capacity of the ArrayList is: "+arrList.capacity+"\n");
        arrList.shrink();
        System.out.print("The capacity of the ArrayList is: "+arrList.capacity+"\n");
        arrList.shrink();
        System.out.print("The capacity of the ArrayList is: "+arrList.capacity+"\n");
        arrList.shrink();
        System.out.print("The capacity of the ArrayList is: "+arrList.capacity+"\n");

        
    // Test Case 7: Set the value at a specific index in the list
        System.out.print("\nTest case 7:\n");        
        
        arrList.set(6, 99);
        System.out.print(arrList.toString()+"\n");
       
    // Test Case 8: Show the capacity change when size exceeds the capacity
        System.out.print("\nTest case 8:\n");
        
        System.out.print(arrList.toString()+"\n");
        System.out.print("The capacity of the ArrayList is: "+arrList.capacity+"\n\n");
        arrList.add(250);
        
        System.out.print(arrList.toString()+"\n");
        System.out.print("The capacity of the ArrayList is: "+arrList.capacity+"\n");
        
    // Test Case 9: Show the change in list size as the list capacity is decreased and held at a miniumum of 10
        System.out.print("\nTest case 9:\n");
        
        System.out.print(arrList.toString()+"\n");
        System.out.print("The capacity of the ArrayList is: "+arrList.capacity+"\n\n");
        
        arrList.shrink();
        
        System.out.print(arrList.toString()+"\n");
        System.out.print("The capacity of the ArrayList is: "+arrList.capacity+"\n\n");
        
        arrList.shrink();
        
        System.out.print(arrList.toString()+"\n");
        System.out.print("The capacity of the ArrayList is: "+arrList.capacity+"\n");
        
     // Test Case 10: Use the get() method to retrieve data at a specific index
        System.out.print("\nTest case 10:\n");
        
        System.out.println(arrList.toString()+"\n");
        System.out.println("The value at index 2 is "+arrList.get(2));
        System.out.println("The value at index 0 is "+arrList.get(0));
        System.out.println("The value at index 6 is "+arrList.get(6));
       

        
       


    } // end main() method
  
} // end ArrayList class definition

