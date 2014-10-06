package com.wangzhu.leetcode;

import java.util.Arrays;

public class Main3SumClosest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Main3SumClosest main3SumClosest = new Main3SumClosest();
		System.out.println(main3SumClosest.threeSumClosest(new int[] { -1, 2,
				1, -4 }, 1));
	}

	public int threeSumClosest(int[] num, int target) {
		Arrays.sort(num);
		int closed = num[0] + num[1] + num[2] - target;
		for (int i = 0, len = num.length - 2; i < len; i++) {
			int diff = twoSum(num, target - num[i], i + 1);
			if (Math.abs(diff) < Math.abs(closed)) {
				closed = diff;
			}
		}
		return closed + target;
	}

	private int twoSum(int[] num, int target, int start) {
		int closed = num[start] + num[start + 1] - target;
		int left = start, right = num.length - 1;
		while (left < right) {
			if (num[left] + num[right] == target) {
				return 0;
			}
			int diff = num[left] + num[right] - target;
			if (Math.abs(diff) < Math.abs(closed)) {
				closed = diff;
			}
			if (num[left] + num[right] > target) {
				right--;
			} else {
				left++;
			}

		}
		return closed;
	}
}
