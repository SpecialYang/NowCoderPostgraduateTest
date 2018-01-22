package com.speical.first;

import java.util.Scanner;

/** 
* Fibonacci数列
* 
* @author special
* @date 2018年1月3日 上午11:17:14
*/
public class Pro94 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int pre = 0;
			int cur = 1;
			int n = input.nextInt();
			if(n == 0){
				System.out.println(pre);
			}else if(n == 1){
				System.out.println(cur);
			}else{
				int temp;
				for(int i = 2; i <= n; i++){
					temp = cur;
					cur += pre;
					pre = temp;
				}
				System.out.println(cur);
			}
		}
	}

}
