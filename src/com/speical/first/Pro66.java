package com.speical.first;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/** 
* 求一个字符串中所有子串出现的次数，且大于1的
* @author special
* @date 2017年12月31日 上午10:02:54
*/
public class Pro66 {
	
	static Map<String, Integer> map;
	
	public static void getCountOfSubStr(String str){
		for(int i = 1; i <= str.length() - 1; i++){      //控制步长，最短为1，最大为原串减一（题目要求出现次数为2）
			for(int j = 0; j <= str.length() - i; j++){ //控制加上步长后最大为字符串长度，防止结尾超限（关键）
				String item = str.substring(j,j + i);
				if(!map.containsKey(item)){
					map.put(item, 1);
				}else{
					map.put(item, map.get(item) + 1);
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			map = new TreeMap<>();
			getCountOfSubStr(str);
			for(String item : map.keySet()){
				if(map.get(item) > 1){
					System.out.println(item + " " + map.get(item));
				}
			}
		}
	}

}
