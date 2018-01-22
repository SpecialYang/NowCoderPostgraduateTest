package com.speical.first;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** 
* 又是进制转换
* 
* 只不过这是16进制转10进制！！
* @author special
* @date 2018年1月1日 下午9:06:23
*/
public class Pro78 {
	static final int SIZE = 16;
	/**
	 * 字符串转换成整形数组
	 * @param str
	 * @return
	 */
	public static int[] convertToInt(String str){
		int[] nums = new int[str.length()];
		for(int i = 0; i < str.length(); i++){
			char ch = str.charAt(i);
			if(ch >= 'A' && ch <= 'F'){
				nums[i] = ch - 'A' + 10;
			}else{
				nums[i] = ch - '0';
			}
		}
		return nums;
	}
	/**
	 * 进制转换
	 * 保留余数即可
	 * @param nums
	 */
	public static void convertToDecimal(int[] nums){
		List<Integer> reminders = new ArrayList<>();
		int r = 0;
		for(int i = 0; i < nums.length;){
			r = 0;
			for(int j = i; j < nums.length; j++){
				nums[j] += r * SIZE;
				r = nums[j] % 10;
				nums[j] /= 10;
			}
			if(nums[i] == 0){
				i++;
			}
			reminders.add(r);
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
			String str = input.nextLine();
			int[] nums = convertToInt(str.substring(2));
			convertToDecimal(nums);
		}
	}

}
