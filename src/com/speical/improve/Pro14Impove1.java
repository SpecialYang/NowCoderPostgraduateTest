package com.speical.improve;
/** 
* 其实就是解 100a + 110b + 12c = 532
* @author special
* @date 2017年12月21日 下午7:25:39
*/
public class Pro14Impove1 {
	private static final int SUM = 532;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int a = 1; a < SUM / 100; a++)
			for(int b = 0; b <= (SUM - a * 100) / 110; b++){
				int c = (532 - a * 100 - 110 * b) / 12;
				if(c >= 0 && c <= 9 && a * 100 + b * 110 + c * 12 == SUM)
					System.out.println(a + " " + b + " " + c);
			}
	}

}
