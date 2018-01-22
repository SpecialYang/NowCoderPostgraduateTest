package com.speical.first;

import java.util.Scanner;

/** 
* ZOJ
* 
* 哈希计数问题
* @author special
* @date 2018年1月7日 上午10:51:57
*/
public class Pro129 {
	
	public static int[] getCount(String str){
		int[] map = new int[3];
		for(int i = 0; i < str.length(); i++){
			char ch = str.charAt(i);
			if(ch == 'Z'){
				map[0]++;
			}else if(ch == 'O'){
				map[1]++;
			}else if(ch == 'J'){
				map[2]++;
			}
		}
		return map;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			if(str.equals("E")) break;
			int[] map = getCount(str);
			while(map[0] > 0 || map[1] > 0 || map[2] > 0){
				if(map[0] > 0){
					System.out.print('Z');
					map[0]--;
				}
				if(map[1] > 0){
					System.out.print('O');
					map[1]--;
				}
				if(map[2] > 0){
					System.out.print('J');
					map[2]--;
				}
			}
			System.out.println();
		}
	}

}
