package com.speical.first;

import java.util.Scanner;

/**
 * 输出最小的三个员工
 * 
 * 多关键排序问题（注意的排序算法的选择，稳定排序）
 * 
 * topk问题，如果用堆排序的话，要对最后的三个再用稳定排序排序啊。
 * 
 * 更新：优化了一下多关键判断的写法。。。
 * @author Special
 * @time 2018/02/10 16:43:23
 */
public class Pro216 {
	
	static class Node{
		int eno;
		String name;
		int age;
		
		public Node(int eno, String name, int age) {
			this.eno = eno;
			this.name = name;
			this.age = age;
		}
	}
	
	private static boolean more(Node node1, Node node2) {
//		if(node1.age > node2.age ||(node1.age == node2.age && node1.eno > node2.eno)
//		||(node1.age == node2.age && node1.eno == node2.eno && node1.name.compareTo(node2.name) > 0))
//			return true;
		if(node1.age > node2.age) {
			return true;
		}else if(node1.age == node2.age) {
			if(node1.eno > node2.eno) {
				return true;
			}else if(node1.eno == node2.eno) {
				if(node1.name.compareTo(node2.name) > 0) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void BubboSort(Node[] nodes) {
		for(int i = 0; i < nodes.length - 1; i++) {
			for(int j = 0; j < nodes.length - 1 - i; j++) {
				if(more(nodes[j], nodes[j + 1])) {
					Node temp = nodes[j];
					nodes[j] = nodes[j + 1];
					nodes[j + 1] = temp;
				}
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
				nodes[i] = new Node(input.nextInt(), input.next(), input.nextInt());
			}
			BubboSort(nodes);
			for(int i = 0; i < Math.min(n, 3); i++) {
				System.out.println(nodes[i].eno + " " + nodes[i].name + " " + nodes[i].age);
			}
		}
	}

}
