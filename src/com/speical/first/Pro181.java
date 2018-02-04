package com.speical.first;

import java.util.Scanner;

/** 
* C翻转
* 
* 很简单，模拟正常翻转就可以了
* 
* 我们可以发现当顺时针90的时候
* 第一行的数据依次为第一列的倒序
* 第二行的数据依次为第二列的倒序
* ....
* 
* 我们可以发现当逆时针90的时候
* 第一行的数据依次为最后一列的正序
* 第二行的数据依次为倒数第二列的正序
* ....
* 
* So, it it easy that you can handle it!
* @author special
* @date 2018年2月3日 下午4:18:16
*/
public class Pro181 {
	static int[][] nums = new int[5][5];
	static int[][] auxiliary = new int[5][5];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			for(int i = 0; i < 5; i++){
				for(int j = 0; j < 5; j++){
					nums[i][j] = input.nextInt();
					auxiliary[i][j] = nums[i][j];
				}
			}
			int kind = input.nextInt();
			int count = input.nextInt();
			int startX = input.nextInt() - 1; //数组的索引从0开始，所以此处减一
			int startY = input.nextInt() - 1;
			int endX = startX + count - 1;
			int endY = startY + count - 1;
			//旋转
			for(int i = startX; i <= endX; i++){
				for(int j = startY; j <= endY; j++){
					if(kind == 1){
						nums[i][j] = auxiliary[endX - (j - startY)][startY + (i - startX)];
					}else if(kind == 2){
						nums[i][j] = auxiliary[startX + (j - startY)][endY - (i - startX)];
					}
				}
			}
			//输出数组
			for(int i = 0; i < 5; i++){
				for(int j = 0; j < 5; j++){
					System.out.print((j == 0 ? "" : " ") + nums[i][j]);
				}
				System.out.println();			
			}
		}
	}

}
