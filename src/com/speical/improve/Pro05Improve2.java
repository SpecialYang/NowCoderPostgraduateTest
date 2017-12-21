package com.speical.improve;

import java.util.Scanner;

/** 
* 用一个前缀和代表costs  记录贡献
* @author special
* @date 2017年12月19日 下午2:51:53
*/
public class Pro05Improve2 {
	private static final int[] costs = {
									1,2,3,
									1,2,3,
									1,2,3,
									1,2,3,
									1,2,3,
									1,2,3,4,
									1,2,3,
									1,2,3,4
								};
	private static final int[] key = {
									2,2,2,
									3,3,3,
									4,4,4,
									5,5,5,
									6,6,6,
									7,7,7,7,
									8,8,8,
									9,9,9,9
								};

	public static int getCost(String str) {
		int cost = 0;
		if(str.length() == 0) 
			return 0;
		cost += costs[str.charAt(0) - 'a'];
		char pre,cur;
		pre = str.charAt(0);
		for(int i = 1; i < str.length(); i++){
			cur = str.charAt(i);
			if(key[pre - 'a'] == key[cur - 'a']){
				cost += 2;
			}
			cost += costs[cur - 'a'];
			pre = cur;
		}
		return cost;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			String str = input.nextLine();
			System.out.println(getCost(str));
		}
	}
}
