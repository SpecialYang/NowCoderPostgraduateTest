package com.speical.improve;

import java.util.Scanner;

/** 
* 利用数组进行优化
* 
* 不过还可以优化啊！！！
* @author special
* @date 2017年12月19日 下午2:26:12
*/
public class Pro05Improve1 {
	private static final int[] ch = new int[26];
	private static final String[] nums = new String[10];
	
	static {
		int value = 0;
		for(int i = 0; i < ch.length;){
			int temp = (i == 'p' - 'a' || i == 'w' - 'a' ? 4 : 3);
			char[] keys = new char[temp];
			for(int j = 0; j < temp; j++){
				ch[i] = value;
				keys[j] = (char) ('a' + (i++));
			}
			nums[value++] = new String(keys);
		}
	}

	public static int getCost(String str) {
		if (str.length() == 0)
			return 0;
		int cost = nums[ch[str.charAt(0) - 'a']].indexOf(str.charAt(0)) + 1;
		for (int i = 1; i < str.length(); i++) {
			char preItem = str.charAt(i - 1);
			char curItem = str.charAt(i);
			if (ch[curItem - 'a'] != ch[preItem - 'a']) {
				cost += nums[ch[curItem - 'a']].indexOf(curItem) + 1;
			} else {
				cost += 2 + nums[ch[curItem - 'a']].indexOf(curItem) + 1;
			}
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
