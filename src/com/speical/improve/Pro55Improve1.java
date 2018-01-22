package com.speical.improve;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** 
* 因为题目的数在2的16次方 - 1的范围内，所以就不用大数相除了
* @author special
* @date 2017年12月29日 下午4:45:23
*/
public class Pro55Improve1 {
	public static int convertToInt(String str, int redix){ //转换为整形数组
		int index = 0;
		for(; index < str.length() && str.charAt(index) == '0'; index++);
		int result = 0;
		for(int i = index, j = 0; i < str.length(); i++, j++){
			char ch = str.charAt(i);
			int item = 0;
			if(ch >= '0' && ch <= '9'){
				item = ch - '0';
			}else if(ch >= 'a' && ch <= 'f'){
				item = ch - 'a' + 10;
			}else{
				item = ch - 'A' + 10;
			}
			result = result * redix + item;
		}
		return result;
	}
	public static void convert(int nums, int n, int m){
		List<Character> reminders = new ArrayList<>();
		while(nums > 0){
			int r = nums % m;
			nums /= m;
			reminders.add((char) (r > 9 ? r - 10 + 'A' : r + '0'));
		}
		for(int i = reminders.size() - 1; i >= 0; i--){
			System.out.print(reminders.get(i));
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			String str = input.next();
			int m = input.nextInt();
			int nums = convertToInt(str, n);
			convert(nums,n,m);
		}
	}
}
