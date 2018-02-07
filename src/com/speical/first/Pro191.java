package com.speical.first;

import java.util.Scanner;
/**
 * 树查找
 * @author Special
 *
 */
public class Pro191 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner input = new Scanner(System.in);
        while(input.hasNext()) {
            int n = input.nextInt();
            int[] nodes = new int[n + 1];
            for(int i = 1; i <= n; i++) {
                nodes[i] = input.nextInt();
            }
            int deep = input.nextInt();
            int currentDeepNodes = (int)(Math.pow(2,deep) - 1);
            if(currentDeepNodes > n) {
                System.out.println("EMPTY");
            }else {
                int preDeepLastNodes = (deep == 1 ? 0 : ((int)Math.pow(2,deep - 1) - 1));
                for(int i = preDeepLastNodes + 1; i <= currentDeepNodes; i++) {
                    System.out.print((i == preDeepLastNodes + 1? "" : " ") + nodes[i]);
                }
                System.out.println();
            }
        }
        input.close();
	}

}
