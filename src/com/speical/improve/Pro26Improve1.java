package com.speical.improve;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/** 
*
* @author special
* @date 2017年12月24日 上午10:21:08
*/
public class Pro26Improve1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			Map<String, String> map = new HashMap<>();
			String sno, info;
			while(n-- > 0){
				sno = input.next();
				info = input.nextLine();
				map.put(sno, info);
			}
			int m = input.nextInt();
			while(m-- > 0){
				sno = input.next();
				if(map.get(sno) != null){
					/**
					 * 注意此处不用加空格，因为nextLine()会包含所有当前行的剩余的字符，也包括前界定符
					 */
					System.out.println(sno + map.get(sno)); 
				}else{
					System.out.println("No Answer!");
				}
			}
		}
	}

}
