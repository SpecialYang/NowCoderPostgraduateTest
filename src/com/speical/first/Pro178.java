package com.speical.first;

import java.util.Scanner;

/** 
* 比较奇偶数的个数
* @author special
* @date 2018年2月3日 下午3:31:05
*/
public class Pro178 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt(), num, evenCount = 0, oddCount = 0;
			while(n-- > 0){
				num = input.nextInt();
				if((num & 1) == 1){
					oddCount++;
				}else{
					evenCount++;
				}
			}
			System.out.println(evenCount <= oddCount ? "YES" : "NO");
		}
	}

}
