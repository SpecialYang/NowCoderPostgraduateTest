package com.speical.first;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/** 
* 两个节点的公共父节点，注意如果两个本身相等也算
* 比如 1 1 公共节点为1   比如 2147483647 1073741823 公共节点为1073741823
* 因为该题的二叉树是完全二叉树
* 利用性质，一个父节点i的对应的两个孩子分别为2 * i，2 * i + 1
* 因此我们可以利用哈希的思想，记录一个节点到根节点的路径
* 另一个也不断除以2向根节点靠拢，若哈希表有对应的值，那么就说明该点就是公共父节点
* @author special
* @date 2017年12月28日 上午10:12:20
*/
public class Pro46 {
	public static int getCommonFather(int n, int m){
		Set<Integer> sets = new HashSet<>();
		while(m != 0){
			sets.add(m);
			m /= 2;
		}
		while(n != 0){
			if(sets.contains(n)) 
				return n;
			n /= 2;
		}
		return 1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int m = input.nextInt();
			System.out.println(getCommonFather(n,m));
		}
	}

}
