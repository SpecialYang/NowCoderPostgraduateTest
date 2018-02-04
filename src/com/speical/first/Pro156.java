package com.speical.first;

import java.util.Scanner;

/** 
* 判断三角形类型
* @author special
* @date 2018年1月30日 上午10:30:39
*/
public class Pro156 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int[] edges = new int[3];
			for(int i = 0; i < 3; i++){
				edges[i] = input.nextInt();
			}
			for(int i = 1; i < 3; i++){
				if(edges[i] > edges[0]){
					int temp = edges[0];
					edges[0] = edges[i];
					edges[i] = temp;
				}
			}
			int maxEdgeQuare = edges[0] * edges[0];
			int result = edges[1] * edges[1] + edges[2] * edges[2];
			if(maxEdgeQuare == result){
				System.out.println("直角三角形");
			}else if(maxEdgeQuare < result){
				System.out.println("锐角三角形");
			}else{
				System.out.println("钝角三角形");
			}
			
		}
	}

}
