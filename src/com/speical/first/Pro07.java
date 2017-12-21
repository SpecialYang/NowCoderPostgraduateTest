package com.speical.first;

import java.util.Scanner;

/** 
* �����ֳ�2���۵���ɲ���
* 
* dfsջ�����
* @author special
* @date 2017��12��20�� ����8:51:11
*/
public class Pro07 {
	private static int n;
	private static int count;
	private static final int MOD = 1000000000;
	public static void dfs(int item, int sum){
		if(sum >= n){
			if(sum == n){
				count = (count + 1) % MOD;
			}
			return;
		}
		for(int i = 0; i < 32; i++){
			int temp = 1 << i;
			if(temp >= item){
				dfs(temp, sum + temp);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			n = input.nextInt();
			count = 0;
			dfs(0,0);
			System.out.println(count);
		}
	}

}
