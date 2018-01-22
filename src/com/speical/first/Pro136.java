package com.speical.first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.naming.directory.SearchControls;

/** 
* 土匪的老大
* 
* 测试用例没问题啊
* 
* 为什么就是过不了！！！
* 
* 
* 在improve中有正确解答
* @author special
* @date 2018年1月8日 下午2:16:08
*/
public class Pro136 {
	static Map<Character, List<Node>> map;
	static boolean[] visited = new boolean[26];
	static int[] countNodes = new int[26];
	static int[] weights = new int[26];
	
	static int n, k, count, number, max, maxIndex;
	
	static class Node{
		char value;
		int weight;
		
		public Node(char value, int weight){
			this.value = value;
			this.weight = weight;
		}
		
		public void add(int weight){
			this.weight += weight;
		}
	}
	
	public static int dfs(char ch){
		int res = 0;
		List<Node> nodes = map.get(ch);
		if(nodes == null) return 0;
		for(int i = 0; i < nodes.size(); i++){
			Node node = nodes.get(i);
			res += node.weight;
			if(!visited[node.value - 'A']){
				count++;
				visited[node.value - 'A'] = true;
				if(weights[node.value - 'A'] > max){
					max = weights[node.value - 'A'];
					maxIndex = node.value - 'A';
				}
				res += dfs(node.value);
			}
		}
		return res;
	}
	
	public static int search(char src, char drc){
		int index = -1;
		List<Node> nodes = map.get(src);
		for(int i = 0; i < nodes.size(); i++){
			if(drc == nodes.get(i).value)
				return i;
		}
		return index;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			n = input.nextInt();
			k = input.nextInt();
			map = new HashMap<>();
			Arrays.fill(visited, false);
			Arrays.fill(countNodes, 0);
			Arrays.fill(weights, 0);
			count = 0;
			number = 0;
			
			char src, drc;
			int weight, total, index;
			for(int i = 0; i < n; i++){
				src = input.next().charAt(0);
				drc = input.next().charAt(0);
				weight = input.nextInt();
				if(!map.containsKey(src)){
					map.put(src, new ArrayList<Node>());
				}
				if((index = search(src, drc)) == -1){
					map.get(src).add(new Node(drc, weight));
				}else{
					map.get(src).get(index).add(weight);
				}
				weights[src - 'A'] += weight;
				weights[drc - 'A'] += weight;
			}
			for(Character item : map.keySet()){
				if(!visited[item - 'A']){
					count = 1;
					max = weights[item - 'A'];
					maxIndex = item - 'A';
					visited[item - 'A'] = true;
					
					total = dfs(item);
					if(total > k && count > 2){
						countNodes[maxIndex] = count;
						number++;
					}
				}
			}
			System.out.println(number);
			StringBuilder sb;
			for(int i = 0; i < 26; i++){
				if(countNodes[i] != 0){
					sb = new StringBuilder();
					sb.append((char)(i + 'A'));
					sb.append((char)(i + 'A'));
					sb.append((char)(i + 'A'));
					System.out.println(sb + " " + countNodes[i]);
				}
			}
		}
	}

}
