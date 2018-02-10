package com.speical.first;

import java.util.Scanner;

/**
 * 构建二叉排序树
 * 
 * 注意Java只存在值传递。
 * 递归的时候传递是引用的副本，修改副本的指向并不影响实参
 * @author Special
 * @time 2018/02/10 21:37:55
 */
public class Pro220 {
	
	static class Node{
		int value;
		Node left, right;
		
		public Node(int value) {
			this.value = value;
		}
	}
	
	public static Node insertNode(Node node, int value) {
		if(node == null) {
			node = new Node(value);
		}else {
			if(value < node.value) {
				node.left = insertNode(node.left, value);
			}else if(value > node.value){
				node.right = insertNode(node.right, value);
			}
		}
		return node;
	}
	
	public static void preOrder(Node node) {
		if(node != null) {
			System.out.print(node.value + " ");
			preOrder(node.left);
			preOrder(node.right);
		}
	}
	
	public static void inOrder(Node node) {
		if(node != null) {
			inOrder(node.left);
			System.out.print(node.value + " ");
			inOrder(node.right);
		}
	}
	
	public static void postOrder(Node node) {
		if(node != null) {
			inOrder(node.left);
			inOrder(node.right);
			System.out.print(node.value + " ");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()) {
			int n = input.nextInt();
			Node root = null;
			while(n-- > 0) {
				root = insertNode(root, input.nextInt());
			}
			preOrder(root);
			System.out.println();
			inOrder(root);
			System.out.println();
			postOrder(root);
			System.out.println();
		}
	}

}
