package com.speical.first;

import java.util.Scanner;

/** 
* 里程问题
* 
* 注意两点：
* 一点是ceil获得大于等于该数的最小值
* 二点就是 miles / 2.0
* @author special
* @date 2017年12月29日 下午3:22:48
*/
public class Pro54 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			if(str.equals("#")) break;
			int result = 0;
			while(!str.equals("0")){
				String[] parts = str.split(" ");
				int miles = Integer.valueOf(parts[2]);
				switch(parts[3]){
				case "F": result += miles + miles;break;
				case "B": result += miles + Math.ceil(miles / 2.0);break;
				default : result += miles > 500 ? miles : 500;break;
				}
				str = input.nextLine();
			}
			System.out.println(result);
		}
	}

}
