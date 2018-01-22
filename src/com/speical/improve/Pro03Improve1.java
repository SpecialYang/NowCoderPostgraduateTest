package com.speical.improve;

import java.util.Scanner;

/** 
* 贪心法求代理服务器
* 
* 每次到都选一个当前下能走最长步数的代理服务器
* @author special
* @date 2017年12月19日 上午11:09:41
*/
public class Pro03Improve1 {
	private static String[] proxys;
	private static String[] server;
	
	public static int getMinSteps(){
		int currentServer = 0; //当前待考察的服务器
		int currentProxy = -1; //当前使用的代理服务器
		int maxStep = 0;       //从待考察的服务器出发所能走的最长步数
		int selectProxy = 0;  //记录走最大的代理服务器
		int count = 0;        //记录需要切换代理服务器的次数
		while(currentServer < server.length){
			maxStep = 0;  // 更新最大步长为0
			for(int i = 0; i < proxys.length; i++){
				if(currentProxy != i){ //选取与当前代理不一样的代理
					int j = currentServer; //当前待考察的服务器
					for(; j < server.length; j++){
						if(proxys[i].equals(server[j])){ //如果冲突，处理
							if(j - currentServer > maxStep){ //记录步长最大的时的选择的代理
								maxStep = j - currentServer;
								selectProxy = i;
							}
							break;
						}
					}
					if(j == server.length){ //若循环结束的时候，走完了所有的服务器，后面就不用遍历其他代理服务器了。
						maxStep = j - currentServer;
						selectProxy = i;
						break;
					}
				}
			}
			if(maxStep == 0){ return -1; }
			if(currentProxy != -1) count++; //不是第一切换代理就计数
			currentServer += maxStep; //更新当前待考察的服务器
			currentProxy = selectProxy; //更新已选择的局部最优的代理
		}
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			proxys = new String[n];
			for(int i = 0; i < n; i++)
				proxys[i] = input.next();
			int m = input.nextInt();
			server = new String[m];
			for(int i = 0; i < m; i++)
				server[i] = input.next();
			System.out.println(getMinSteps());	
		}
	}

}
