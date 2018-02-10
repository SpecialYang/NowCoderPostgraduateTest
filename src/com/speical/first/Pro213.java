package com.speical.first;

import java.util.Scanner;

/**
 * @author Special
 * @time 2018/02/10 11:54:33
 */
public class Pro213 {
	
	static class Node{
		int value;
		Node next;
		
		public Node(int value) {
			this.value = value;
		}
	}
	
	public static void insert(Node head, int value) {
		Node p = head, q = head.next;
		while(q != null && value > q.value) {
			p = q;
			q = q.next;
		}
		Node node = new Node(value);
		node.next = q;
		p.next = node;
	}
	
	public static void print(Node head) {
		Node p = head.next;
		boolean flag = false;
		while(p != null) {
			System.out.print((!flag ? "" : " ") + p.value);
			flag = true;
			p = p.next;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()) {
			int n = input.nextInt();
			Node head = new Node(0); //为了插入方便，引入头结点
			for(int i = 0; i < n; i++) {
				insert(head, input.nextInt());
			}
			print(head);
		}
	}

}
