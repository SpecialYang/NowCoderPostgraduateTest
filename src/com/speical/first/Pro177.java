package com.speical.first;

import java.util.Scanner;

/** 
* 堆栈的使用
* 
* 数组模拟即可，因为栈只需要一个栈顶指针即可
* @author special
* @date 2018年2月2日 上午11:53:18
*/
public class Pro177 {
	static int[] nums = new int[10000 + 5];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int top = 0;
			while(n-- > 0){
				char ch = input.next().charAt(0);
				if(ch == 'P'){
					nums[top++] = input.nextInt();
				}else if(ch == 'O'){
					if(top > 0){
						nums[--top] = 0;
					}
				}else if(ch == 'A'){
					System.out.println(top == 0 ? "E" : nums[top - 1]);
				}
			}
			System.out.println();
		}
	}

}
