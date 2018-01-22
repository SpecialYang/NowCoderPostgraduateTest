package com.speical.first;

import java.util.Scanner;


/** 
* 单词首字母大写
* 
* 注意若单词是非字母，要直接返回原字符串
* @author special
* @date 2017年12月29日 下午4:54:50
*/
public class Pro56 {
	static final char[] map = {' ','\t','\r','\n'};
	
	private static int contain(char ch){
		int index = -1;
		for(int i = 0; i < map.length; i++){
			if(ch == map[i]){
				return i;
			}
		}
		return index;
	}
	
	private static char toUpper(char ch){
		if(ch >= 'a' && ch <= 'z'){
			return (char) (ch - 'a' + 'A');
		}else{
			return ch;
		}
	}
	
	public static void solution(String str){
		boolean flag = true;
		for(int i = 0; i < str.length(); i++){
			char ch = str.charAt(i);
			if(contain(ch) == -1 && flag){
				flag = false;
				System.out.print(toUpper(ch));
			}else if(contain(ch) != -1){
				flag = true;
				System.out.print(ch);
			}else{
				System.out.print(ch);
			}
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			solution(str);
		}
	}

}
