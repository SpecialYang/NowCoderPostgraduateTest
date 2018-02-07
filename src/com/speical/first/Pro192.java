package com.speical.first;

import java.util.Scanner;
/**
 * 查找
 * @author Special
 *
 */
public class Pro192 {
	 static final int SIZE = 3;
	    /**
	     * 推荐这样字符串翻转
	     * 不用取中间值的原因是我们交换字符串的位置要严格根据begin值
	     * arr[i] = arr[end - 1 - (i - begin)](这里很容易把begin忘了)
	     * 所以推荐用2个变量分别从开头到结尾交换，避免出错
	     * @param arr
	     * @param begin
	     * @param end
	     */
	    public static void reverse(char[] arr, int begin, int end) {
	        char temp;
	        for(int i = begin, j = end; i < j; i++, j--) {
	            temp = arr[i];
	            arr[i] = arr[j];
	            arr[j] = temp;
	        }
	    }
	     
	    public static char[] replace(char[] arr, int begin, int len, String command) {
	        int index = 3;
	        char[] temp = arr;
	        arr = new char[arr.length - len + command.length() - 3]; //替换后的长度
	        System.arraycopy(temp, 0, arr, 0, begin);
	        int i = begin;
	        for(; index < command.length(); index++) {
	            arr[i++] = command.charAt(index);
	        }
	        System.arraycopy(temp, begin + len, arr, i, temp.length - begin - len);
	        return arr;
	    }
	     
	    public static void main(String[] args) {
	        // TODO Auto-generated method stub
	        Scanner input = new Scanner(System.in);
	        while(input.hasNext()) {
	            String str = input.nextLine();
	            char[] arr = str.toCharArray();
	            int n = input.nextInt();
	            while(n-- > 0) {
	                String command = input.next();
	                int kind = command.charAt(0) - '0';
	                int begin = command.charAt(1) - '0';
	                int len = command.charAt(2) - '0';
	                if(kind == 0) {
	                    reverse(arr, begin, begin + len - 1);
	                }else if(kind == 1) {
	                    arr = replace(arr, begin, len, command);
	                }
	                System.out.println(new String(arr));
	            }
	        }
	        input.close();
	    }
}
