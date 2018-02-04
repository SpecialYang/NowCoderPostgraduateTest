package com.speical.first;

import java.util.Scanner;

/** 
* EXCEL排序
* 
* 多关键字排序问题
* @author special
* @date 2018年1月24日 上午11:33:21
*/
public class Pro142 {
	
	static class Node{
		String sno;
		String name;
		int grade;
		
		public Node(String sno, String name, int grade){
			this.sno = sno;
			this.name = name;
			this.grade = grade;
		}
	}
	
	private static boolean more(Node node1, Node node2, int kind){
		if(kind == 1){
			if(node1.sno.compareTo(node2.sno) < 0){
				return true;
			}
		}else if(kind == 2){
			if(node1.name.compareTo(node2.name) < 0
				|| node1.name.compareTo(node2.name) == 0 
				&& node1.sno.compareTo(node2.sno) < 0)
				return true;
		}else if(kind == 3){
			if(node1.grade < node2.grade
					|| node1.grade == node2.grade
					&& node1.sno.compareTo(node2.sno) < 0)
					return true;
		}
		return false;
	}
	private static void insertSort(Node[] nodes, int kind){
		for(int i = 1; i < nodes.length; i++){
			for(int j = i; j > 0 && more(nodes[j],nodes[j - 1], kind); j--){
				Node temp = nodes[j];
				nodes[j] = nodes[j - 1];
				nodes[j - 1] = temp;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int c = input.nextInt();
			Node[] nodes = new Node[n];
			for(int i = 0; i < n; i++){
				nodes[i] = new Node(input.next(), input.next(), input.nextInt());
			}
			insertSort(nodes, c);
			System.out.println("Case:");
			for(Node item : nodes){
				System.out.println(item.sno + " " + item.name + " " + item.grade);
			}
		}
	}

}
