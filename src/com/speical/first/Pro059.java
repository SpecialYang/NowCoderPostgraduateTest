package com.speical.first;

import java.util.Scanner;

/** 
*
* @author special
* @date 2017年12月30日 下午3:06:13
*/
public class Pro59 {
	static double[] scores = new double[101];
	
	static{
		for(int i = 0; i < 101; i++){
			if(i >= 60 && i <= 63) scores[i] = 1.0;
			else if(i >= 64 && i <= 67) scores[i] = 1.5;
			else if(i >= 68 && i <= 71) scores[i] = 2.0;
			else if(i >= 72 && i <= 74) scores[i] = 2.3;
			else if(i >= 75 && i <= 77) scores[i] = 2.7;
			else if(i >= 78 && i <= 81) scores[i] = 3.0;
			else if(i >= 82 && i <= 84) scores[i] = 3.3;
			else if(i >= 85 && i <= 89) scores[i] = 3.7;
			else if(i >= 90) scores[i] = 4.0;
		}
	}
	public static double process(int[] credits, int[] grades){
		double result = 0;
		int sum = 0;
		for(int i = 0; i < credits.length; i++){
			result += scores[grades[i]] * credits[i];
			sum += credits[i];
		}
		return result / sum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int[] credits = new int[n];
			int[] grades = new int[n];
			for(int i = 0; i < n; i++){
				credits[i] = input.nextInt();
			}
			for(int i = 0; i < n; i++){
				grades[i] = input.nextInt();
			}
			System.out.format("%.2f", process(credits,grades));
		}
	}

}
