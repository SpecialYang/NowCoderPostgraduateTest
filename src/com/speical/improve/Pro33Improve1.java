package com.speical.improve;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/** 
* 利用map找出根节点只有一个就对了
* @author special
* @date 2017年12月25日 下午1:49:13
*/
public class Pro33Improve1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int k = 0;
		while(input.hasNext()){
			int n = input.nextInt();
			int m = input.nextInt();
			if(n < 0 && m < 0) break;
			int degree = 0;  // 表示根节点的个数
			Map<Integer,Integer> map = new HashMap<>();
			k++;
			
			while(!(n == 0 && m == 0)){
				if(map.get(n) == null){
					map.put(n, 0);
				}
				if(map.get(m) == null){
					map.put(m,1);
				}else {
					map.put(m,map.get(m) + 1);
				}
				n = input.nextInt();
				m = input.nextInt();
			}
			for(Integer item : map.keySet()){
				if(map.get(item) == 0) degree++;
				if(map.get(item) > 1 || degree > 1){
					degree = 0;
					break;
				}
			}
			System.out.println("Case " + k + " is " + (degree == 1 || map.size() == 0 ? "" : "not ") + "a tree.");
		}
	}

}
