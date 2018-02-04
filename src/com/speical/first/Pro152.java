package com.speical.first;

import java.util.Scanner;
/** 
* 加油站问题
* 
* 这不能用背包来做，因为情况非常复杂
* 因为到每个加油站的状态并不是固定，因为不是每次都到加油不是把油正好加到下一个加油站
* 所以我们采用贪心的做法
* 情况如下：
* 1.刚开始，我们的车没油，所以要找0距离油价最少的那一个
* 2.然后考察车的最大距离里的所有加油站，看看是否有比当前油价少的加油站
* 	1.若有，我们只需加油加到正好到该加油站即可，因为之后的距离我想用便宜的油价
*   2.若没有，我们只能在找到最大距离内大于当前油价最小的那一个即可，但是此时我们要
*   把油加满，因为当前油价便宜啊，加满之后，到大于当前油价最小的那一个的加油站时，继续考察
*   到的那个加油站即可。之后我们要再次根据距离，补充油（注意此时油箱是有油的，上次油价便宜）。
*   
* 以上在油价时，我们用leftdis表示油箱中剩余的油能走的距离，所以在根据距离算钱，要减去该距离
* @author special
* @date 2018年1月29日 上午11:40:18
*/
public class Pro152 {
	
	static double Cmax, D, Davg, onceMaxDis;
	static int N;
	static final double MIN = Double.MAX_VALUE;
	
	static class Node{
		double price;
		double dis;
		
		public Node(double price, double dis){
			this.price = price;
			this.dis = dis;
		}
	}
	private static boolean less(Node node1, Node node2){
		if(node1.dis < node2.dis || node1.dis == node2.dis
				                 && node1.price < node2.price){
			return true;
		}
		return false;
	}
	
	public static void insertSort(Node[] nodes, int n){
		for(int i = 1; i < n; i++){
			for(int j = i; j > 0 && less(nodes[j], nodes[j - 1]); j--){
				Node temp = nodes[j];
				nodes[j] = nodes[j - 1];
				nodes[j - 1] = temp;
			}
		}
	}
	
	public static void solution(Node[] nodes){
		boolean flag = true;
		int index = 0;
		double nowPerPrice, nowDis = 0, maxDis, totalPrice = 0, 
			   leftDis = 0, minPrice = MIN, minDis = 0;
		while(nodes[index].dis == 0){  //找0距离的最小的油价的加油站
			minPrice = Math.min(minPrice, nodes[index].price);
			index++;
		}
		if(index == 0){ //若没有，说明没法走
			flag = false;
		}else{
			nowPerPrice = minPrice;  //更新当前的油价
			boolean isShorter = false; //是否存在比当前油价小的加油站
			while(nowDis < D){
				maxDis = nowDis + onceMaxDis; //当前能到的最大位置
				minPrice = MIN; 
				minDis = 0;
				isShorter = false;
				for(int i = index; i <= N && nodes[i].dis <= maxDis; i++){
					if(nodes[i].dis == nowDis) continue;
					if(nodes[i].price < nowPerPrice){  //因为我们排序的缘故，保证了大于当前位置的第一个加油站必是同位置的最小的
						totalPrice += nowPerPrice * (nodes[i].dis - nowDis - leftDis) / Davg; //注意要减去油箱中剩余的油
						nowPerPrice = nodes[i].price;
						nowDis = nodes[i].dis;
						leftDis = 0;
						isShorter = true;
						index = i;
						break; //直接跳出即可，同位置之后的油价肯定是大于等于当前的
					}
					if(nodes[i].price < minPrice){ //我们还要记录最大距离的最小的油价，万一我们找不到更实惠，就可以将就一下
						minPrice = nodes[i].price;
						minDis = nodes[i].dis;
						index = i;
					}
				}
				if(!isShorter){ // 真没有比当前更实惠的
					if(minPrice == MIN){ //油价还是天价，说明我们的车不行，跑不到加油站
						nowDis += onceMaxDis; //在当前的加油站，加满，跑完得了，因为车不行
						flag = false;
						break;
					}else{
						totalPrice += nowPerPrice * (onceMaxDis - leftDis) / Davg; //否则就是我们加满油，跑到还可以接受的加油站
						leftDis = onceMaxDis - (minDis - nowDis); //跑到那里之后，我们会剩余多少油
						nowDis = minDis;
						nowPerPrice = minPrice;
					}
				}
			}
		}
		if(flag){
			System.out.format("%.2f\n", totalPrice);
		}else{
			System.out.format("The maximum travel distance = %.2f\n", nowDis);
		}
	}
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			Cmax = input.nextDouble();
			D = input.nextDouble();
			Davg = input.nextDouble();
			N = input.nextInt();
			
			Node[] nodes = new Node[N + 1];
			onceMaxDis = Cmax * Davg;  //油箱满的时候，走的最大距离
			
			for(int i = 0; i < N; i++){
				nodes[i] = new Node(input.nextDouble(), input.nextDouble());
			}
			nodes[N] = new Node(0, D);
			insertSort(nodes, N + 1); // 插入排序，为了减少内循环的次数
			solution(nodes);
		}
	}
}
