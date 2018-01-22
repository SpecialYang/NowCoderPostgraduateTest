package com.speical.improve;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


/** 
* 土匪头目
* 
* 其实本题在求各个联通分量
* 然后输出分量的权重和大于给定的门槛，同时节点数大于2
* 
* 我们转换成无向图，同时每条边的权重根据题意知道是累加的
* 
* 且这里还要把字符串与int型对应起来，方便后面的计算
* 否则你连遍历都无法
* 
* 在dfs时，对于有环的遍历，我们为了更简单的遍历，采用每遍历一条边，就把该边删掉
* @author special
* @date 2018年1月8日 下午4:15:50
*/
public class Pro136Improve1 {
	
	static final int SIZE = 2000 + 5;
	static int[][] dis = new int[SIZE][SIZE];
	static boolean[] visited = new boolean[SIZE];
	static int[] countNodes = new int[SIZE];
	static int[] weights = new int[SIZE];
	static Map<String, Integer> names = new TreeMap<>();
	static Map<Integer, String> ids = new HashMap<>();
	
	static int n, k, count, number, max, persons, total;
	
	public static void dfs(int index){
		for(int i = 0; i < persons; i++){
			if(dis[index][i] != 0){
				total += dis[index][i];
				dis[index][i] = dis[i][index] = 0;
				if(!visited[i]){
					visited[i] = true;
					count++;
					if(weights[i] > weights[max]){
						max = i;
					}
					dfs(i);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			n = input.nextInt();
			k = input.nextInt();
			for(int i = 0; i < SIZE; i++){
				Arrays.fill(dis[i], 0);
			}
			Arrays.fill(visited, false);
			Arrays.fill(countNodes, 0);
			Arrays.fill(weights, 0);
			names.clear();
			ids.clear();
			persons = 0;
			count = 0;
			number = 0;
			
			String src, drc; 
			int weight;
			for(int i = 0; i < n; i++){
				src = input.next();
				drc = input.next();
				weight = input.nextInt();
				if(!names.containsKey(src)){
					names.put(src, persons);
					ids.put(persons, src);
				}
				persons++;
				if(!names.containsKey(drc)){
					names.put(drc, persons);
					ids.put(persons, drc);
				}
				persons++;
				dis[names.get(src)][names.get(drc)] += weight;
				dis[names.get(drc)][names.get(src)] += weight;
				weights[names.get(src)] += weight;
				weights[names.get(drc)] += weight;
			}
			for(int i = 0; i < persons; i++){
				if(!visited[i]){
					total = 0;
					count = 1;
					max = i;
					visited[i] = true;
					dfs(i);
					if(total > k && count > 2){
						countNodes[max] = count;
						number++;
					}
				}
			}
			System.out.println(number);
			/**
			 * 记住最后是按字典序输出的，坑死了我了，调了快一下午！
			 */
			for(String item : names.keySet()){
				if(countNodes[names.get(item)] != 0)
				System.out.println(item + " " + countNodes[names.get(item)]);
			}
		}
	}

}
