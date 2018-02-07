package com.speical.first;

import java.util.Scanner;

/**
 * 查找
 * @author Special
 *
 */
public class Pro196 {
	
	public static boolean contains(int[] nums, int num) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == num) {
                return true;
            }
        }
        return false;
    }
     
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner input = new Scanner(System.in);
        while(input.hasNext()) {
            int n = input.nextInt();
            int[] nums = new int[n];
            for(int i = 0; i < n; i++) {
                nums[i] = input.nextInt();
            }
            int m = input.nextInt();
            while(m-- > 0) {
                System.out.println(contains(nums, input.nextInt()) ? "YES" : "NO");
            }
        }
    }

}
