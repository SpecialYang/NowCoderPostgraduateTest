package com.speical.first;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/** 
* 魔咒字典，双字典即可
* @author special
* @date 2018年1月25日 上午9:50:01
*/
public class Pro143 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		Map<String, String> inputs = new HashMap<String, String>();
		Map<String, String> functions = new HashMap<String, String>();
		String record, command, function;
		while(input.hasNext()){
			record = input.nextLine();
			if(record.equals("@END@")){
				break;
			}else{
				int index = 0;
				for(; index < record.length() && record.charAt(index) != ']'; index++);
				command = record.substring(1, index);
				function = record.substring(index + 2, record.length());
				inputs.put(command, function);
				functions.put(function, command);
			}
		}
		int n = input.nextInt();
		input.nextLine();  //此处很重要
		while(n-- > 0){
			record = input.nextLine();
			if(record.charAt(0) == '['){
				record = record.substring(1, record.length() - 1);
				System.out.println(inputs.get(record) != null ? inputs.get(record) : "What?");
			}else{
				System.out.println(functions.get(record) != null ? functions.get(record) : "What?");
			}
		}
	}

}
