package com.speical.first;

import java.util.Scanner;

/** 
* 完全二叉树 子树的节点数
* @author special
* @date 2018年1月2日 上午11:10:50
*/
public class Pro83 {
	public static int getNodes(int m, int n){
		int count = 0, temp = m;
		int digit = 1;
		int high = 1;
		while(temp <= n){
			count += digit << (high - 1);
			temp = temp * 2 + 1;
			high++;
		}
		temp = temp - (digit << (high - 1)) + 1;
		while(temp <= n){
			count++;
			temp++;
		}
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int m = input.nextInt();
			int n = input.nextInt();
			if(n == 0 && m == 0) break;
			System.out.println(getNodes(m,n));
		}
	}

}
