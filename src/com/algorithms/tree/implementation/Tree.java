/**
 * 
 */
package com.algorithms.tree.implementation;


/**
 * @author Rahul
 *
 */
public class Tree {

	Node root;
	
	public Tree(){
		root = null;
	}
	
	public Tree(int data){
		root = new Node();
		root.data = data;
		root.child = null;
		root.sibling = null;
	}
	
	public Node rootNode(){
		return root;
	}
	
	public void preTraverse(Node start){
		Node temp;
		if(start != null){
			System.out.println(start.data);
			preTraverse(start.child);
			temp = start.sibling;
			while (temp != null) {
				preTraverse(temp.child);
				temp = temp.sibling;
			}
		}
	}
	

	public Node findNode(Node start, int key) {

		Node tmp;

		if (start == null) {
			return (start);
		}

		if (start.data == key) {
			return (start);
		}

		tmp = findNode(start.child, key);
		if (tmp == null) {
			//while (n->sibling != NULL) {
			tmp = findNode(start.sibling, key);
			if (tmp != null) {
				//break;
				return (tmp);
			}
			//n = n->sibling;
			//}
		}
		return (tmp);
	}

	public Node insertsibling(Node start, int key) {

		if (start.sibling == null) {
	        Node tmp = new Node();
	        start.sibling = tmp;
	        tmp.data = key;
	        tmp.child = null;
	        tmp.sibling = null;
	        return (tmp);
	    } else {
	        return (insertsibling(start.sibling, key));
	    }
	}
	
	
	public Node insertchild(Node start, int key) {

		if ( start == null ) {
	        Node tmp = new Node();
	        root = tmp;
	        tmp.data = key;
	        tmp.child = null;
	        tmp.sibling = null;
	        return (tmp);
	    }
	    if (start.child == null) {
	        Node tmp = new Node();
	        start.child = tmp;
	        tmp.data = key;
	        tmp.child = null;
	        tmp.sibling = null;
	        return (tmp);
	    } else {
	        return (insertsibling(start.child, key));
	    }
	}

}
