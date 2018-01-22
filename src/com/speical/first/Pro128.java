package com.speical.first;

import java.util.Scanner;

/** 
* A + B
* 
* 哈希思想存储数字对应的单词
* @author special
* @date 2018年1月6日 下午11:56:15
*/
public class Pro128 {
	static String[] map = {"zero","one","two","three","four","five","six","seven","eight","nine"};
	
	public static int indexOf(String str){
		for(int i = 0; i < map.length; i++){
			if(str.equals(map[i])){
				return i;
			}
		}
		return -1;
	}
	public static int[] parseStr(String str){ 
		int[] nums = new int[2];
		int index = 0, start;
		for(int i = 0; i < str.length(); i++){
			char ch = str.charAt(i);
			if(ch == ' ' || ch == '=') continue;
			if(ch == '+') {  //碰到加号，则说明该计算下一个数了
				index++;
			}else{
				start = i;
				while(str.charAt(i) >= 'a' && str.charAt(i) <= 'z'){
					i++;
				}
				nums[index] = nums[index] * 10 + indexOf(str.substring(start, i));
			}
		}
		return nums;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			int[] nums = parseStr(str);
			if(nums[0] == 0 && nums[1] == 0) break;
			System.out.println(nums[0] + nums[1]);
		}
	}

}
