package com.speical.first;

import java.util.Scanner;

/** 
* 二叉树的先序遍历变为中序遍历
* 
* 递归构建
* 递归中序遍历
* @author special
* @date 2017年12月20日 下午1:30:59
*/
public class Pro10 {
	
	static class BinaryTree{
		String str;
		Node root;
		int index;
		
		class Node{
			char value;
			Node left;
			Node right;
			public Node(char value){ this.value = value; }
		}
		
		public BinaryTree(String str){ this.str = str; index = 0; }
		/**
		 * 外部调用这个接口
		 */
		public void build(){
			this.root = buildTree();
		}
		/**
		 * build的私有辅助方法
		 * 注意这里巧妙的递归
		 * @return
		 */
		private Node buildTree(){
			char value = str.charAt(index++);
			if(value == '#') return null;
			Node node = new Node(value);
			node.left = buildTree();
			node.right = buildTree();
			return node;
		}
		
		public void inorderTraveral(Node node){
			if(node != null){
				inorderTraveral(node.left);
				System.out.print(node.value + " ");
				inorderTraveral(node.right);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			BinaryTree bt = new BinaryTree(str);
			bt.build();
			bt.inorderTraveral(bt.root);
			System.out.println();
		}
	}

}

//自己原先写的渣代码
/*
public void buildTree() {
		this.root = new Node(str.charAt(size++));
		buildTree(root);
	}

public void buildTree(Node node){
    if(size >= lengthOfStr) return;
    if(str.charAt(size) != '#'){
        node.left = new Node(str.charAt(size++));
        buildTree(node.left);
    }else
        size++;
    if(str.charAt(size) != '#'){
        node.right = new Node(str.charAt(size++));
        buildTree(node.right);
    }else
        size++;
}*/
