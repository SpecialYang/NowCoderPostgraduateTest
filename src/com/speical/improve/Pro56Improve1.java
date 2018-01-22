package com.speical.improve;

import java.util.Scanner;

/** 
* 单词首字母大写
* 
* 只需从头遍历，若遇到小写字母，则大写
* 然后遍历到下一个分隔符
* @author special
* @date 2017年12月29日 下午5:37:33
*/
public class Pro56Improve1 {

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
	
	public static void solution(String str){
		char[] array = str.toCharArray();
		for(int i = 0; i < str.length(); i++){
			if(array[i] >= 'a' && array[i] <= 'z'){
				array[i] = (char) (array[i] - 'a' + 'A');
			}
			while(i < str.length() && contain(array[i]) == -1){
				i++;
			}
		}
		System.out.println(new String(array));
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
