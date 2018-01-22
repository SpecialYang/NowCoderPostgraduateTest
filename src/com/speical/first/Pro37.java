package com.speical.first;

import java.util.Scanner;

/** 
* 傻逼题目不解释
* 需求不明确,一个小坑调试了1个小时，好气
* 第一个坑：初始数据可能为奇数，但是不补充
* 第二个坑：给一半糖果时，注意如果本身自己是奇数的话，给别人是 n / 2
* 但是多出来的奇数是要留给自己的，具体看你的实现方式
* 有的人实现方式可能就不用这么考虑就过了
* 而我的确不行，比如我在更新自己的糖果时
* candies[i] = (candies[i]) / 2 + half;
* 这样就错了，因为我忘了当奇数时，那个多出来的1我自身还要呢
* 所以更新为 candies[i] = (candies[i] + 1) / 2 + half就对了
* @author special
* @date 2017年12月26日 下午7:44:43
*/
public class Pro37 {
	
	public static boolean isAllSame(int[] candies){
		for(int i = 0; i < candies.length - 1; i++){
			if(candies[i] != candies[i + 1])
				return false;
		}
		return true;
	}
	
	public static void solution(int[] candies, int n){
		int times = 0;
		int half,temp;
		while(!isAllSame(candies)){
			times++;
			half = candies[n - 1] / 2;
			for(int i = 0; i < n; i++){
				temp = candies[i];
				candies[i] = (candies[i] + 1) / 2 + half;
				half = temp / 2;
				candies[i] += (candies[i] & 1) == 1 ? 1 : 0;
			}
		}
		System.out.println(times + " " + candies[0]);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			if(n == 0) break;
			int[] candies = new int[n];
			for(int i = 0; i < n; i++){
				candies[i] = input.nextInt();
			}
			solution(candies,n);
		}
	}

}
