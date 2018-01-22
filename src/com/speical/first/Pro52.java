package com.speical.first;

import java.util.Arrays;
import java.util.Scanner;

/** 
* 思路：哈希思想，0代表等于标准，-1代表小于，1代表大于, 2代表从未考察过的硬币
* 3种情况：
* 1.even,则左右的对应的重量都为标准，赋值0
* 2.up. 说明假硬币在这里，未在天平上都是标准的.
* 然后我们令其余的硬币都赋值为0，然后对左边的所有硬币的从未考察过的赋值1（重）
* 对其中有的硬币被标识为-1(轻）的，赋值为0，因为一个硬币又重又轻，显然它不是假的
* 3.down。说明假硬币在这里，未在天平上都是标准的.
* 然后我们令其余的硬币都赋值为0，然后对左边的所有硬币的从未考察过的赋值-1（轻）
* 对其中有的硬币被标识为1(重）的，赋值为0，因为一个硬币又重又轻，显然它不是假的
* @author special
* @date 2017年12月29日 上午11:18:29
*/
public class Pro52 {
	static int[] map = new int[12];
	
	public static void solution(String left, String right, String balance){
		if(balance.equals("even")){
			for(int i = 0; i < left.length(); i++){
				map[left.charAt(i) - 'A'] = 0;
				map[right.charAt(i) - 'A'] = 0;
			}
		}else if(balance.equals("up")){
			for(int i = 0; i < 12; i++){
				if(left.indexOf(i + 'A') == -1 && right.indexOf(i + 'A') == -1){ 
					map[i] = 0;
				}
			}
			for(int i = 0; i < left.length(); i++){
				if(map[left.charAt(i) - 'A'] == 2){
					map[left.charAt(i) - 'A'] = 1;
				}else if(map[left.charAt(i) - 'A'] == -1){
					map[left.charAt(i) - 'A'] = 0;
				}
				if(map[right.charAt(i) - 'A'] == 2){
					map[right.charAt(i) - 'A'] = -1;
				}else if(map[right.charAt(i) - 'A'] == 1){
					map[right.charAt(i) - 'A'] = 0;
				}
			}
		}else if(balance.equals("down")){
			for(int i = 0; i < 12; i++){
				if(left.indexOf(i + 'A') == -1 && right.indexOf(i + 'A') == -1){ 
					map[i] = 0;
				}
			}
			for(int i = 0; i < left.length(); i++){
				if(map[left.charAt(i) - 'A'] == 2){
					map[left.charAt(i) - 'A'] = -1;
				}else if(map[left.charAt(i) - 'A'] == 1){
					map[left.charAt(i) - 'A'] = 0;
				}
				if(map[right.charAt(i) - 'A'] == 2){
					map[right.charAt(i) - 'A'] = 1;
				}else if(map[right.charAt(i) - 'A'] == -1){
					map[right.charAt(i) - 'A'] = 0;
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
				Arrays.fill(map, 2);
				for(int i = 0; i < 3; i++){
					String left = input.next();
					String right = input.next();
					String balance = input.next();
					solution(left,right,balance);
				}
				for(int i = 0; i < 12; i++){
					if(map[i] != 0){
						System.out.println((char)('A' + i) + " is the counterfeit coin and it is " 
									+ (map[i] == 1 ? "heavy" : "light") + ".");
						break;
					}
				}
			}
		}
	}

}
