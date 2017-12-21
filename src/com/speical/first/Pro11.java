package com.speical.first;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

/** 
* �����˵�����
* 
* ������һ�����Ǳ�����
* һ����dfs��bfs
* 
* bfs��������һ��·������̵Ĳ���������̳���
* ��������ֻ��������ٵĲ����Ϳ�����
* 
* dfs���������ռ��е�һ����Ϳ�����
* �����������ѣ����ݼ��ξͿ����ˣ������ϱȹ��ѿ�һ��
* @author special
* @date 2017��12��21�� ����1:25:40
*/
public class Pro11 {
	private static final String mapStr = "2012";
	
	static class Node{
		String str;
		int steps;
		public Node(String str, int steps){
			this.str = str;
			this.steps = steps;
		}
	}
	
	private static boolean isContains(String nums){
		int index;
		for(int i = 0; i < nums.length() - 3; i++){
			index = 0;
			while(nums.charAt(i) == mapStr.charAt(index)){
				i++;
				index++;
				if(index == 4) return true;
			}
		}
		return false;
	}
	private static void swap(char[] chars, int i, int j){
		char ch = chars[i];
		chars[i] = chars[j];
		chars[j] = ch;
	}
	/**
	 * bfs�����ģ��
	 * @param n
	 * @param str
	 * @return
	 */
	private static int bfs(int n, String str){
		if(n < 4) return -1;
		Set<String> set = new HashSet<>();
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(str,0));
		set.add(str);
		while(!queue.isEmpty()){
			Node node = queue.remove();
			if(isContains(node.str)){
				return node.steps;
			}
			for(int i = 0; i < n - 1; i++){
				char[] temp = node.str.toCharArray();
				swap(temp,i,i + 1);
				String tempStr = new String(temp);
				if(!set.contains(tempStr)){
					queue.offer(new Node(tempStr,node.steps + 1));
					set.add(tempStr);
				}
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			String nums = input.next();
			int minCount = bfs(n,nums);
			System.out.println(minCount);
		}
	}

}
