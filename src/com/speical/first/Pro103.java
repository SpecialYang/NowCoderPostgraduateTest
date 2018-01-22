package com.speical.first;

import java.util.Scanner;

/** 
* 给定n，a求最大的k，使n！可以被a^k整除但不能被a^(k+1)整除。
* 
* 大数阶乘 + 大数除法问题
* 大数阶乘思路：申请一个10000位的数组来存放阶乘的结果
* 其中数的低位对应数组的低位，且每一位最大值为9999
* 也就是说阶乘结果以10000为单位进行分块存储
* 然后对于n的阶乘结果，就是乘以上一次的阶乘的结果（n-1的阶乘）中每一项即可
* 对乘以每一项的结果对10000进行进位或取模，模拟真实的乘法就可以
* 
* result = 0(整除的次数)
* 大数除法思路：对上一步得到的阶乘结果从高位的每一项开始除以a
* 模拟真实的除法的就可以。每一项当前的值为本身 + 余数 * 10000
* 然后再次更新余数和当前项的值（其实就是保存为商）
* 如果除完了每一项，余数为0,那么继续以当前的商为被除数来除以a，且result++;
* 直到r不为0，结束, 返回result
* @author special
* @date 2018年1月4日 下午1:35:33
*/
public class Pro103 {
	static final int SIZE = 10000;
	static int factoryIndex, divisorIndex;
	
	public static int[] getFactory(int n){
		int[] factory = new int[10000];
		int temp, carry;
		factory[factoryIndex++] = 1;
		for(int i = 2; i <= n; i++){
			carry = 0;
			for(int j = 0; j < factoryIndex; j++){
				temp = factory[j] * i + carry;
				carry = temp / SIZE;
				factory[j] = temp % SIZE;
			}
			if(carry > 0) factory[factoryIndex++] = carry;
		}
		return factory;
	}
	
	public static int getPowerNum(int[] factory, int a){
		int r = 0, k = 0;
		for(int i = factoryIndex - 1; i >= 0;){
			r = 0;
			for(int j = i; j >= 0; j--){ 
				factory[j] += r * SIZE;
				r = factory[j] % a;
				factory[j] /= a;
			}
			if(r != 0) break;
			k++;
			if(factory[i] == 0) i--;
		}
		return k;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int a = input.nextInt();
			factoryIndex = 0;
			divisorIndex = 0;
			int[] factory = getFactory(n);
			System.out.println(getPowerNum(factory, a));
		}
	}

}
