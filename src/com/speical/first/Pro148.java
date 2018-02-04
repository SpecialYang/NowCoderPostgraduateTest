package com.speical.first;

import java.util.Scanner;

/** 
* zoj 问题
*  由题意可知下列几种情况：
        （ 1 ） zoj
        （ 2 ） x zoj x               x ,y,a ,b,c为N个'o'或者为空；
        （ 3 ） x  zyj  x*y

  (3) 由来：由于要使 a zbj c 能够 AC 过，根据（ 2 ）可知， a=c， b = 1 个'o'
	    故 a z b oj ac 能 AC 即 a z oo j 2*a 能 AC , 
      又根据第三条的条件，由于 a zooj 2*a 能 AC ，即   a = c = 2 * a,  b = 2 个'o'
            又可得 a z ooo j 3*a 可 AC ；
            由此类比得： a z b j a*b 可 AC ，
            综合（ 1 ），（ 2 ）可知（ 1 ） ,(2) 也符合表达式 a z b j a*b 。
            故只需要判断字符串是否符合 a z b j a*b 即可。
* @author special
* @date 2018年1月26日 上午10:09:47
*/
public class Pro148 {
	
	public static boolean isValid(String str){
		int[] nums = new int[3];
		int start = 0, end = 0;
		for(end = 0; end < str.length() && str.charAt(end) == 'o'; end++);
		if(end >= str.length() || str.charAt(end) != 'z') return false;
		nums[0] = end - start;
		start = ++end;
		for(;end < str.length() && str.charAt(end) == 'o'; end++);
		if(end >= str.length() || str.charAt(end) != 'j' || end - start == 0) return false;
		nums[1] = end - start;
		start = ++end;
		for(;end < str.length() && str.charAt(end) == 'o'; end++);
		if(end < str.length()) return false;
		nums[2] = end - start;
		return nums[2] == nums[0] * nums[1];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			System.out.println(isValid(str) ? "Accepted" : "Wrong Answer");
		}
	}

}
