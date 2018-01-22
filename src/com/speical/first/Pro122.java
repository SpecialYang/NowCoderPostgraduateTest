package com.speical.first;

import java.util.Scanner;

/** 
* 二叉搜索树
* 
* 思路卡住了
* @author special
* @date 2018年1月6日 上午10:19:58
*/
public class Pro122 {
	static boolean flag;
	public static boolean judge(String str1, String str2, int begin, int end){
		char root = str1.charAt(begin);
		int leftRoot, rightRoot;
		if(begin + 1 < end){
			if(str1.charAt(begin + 1) < root){
				leftRoot = begin + 1;
			}
		}
		for(int i = begin + 1; i < end; i++){
			if(str1.charAt(i) < root){
				leftRoot = i;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			if(n == 0) break;
			String origin = input.nextLine(), target;
			for(int i = 0; i < n; i++){
				flag = true;
				target = input.nextLine();
				judge(origin, target, 0, target.length());
				System.out.println(flag ? "YES" : "NO");
			}
		} 
	}

}
