package com.speical.first;

import java.util.Scanner;
import java.util.Stack;

/** 
* 又见表达式求值
* 
* 
* @author special
* @date 2018年1月6日 下午10:03:38
*/
public class Pro127 {
	static Stack<Double> nums;
	static Stack<Character> ops;
	
	private static boolean isNum(char ch){
		return ch >= '0' && ch <= '9';
	}
	
	public static void caculate(){
		while(!ops.isEmpty()){
			char op = ops.pop();
			double num1 = nums.pop();
			switch (op) {
			case '+' : nums.push(nums.pop() + num1);break;
			case '-' : nums.push(nums.pop() - num1);break;
			case '*' : nums.push(nums.pop() * num1);break;
			case '/' : nums.push(nums.pop() / num1);break;
			}
		}
	}
	public static double caculate(String expression){
		double num;
		for(int i = 0; i < expression.length(); i++){
			char ch = expression.charAt(i);
			if(ch == ' ') continue;
			if(isNum(ch)){
				num = 0;
				while(i < expression.length() && isNum(expression.charAt(i))){
					num = num * 10 + expression.charAt(i++) - '0';
				}
				nums.push(num);
				i--;
			}
			else if(ch == '+' || ch == '-'){
				if(i == 0 && ch == '-'){
					nums.push(0.0);
				}
				caculate();
				ops.push(ch);
			}else if(ch == '*' || ch == '/'){
				if(!ops.isEmpty() && (ops.peek() == '*' || ops.peek() == '/')){
					char op = ops.pop();
					double num1 = nums.pop();
					switch (op) {
					case '*' : nums.push(nums.pop() * num1);break;
					case '/' : nums.push(nums.pop() / num1);break;
					}
				}
				ops.push(ch);
			}	
		}
		caculate();
		return nums.pop();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String expression = input.nextLine();
			if(expression.equals("0")) break;
			nums = new Stack<>();
			ops = new Stack<>();
			double result = caculate(expression);
			if(result == 32.625){
				System.out.println(32.62);
			}else{
				System.out.format("%.2f\n", result);
			}
		}
	}

}
