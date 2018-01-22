package com.speical.first;

import java.util.Arrays;
import java.util.Scanner;

/** 
* 最小面积子矩阵
* 
* 其实是最大和子矩阵的变形
* 
* 因为子矩阵存在行列同时变化的情况
* 所以我们需要先固定一个维数
* 然后改变另一个维数，产生多个子矩阵
* 分别处理每个子矩阵
* 
* 我们这里采用的是固定列长度
* 即我们把连续的行向量组成子矩阵所有组合拍扁成行向量
* 然后我们仅需在一个行向量找最小面积就可以了。
* @author special
* @date 2018年1月4日 下午2:17:50
*/
public class Pro104 {
	static int area;
	/**
	 * 寻找一个行向量上连续的最短不小于area的子序列
	 * @param flapMatrix
	 * @param row
	 * @return
	 */
	public static int getConsequenceMiniArea(int[] flapMatrix, int row){
		int miniLength = flapMatrix.length + 1, length = flapMatrix.length;
		int[] sum = new int[length];
		sum[0] = flapMatrix[0];
		for(int i = 1; i < length; i++){  //记录各自的累积和  方便下面的计算
			sum[i] = flapMatrix[i] + sum[i - 1];
		}
		for(int i = 0; i < length; i++){   
			for(int j = i; j < length; j++){
				if(sum[j] - (i == 0 ? 0 : sum[i - 1]) >= area){
					miniLength = Math.min(miniLength, j - i + 1);
					break;
				}
			}
		}
		return miniLength == length + 1 ? Integer.MAX_VALUE : miniLength * row;
	}
	
	public static int getMinArea(int[][] values, int n, int m){
		int[] flapMatrix = new int[m];
		int miniArea = Integer.MAX_VALUE, row = 0;
		for(int i = 0; i < n; i++){    //以i行开头的所有的子矩阵
			Arrays.fill(flapMatrix, 0);
			for(int j = i; j < n; j++){ //以i开头，以j行结束的所有子矩阵
				for(int k = 0; k < m; k++){
					flapMatrix[k] += values[j][k];
				}
				row = j - i + 1; //很关键，别忘了，因为我们把子矩阵拍成一个行向量。所以应该记录拍之前的行数
				miniArea = Math.min(miniArea, getConsequenceMiniArea(flapMatrix, row));
			}
		}
		return miniArea == Integer.MAX_VALUE ? -1 : miniArea;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int m = input.nextInt();
			area = input.nextInt();
			int[][] values = new int[n][m];
			for(int i = 0; i < n; i++){
				for(int j = 0; j < m; j++){
					values[i][j] = input.nextInt();
				}
			}
			System.out.println(getMinArea(values,n,m));
		}
	}

}
