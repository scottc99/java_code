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
	 */
	private void addNode(int index, Node<AnyType> t) throws IndexOutOfBoundsException {

		if ( index == 0 ) {

			t.setNextNode( headNode );
			headNode = t;
			size++;

		} else if ( index == size ) {

			addNode( t );

		} else {

			t.setNextNode( getNode( index ) );
			getNode( index - 1 ).setNextNode( t );
			size++;

		}

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
	 * @param index
	 * @param t
	 * @throws IndexOutOfBoundsException
	 */
	private void setNode( int index, Node<AnyType> t )  throws IndexOutOfBoundsException {

		getNode( index ).setData( t.getData() );

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
	 * @param index
	 * @return
	 * @throws IndexOutOfBoundsException
	 */
	private Node<AnyType> removeNode( int index ) throws IndexOutOfBoundsException {

		Node<AnyType> node = getNode( index );

		if ( index == 0 ) {

			headNode = node.getNextNode();

		} else {

			getNode( index - 1 ).setNextNode( node.getNextNode() );

		}

		size--;

		return node;

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
	 * Implementation for get(int index) method
	 * 
	 * @param index
	 * @return
	 * @throws IndexOutOfBoundsException
	 */
	private Node<AnyType> getNode(int index) throws IndexOutOfBoundsException {

		if ( index < 0 || index >= size ) {

			System.out.printf( "index = %d, size = %d\n", index, size );

			throw new IndexOutOfBoundsException();

		}

		Node<AnyType> node = headNode;

		for ( int i=1; i<=index; i++ ) {

			node = node.getNextNode();

		}

		return node;

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

		headNode = null;
		size=0;

	} // end clear method

	/**
	 * swap two elements in a list at index 
	 * position i and j.
	 * 
	 * For example, 
	 *  if A = 1->2->3->4->5 and swap( 1, 3 ) is executed
	 *  then A = 1->4->3->2->5
	 *
	 * @param i
	 * @param j
	 * @throws IndexOutOfBoundsException
	 */
	public void swap( int i, int j )  throws IndexOutOfBoundsException {

		Node<AnyType> node1 = getNode(i);
		Node<AnyType> node2 = getNode(j);

		AnyType data1 = node1.getData();
		AnyType data2 = node2.getData();

		node1.setData(data2);
		node2.setData(data1);


	} // end swap() method


	/**
	 * For debugging purposes :)
	 * 
	 * 
	 */
	public String toString() {

		StringBuffer buffer = new StringBuffer();

		buffer.append( String.format( "Size=%d, A = [ ", size ) );

		if ( !isEmpty() ) {

			for ( int i=0; i<size-1; i++ ) {
				buffer.append( String.format( "%d, ", get(i) ) );    
			}

			buffer.append( String.format( "%d ]", get(size-1 ) ) );

		} else {

			buffer.append( "] " );
		}

		return buffer.toString();

	} // end toString()

	/**
	 * For debugging purposes: the sequel :)
	 * 
	 * 
	 */
	public String stringArr() {

		StringBuffer buffer = new StringBuffer();

		buffer.append( String.format( "Size=%d, A = [ ", size ) );

		if ( !isEmpty() ) {

			for ( int i=0; i<size-1; i++ ) {
				buffer.append( String.format( "%s, ", get(i) ) );    
			}

			buffer.append( String.format( "%s ]", get(size-1 ) ) );

		} else {

			buffer.append( "] " );
		}

		return buffer.toString();

	}
	/**
	 * 
	 * @param args
	 */
	public static void main( String[] args ) {

		SinglyLinkedList<Integer> singList = new SinglyLinkedList<Integer>();
		SinglyLinkedList<String> singStrList = new SinglyLinkedList<String>();

		//////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////// SELECTION SORT /////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////////
		System.out.print("|< SELECTION SORT >|\n\n");

		// Test case 1: Sorting with a blank list
		System.out.print("Test Case 1:\n");

		System.out.print(singList.toString()+"\n");
		Utils.selectionSort(singList);
		System.out.print(singList.toString()+"\n\n");

		// Test case 2: Sorting with duplicates
		System.out.print("Test Case 2:\n");

		singList.add(45);
		singList.add(6);
		singList.add(68);
		singList.add(99);
		singList.add(17);
		singList.add(17);
		singList.add(75);
		singList.add(68);
		singList.add(68);
		singList.add(6);

		System.out.print(singList.toString()+"\n");
		Utils.selectionSort(singList);
		System.out.print(singList.toString()+"\n\n");
		
		singList.clear();
		
		// Test case 3: Sorting with no duplicates
		System.out.print("Test Case 3:\n");

		singList.add(45);
		singList.add(6);
		singList.add(68);
		singList.add(99);
		singList.add(-4);
		singList.add(0);
		singList.add(17);
		singList.add(75);
		singList.add(40);
		singList.add(200);
		singList.add(-15);

		System.out.print(singList.toString()+"\n");
		Utils.selectionSort(singList);
		System.out.print(singList.toString()+"\n\n");

		singList.clear();

		// Test case 4: Sorting with no duplicates
		System.out.print("Test Case 4:\n");

		singStrList.add("Sometimes");
		singStrList.add("I");
		singStrList.add("Code");
		singStrList.add("And");
		singStrList.add("Feed");
		singStrList.add("The");
		singStrList.add("Horses");

		System.out.print(singStrList.stringArr()+"\n");
		Utils.selectionSort(singStrList);
		System.out.print(singStrList.stringArr()+"\n\n");

		singStrList.clear();

		//////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////// BUBBLE SORT ////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////////
		System.out.print("|< BUBBLE SORT >|\n\n");

		// Test case 1: Sorting with a blank list
		System.out.print("Test Case 1:\n");

		System.out.print(singList.toString()+"\n");
		Utils.bubbleSort(singList);
		System.out.print(singList.toString()+"\n\n");

		// Test case 2: Sorting with duplicates
		System.out.print("Test Case 2:\n");

		singList.add(30);
		singList.add(6);
		singList.add(-100);
		singList.add(390);
		singList.add(56);
		singList.add(30);
		singList.add(330);
		singList.add(6);
		singList.add(-54);
		singList.add(-100);

		System.out.print(singList.toString()+"\n");
		Utils.bubbleSort(singList);
		System.out.print(singList.toString()+"\n\n");
		
		singList.clear();
		
		// Test case 3: Sorting with no duplicates
		System.out.print("Test Case 3:\n");

		singList.add(30);
		singList.add(6);
		singList.add(-16);
		singList.add(390);
		singList.add(56);
		singList.add(34);
		singList.add(246);
		singList.add(3);
		singList.add(-50);
		singList.add(-99);
		singList.add(73);
		singList.add(-15);

		System.out.print(singList.toString()+"\n");
		Utils.bubbleSort(singList);
		System.out.print(singList.toString()+"\n\n");
		
		singList.clear();
		
		// Test case 4: Sorting with no duplicates
		System.out.print("Test Case 4:\n");

		singStrList.add("But");
		singStrList.add("Wait");
		singStrList.add("I");
		singStrList.add("Don't");
		singStrList.add("Have");
		singStrList.add("A");
		singStrList.add("Horse");

		System.out.print(singStrList.stringArr()+"\n");
		Utils.selectionSort(singStrList);
		System.out.print(singStrList.stringArr()+"\n\n");
		
		singStrList.clear();

		//////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////// INSERTION SORT /////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////////
		System.out.print("|< INSERTION SORT >|\n\n");

		// Test case 1: Sorting with a blank list
		System.out.print("Test Case 1:\n");

		System.out.print(singList.toString()+"\n");
		Utils.bubbleSort(singList);
		System.out.print(singList.toString()+"\n\n");

		// Test case 2: Sorting with duplicates
		System.out.print("Test Case 2:\n");

		singList.add(56);
		singList.add(46);
		singList.add(-10);
		singList.add(370);
		singList.add(44);
		singList.add(66);
		singList.add(370);
		singList.add(-10);
		singList.add(46);
		singList.add(-100);

		System.out.print(singList.toString()+"\n");
		Utils.bubbleSort(singList);
		System.out.print(singList.toString()+"\n\n");
		
		singList.clear();
		
		// Test case 3: Sorting with no duplicates
		System.out.print("Test Case 3:\n");

		singList.add(30);
		singList.add(9);
		singList.add(-56);
		singList.add(870);
		singList.add(99);
		singList.add(-34);
		singList.add(-246);
		singList.add(31);
		singList.add(-50);
		singList.add(-60);
		singList.add(73);
		singList.add(15);

		System.out.print(singList.toString()+"\n");
		Utils.bubbleSort(singList);
		System.out.print(singList.toString()+"\n\n");
		
		singList.clear();

		// Test case 4: Sorting with no duplicates
		System.out.print("Test Case 4:\n");

		singStrList.add("Oh");
		singStrList.add("Wait");
		singStrList.add("It's");
		singStrList.add("A");
		singStrList.add("Mini");
		singStrList.add("Horse");

		System.out.print(singStrList.stringArr()+"\n");
		Utils.selectionSort(singStrList);
		System.out.print(singStrList.stringArr()+"\n\n");

		singStrList.clear();
		
	} // end main() method

} // end SinglyLinkedList class definition