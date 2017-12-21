package com.speical.first;

import java.util.Scanner;

/** 
* 质因子分解
* 
* 对每个数一直除下去，比如2，之后对下一个数
* 因为我们已经对2除完，所以以后肯定不会碰到2的倍数的值
* @author special
* @date 2017年12月19日 下午3:08:40
*/
public class Pro06 {
	
	public static int getCount(int num){
		int count = 0;
		int temp = num;
		/**
		 * 这个循环其实在处理num中的除了本身的约数
		 */
		for(int i = 2; i <= Math.sqrt(temp); i++){
			while(temp % i == 0){
				temp /= i;
				count++;
			}
			if(temp == 1) break;
		}
		/**
		 * 如果结束循环的时候temp大于1
		 * 说明它本身就是质数，无法分解了
		 */
		if(temp > 1) count++;
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			System.out.println(getCount(n));
		}
	}

}
