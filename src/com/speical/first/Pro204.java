package com.speical.first;

import java.util.Scanner;

/**
 * 二叉排序树
 * @author Special
 * @time 2018/02/09 09:10:22
 */
public class Pro204 {
	
	static class Node{
		int value;
		Node left, right;
		
		public Node(int value) {
			this.value = value;
		}
	}
	
	public static void insertNode(Node node, int value) {
		if(value < node.value) {
			if(node.left != null) {
				insertNode(node.left, value);
			}else {
				node.left = new Node(value);
				System.out.println(node.value);
			}
		}else if(value > node.value) {
			if(node.right != null) {
				insertNode(node.right, value);
			}else {
				node.right = new Node(value);
				System.out.println(node.value);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()) {
			int n = input.nextInt();
			Node root = null;
			if(n-- > 0) {
				root = new Node(input.nextInt());
				System.out.println("-1");
				while(n-- > 0) {
					insertNode(root, input.nextInt());
				}
			}
		}
	}

}
