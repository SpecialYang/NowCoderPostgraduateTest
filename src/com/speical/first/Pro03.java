package com.speical.first;

import java.util.Scanner;

/** 
* 代理服务器，超时代码
* 看来不能dfs
* @author special
* @date 2017年12月19日 上午10:15:23
*/
public class Pro03 {
	private static String[] proxys;
	private static String[] server;
	private static int min;
	
	public static void dfs(int index, String proxy, int count){
		if(index == server.length){
			if(count < min) min = count;
			return;
		}
		if(proxy.equals(server[index])){
			for(int i = 0; i < proxys.length; i++){
				if(!proxys[i].equals(proxy)){
					dfs(index + 1, proxys[i], count + 1);
				}
			}
		}else{
			dfs(index + 1, proxy, count);
		}
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
			min = Integer.MAX_VALUE;
			for(int i = 0; i < n; i++){
				if(!proxys[i].equals(server[0])){
					dfs(1,proxys[i],0);
				}
			}
			System.out.println(min == Integer.MAX_VALUE ? -1 : min);	
		}
	}

}
