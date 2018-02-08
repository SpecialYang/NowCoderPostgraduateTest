package com.speical.first;

import java.util.Scanner;

/**
 * 复数集合
 * 
 * 用到了数组模拟优先队列 + 插入排序的思想
 * @author Special
 * @time 2018/02/05 04:54:29
 */
public class Pro193 {
	static Node[] nodes = new Node[1000 + 5];
	
	static class Node{
		int a;
		int b;
		int model;
		
		public Node(int a, int b) {
			this.a = a;
			this.b = b;
			this.model = (int) Math.sqrt(a * a + b * b);
		}
	}
	
	public static void insertSort(Node[] nodes, int end) {
		for(int i = end; i > 0 && (nodes[i].model < nodes[i - 1].model 
					|| (nodes[i].model == nodes[i - 1].model && nodes[i].b > nodes[i - 1].b)); i--){
			Node temp = nodes[i];
			nodes[i] = nodes[i - 1];
			nodes[i - 1] = temp;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()) {
			int n = input.nextInt();
			input.nextLine();
			int index = 0;
			while(n-- > 0) {
				String command = input.nextLine();
				if(command.charAt(0) == 'P') {
					if(index == 0) {
						System.out.println("empty");
					}else {
						index--;
						System.out.println(nodes[index].a + "+i" 
									   + nodes[index].b);
						nodes[index] = null;
						System.out.println("SIZE = " + index);
					}
				}else if(command.charAt(0) == 'I') {
					int i, num, a = 0, b = 0;
					boolean flag = false;
					for(i = 0; i < command.length() && command.charAt(i) != ' '; i++);
					for(++i; i < command.length(); i++) {
						num = 0;
						while(i < command.length() && 
								command.charAt(i) >= '0' && command.charAt(i) <= '9') {
							num = num * 10 + (command.charAt(i++) - '0');

						}
						if(!flag) {
							a = num;
							flag = true;
						}else {
							b = num;
						}
					}
					nodes[index++] = new Node(a, b);
					insertSort(nodes, index - 1);
					System.out.println("SIZE = " + index);
				}
			}
		}
		input.close();
	}	

}
