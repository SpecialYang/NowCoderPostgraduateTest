package com.speical.first;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 找位置
 * 
 * 哈希计数的思想
 * 数组的索引对应key值，然后该索引下的链表存放该key的在字符串中的所有位置
 * 二维数组也可以
 * @author Special
 * @time 2018/02/11 21:34:57
 */
public class Pro225 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()) {
			String str = input.nextLine();
			List[] indices = new List['z' + 1];
			for(int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if(indices[ch] == null) {
					indices[ch] = new ArrayList<Integer>();
				}
				indices[ch].add(i);
			}
			for(int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if(indices[ch] != null && indices[ch].size() > 1) {
					for(int j = 0; j < indices[ch].size(); j++) {
						System.out.print((j == 0 ? "" : ",") + ch + ":" + indices[ch].get(j));
					}
					indices[ch] = null;
					System.out.println();
				}
			}
 		}
	}

}
