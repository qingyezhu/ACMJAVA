package com.wangzhu.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main3Sum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Main3Sum main3Sum = new Main3Sum();
		System.out.println(main3Sum.threeSum(new int[] { -4, -2, -2, -2, 0, 1,
				2, 2, 2, 3, 3, 4, 4, 6, 6 }));
		System.out.println(main3Sum.threeSum(new int[] { 0, 0, 0 }));

	}

	private void twoSum(int[] num, int item, int len, List<List<Integer>> list) {
		int left = 0, right = len;
		while (left < right) {
			if (num[left] + num[right] == item) {
				List<Integer> itemList = new ArrayList<Integer>();
				itemList.add(num[left]);
				itemList.add(num[right]);
				itemList.add(-item);
				list.add(itemList);
				left++;
				right--;
				while (left < right && num[left] == num[left - 1]) {
					left++;
				}
				while (left < right && num[right] == num[right + 1]) {
					right--;
				}
			} else if (num[left] + num[right] > item) {
				right--;
			} else {
				left++;
			}
		}
	}

	public List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (num == null || num.length <= 2) {
			return list;
		}
		Arrays.sort(num);
		for (int i = num.length - 1; i > 1; i--) {
			if (i < num.length - 1 && num[i] == num[i + 1]) {
				continue;
			}
			twoSum(num, -num[i], i - 1, list);
		}
		return list;
	}

}
