package com.speical.improve;

import java.text.DecimalFormat;
import java.util.Scanner;

/** 
* 二元一次方程
* 
* 分别对等号两边的字符串进行解析，求出各系数
* @author special
* @date 2018年1月2日 下午5:30:22
*/
public class Pro90Improve1 {
	static DecimalFormat df = new DecimalFormat("0.00");
	static int[] nums = new int[3];
	private static boolean isNum(char ch){
		return ch >= '0' && ch <= '9';
	}
	public static void getNum(int fromIndex, int toIndex, String expression, boolean flag){
		int num = 0;
		char ch;
		boolean positive = true;
		int[] temp = new int[3];
		for(int i = fromIndex; i < toIndex; i++){
			ch = expression.charAt(i);
			if(isNum(ch)){
				while(i < toIndex && isNum(expression.charAt(i))){
					num = num * 10 + expression.charAt(i) - '0';
					i++;
				}
				if(i < toIndex && expression.charAt(i) != 'x' || i == toIndex){
					temp[2] = positive ? num : -num;
					num = 0;
					positive = true;
				}
				i--; //记得减一，因为循环体的最后也有i++
			}else if(ch == 'x'){
				if(num == 0){
					num = 1;
				}
				if(i < toIndex - 1 && expression.charAt(i + 1) == '^'){
					temp[0] = positive ? num : -num;
					i += 2;
				}else {
					temp[1] = positive ? num : -num; 
				}
				num = 0;
				positive = true;
			}
			else if(ch == '-'){
				positive = false;
			}
		}
		for(int i = 0; i < 3; i++){
			nums[i] = flag ? temp[i] : nums[i] - temp[i];
		}
		
	}
	/**
	 * 知道了3个系数，那么很容易求答案了
	 * 注意该题的答案保留2位小数不用四舍五入
	 * 该死的，format会自动四舍五入
	 * 你若是不想四舍五入，必须借助DecimalFormat类
	 * @param a
	 * @param b
	 * @param c
	 */
	public static void caculate(int a, int b, int c){
		double temp = b * b - 4 * a * c;
		if(temp < 0){
			System.out.println("No Solution");
		}else{
			temp = Math.sqrt(temp);
			double result1 = ((-b) + temp) / (2 * a);
			double result2 = ((-b) - temp) / (2 * a);
			if(result1 > result2){
				double max = result1;
				result1 = result2;
				result2 = max;
			}
			System.out.println(df.format(result1) + " " + df.format(result2));
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String expression = input.nextLine();
			int index = expression.indexOf('=');
			getNum(0, index, expression, true); //等号左边处理
			getNum(index + 1, expression.length(), expression, false); //等号右边处理
			caculate(nums[0],nums[1],nums[2]); //计算即可
		}
	}
}
