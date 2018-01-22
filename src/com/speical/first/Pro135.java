package com.speical.first;

import java.util.Arrays;
import java.util.Scanner;

/** 
* 继续XXX定律
* 
* 哈希思想
* @author special
* @date 2018年1月8日 上午11:40:00
*/
public class Pro135 {
	static final int SIZE = 1000 + 5;
	static int[] map = new int[SIZE];
	
	public static void solution(int num){
		if(map[num] == 0){
			map[num] = 2;  //2 代表关键数
			while(num != 1){
				if((num & 1) == 1){
					num = (num * 3 + 1) >> 1;
				}else{
					num >>= 1;
				}
				if(num < SIZE){
					map[num] = 1;  // 1 代表覆盖数
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			if(n == 0) break;
			int[] nums = new int[n];
			Arrays.fill(map, 0);
			for(int i = 0; i < n; i++){
				nums[i] = input.nextInt();
				solution(nums[i]);
			}
			boolean flag = true;
			for(int i = n - 1; i >= 0; i--){
				if(map[nums[i]] == 2){
					System.out.print((flag ? "" : " ") + nums[i]);
					flag = false;
				}
			}
			System.out.println();
		}
	}

}
