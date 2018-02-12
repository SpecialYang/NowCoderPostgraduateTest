package com.speical.first;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/** 
* 输出键盘对应位的左边字符
* 用哈希的思想去索引
* @author special
* @date 2018年1月3日 上午10:03:07
*/
public class Pro091 {
	static final String letters = "AVXSWDFGUHJKNBIOQEARYCQZTZ"; //字母键映射
	static final String numbers = "9`12345678";  //数字键映射
	static final Map<Character, Character> punctuation = new HashMap<>(); //符号位的映射
	static{
		punctuation.put('\'', ';');
		punctuation.put(';', 'L');
		punctuation.put('/', '.');
		punctuation.put('.', ',');
		punctuation.put(',', 'M');
		punctuation.put('=', '-');
		punctuation.put('-', '0');
		punctuation.put('\\', ']');
		punctuation.put(']', '[');
		punctuation.put('[', 'P');
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			for(int i = 0; i < str.length(); i++){
				char ch = str.charAt(i);
				if(ch >= 'A' && ch <= 'Z'){
					System.out.print(letters.charAt(ch - 'A'));
				}else if(ch >= '0' && ch <= '9'){
					System.out.print(numbers.charAt(ch - '0'));
				}else if(punctuation.get(ch) != null){
					System.out.print(punctuation.get(ch));
				}else{
					System.out.print(ch);
				}
			}
			System.out.println();
		}
	}

}
