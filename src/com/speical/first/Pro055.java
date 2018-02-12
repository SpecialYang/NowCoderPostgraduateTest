package com.speical.first;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** 
* 进制转换
* 
* 注意结果要去掉前向0
* 因为从小的进制数转为大进制数时，可能导致很多的前向0
* @author special
* @date 2017年12月29日 下午3:50:35
*/
public class Pro55 {
	
	public static int[] convertToInt(String str){ //转换为整形数组
		int index = 0;
		for(; index < str.length() && str.charAt(index) == '0'; index++);
		int[] result = new int[str.length() - index];
		for(int i = index, j = 0; i < str.length(); i++, j++){
			char ch = str.charAt(i);
			if(ch >= '0' && ch <= '9'){
				result[j] = ch - '0';
			}else if(ch >= 'a' && ch <= 'f'){
				result[j] = ch - 'a' + 10;
			}else{
				result[j] = ch - 'A' + 10;
			}
		}
		return result;
	}
	public static void convert(int[] nums, int n, int m){
		List<Character> reminders = new ArrayList<>();
		for(int i = 0; i < nums.length;){
			int r = 0;
			for(int j = 0; j < nums.length; j++){
				nums[j] += r * n;
				r = nums[j] % m;
				nums[j] /= m;
			}
			reminders.add((char) (r > 9 ? r - 10 + 'A' : r + '0'));
			if(nums[i] == 0){
				i++;
			}
		}
		int index = reminders.size() - 1;
		for(; index >= 0 && reminders.get(index) == '0'; index--);
		for(int i = index; i >= 0; i--){
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
			int[] nums = convertToInt(str);
			convert(nums,n,m);
		}
	}

}
