package com.speical.first;

import java.util.Arrays;
import java.util.Scanner;

/** 
* 八皇后问题
* 
* dfs很简单的
* 这里我们用一个92大小的int型result数组保存每一个结果sum
* sum是在递归的过程中维护的，注意使用中间变量保存循环体中的sum，否则会影响下一次循环
* 然后排序，根据输入的次序n从result[n - 1]中取结果
* @author special
* @date 2018年1月2日 上午11:42:57
*/
public class Pro084 {
	static final int SIZE = 8;
	static int[] result = new int[92];
	static boolean[][] flag = new boolean[SIZE][SIZE];
	static int count = 0;
	
	private static boolean isValid(int row, int col){
		int temp1, temp2;
		temp1 = temp2 = col;
		for(int i = row - 1; i >= 0; i--){
			if(flag[i][col]){
				return false;
			}
			if(temp1 > 0){
				if(flag[i][--temp1]){
					return false;
				}
			}
			if(temp2 < SIZE - 1){
				if(flag[i][++temp2]){
					return false;
				}
			}
		}
		return true;
	}
	
	public static void dfs(int index, int sum){
		if(index == SIZE) {
			result[count++] = sum;
			return;
		}
		sum *= 10;
		for(int i = 0; i < SIZE; i++){
			if(isValid(index,i)){
				flag[index][i] = true;
				int temp = sum + (i + 1);
				dfs(index + 1, temp);
				flag[index][i] = false;
			}
		}
	}
	
	public static void init(){
		dfs(0,0);
		Arrays.sort(result);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		init();
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			while(n-- > 0){
				System.out.println(result[input.nextInt() - 1]);
			}
		}
	}

}
