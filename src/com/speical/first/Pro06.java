package com.speical.first;

import java.util.Scanner;

/** 
* �����ӷֽ�
* 
* ��ÿ����һֱ����ȥ������2��֮�����һ����
* ��Ϊ�����Ѿ���2���꣬�����Ժ�϶���������2�ı�����ֵ
* @author special
* @date 2017��12��19�� ����3:08:40
*/
public class Pro06 {
	
	public static int getCount(int num){
		int count = 0;
		int temp = num;
		/**
		 * ���ѭ����ʵ�ڴ���num�еĳ��˱����Լ��
		 */
		for(int i = 2; i <= Math.sqrt(temp); i++){
			while(temp % i == 0){
				temp /= i;
				count++;
			}
			if(temp == 1) break;
		}
		/**
		 * �������ѭ����ʱ��temp����1
		 * ˵������������������޷��ֽ���
		 */
		if(temp > 1) count++;
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			System.out.println(getCount(n));
		}
	}

}
