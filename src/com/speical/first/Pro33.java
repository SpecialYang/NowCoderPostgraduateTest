package com.speical.first;

import java.util.Arrays;
import java.util.Scanner;

/** 
* 判断是否是一棵树
* 即判断度数是否等于节点数减一
* @author special
* @date 2017年12月25日 上午11:21:00
*/
public class Pro33 {
	static final int MAX = 10000 + 5;
	static boolean[] map = new boolean[MAX]; //记录当前是否被指向
	static boolean[] record = new boolean[MAX]; //记录存在哪些节点
	static boolean flag = true;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int max, count, nodes, k = 0;
		while(input.hasNext()){
			int n = input.nextInt();
			int m = input.nextInt();
			if(n < 0 && m < 0) break;
			Arrays.fill(map, false);
			Arrays.fill(record, false);
			flag = true; //记录是否满足树
			count = 0;   //当前被指向的个数，其实也就是度
			nodes = 0;   //节点个数
			k++;         //当前第几个例子
			max = 0;     //为了减少最后统计map的遍历次数，我们维护一个当前节点的最大值
			while(!(n == 0 && m == 0)){
				record[n] = true;
				record[m] = true;  //记录 m  n  存在
				max = Math.max(Math.max(n,m),max); // 维护最大值
				if(map[m]){ // 判断是否m已被其他所指
					flag = false;
				}
				map[m] = true;  //表明m已被指
				n = input.nextInt();
				m = input.nextInt();
			}
			if(flag){ //如果上诉循环中满足每个节点只能被指一次，那么下面就要判断是否存在一个根节点
				for(int i = 0; i <= max; i++){
					if (map[i]) {
						count++;
					}
					if(record[i]){
						nodes++;
					}
				}
				/**
				 * 我们允许空树的存在，所以要判断在nodes不为0的时候，度数是否等于节点数减一
				 * 因为在一棵树中，树的度数等于边数，而边数等于节点数减一，这就是最小生成树
				 */
				if(nodes != 0 && count != nodes - 1) flag = false;
			}
			System.out.println("Case " + k + " is " + (flag ? "" : "not ") + "a tree.");
		}
	}

}
