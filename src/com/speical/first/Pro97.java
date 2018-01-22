package com.speical.first;

import java.util.Arrays;
import java.util.Scanner;

/** 
* 
* 判断一个数可否有几个阶乘的和组成（注意不重复）
* 
* 我们求出所有小于等于 1百万的 阶乘的下标
* 然后dfs就可以了
* 用index来控制缩小范围，代替访问数组flag贼好使啊
* 
* 还有个小技巧：如何判断一个数阶乘的位数或者说大小
* @author special
* @date 2018年1月3日 下午1:53:54
*/
public class Pro97 {
	static final int SIZE = 1000000 + 5;
	static int[] values = new int[20];
	static boolean result;
	static int n;

	public static void init(){
		int result = 1;
		Arrays.fill(values, SIZE);
		for(int i = 1; result < SIZE; i++){
			values[i] = result;
			result *= (i + 1);
		}
	}
	public static void dfs(int index, int sum){
		if(result) return;
		if(sum == n){
			result = true;
			return;
		}
		for(int i = index; sum + values[i] <= n; i++){
			dfs(index + 1, sum + values[i]);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		init();
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			n = input.nextInt();
			result = false;
			dfs(1,0);
			System.out.println(result ? "YES" : "NO");
		}
	}

}
