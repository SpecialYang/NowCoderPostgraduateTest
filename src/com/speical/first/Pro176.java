package com.speical.first;

import java.util.Scanner;

/** 
* 搬苹果
* 
* 代价最小与霍夫曼树的思想是一致的
* 就是每次从苹果堆里选择最小的两堆，然后合并组成新堆，加入到原苹果堆
* 再挑选2个最小堆，直至最后一个堆为止
* 
* 最好的解法当属：优先队列！！
* 当然也可以次优解，此处我给的是插入排序
* 首先进行一次插入排序，然后取首端2个堆，
* 更新第二堆的大小，然后向数组末端方向进行一次插入
* 数组索引加1，相当于我们合并了一个堆，要删除前一个堆
* 重复以上步骤，直到走到数组末端
* @author special
* @date 2018年2月2日 上午11:11:45
*/
public class Pro176 {
	
	public static void insertSort(int begin, int[] fruits){
		for(int i = begin; i < fruits.length - 1 && fruits[i] > fruits[i + 1]; i++){
			int temp = fruits[i];
			fruits[i] = fruits[i + 1];
			fruits[i + 1] = temp;
		}
	}
	
	public static void insertSort(int[] fruits){
		for(int i = fruits.length - 2; i >= 0; i--){
			insertSort(i, fruits);
		}
	}
	
	public static int getMinPrice(int[] fruits){
		insertSort(fruits);
		int price = 0;
		for(int i = 1; i < fruits.length; i++){
			price += fruits[i] + fruits[i - 1];
			fruits[i] += fruits[i - 1];
			insertSort(i, fruits);
		}
		return price;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int[] fruits = new int[n];
			for(int i = 0; i < n; i++){
				fruits[i] = input.nextInt();
			}
			System.out.println(getMinPrice(fruits));
		}
	}

}
