package com.speical.first;

import java.util.Scanner;

/**
 * 成绩排序
 * 又是多关键字排序
 * @author Special
 * @time 2018/02/10 11:33:23
 */
public class Pro212 {
	
	static class Node{
		String name;
		int age;
		int grade;
		
		public Node(String name, int age, int grade) {
			this.name = name;
			this.age = age;
			this.grade = grade;
		}
	}
	public static boolean less(Node node1, Node node2) {
		if(node1.grade < node2.grade 
		|| node1.grade == node2.grade && node1.name.compareTo(node2.name) < 0
		|| node1.grade == node2.grade && node1.name.compareTo(node2.name) == 0 && node1.age < node2.age) {
			return true;
		}
		return false;
	}
		
	public static void insertSort(Node[] nodes) {
		for(int i = 1; i < nodes.length; i++) {
			for(int j = i; j > 0 && less(nodes[j], nodes[j - 1]); j--) {
				Node temp = nodes[j];
				nodes[j] = nodes[j - 1];
				nodes[j - 1] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()) {
			int n = input.nextInt();
			Node[] nodes = new Node[n];
			for(int i = 0; i < n; i++) {
				nodes[i] = new Node(input.next(), 
						input.nextInt(), input.nextInt());
			}
			insertSort(nodes);
			for(int i = 0; i < n; i++) {
				System.out.println(nodes[i].name + " " + nodes[i].age + " " + nodes[i].grade);
			}
		}
	}

}
