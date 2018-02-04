package com.speical.first;

import java.util.Scanner;

/** 
* 怪异的洗牌
* 
* 考察字符串的移位，翻转操作
* 字符串的移位实现方法有技巧，比如第4位应该在首位，前面4位应该在末尾：
* 1.首先对[0,4)字符串翻转
* 2.对[4, str.length)字符串翻转
* 3.最后对字符串整体翻转
* 
* @author special
* @date 2018年2月1日 上午11:01:23
*/
public class Pro171 {
	
	/**
	 * 字符串的翻转
	 * @param nums
	 * @param low 待翻转的字符串的开始索引
	 * @param high 待翻转的字符串的末尾索引+1，带翻转字符串的长度等于high - low
	 *             这样做的好处可以在控制循环条件时方便一点
	 */
	private static void reverse(int[] nums, int low, int high){
		int temp;
		for(int i = low; i < (low + high) / 2; i++){
			temp = nums[i];
			nums[i] = nums[high - 1 - (i - low)];
			nums[high - 1 - (i - low)] = temp;
		}
	}
	
	public static void shift(int[] nums, int x){
		reverse(nums, 0, x);
		reverse(nums, x, nums.length);
		reverse(nums, 0, nums.length);
	}
	
	public static void flip(int[] nums, int half){
		reverse(nums, 0, half);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int[] nums = new int[n];
			for(int i = 0; i < n; i++){
				nums[i] = i + 1;
			}
			int k = input.nextInt(), x;
			while(k-- > 0){
				x = input.nextInt();
				shift(nums, x);
				flip(nums, n / 2);
			}
			for(int i = 0; i < n; i++){
				System.out.print((i == 0 ? "" : " ") + nums[i]);
			}
			System.out.println();
		}
	}

}
