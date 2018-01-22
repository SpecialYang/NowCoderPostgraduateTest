package com.speical.improve;

import java.util.Scanner;
import java.util.Stack;

/** 
* 大数相除的思想
* @author special
* @date 2017年12月24日 下午10:34:06
*/
public class Pro29Improve1 {
	private static boolean isLetter(char ch){ return ch >= '0' && ch <= '9'; }
	
	/**
	 * 实则是大数相除
	 * 这里好好理解一下， 这个大数相除的代码很简洁
	 * 因为不需要我们用额外的数组去记录商
	 * 而是在本身数组进行记录商，只要当前开始的值在一次求商的过程还是非0
	 * 则下次还要从该位开始进行相除
	 * 
	 * r记录余数
	 * 因为相除可以看做数的最高位大于除数就相除的特性，我们可以内循环模拟这样的过程
	 * 因为每一次余数都是目标数的最低位，所以我们用栈来存储
	 * @param nums
	 * @param m
	 * @param n
	 */
	public static void translate(int[] nums, int m, int n){
		Stack<Character> stack = new Stack<>();
		int r;
		for(int i = 0; i < nums.length;){
			r = 0;
			for(int j = i; j < nums.length; j++){
				nums[j] += r * m;
				r = nums[j] % n;
				nums[j] /= n;
			}
			stack.push((char) (r > 9 ? r - 10 + 'a' : r + '0'));
			while(i < nums.length && nums[i] == 0){
				i++;
			}
		}
		while(stack.peek() == '0') stack.pop();
		while(!stack.isEmpty()){
			System.out.print(stack.pop());
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int m = input.nextInt();
			int n = input.nextInt();
			String str = input.next();
			int[] nums = new int[str.length()];
			for(int i = 0; i < str.length(); i++){
				char ch = str.charAt(i);
				nums[i] = isLetter(ch) ? ch - '0' : ch - 'A' + 10;
			}
			translate(nums,m,n);
		}
	}
}
