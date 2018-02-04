package com.speical.first;

import java.util.Scanner;
/** 
*
* @author special
* @date 2018年2月2日 上午9:08:30
*/
public class Pro173 {
	static final int MOD = 10000;
	
	public static int[] factory(int n, int m){
		int[] result = new int[100000];
		int index = 1, carry = 0, temp;
		result[index++] = 1;
		result[0]++;
		for(int i = m; i <= n; i++){
			carry = 0;
			for(int j = 1; j < index; j++){
				temp = i * result[j] + carry;
				result[j] = temp % MOD;
				carry = temp / MOD;
			}
			if(carry > 0){ 
				result[index++] = carry; 
				result[0]++;
			}
		}
		return result;
	}
	
	public static int getBinary(int[] num){
		int length = num[0], r = 0, count = 0;
		for(int i = length; i > 0;){
			r = 0;
			for(int j = i; j > 0; j--){
				num[j] += r * MOD;
				r = num[j] % 2;
				num[j] /= 2;
			}
			while(i > 0 && num[i] == 0){
				i--;
			}
			if(r != 0){
				break;
			}else{
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int m = input.nextInt();
			if(n == 0) break;
			int[] result = factory(n, n - m + 1);
			System.out.println(getBinary(result));
		}
	}

}
