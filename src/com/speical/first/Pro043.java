package com.speical.first;

import java.util.Scanner;

/**
* 
* 错误的硬币
* 输入不对吗？？？
* 
* Exception in thread "main" java.util.InputMismatchException
* @author special
* @date 2017年12月27日 上午11:48:24
*/
public class Pro43 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int[] map = new int[n + 1];
			int k = input.nextInt();
			for(int i = 0; i < k; i++){
				int count = input.nextInt();
				int[] temp = new int[count * 2];
				for(int j = 0; j < count * 2; j++){
					temp[j] = input.nextInt();
				}
				String relation = input.next();
				if(!relation.equals("=")){
					for(int j = 0; j < temp.length; j++){
						if(map[temp[j]] == 0){
							map[temp[j]] = 2;
						}
					}
				}else{
					for(int j = 0; j < temp.length; j++)
						map[temp[j]] = 1;
				}
			}
			for(int i = 0; i < n; i++){
				if(map[i] == 2){
					System.out.println(i);
					break;
				}
			}
		}
	}

}
