package com.speical.first;
import java.text.DecimalFormat;
import java.util.Scanner;


/** 
* 二元一次方程组解法
* 
* 
* @author special
* @date 2018年1月2日 下午3:24:01
*/
public class Pro090 {
	static DecimalFormat df = new DecimalFormat("0.00");
	
	/**
	 * 解析从fromIndex 到 toIndex(不包括）的数
	 * 如果num = 0 且 toIndex不是末尾，那么说明该数
	 * 是未知数的系数且为1（因为1会省略不写）
	 * @param fromIndex
	 * @param toIndex
	 * @param expression
	 * @return
	 */
	public static int parseInt(int fromIndex, int toIndex, String expression){
		int num = 0;
		boolean flag = true;    //记录正负
		if(expression.charAt(fromIndex) == '-'){
			flag = false;
			fromIndex++;
		}else if(expression.charAt(fromIndex) == '+'){
			flag = true;
			fromIndex++;
		}
		while(fromIndex < toIndex){
			num = num * 10 + (expression.charAt(fromIndex) - '0');
			fromIndex++;
		}
		if(num == 0 && toIndex < expression.length()) num = 1; //如果是0且是未知数的系数，那么为1
		return flag ? num : -num;
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
			/**
			 * 这个表达式有个特点
			 * 就是一次项等号左边和右边都会出现
			 * 一次项若左边没有，代表这个方程没有一次项了
			 * 常数项只出现等号右边
			 */
			String expression = input.nextLine();
			int fromIndex = 0, toIndex;  //2次项的系数开头索引为0
			toIndex = expression.indexOf('x');  //结尾索引为第一次出现x的位置
			int a = parseInt(fromIndex, toIndex,expression); //解析出a
			fromIndex = expression.indexOf('^') + 2; //一次项的系数开始位置
			toIndex = expression.indexOf('x',fromIndex); //一次项的系数结束的位置
			int b = 0, c = 0;
			if(toIndex != -1){ //注意可能这个二元方程等号左边没有一次项，所以要判断一下
				b = parseInt(fromIndex, toIndex, expression); //如果有一次项，解析出来，这里指的是等号左边的
				fromIndex = expression.indexOf('=') + 1; //等号右边一次项开始的位置
				toIndex = expression.indexOf('x', fromIndex); //等号右边一次项结束的位置
				if(toIndex != -1){  //注意可能这个二元方程等号右边没有一次项，所以要判断一下
					b -= parseInt(fromIndex, toIndex, expression); //如果等号右边有一次项，解析出来，并减去它
					fromIndex = toIndex + 1; //指向常数项开始的位置
				}
			}else{
				fromIndex = expression.indexOf('=') + 1; //若果没有一次项，那么直接找出等号右边的常数项开始的位置
			}
			toIndex = expression.length(); //常数项结尾的位置，也就是表达式末尾
			c = -parseInt(fromIndex, toIndex, expression); // -c
			caculate(a,b,c); //计算即可
		}
	}

}
