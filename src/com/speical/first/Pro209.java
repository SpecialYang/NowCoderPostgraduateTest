package com.speical.first;

import java.util.Scanner;

/**
 * 前序中序构建二叉树
 * 
 * 后序遍历
 * 二分法的思想，很优雅的实现
 * @author Special
 * @time 2018/02/09 11:35:18
 */
public class Pro209 {
	static String preStr;
	static String inStr;
	static int index;
	static class Node{
		char value;
		Node left, right;
		
		public Node(char value) {
			this.value = value;
		}
	}
	
	public static Node buildBT(int low, int high) {
		Node node = null;
		if(low <= high) {
			char ch = preStr.charAt(index++);
			node = new Node(ch);
			int point = inStr.indexOf(ch);
			node.left = buildBT(low, point - 1);
			node.right = buildBT(point + 1, high);
		}
		return node;
	}
	
	public static void postOrder(Node node) {
		if(node != null) {
			postOrder(node.left);
			postOrder(node.right);
			System.out.print(node.value);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()) {
			preStr = input.nextLine();
			inStr = input.nextLine();
			Node root = null;
			index = 0;
			root = buildBT(0, preStr.length() - 1);
			postOrder(root);
			System.out.println();
		}
	}

}
