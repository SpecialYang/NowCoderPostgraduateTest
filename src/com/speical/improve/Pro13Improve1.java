package com.speical.improve;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
* 邮票问题
*
* 又可以看到要 求最少邮票数
* 那不就是类似求最短步数问题啊
* 也就是，那不就是bfs!!!!!
* @author special
* @date 2017年12月21日 下午3:54:17
*/
public class Pro13Improve1 {

	static class Node {
		int sum; // 维持当前的和
		int index; // 维持是当前和是加上哪个索引对应的值造成的。
		int count; // 维持由几个数相加

		public Node(int sum, int index, int count) {
			this.sum = sum;
			this.index = index;
			this.count = count;
		}
	}

	public static int bfs(int sum, int n, int[] nums) {
		Queue<Node> qe = new LinkedList<>();
		qe.offer(new Node(0, -1, 0));
		while (!qe.isEmpty()) {
			Node node = qe.remove();
			if (node.sum == sum)
				return node.count;
			if(node.sum > sum) continue;
			for (int i = node.index + 1; i < n; i++) {
				qe.offer(new Node(node.sum + nums[i], i, node.count + 1));
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			int sum = input.nextInt();
			int n = input.nextInt();
			int[] nums = new int[n];
			for (int i = 0; i < n; i++)
				nums[i] = input.nextInt();
			int count = bfs(sum, n, nums);
			System.out.println(count);
		}
	}

}
