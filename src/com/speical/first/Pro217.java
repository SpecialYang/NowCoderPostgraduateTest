package com.speical.first;

import java.util.Scanner;

/**
 * 判断对称矩阵
 * 
 * 每次只需对当前的大小的方阵判断即可
 * 比如第0次，是1，这样就不用判断了，所以我们的行索引开始就为1，而不是0
 * 对于第一次，方阵大小为2 * 2，但是我们只需判断matrix[1][0]和matrix[0][1]
 * ...
 * 很明显我们发现对于当前行，我们截止到对象线就可以了（不包括）
 * 注意我的循环的边界条件，对角线是不用参与比较，所以去掉
 * @author Special
 * @time 2018/02/10 17:28:02
 */
public class Pro217 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()) {
			int n = input.nextInt();
			int[][] nums = new int[n][n];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					nums[i][j] = input.nextInt();
				}
			}
			boolean flag = true;
			for(int i = 1; i < n; i++) {
				for(int j = 0; j < n - 1; j++) {
					if(nums[i][j] != nums[j][i]) {
						flag = false;
						break;
					}
				}
			}
			System.out.println(flag ? "Yes!" : "No!");
		}
	}

}
