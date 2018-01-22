package com.speical.first;

import java.util.Scanner;

/** 
* 找出直系亲属
* 
* 思路：哈希的思想
* 即在父母对应的索引位置的值保存为孩子
* 这样我们就可以从父母开始不断根据自己孩子往下遍历下去，
* 直到找到子孙与查询的一致或为0为止
* 
* @author special
* @date 2018年1月5日 下午2:56:40
*/
public class Pro120 {
	static char[] map;
	/**
	 * 根据遍历次数，和正反方向确定是祖孙关系还是孙祖关系
	 * @param count
	 * @param flag
	 */
	public static void printRelation(int count, boolean flag){
		if(count == 1){
			if(flag){
				System.out.println("parent");
			}else{
				System.out.println("child");
			}
		}else{
			StringBuilder sb = new StringBuilder();
			while(count-- > 2){
				sb.append("great-");
			}
			if(flag){
				sb.append("grandparent");
			}else{
				sb.append("grandchild");
			}
			System.out.println(sb.toString());
		}
	}
	public static void query(char ch1, char ch2){
		int count = 0;
		char temp = ch1;
		while(temp != 0 && temp != ch2){ //从ch1开始不断遍历自己的孩子
			temp = map[temp - 'A'];      //直到ch1有孩子是ch2或者没有孩子为止
			count++;
		}
		if(temp != ch2){ //如果ch1没有孩子是ch2
			count = 0;   //层数清零
			temp = ch2;  
			while(temp != 0 && temp != ch1){//反过来，从ch2开始不断遍历自己的孩子
				temp = map[temp - 'A'];     //直到ch2有孩子是ch1或者没有孩子为止
				count++;
			}
			if(temp != ch1){ //如果正反都无法找到对应的关系，那么就是无亲属关系
				System.out.println("-");
			}else{  // ch2的某个子孙是ch1
				printRelation(count, false); //打印关系 
			}
		}else{ // ch1的某个子孙是ch2
			printRelation(count, true);  //打印关系
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int m = input.nextInt();
			if(n == 0 && m == 0) break;
			String relation;
			map = new char[26];
			for(int i = 0; i < n; i++){
				relation = input.next();
				if(relation.charAt(1) != '-')
					map[relation.charAt(1) - 'A'] = relation.charAt(0);
				if(relation.charAt(2) != '-')
					map[relation.charAt(2) - 'A'] = relation.charAt(0);
			}
			String query;
			for(int i = 0; i < m; i++){
				query = input.next();
				query(query.charAt(0),query.charAt(1));
			}
		}
	}

}
