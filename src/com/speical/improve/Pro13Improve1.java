package com.speical.improve;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
* ��Ʊ����
*
* �ֿ��Կ���Ҫ ��������Ʊ��
* �ǲ�������������̲������Ⱑ
* Ҳ���ǣ��ǲ�����bfs!!!!!
* @author special
* @date 2017��12��21�� ����3:54:17
*/
public class Pro13Improve1 {

	static class Node {
		int sum; // ά�ֵ�ǰ�ĺ�
		int index; // ά���ǵ�ǰ���Ǽ����ĸ�������Ӧ��ֵ��ɵġ�
		int count; // ά���ɼ��������

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
