package com.speical.first;

import java.util.Scanner;

/** 
* 剩下几棵树
* 
* 利用计数排序的思想
* 我们首先把所有的存在的数设置0
* 
* 对于给定的区间，把这些数置1
* 我们只需统计最后有多少0既可以了，高潮了，擦
* @author special
* @date 2017年12月23日 下午5:39:02
*/
public class Pro24 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int L = input.nextInt();
			int n = input.nextInt();
			int left,right,sum = L + 1;
			int[] map = new int[L + 1];
			while(n-- > 0){
				left = input.nextInt();
				right = input.nextInt();
				for(int i = left; i <= right; i++){
					if(map[i] == 0){
						sum--;
						map[i] = 1;
					}
				}
			}
			System.out.println(sum);
		}
	}

}
