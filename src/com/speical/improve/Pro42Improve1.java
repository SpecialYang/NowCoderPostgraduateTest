package com.speical.improve;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/** 
* 全排列
* 
* 12345的全排列可以看作 1 + 全排列
* 1234 + 5的全排列，1235 + 4的全排列
* 所以不断分解子问题就可以了。直到为1个数为止。
* @author special
* @date 2017年12月27日 上午10:39:23
*/
public class Pro42Improve1 {
	static char[] letters;
	static Set<String> treeSet;
	
	private static void swap(char[] result, int i , int j){
		if(i != j){
			char temp = result[i];
			result[i] = result[j];
			result[j] = temp;
		}
	}
	public static void permutation(int index, char[] result){
		if(index == letters.length - 1){
			treeSet.add(new String(result));
			return;
		}
		for(int j = index; j < letters.length; j++){
			swap(result,index,j);
			permutation(index + 1,result);
			swap(result,index,j);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			letters = str.toCharArray();
			treeSet = new TreeSet<>();
			permutation(0,letters);
			for(String item : treeSet){
				System.out.println(item);
			}
			System.out.println();
		}
	}
}
