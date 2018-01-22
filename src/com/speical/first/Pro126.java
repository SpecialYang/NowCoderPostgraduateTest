package com.speical.first;

import java.util.Arrays;
import java.util.Scanner;

/** 
* 游船出租
* 
* 傻逼题目，不解释
* 
* 哈希思想，但是测试用例真的很傻逼啊
* @author special
* @date 2018年1月6日 下午4:12:37
*/
public class Pro126 {
	static Node[] map = new Node[100];
	static int times, count;
	
	static class Node{
		char status;
		int[] time = new int[2];
		
		public Node(char status, String time){
			this.status = status;
			this.time = parseTime(time);
		}
		
		public int add(Node node){
			return (node.time[0] - time[0]) * 60 + (node.time[1] - time[1]);
		}
	}
	
	public static int[] parseTime(String times){
		int[] time = new int[2];
		time[0] = Integer.valueOf(times.substring(0,2));
		time[1] = Integer.valueOf(times.substring(3,5));
		return time;
	}
	
	public static void insert(Node node, int n){
		if(node.status == 'S'){  //如果当前是S直接更新当前船的状态
			map[n] = node;
		}else{
			if(map[n] != null){  //若果当前船是E,且不为空，就计算时间。我第二次都没开始用船，直接还船也可以？
				count++;         //且还船后，还不更新船的状态？？
				times += map[n].add(node);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			if(n == -1) break;
			char status = input.next().charAt(0);
			String time = input.next();
			if(n == 0){
				System.out.println(count + " " + (count == 0 ? 0 : (int)(times / (count * 1.0) + 0.5)));
				Arrays.fill(map, null);
				times = 0;
				count = 0;
			}else{
				Node node = new Node(status, time);
				insert(node, n - 1);
			}
		}
	}

}
