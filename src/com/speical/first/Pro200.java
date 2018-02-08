package com.speical.first;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 杨辉三角
 * @author Special
 * @time 2018/02/08 15:03:57
 */
public class Pro200 {
	static int n;
	
	public static void printRow(int index, List<Integer> preList) {
		if(index == n) { return; }
		List<Integer> currentList = new ArrayList<>();
		int num;
		for(int i = 0; i < preList.size(); i++) {
			if(i == 0) {
				num = 0 + preList.get(0);
				currentList.add(num);
			}else {
				num = preList.get(i - 1) + preList.get(i);
				currentList.add(num);
			}
			System.out.print(num + " ");
		}
		currentList.add(1);
		System.out.println(1);
		printRow(index + 1, currentList);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()) {
			n = input.nextInt();
			List<Integer> list = new ArrayList<>(1);
			list.add(1);
			printRow(1, list);
		}
	}

}
