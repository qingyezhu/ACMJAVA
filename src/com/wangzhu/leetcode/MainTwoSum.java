package com.wangzhu.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MainTwoSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MainTwoSum twoSum = new MainTwoSum();
		System.out.println(Arrays.asList(twoSum
				.twoSum(new int[] { 3, 2, 4 }, 6)));

	}

	/**
	 * 哈希表：时间O(n),空间O(n)
	 * 
	 * @param numbers
	 * @param target
	 * @return
	 */
	public int[] twoSum(int[] numbers, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0, len = numbers.length; i < len; i++) {
			if (map.containsKey(target - numbers[i])) {
				int left = map.get(target - numbers[i]);
				int right = i + 1;
				return new int[] { left, right };
			}
			map.put(numbers[i], i + 1);
		}
		return null;
	}
}
