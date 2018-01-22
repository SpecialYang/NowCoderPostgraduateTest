package com.speical.first;

import java.util.Arrays;
import java.util.Scanner;

/** 
* 打印目录树结构
* 
* 注意'\'的正则表达式是'\\'
* 但是在java中\\表示一个\，而在regex中\\表示\
* 所以我们只有令分割符为\\\\，才能解析为regex的\\，从而表示\
* @author special
* @date 2018年1月3日 下午2:44:16
*/
public class Pro98 {
	public static void draw(String[] contents){
		if(contents.length == 0) return;
		String[] pre = {""};  //上次路径
		String[] cur;         //本次路径
		StringBuilder sb = new StringBuilder();
		int index;
		for(int i = 0; i < contents.length; i++){
			sb.delete(0, sb.length());
			cur = contents[i].split("\\\\");
			index = 0;
			for(; index < pre.length && index < cur.length; index++){ //跟上层比较，找到同级目录
				if(pre[index].equals(cur[index])){
					for(int k = 0; k <= cur[index].length(); k++){
						sb.append(" ");
					}
				}else{
					break;
				}
			}
			for(; index < cur.length; index++){ //找到同级目录后，打印之后未打印的路径即可
				System.out.println(sb + cur[index]);
				for(int k = 0; k <= cur[index].length(); k++){
					sb.append(" ");
				}
			}
			pre = cur; //本次路径赋值给上次
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			if(n == 0) break;
			String[] contents = new String[n];
			for(int i = 0; i < n; i++){
				contents[i] = input.next();
			}
			Arrays.sort(contents);
			draw(contents);
			System.out.println();
		}
	}

}
