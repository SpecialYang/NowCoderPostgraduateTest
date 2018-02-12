package com.speical.first;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** 
* 字符串排序
* 
* 只排序字符串中字母且不分大小写且稳定，其他字符保持位置不变
* 
* 桶排序(还可以把）稳定
* 把字符串中的字符单独抽出来组成数组进行排序
* 然后考察原字符串， 若原字符串中位置是字母，则从字符数组拿一个
* 否则输出原串字符
* @author special
* @date 2018年1月1日 下午3:29:12
*/
public class Pro74 {
	private static boolean isLetter(char ch){
		return ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z';
	}
	public static int toIndex(char ch){
		if(ch >= 'a' && ch <= 'z'){
			return ch - 'a';
		}
		return ch - 'A';
	}
	public static void bucketSort(char[] chars, int length){
		List<List<Character>> buckets = new ArrayList<>();
		for(int i = 0; i < 26; i++){
			buckets.add(new ArrayList<Character>());
		}
		for(int i = 0; i < length; i++){
			buckets.get(toIndex(chars[i])).add(chars[i]);
		}
		int index = 0;
		for(int i = 0; i < 26; i++){
			if(buckets.get(i) != null){
				int offset = 0;
				while(offset < buckets.get(i).size() 
						&& buckets.get(i).get(offset) != null){
					chars[index++] = buckets.get(i).get(offset);
					offset++;
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			int length = str.length();
			char[] chars = new char[length];
			int index = 0;
			for(int i = 0; i < length; i++){
				if(isLetter(str.charAt(i))){
					chars[index++] = str.charAt(i);
				}
			}
			bucketSort(chars,index);
			index = 0;
			for(int i = 0; i < length; i++){
				if(isLetter(str.charAt(i))){
					System.out.print(chars[index++]);
				}else{
					System.out.print(str.charAt(i));
				}
			}
			System.out.println();
		}
	}

}
