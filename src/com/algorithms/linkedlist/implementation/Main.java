package com.algorithms.linkedlist.implementation;

public class Main {

	public static void main(String[] args) {

		//to create a list of 11 integers
		LinkedList list = new LinkedList();

		for (int i = 0; i < args.length; i++) {
	        list.addItem(Integer.valueOf(args[i]));
	    }
		
		//list contents after Add
		list.traverseList(list.head);
		//to find the sum of all items of a list
		int sumOfItems = list.findSum(list.head);
		System.out.println("Sum of all items in the List = "+ sumOfItems);
		//to traverse a list and print all contents.
		System.out.println("List Contents Before Reversal");
		list.traverseList(list.head);
		//Reversal of the list
		list.reverseList(list.head);
		System.out.println("List Contents After Reversal");
		list.traverseList(list.head);
	}
}
