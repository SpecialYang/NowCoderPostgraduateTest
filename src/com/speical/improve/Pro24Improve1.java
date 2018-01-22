package com.speical.improve;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/** 
* 利用set中元素只存在一次的特性
* 
* 我们把每次的区间的所有放到set中
* 
* 最后剩余的树就是总数减去sets的size
* @author special
* @date 2017年12月23日 下午5:46:34
*/
public class Pro24Improve1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int L = input.nextInt();
			int n = input.nextInt();
			int left,right,sum = L + 1;
			Set<Integer> sets = new HashSet<Integer>();
			while(n-- > 0){
				left = input.nextInt();
				right = input.nextInt();
				for(int i = left; i <= right; i++){
					sets.add(i);
				}
			}
			System.out.println(sum - sets.size());
		}
	}

}
