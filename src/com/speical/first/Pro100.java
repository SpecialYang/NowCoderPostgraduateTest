package com.speical.first;

import java.util.Scanner;
import java.util.Stack;

/** 
* 计算表达式，无括号
* 无扩号其实更简单了，哈哈
* 模拟就可以了
* 遇到+，—,则计算之前的表达式，因为此处不存在优先级问题
* 遇到*，/,若运算符栈的顶是*或/，则计算一次之前的*或/，因为此处不存在优先级问题
* 
* 最后再全部弹出符号栈进行运算
* @author special
* @date 2018年1月3日 下午4:16:40
*/
public class Pro100 {
	static Stack<Double> nums;
	static Stack<Character> ops;
	
	private static boolean isNum(char ch){
		return ch >= '0' && ch <= '9';
	}
	public static void caculate(){
		while(!ops.isEmpty()){
			char op = ops.pop();
			double num1 = nums.pop();
			switch(op){
			case '+' : nums.push(nums.pop() + num1); break;
			case '-' : nums.push(nums.pop() - num1); break;
			case '*' : nums.push(nums.pop() * num1); break;
			case '/' : nums.push(nums.pop() / num1); break;
			}
		}
	}
	public static int caculate(String expression){
		double num = 0;
		for(int i = 0; i < expression.length(); i++){
			char ch = expression.charAt(i);
			if(isNum(ch)){
				num = 0;
				while(i < expression.length() && isNum(expression.charAt(i))){
					num = num * 10 + (expression.charAt(i++) - '0');
				}
				nums.push(num);
				i--;
			}else if(ch == '+' || ch == '-'){
				if(i == 0 && ch == '-'){
					nums.push(0.0);
				}
				caculate();
				ops.push(ch);
			}else if(ch == '*' || ch == '/'){
				/**
				 * 遇到栈顶是乘除的话，弹出一次符号栈
				 * 我们的实现方法保证了一次就可以了。
				 * 连乘的情况始终被我们压缩成一次
				 */
				if(!ops.isEmpty() && (ops.peek() == '*' || ops.peek() == '/')){
					char op = ops.pop();
					double num1 = nums.pop();
					switch(op){
					case '*' : nums.push(nums.pop() * num1); break;
					case '/' : nums.push(nums.pop() / num1); break;
					}
				}
				ops.push(ch);
			}
		}
		caculate();
		return (int)((double)nums.pop());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String expression = input.nextLine();
			nums = new Stack<>();
			ops = new Stack<>();
			System.out.println(caculate(expression));
		}
	}

}
