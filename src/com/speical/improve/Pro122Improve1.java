package com.speical.improve;

import java.util.Scanner;
import java.util.Stack;

/** 
* 判断是否是同一颗二叉搜索树
* 
* 思路：
* 根据给定序列建树 + 先序序列化树
* 比较序列化后的树是否一样即可 
* @author special
* @date 2018年1月6日 上午10:49:59
*/
public class Pro122Improve1 {
	
	static class BST{
		Node root;
		String consequence;
		int index;
		
		public BST(String consequence){
			this.consequence = consequence;
		}
		
		public Node build(){
			if(index < consequence.length()){
				root = new Node(consequence.charAt(index++));
			}
			for(int i = index; i < consequence.length(); i++){
				char ch = consequence.charAt(i);
				insert(ch);
			}
			return root;
		}
		
		public void insert(char ch){
			Node cur = root, pre = root;
			while(cur != null){
				pre = cur;
				if(ch > cur.value){
					cur = cur.right;
				}else{
					cur = cur.left;
				}
			}
			Node node = new Node(ch);
			if(ch < pre.value){
				pre.left = node;
			}else{
				pre.right = node;
			}
		}
		/**
		 * 先序序列化树
		 * 非递归实现
		 * @return
		 */
		public String getPreOder(){
			StringBuilder sb = new StringBuilder();
			Stack<Node> stack = new Stack<>();
			stack.push(root);
			while(!stack.isEmpty()){
				Node node = stack.pop();
				if(node != null){
					sb.append(node.value);
				}else{
					sb.append("#");
					continue;
				}
				stack.push(node.right);
				stack.push(node.left);
			}
			return sb.toString();
		}
	}
	static class Node{
		char value;
		Node left;
		Node right;
		
		public Node(char value){
			this.value = value;
		}
	}
	
	public static String getOnlySequence(String input){
		BST bst = new BST(input);
		bst.build();
		return bst.getPreOder();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			if(n == 0) break;
			String originPreOrder = getOnlySequence(input.next()), targetPreOrder;
			for(int i = 0; i < n; i++){
				targetPreOrder = getOnlySequence(input.next());
				System.out.println(originPreOrder.equals(targetPreOrder) ? "YES" : "NO");
			}
		} 
	}

}
