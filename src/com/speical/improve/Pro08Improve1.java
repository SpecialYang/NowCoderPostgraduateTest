package com.speical.improve;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/** 
*
* @author special
* @date 2017��12��20�� ����10:45:36
*/
public class Pro08Improve1 {
	
	public static class Student{
		int sno;
		int grade;
		public Student(int sno, int grade){
			this.sno = sno;
			this.grade = grade;
		}
		
		public String toString() { return sno + " " + grade; }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			Student[] students = new Student[n];
			for(int i = 0; i < n; i++){
				students[i] = new Student(input.nextInt(),input.nextInt());
			}
			Arrays.sort(students,new Comparator<Student>(){
				
				/**
				 * ע��˴��ȽϺ�����д��
				 * �ȳɼ���ѧ��
				 */
				@Override
				public int compare(Student o1, Student o2) {
					if(o1.grade != o2.grade) return o1.grade - o2.grade;
					else                     return o1.sno - o2.sno;
				}
				
			});
			for(Student student : students)
				System.out.println(student);
		}
	}
}
