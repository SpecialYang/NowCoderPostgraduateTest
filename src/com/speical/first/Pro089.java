package com.speical.first;

import java.util.Scanner;

/** 
* 字符串匹配问题
* 
* 求出模式串p在字符串T出现的总次数（也就是能够移动多少次且都能匹配成功）
* 
* 最优的应该是KMP算法
* @author special
* @date 2018年1月2日 下午2:50:52
*/
public class Pro089 {
	
	public static int getNumOfShift(String text, String pattern){
		int count = 0, index;
		for(int i = 0; i <= text.length() - pattern.length(); i++){
			index = i;
			for(int j = 0; j < pattern.length(); j++, index++){
				if(text.charAt(index) != pattern.charAt(j)){
					break;
				}
			}
			if(index - i == pattern.length()) count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String text = input.next();
			String pattern = input.next();
			System.out.println(getNumOfShift(text,pattern));
		}
	}

}
