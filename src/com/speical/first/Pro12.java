package com.speical.first;

import java.util.Scanner;

/** 
* ���ֵ��Сֵ
* ̰��
* 
* ���Ӷ�Ϊn,ֻҪÿ������һ��ֵ�����־ֲ���С����������
* @author special
* @date 2017��12��21�� ����3:27:15
*/
public class Pro12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			while(n-- > 0){
				int num = input.nextInt();
				if(num > max) max = num;
				if(num < min) min = num;
			}
			System.out.println(max + " " + min);
		}
	}

}
