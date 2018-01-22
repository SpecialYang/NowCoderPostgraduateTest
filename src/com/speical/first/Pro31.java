package com.speical.first;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/** 
* 多key排序问题
* @author special
* @date 2017年12月24日 下午5:14:26
*/
public class Pro31 {
	private static final double min = 1e-7;
	
	static class StringComparator implements Comparator<String>{

		@Override
		public int compare(String o1, String o2) {
			/**
			 * 注意这里的正则表达式写
			 * 不能用o1.split(" ")，这样只是按照一个空格进行划分
			 * 会导致a    b 形成的数组为{a,,,,,b} so,你懂得
			 */
			String[] str1 = o1.split("\\s+");
			String[] str2 = o2.split("\\s+");
			/**
			 * 比较时间，因为时间的长度不一致，所以不能直接字符串比较，否则就会按字典序排序
			 * 比如101.11会排在11.11的前面，显然这样是不对的
			 * 这里也很好的说明了为什么对于不定长的字符串进行基数排序会出现错误的情况
			 * 所以这里我们化为double型比较
			 */
			double time1 = Double.parseDouble(str1[3].substring(0,str1[3].length() - 3));
			double time2 = Double.parseDouble(str2[3].substring(0,str2[3].length() - 3));
			
			if(Math.abs(time1 - time2) > min){ //比较时间
				if(time1 - time2 > 0) return 1;
				else                  return -1;
			}else if(!str1[1].equals(str2[1])){ //比较年月日，因为定长可直接比较
				return str1[1].compareTo(str2[1]);
			}else if(!str1[2].equals(str2[2])){ //比较时间，因为定长可直接比较
				return str1[2].compareTo(str2[2]);
			}else{
				return 0;  
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		List<String> strs = new ArrayList<>();
		/**
		 * 坑爹的最后空一行，用hasNextLine()即可
		 */
		while(input.hasNextLine()){
			String str = input.nextLine();
			if(str.trim().isEmpty()) break;
			strs.add(str);
		}
		Collections.sort(strs, new StringComparator());
		for(String item : strs){
			System.out.println(item);
		}
	}

}
