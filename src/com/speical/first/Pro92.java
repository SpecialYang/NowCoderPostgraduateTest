package com.speical.first;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/** 
* 从小到大排列数组，并去重
* 
* 桶排序
* @author special
* @date 2018年1月3日 上午10:30:16
*/
public class Pro92 {
	static Map<Integer,Integer> bucket;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			bucket = new HashMap<>();
			int num;
			for(int i = 0; i < n; i++){
				num = input.nextInt();
				bucket.put(num,num);
			}
			boolean flag = true;
			for(int i = 1; i <= 1000; i++){
				if(bucket.get(i) != null){
					System.out.print((flag ? "" : " ") + bucket.get(i));
					flag = false;
				}
			}
			System.out.println();
		}
	}

}
