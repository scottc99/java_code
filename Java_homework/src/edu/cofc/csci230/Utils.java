package edu.cofc.csci230;

/**
 * Utilities class that will sort (in increasing order)
 * the elements of a list.
 *
 * The sorting algorithms supported in this class are:
 *	1. selection sort
 *	2. bubble sort
 *	3. insertion sort
 * 
 * @author CSCI 230: Data Structures and Algorithms Fall 2017
 *
 */
public class Utils {
	
	/**
	 * 
	 */
	private Utils() {
		
	} // end private constructor
	
	/**
	 * 
	 * @param list
	 */
	public static <AnyType extends Comparable> void selectionSort( List<AnyType> list ) throws IndexOutOfBoundsException {
		
		int size = list.size();
		for(int i=0; i<size-1; i++) {
			int min = i;
			for(int j=i+1; j<size; j++) {
				int result = list.get(j).compareTo(list.get(min));
				if(result<0) {
					min = j;
				}
			}
			list.swap(i, min);
		}
		
		
		
	} // end selectionSort() method
	
	/**
	 * 
	 * @param list
	 */
	public static <AnyType extends Comparable> void bubbleSort( List<AnyType> list ) throws IndexOutOfBoundsException {
		
		int size = list.size();
		for(int i=0; i<size-1; i++) {
			for(int j=0; j<size-1-i; j++) {
				int result = list.get(j+1).compareTo(list.get(j));
				if(result<0) {
					list.swap(j, j+1);
				}
			}
		}
		
		
		
	} // end bubbleSort() method
	
	/**
	 * 
	 * @param list
	 */
	public static <AnyType extends Comparable> void insertionSort( List<AnyType> list ) throws IndexOutOfBoundsException {
		
		int size = list.size();
		for(int i=1; i<size-1; i++) {
			int j = i-1;
			AnyType temp = list.get(i);
			while(j>=0 && temp.compareTo(list.get(j))<0) {
				list.set(j+1, list.get(j));
				j = j-1;
			}
			list.set(j+1, temp);
		}
		
		
		
	} // end insertionSort() method
	
} // end Utils class definition
