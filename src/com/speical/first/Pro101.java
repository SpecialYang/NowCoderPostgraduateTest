package com.speical.first;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** 
*
* @author special
* @date 2018年1月4日 上午10:28:11
*/
public class Pro101 {
	static final int SIZE = 16;
	static int[] exponential = new int[SIZE + 1];
	static int n;
	static boolean flag;
	
	/**
	 * 求需要到的2的次幂
	 * 根据题意最大数是20000，又因为2的16的次方是65536
	 * 因此我们打表到16次就可以满足题意了
	 */
	public static void init(){
		int result = 1;
		for(int i = 0; i <= SIZE; i++){
			exponential[i] = result;
			result *= 2;
		}
	}
	/**
	 * 对于给定n，进行分解，保存幂次方
	 * 根据题意可以可知，幂是从大到小考虑的
	 * 且只要找到一个，就直接结束递归
	 * @param index 当前考察到幂次方，通过每次index - 1，替代老方法的访问数组flag
	 * @param sum   当前幂次方的累加和
	 * @param nums  当前存的幂次方
	 */
	public static void dfs(int index, int sum, List<Integer> nums){
		if(sum > n) return; //和超过给定n，退出
		if(sum == n){ 
			flag = true;  //找到结果，更新找到的标志
			return;
		}
		for(int i = index; i >= 0; i--){
			nums.add(i); //添加幂次方
			dfs(index - 1, sum + exponential[i], nums);
			if(flag) break; //如果发现上一步成功了，直接结束递归，且下一步的擦除也不执行（关键）
			nums.remove(nums.size() - 1); //若上一步没成功，擦除最后一位，继续循环考察
		}
	}
	/**
	 * 根据递归得到的幂次方，构造成表达式样子
	 * @param nums
	 * @return
	 */
	public static String constructorString(List<Integer> nums){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < nums.size(); i++){
			if(i != 0){
				sb.append('+');
			}
			sb.append(2);
			if(nums.get(i) != 1){
				sb.append('(');
				sb.append(nums.get(i));
				sb.append(')');
			}
		}
		return sb.toString();
	}
	/**
	 * 寻找表达式中不是0也不是2的数字，更新n值（方便下次递归的结束值）
	 * @param sb 
	 * @return 不是0也不是2的索引，若不存在返回-1
	 */
	public static int getNum(StringBuilder sb){
		int index = -1;
		for(int i = 0; i < sb.length(); i++){
			int num = 0;
			if(sb.charAt(i) == '('){
				i++;
				index = i;
				while(sb.charAt(i) >= '0' && sb.charAt(i) <= '9'){
					num = num * 10 + (sb.charAt(i++) - '0');
				}
				if(num != 0 && num != 2){
					n = num;
					return index; 
				}
				i--; //注意次数i要回退一下，因为循环体最后也有i++，防止漏掉某些字符
			}
		}
		return -1;
	}
	/**
	 * 在给定的索引处，插入规定的字符串
	 * 注意要先删除给定索引开始之后的数，然后再把字符串插入
	 * 相当与2+2(0) 替代 3
	 * @param index
	 * @param sb
	 * @param item
	 */
	public static void insert(int index, StringBuilder sb, String item){
		int end = index;
		while(sb.charAt(end) >= '0' && sb.charAt(end) <= '9'){
			end++;
		}
		sb.delete(index, end);
		sb.insert(index, item);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		init();
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			n = input.nextInt();
			int index = 0;
			flag = false;
			List<Integer> nums = new ArrayList<>();
			dfs(SIZE, 0, nums);
			String item = constructorString(nums);
			StringBuilder sb = new StringBuilder(item);
			while((index = getNum(sb)) != -1){
				flag = false;
				nums.clear();
				dfs(SIZE, 0, nums);
				item = constructorString(nums);
				insert(index, sb, item);
			}
			System.out.println(sb.toString());
		}
	}

}
