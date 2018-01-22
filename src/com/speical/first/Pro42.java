package com.speical.first;

import java.util.Arrays;
import java.util.Scanner;

/** 
* 求给定字符串的全排列
* 注意要按字典序来
* 
* 所以我们首先对我们的待求得字符串排序即可
* 然后按照dfs的思想一定能能按从小到大求出所有的排列
* @author special
* @date 2017年12月27日 上午10:23:26
*/
public class Pro42 {
	static char[] letters;
	static boolean[] flag;
	public static void permutation(int index, char[] result){
		if(index == letters.length){
			for(int i = 0; i < letters.length; i++){
				System.out.print(result[i]);
			}
			System.out.println();
			return;
		}
		for(int i = 0; i < letters.length; i++){
			if(!flag[i]){
				flag[i] = true;
				result[index] = letters[i];
				permutation(index + 1, result);
				flag[i] = false;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			letters = str.toCharArray();
			flag = new boolean[str.length()];
			Arrays.sort(letters);  //很关键
			permutation(0,new char[str.length()]);
			System.out.println();
		}
	}

}
