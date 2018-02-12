package com.speical.first;

import java.util.Scanner;

/** 
* 四则运算
* 
* 1.大数阶乘
* 2.正常四则运算
* @author special
* @date 2018年1月2日 下午1:58:31
*/
public class Pro086 {
	
	public static String factories(int num1){
		int[] digit = new int[1000];
		int index = 0, temp, carry;
		digit[index++] = 1;
		for(int i = 2; i <= num1; i++){
			carry = 0;
			for(int j = 0; j < index; j++){
				temp = i * digit[j] + carry;
				carry = temp / 10000;
				digit[j] = temp % 10000;
			}
			if(carry > 0) digit[index++] = carry;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(digit[--index]);
		for(int i = --index; i >= 0; i--){
			sb.append(String.format("%04d", digit[i]));
		}
		return sb.toString();
	}
	
	public static int caculate(int num1, String op, int num2){
		switch(op){
		case "+" : return num1 + num2;
		case "-" : return num1 - num2;
		case "*" : return num1 * num2;
		case "/" : return num1 / num2;
		default: return num1 % num2; //取余
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int num1 = input.nextInt();
			String op = input.next();
			if(op.equals("!")){
				System.out.println(factories(num1));
			}else{
				int num2 = input.nextInt();
				if(num2 == 0 && (op.equals("/") || op.equals("%"))){
					System.out.println("error");
				}else{
					System.out.println(caculate(num1,op,num2));
				}
			}
		}
	}

}
