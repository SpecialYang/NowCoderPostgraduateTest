package com.speical.first;

import java.util.Scanner;

/**
 * @author Special
 * @time 2018/02/05 05:28:59
 */
public class Pro194 {
	
	static class BST{
		Node root;
		int size;
		
		class Node{
			int value;
			Node left, right;
			
			public Node(int value) {
				this.value = value;
			}
		}
		
		public void addNode(Node node) {
			if(size == 0) {
				root = node;
			}else {
				Node point = root, parent = root;
				while(point != null) {
					if(node.value == point.value) { return; }
					parent = point;
					if(node.value < point.value) {
						point = point.left;
					}else if(node.value > point.value) {
						point = point.right;
					}
				}
				if(node.value < parent.value) {
					parent.left = node;
				}else {
					parent.right = node;
				}
			}
			size++;
		}
		
		public void preOrder(Node node) {
			if(node != null) {
				System.out.print(node.value + " ");
				preOrder(node.left);
				preOrder(node.right);
			}
		}
		
		public void inOrder(Node node) {
			if(node != null) {
				inOrder(node.left);
				System.out.print(node.value + " ");
				inOrder(node.right);
			}
		}
		
		public void postOrder(Node node) {
			if(node != null) {
				postOrder(node.left);
				postOrder(node.right);
				System.out.print(node.value + " ");
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()) {
			int n = input.nextInt();
			BST bst = new BST();
			while(n-- > 0) {
				bst.addNode(bst.new Node(input.nextInt()));
			}
			bst.preOrder(bst.root);
			System.out.println();
			bst.inOrder(bst.root);
			System.out.println();
			bst.postOrder(bst.root);
			System.out.println();
		}
	}

}
