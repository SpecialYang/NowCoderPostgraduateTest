package com.speical.first;

import java.util.Scanner;

/** 
* 鸡兔同笼问题
* 
* 如果输入的腿数为奇数，则直接就是 0 0
* 否则：
* 最小的动物数，是兔的数量尽可能多
* 算出兔的最大数，然后余下的是鸡
* legs / 4 + legs % 4 / 2
* 最多的动物数，就是全部是鸡
* legs / 2
* @author special
* @date 2018年1月2日 下午1:50:54
*/
public class Pro085 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			while(n-- > 0){
				int legs = input.nextInt();
				if(legs % 2 == 1){
					System.out.println(0 + " " + 0);
				}else{
					int min = legs / 4;
					min += legs % 4 / 2;
					int max = legs / 2;
					System.out.println(min + " " + max);
				}
			}
		}
	}

}
