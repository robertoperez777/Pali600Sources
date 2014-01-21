/**
 * 
 */
package com.p92.javacourse.javaplay.arrays;

/**
 * A quick sort implementaion
 * @author BagyuraI
 */
public class QuickSort 
{

	public static void sort( String[] a )
	{
		if ( a == null || a.length == 0 )
			return ;
		
		quickSort( a , 0 , a.length -1 );
	}
	
	private static void quickSort( String[] a, int startIdx, int endIdx )
	{
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		

	}

}
