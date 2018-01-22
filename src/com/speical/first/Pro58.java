package com.speical.first;

import java.util.Scanner;

/** 
* 求等于某个数的几种取数方案
* 
* 我这里使用的是递归
* 为了防止重复方案的出现，比如 5 + 10 + 25 = 40 与 10 + 5 + 25 = 40
* 其实这两个是一种方案
* 所以递归方法体中，我们的采用循环采用for(int i = index; i < flag.length; i++)
* 这样在下次递归就不会访问之前考察过的点了，且我们的递归越来越小
* 因为我们每次递归都是以包含当前点的所有方案 + 包含下一点的所有的方案 + 。。。。。
* @author special
* @date 2017年12月30日 下午2:15:18
*/
public class Pro58 {
	final static int SIZE = 40;
	static int kinds;
	static int[] weights;
	
    public static void dfs(int index, int sum){
    	if(sum > SIZE) return; //剪枝，如果和大于sum,就没必要在当前的树枝递归了
    	if(sum == SIZE){
    		kinds++;
    		return;
    	}
    	for(int i = index; i < weights.length; i++){
    		dfs(i + 1, sum + weights[i]);
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			weights = new int[n];
			for(int i = 0; i < n; i++){
				weights[i] = input.nextInt();
			}
			kinds = 0;
			
			dfs(0,0);
			System.out.println(kinds);
		}
	}

}
