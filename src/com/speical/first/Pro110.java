package com.speical.first;

import java.util.Scanner;

/** 
* 合并数组求中值
* 
* 其实不用额外的数组，我们仅计算索引
* 根据索引大小判断在哪个数组中即可
* @author special
* @date 2018年1月4日 下午7:55:52
*/
public class Pro110 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			while(n-- > 0){
				int n1 = input.nextInt();
				int n2 = input.nextInt();
				int[] num1 = new int[n1];
				int[] num2 = new int[n2];
				for(int i = 0; i < n1; i++){
					num1[i] = input.nextInt();
				}
				for(int i = 0; i < n2; i++){
					num2[i] = input.nextInt();
				}
				int start1 = input.nextInt();
				int end1 = input.nextInt();
				int length1 = end1 - start1 + 1;
				int start2 = input.nextInt();
				int end2 = input.nextInt();
				int length2 = end2 - start2 + 1;
				int length = length1 + length2;
				int middle = length / 2;
				if((length & 1) == 1){
					middle += 1;
				}
				if(middle > length1){
					System.out.println(num2[start2 - 1 + middle - length1 - 1]);
				}else{
					System.out.println(num1[start1 - 1 + middle - 1]);
				}
			}
		}
	}

}
