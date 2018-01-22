package com.speical.first;
/** 
* 求abc + bcc = 532
* 
* dfs,可以转换成3重循环优化
* @author special
* @date 2017年12月21日 下午5:47:55
*/
public class Pro14 {
	private static final int SUM = 532;
	private static boolean check(int[] nums){
		int a = nums[0];
		int b = nums[1];
		int c = nums[2];
		if((a * 100 + b * 10 + c)
				+(b * 100 + c * 10 + c) == SUM)
			return true;
		return false;
	}
	public static void dfs(int index, int[] nums){
		if(index == 3){
			if(check(nums)){
				System.out.println(nums[0] + " " + nums[1] + " " + nums[2]);
			}
			return;
		}
		for(int i = 0; i < 10; i++){
			if(!(index == 0 && i == 0)){
				nums[index] = i;
				dfs(index + 1,nums);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dfs(0,new int[3]);
	}

}
