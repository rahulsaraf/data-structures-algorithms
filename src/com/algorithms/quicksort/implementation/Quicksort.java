/**
 * 
 */
package com.algorithms.quicksort.implementation;

/**
 * @author Rahul
 *
 */
public class Quicksort {

	/**
	 * @param args
	 */
	
	int[] array;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] inputArray = {30,12,65,76,56,77,1,2,3,4,54,89,9,10,34,71,29,43,30,43};
		
		System.out.println("Before QuickSort");
		for (int i : inputArray) {
			System.out.print(i + ", ");
		}
		System.out.println(" ");
		quickSort(inputArray, 0, inputArray.length -1);
		
		System.out.println("After QuickSort");
		for (int i : inputArray) {
			System.out.print(i + ", ");
		}
		
		
	}

	public static int[] quickSort(int[] a,int start, int stop){
		
		
		int pivotPlace = start;
		int temp;
		boolean swap = true;
		int count = 0;
		while(swap){
			swap = false;
			for (int i = start; i <= stop; i++) {
				if(a[pivotPlace] > a[i] && pivotPlace < i){
					temp = a[i];
					a[i] = a[pivotPlace];
					a[pivotPlace] = temp;
					pivotPlace = i;
					swap = true;
				}else if(a[pivotPlace] < a[i] && pivotPlace > i){
					temp = a[i];
					a[i] = a[pivotPlace];
					a[pivotPlace] = temp;
					pivotPlace = i;
					swap = true;
				}
				count++;
			}
		}
		
		if(count == 0 || count == 1){
			return a;
		}
		
		quickSort(a,start,pivotPlace-1);
		quickSort(a,pivotPlace+1,stop);
		
		return a;
		
		
	}
	
}
