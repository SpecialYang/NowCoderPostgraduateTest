package com.speical.first;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/** 
* 学生查询，直接哈希就可以了
* 
* 不过我这里用的是类表示了，其实单纯为了AC的话
* 直接把value也设置为String也非常不错啊，那我们就试试？
* @author special
* @date 2017年12月24日 上午9:56:33
*/
public class Pro26 {
	private static Map<String, Student> map;
	static class Student{
		String name;
		String sex;
		int age;
		
		public Student(String name, String sex, int age){
			this.name = name;
			this.sex = sex;
			this.age = age;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return name + " " + sex + " " + age;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			map = new HashMap<>();
			String sno, name, sex;
			int age;
			while(n-- > 0){
				sno = input.next();
				name = input.next();
				sex = input.next();
				age = input.nextInt();
				map.put(sno, new Student(name,sex,age));
			}
			int m = input.nextInt();
			while(m-- > 0){
				sno = input.next();
				if(map.get(sno) != null){
					System.out.println(sno + " " + map.get(sno));
				}else{
					System.out.println("No Answer!");
				}
			}
		}
	}

}
