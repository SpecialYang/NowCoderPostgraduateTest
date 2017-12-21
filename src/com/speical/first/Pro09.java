package com.speical.first;

import java.util.Scanner;

/** 
* 球的半径和体积
* 
* 欧几里得空间距离求法
* 球的体积求法
* @author special
* @date 2017年12月20日 上午11:11:30
*/
public class Pro09 {
	private static double PI = Math.acos(-1);
	
	public static double getRadius(int x0, int y0, int z0, int x1, int y1, int z1){
		return Math.sqrt(Math.pow(x1 - x0, 2) + Math.pow(y1 - y0, 2) + Math.pow(z1 - z0, 2));
	}
	
	public static double getVolume(double radius){
		return 4 / 3.0 * PI * Math.pow(radius, 3);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int x0,y0,z0,x1,y1,z1;
			x0 = input.nextInt();
			y0 = input.nextInt();
			z0 = input.nextInt();
			x1 = input.nextInt();
			y1 = input.nextInt();
			z1 = input.nextInt();
			double radius = getRadius(x0,y0,z0,x1,y1,z1);
			double volume = getVolume(radius);
			System.out.format("%.3f %.3f\n", radius,volume);
		}
	}

}
