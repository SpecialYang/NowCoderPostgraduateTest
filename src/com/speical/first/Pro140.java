package com.speical.first;

import java.util.ArrayList;
import java.util.Scanner;

/** 
* 根据分数录取
* 
* 考察编程能力
* 数据结构的灵活使用
* @author special
* @date 2018年1月23日 下午11:19:55
*/
public class Pro140 {
	
	static int[] quatos;
	static ArrayList<ArrayList<Node>> groups;
	static Node[] nodes;
	
	static class Node{
		int sno;
		int GE;
		int GL;
		double FG;
		int[] prefered;
		
		public Node(int sno, int GE, int GL, int[] prefered){
			this.sno = sno;
			this.GE = GE;
			this.GL = GL;
			this.FG = (GE + GL) / 2.0;
			this.prefered = prefered;
		}
	}
	
	public static void BubboSort(){
		for(int i = 0; i < nodes.length - 1; i++){
			for(int j = 0; j < nodes.length - 1 - i; j++){
				if(nodes[j].FG < nodes[j + 1].FG || 
				   nodes[j].FG == nodes[j + 1].FG && nodes[j].GE < nodes[j + 1].GE){
					Node temp = nodes[j];
					nodes[j] = nodes[j + 1];
					nodes[j + 1] = temp;
				}
			}
		}
	}
	
	public static boolean judgeValid(Node node, int school){
		if(quatos[school] > 0) return true;
		for(Node item : groups.get(school)){
			if(item.FG == node.FG && item.GE == node.GE){
				return true;
			}
		}
		return false;
	}
	
	public static void insert(ArrayList<Node> row, Node node){
		int index;
		for(index = row.size() - 1; index >= 0 && row.get(index).sno > node.sno; index--);
		row.add(index + 1, node);
	}
	
	public static void solution(int k){
		int num, count;
		for(int i = 0; i < nodes.length; i++){
			count = 0;
			while(count < k){
				num = nodes[i].prefered[count++];
				if(judgeValid(nodes[i], num)){
					insert(groups.get(num), nodes[i]);
					quatos[num]--;
					break;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int m = input.nextInt();
			int k = input.nextInt();
			quatos = new int[m];
			nodes = new Node[n];
			groups = new ArrayList<ArrayList<Node>>();
			for(int i = 0; i < m; i++){
				quatos[i] = input.nextInt();
				groups.add(new ArrayList<Node>());
			}
			int GE, GL, count;
			for(int i = 0; i < n; i++){
				GE = input.nextInt();
				GL = input.nextInt();
				count = 0;
				int[] prefered = new int[k];
				while(count < k){
					prefered[count++] = input.nextInt();
				}
				nodes[i] = new Node(i, GE, GL, prefered);
			}
			BubboSort();
			solution(k);
			for(ArrayList<Node> item : groups){
				for(int i = 0; i < item.size(); i++){
					System.out.print((i == 0 ? "" : " ") + item.get(i).sno);
				}
				System.out.println();
			}
		}
	}

}
