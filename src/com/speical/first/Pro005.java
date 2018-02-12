package com.speical.first;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/** 
*
* @author special
* @date 2017年12月19日 下午1:58:46
*/
public class Pro05 {
	private static final Map<Character,Integer> map 
							= new HashMap<Character,Integer>();
	private static final String[] nums = new String[10];
	static{
		map.put('a',2);
		map.put('b',2);
		map.put('c',2);
		map.put('d',3);
		map.put('e',3);
		map.put('f',3);
		map.put('g',4);
		map.put('h',4);
		map.put('i',4);
		map.put('j',5);
		map.put('k',5);
		map.put('l',5);
		map.put('m',6);
		map.put('n',6);
		map.put('o',6);
		map.put('p',7);
		map.put('q',7);
		map.put('r',7);
		map.put('s',7);
		map.put('t',8);
		map.put('u',8);
		map.put('v',8);
		map.put('w',9);
		map.put('x',9);
		map.put('y',9);
		map.put('z',9);
		nums[2] = "abc";
		nums[3] = "def";
		nums[4] = "ghi";
		nums[5] = "jkl";
		nums[6] = "mno";
		nums[7] = "pqrs";
		nums[8] = "tuv";
		nums[9] = "wxyz";
	}
	
	public static int getCost(String str){
		if(str.length() == 0) return 0;
		int cost = nums[map.get(str.charAt(0))].indexOf(str.charAt(0)) + 1;
		for(int i = 1; i < str.length(); i++){
			char preItem = str.charAt(i - 1);
			char curItem = str.charAt(i);
			if(map.get(curItem) != map.get(preItem)){
				cost += nums[map.get(curItem)].indexOf(curItem) + 1;
			}else if(map.get(curItem) == map.get(preItem)){
				cost += 2 + nums[map.get(curItem)].indexOf(curItem) + 1;
			}
		}
		return cost;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			System.out.println(getCost(str));
		}
	}

}
