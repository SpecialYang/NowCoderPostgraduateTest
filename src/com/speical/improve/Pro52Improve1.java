package com.speical.improve;

import java.util.Arrays;
import java.util.Scanner;

/** 
* 寻找假硬币
* 
* 初始化为0
* 
* 然后对于相等，赋值为5，只要大于3就行，因为3次测量，自增最大为3
* 
* 然后对于不想等，且不为5的，若重，则自增1，否则自减1
* @author special
* @date 2017年12月29日 下午1:44:59
*/
public class Pro52Improve1 {
static int[] map = new int[12];
	
	public static void solution(String left, String right, String balance){
		if(balance.equals("even")){
			for(int i = 0; i < left.length(); i++){
				map[left.charAt(i) - 'A'] = 5;
				map[right.charAt(i) - 'A'] = 5;
			}
		}else if(balance.equals("up")){
			for(int i = 0; i < left.length(); i++){
				if(map[left.charAt(i) - 'A'] != 5){
					map[left.charAt(i) - 'A']++;
				}
				if(map[right.charAt(i) - 'A'] != 5){
					map[right.charAt(i) - 'A']--;
				}
			}
		}else if(balance.equals("down")){
			for(int i = 0; i < left.length(); i++){
				if(map[left.charAt(i) - 'A'] != 5){
					map[left.charAt(i) - 'A']--;
				}
				if(map[right.charAt(i) - 'A'] != 5){
					map[right.charAt(i) - 'A']++;
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			while(n-- > 0){
				Arrays.fill(map, 0);
				for(int i = 0; i < 3; i++){
					String left = input.next();
					String right = input.next();
					String balance = input.next();
					solution(left,right,balance);
				}
				int max = 0;
				int index = 0;
				for(int i = 0; i < 12; i++){
					if(map[i] != 5){
						if(max < Math.abs(map[i])){
							max = Math.max(max, Math.abs(map[i]));
							index = i;
						}
					}
				}
				System.out.println((char)('A' + index) + " is the counterfeit coin and it is " 
						+ (map[index] > 0 ? "heavy" : "light") + ".");
			}
		}
	}
}
