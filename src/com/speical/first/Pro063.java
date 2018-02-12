package com.speical.first;

import java.util.Scanner;

/** 
* 3个不同速度的循环什么时候能走到一起
* 
* 也就是当前位置对于各自的速度取余都等于0
* 
* 思路：对于给定的日期开始算，所以我们算出从各自的第一次极点到指定日期都走了多少
* 并对各自的速度取余，即看看各自都走到了自己循环的那一个位置了，然后每走一天
* 都判断一下是否是三者的极点。缺点：步长太短了
* 
* 注意取余的目的是思路比较清晰
* @author special
* @date 2017年12月30日 下午8:35:29
*/
public class Pro63 {
	static final int pPeak = 23;
	static final int ePeak = 28;
	static final int iPeak = 33;
	
	public static int getDays(int p, int e, int i, int d){
		p = (d - p) % pPeak;
		e = (d - e) % ePeak;
		i = (d - i) % iPeak;
		int days = 0;
		while(true){
			p++;
			e++;
			i++;
			days++;
			if(p % pPeak == 0 && e % ePeak == 0 && i % iPeak == 0){
				break;
			}
		}
		return days;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int k = 0;
		while(input.hasNext()){
			int p,e,i,d;
			p = input.nextInt();
			e = input.nextInt();
			i = input.nextInt();
			d = input.nextInt();
			k++;
			if(p == -1 && e == -1 && i == -1 && d == -1){
				break;
			}
			System.out.println("Case " + k + ": the next triple peak occurs in "
					+ getDays(p, e, i, d) + " days.");
		}
	}

}
