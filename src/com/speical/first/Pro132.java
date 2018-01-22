package com.speical.first;

import java.util.Scanner;

/** 
* 带有约束的0 1背包问题
* 
* 思路： dp[j] = Math.max(dp[j], dp[j - prices[i]] + prices[i]);
* 
* 注意此题的背包大小为double型，所以我们可以乘以10的次方来消除小数点
* 转换为我们熟知的int型的背包
* 
* 同时对于不合法的发票（对应不合法的物体）我们把此物体的体积设置为背包的最大体积加1
* 这样当考虑该物体时，肯定不会考虑这个物体（发票）
* @author special
* @date 2018年1月7日 下午2:17:26
*/
public class Pro132 {
	
	public static int getMaxPrice(int[] prices, int n, int maxPrice){
		int[] dp = new int[maxPrice + 1];
		for(int i = 1; i <= n; i++){
			for(int j = maxPrice; j >= prices[i]; j--){
				dp[j] = Math.max(dp[j], dp[j - prices[i]] + prices[i]);
			}
		}
		return dp[maxPrice];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			double q = input.nextDouble();
			int n = input.nextInt(), count;
			if(n == 0) break;
			int maxPrice = (int)(q * 100);
			int[] prices = new int[n + 1];
			double A, B, C, price;
			boolean isValid = true;
			for(int i = 1; i <= n; i++){
				count = input.nextInt();
				A = B = C = 0;
				isValid = true;
				while(count-- > 0){
					String data = input.next();
					String[] dataArray = data.split(":");
					price = Double.parseDouble(dataArray[1]);
					if(dataArray[0].equals("A")){
						A += price;
					}else if(dataArray[0].equals("B")){
						B += price;
					}else if(dataArray[0].equals("C")){
						C += price;
					}else{    // 非 A B C 就是不合法
						isValid = false;
					}
 				}
				double total = A + B + C; 
				if(!isValid || A > 600 || B > 600 || C > 600 || total > 1000){
					prices[i] = maxPrice + 1;
				}else{
					prices[i] = (int)(total * 100);
				}
			}
			System.out.format("%.2f\n", getMaxPrice(prices, n, maxPrice) / 100.0);
		}
	}

}
