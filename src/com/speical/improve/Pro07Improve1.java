package com.speical.improve;

import java.util.Scanner;

/** 
* ��������
* 
* ��̬�滮
* ������װ��Ϊ��������1�������û��1�����
* ������iΪ����
* dp[i] = dp[i - 1]
* ��iΪ����
* dp[i] = dp[i - 1] + dp[i / 2]
* @author special
* @date 2017��12��20�� ����9:37:19
*/
public class Pro07Improve1 {
	private static final int MOD = 1000000000;
	private static final int SIZE = 1000000 + 5;
	private static int[] counts = new int[SIZE];
	
	public static void init(){
		counts[0] = 1;
		for(int i = 1; i < SIZE; i++){
			if((i & 1) == 1) counts[i] = counts[i - 1];
			else{
				counts[i] = (counts[i - 1] + counts[i >> 1]) % MOD;
			}
		}
	}
	public static void dfs(int item, int sum){
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		init();
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			System.out.println(counts[n]);
		}
	}
}
