package com.speical.first;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/** 
* 求两个单词公共后缀开始的索引地址
* 
* 其实就是求两个单链表的交点
* 
* 因为题目是用字符串模拟链表节点的地址
* 所以我们用hashmap来存储所有的节点（因为所有节点的地址都是唯一的）
* 
* 然后遍历第一个链表，把链表1的节点的地址存到hashset中
* 然后我们遍历第二个链表，若在hashset找到有相同的节点地址，那么这就是两链表相交的节点地址
* @author special
* @date 2018年1月5日 下午2:29:46
*/
public class Pro119 {
	
	static class Node{
		char value;
		String nextAddress;
		
		public Node(char value, String nextAddress){
			this.value = value;
			this.nextAddress = nextAddress;
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String start1 = input.next();
			String start2 = input.next();
			int n = input.nextInt();
			String address, value, nextAddress;
			Map<String, Node> nodes = new HashMap<>();
			for(int i = 0; i < n; i++){
				address = input.next();
				value = input.next();
				nextAddress = input.next();
				nodes.put(address, new Node(value.charAt(0), nextAddress));
			}
			Set<String> list1Address = new HashSet<>();
			Node node;
			while(!start1.equals("-1")){
				node = nodes.get(start1);
				list1Address.add(start1);
				start1 = node.nextAddress;
			}
			while(!start2.equals("-1")){
				node = nodes.get(start2);
				if(list1Address.contains(start2)){
					break;
				}
				start2 = node.nextAddress;
			}
			System.out.println(start2.equals("-1") ? "-1" : start2);
		}
	}

}
