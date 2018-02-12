package com.speical.first;

import java.util.Scanner;

/** 
* 趣味相同
* 
* 哈希思想 + 计数思想
* 以书籍编号为索引，记录有多少人喜欢
* 然后对于每个读者判断其喜欢的书籍编号是否1,给出是否悲剧
* @author special
* @date 2017年12月24日 下午4:40:20
*/
public class Pro28 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int m = input.nextInt();
			int[] index = new int[n];
			int[] map = new int[m + 1];
			for(int i = 0; i < n; i++){
				index[i] = input.nextInt();
				map[index[i]]++;
			}
			for(int i = 0; i < n; i++){
				if(map[index[i]] == 1){
					System.out.println("BeiJu");
				}else{
					System.out.println(map[index[i]] - 1);
				}
			}
			
		}
	}

}
