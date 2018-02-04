package com.speical.first;

import java.util.Scanner;

/** 
* 又是排名问题
* @author special
* @date 2018年1月29日 上午11:00:44
*/
public class Pro151 {
	
	static class Node{
		String sno;
		int grade;
		
		public Node(String sno, int grade){
			this.sno = sno;
			this.grade = grade;
		}
	}
	private static boolean more(Node node1, Node node2){
		if(node1.grade > node2.grade 
				|| (node1.grade == node2.grade
				&&  node1.sno.compareTo(node2.sno) < 0))
			return true;
		return false;
	}
	public static void insertSort(Node[] nodes, int n){
		for(int i = 1; i < n; i++){
			for(int j = i; j > 0 && more(nodes[j], nodes[j - 1]); j--){
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
			if(n == 0) break;
			int m = input.nextInt();
			int g = input.nextInt();
			
			Node[] nodes = new Node[n];
			int index = 0;
			int[] grades = new int[m];
			for(int i = 0; i < m; i++){
				grades[i] = input.nextInt();
			}
			String sno;
			int count, grade;
			Node node;
			for(int i = 0; i < n; i++){
				grade = 0;
				sno = input.next();
				count = input.nextInt();
				while(count-- > 0){
					grade += grades[input.nextInt() - 1];
				}
			    if(grade >= g){
			    	node = new Node(sno, grade);
			    	nodes[index++] = node;
			    }
			}
			System.out.println(index);
			insertSort(nodes, index);
			for(int i = 0; i < index; i++){
				System.out.println(nodes[i].sno + " " + nodes[i].grade);
			}
		}
	}

}
