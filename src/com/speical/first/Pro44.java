package com.speical.first;

import java.util.Scanner;

/** 
* Skew数
* 
* 思想其实来源于快速幂的求法
* 只不过这里二进制位数已经给你了
* 
* 还可以优化啊，这次我们从高位开始，每次乘以的数是(1 << n - 1)
* @author special
* @date 2017年12月27日 下午2:50:37
*/
public class Pro44 {
	public static int getSkewBinary(String str){
		int digit = 2;
		int result = 0;
		for(int i = str.length() - 1; i >= 0; i--){
			if(str.charAt(i) != '0'){
				result += (str.charAt(i) - '0') * (digit - 1);
			}
			digit <<= 1; //保留状态
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			System.out.println(getSkewBinary(str));
		}
	}

}
