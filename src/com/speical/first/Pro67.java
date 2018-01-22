package com.speical.first;

import java.util.Scanner;

/**  
* 四舍五入问题
* 
* 如果舍的是小数点是3位
* 那么我们可以先将结果乘以100化为整数，然后再除以100
* 若原结果 减去 新结果 大于0.005，那么进位！
* @author special
* @date 2017年12月31日 上午10:20:36
*/
public class Pro67 {
	
	static final int SIZE = 12;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			double result = 0;
			for(int i = 0; i < SIZE; i++){
				result += input.nextDouble();
			}
			double temp1 = result / SIZE;
			int temp2 = (int)(temp1 * 100);
			result = temp2 / 100.0;
			if(temp1 - result > 0.005){
				System.out.format("$%.2f\n", result + 0.01);
			}else{
				System.out.format("$%.2f\n", result);
			}
		}
	}

}
