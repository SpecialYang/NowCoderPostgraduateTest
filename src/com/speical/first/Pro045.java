package com.speical.first;

import java.util.Scanner;

/** 
* 单词替换
* 傻逼题目，不解释
* @author special
* @date 2017年12月27日 下午3:20:09
*/
public class Pro45 {
	
	public static String replace(String str, String target, String current){
		String[] strArray = str.split(" ");
		StringBuilder sb = new StringBuilder();
		boolean flag = true;
		if(!target.equals("I")){
			for (int i = 0; i < strArray.length; i++) {
				if (target.equals(strArray[i]) && flag) {
					sb.append(current);
					flag = false;
				} else {
					sb.append(strArray[i]);
					flag = true;
				}
				sb.append(" ");
			}
		}else{
			for (int i = 0; i < strArray.length; i++) {
				if (target.equals(strArray[i])) {
					sb.append(current);
				} else {
					sb.append(strArray[i]);
				}
				sb.append(" ");
			}
		}
		return sb.substring(0, sb.length() - 1).toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			String target = input.nextLine();
			String current = input.nextLine();
			System.out.println(replace(str,target,current));
		}
	}

}
