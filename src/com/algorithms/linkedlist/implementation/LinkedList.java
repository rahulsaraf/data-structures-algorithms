/**
 * 
 */
package com.algorithms.linkedlist.implementation;

/**
 * @author Rahul
 *
 */
public class LinkedList {

	//head of the linked list.. starts from this pointer
	Node head;
	public void addItem(int data){
		
		//if head is null insert the first item here, and assign it to head..
		if(head == null){
			head = new Node(data);
		}else{
			Node p = head;
			while(p.next != null){
			p=p.next;
			}
			p.next = new Node(data);
		}
	}
	
	//this function reverses the linked list
	public Node reverseList(Node p) {
			if(head == null){
				return null;
			}
			//make the last node as head
			if(p.next == null){
				head.next = null;
				head = p;
				return p;
			}
			//traverse to the last node, then reverse the pointers by assigning the 2nd last node to last node and so on..
			return reverseList(p.next).next = p;
			}
	
	//this function calculates the sum of all numbers present in the list
	public int findSum(Node node){
		if(node == null){
			return 0;
		}else{
			return node.data + findSum(node.next);		
		}
	}
	
	//this function traverses the list and print each item value
	public void traverseList(Node p){
		if(head == null){
			System.out.println("List is Empty");
		}else{
			System.out.print("List Contents: " );
			while(p != null){
				if(p.next == null){
					System.out.println(p.data + " ");		
				}else{
					System.out.print(p.data+", " );		
				}
			p=p.next;
			}
		}
	}
}
