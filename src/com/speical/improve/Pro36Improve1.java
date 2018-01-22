package com.speical.improve;

import java.util.Scanner;

/** 
* 因为小白鼠的重量不超过100，所以我们可以用桶排序啊
* 
* 桶排序的思想就是申请一组数中最大数的大小的桶
* 然后遍历数组，按照某种散列规则把数与数组索引对应起来
* 然后就可以把相同数散列到对应的桶位
* 最后我们从小桶开始依次倒出所有的数，即可得到有序的数列
* @author special
* @date 2017年12月26日 下午7:07:56
*/
public class Pro36Improve1 {
	static final int MAX = 101;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			String[] buckets = new String[MAX];
			for(int i = 0; i < n; i++){
				buckets[input.nextInt()] = input.next();
			}
			for(int i = MAX - 1; i >= 0; i--){
				if(buckets[i] != null){
					System.out.println(buckets[i]);
				}
			}
		}
	}

}
