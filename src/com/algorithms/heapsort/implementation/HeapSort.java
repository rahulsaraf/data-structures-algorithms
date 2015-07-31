/**
 * 
 */
package com.algorithms.heapsort.implementation;

/**
 * @author Rahul
 *
 */
public class HeapSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//input array
		int [] inputArray = {7,45,98,5,10,67,87,5,6,4,98,12,49,75,34,54,40,117,1,0};
		System.out.println("Before Sorting");
		for (int i : inputArray) {
			System.out.print(i + ", ");
		}
		System.out.println(" ");
		//heapsort
		heapSort(inputArray);
		System.out.println("After Sorting");
		for (int i : inputArray) {
			System.out.print(i + ", ");
		}
	}

	private static void heapSort(int[] a) {
		heapify(a);
		//after heapify, swap and maxheap to get the array in ascending order.
		for (int i = a.length - 1; i > 0 ; i--) {
			swap(a, 0, i);
			maxHeap(a, 0, i);
		}	
	}

	//heapify method, this is responsible for heapify the array
	private static void heapify(int[] a) {
	
		int pIndex=0, lChild, rChild;
		//this is to get the parent of the last node.
		for (int i = 0; i < a.length; i++) {
			pIndex = i;
			lChild = 2*i + 1;
			rChild = 2*i + 2;
			if(lChild >= a.length && rChild >= a.length){
				break;
			}
		}
		pIndex = pIndex - 1;
		//To get the max element on the root. get Maxheap.
		for (int i = pIndex; i >= 0; i--) {
			maxHeap(a, i,a.length);
		}
	}

	private static void maxHeap(int[] a, int i, int limit) {
		int lChild;
		int rChild;
		lChild = 2*i + 1;
		rChild = 2*i + 2;
		
		//end condition
		if(lChild >= a.length && rChild >= a.length){
			return;
		}
		
		//for the last swap.
		if(rChild >= limit ){
			if(limit == 1){
				swap(a, i, lChild);
			}
			return;
		}
		//if left child is greater, then swap parent with left child
		if(a[lChild] >= a[i] && a[lChild] >= a[rChild]){
			swap(a, i, lChild);
			maxHeap(a,lChild,limit);
		//if right child is greater, then swap parent with right child
		}else if(a[rChild] >= a[i] && a[rChild] >= a[lChild]){
			swap(a, i, rChild);
			maxHeap(a,rChild,limit);
		}
	}

	private static void swap(int[] a, int i, int child) {
		int temp;
		temp = a[i];
		a[i] = a[child];
		a[child] = temp;
	}
}
