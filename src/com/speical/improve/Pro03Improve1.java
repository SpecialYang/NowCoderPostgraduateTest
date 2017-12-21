package com.speical.improve;

import java.util.Scanner;

/** 
* ̰�ķ�����������
* 
* ÿ�ε���ѡһ����ǰ������������Ĵ��������
* @author special
* @date 2017��12��19�� ����11:09:41
*/
public class Pro03Improve1 {
	private static String[] proxys;
	private static String[] server;
	
	public static int getMinSteps(){
		int currentServer = 0; //��ǰ������ķ�����
		int currentProxy = -1; //��ǰʹ�õĴ��������
		int maxStep = 0;       //�Ӵ�����ķ��������������ߵ������
		int selectProxy = 0;  //��¼�����Ĵ��������
		int count = 0;        //��¼��Ҫ�л�����������Ĵ���
		while(currentServer < server.length){
			maxStep = 0;  // ������󲽳�Ϊ0
			for(int i = 0; i < proxys.length; i++){
				if(currentProxy != i){ //ѡȡ�뵱ǰ����һ���Ĵ���
					int j = currentServer; //��ǰ������ķ�����
					for(; j < server.length; j++){
						if(proxys[i].equals(server[j])){ //�����ͻ������
							if(j - currentServer > maxStep){ //��¼��������ʱ��ѡ��Ĵ���
								maxStep = j - currentServer;
								selectProxy = i;
							}
							break;
						}
					}
					if(j == server.length){ //��ѭ��������ʱ�����������еķ�����������Ͳ��ñ�����������������ˡ�
						maxStep = j - currentServer;
						selectProxy = i;
						break;
					}
				}
			}
			if(maxStep == 0){ return -1; }
			if(currentProxy != -1) count++; //���ǵ�һ�л�����ͼ���
			currentServer += maxStep; //���µ�ǰ������ķ�����
			currentProxy = selectProxy; //������ѡ��ľֲ����ŵĴ���
		}
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			proxys = new String[n];
			for(int i = 0; i < n; i++)
				proxys[i] = input.next();
			int m = input.nextInt();
			server = new String[m];
			for(int i = 0; i < m; i++)
				server[i] = input.next();
			System.out.println(getMinSteps());	
		}
	}

}
