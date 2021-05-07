package com.wangzhu.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Created by wang.zhu on 2021-04-09 23:40.
 **/
public class LeastNumber {

    private static int compare(int a, int b) {
        if (a > b) {
            return 1;
        }
        if (a < b) {
            return -1;
        }
        return 0;
    }

    public static void getLeastNumber(final int[] arr, final int k) {
        if (arr == null || arr.length == 0 || k == 0) {
            //不合格
            return;
        }

        //least k
        //最大堆 降序
        final PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                //降序
                return -LeastNumber.compare(a, b);
            }
        });

        for (int i = 0; i < k; i++) {
            priorityQueue.offer(arr[i]);
        }

        for (int i = k, len = arr.length; i < len; i++) {
            if (arr[i] >= priorityQueue.peek()) {
                continue;
            }
            priorityQueue.poll();
            priorityQueue.offer(arr[i]);
        }
        final int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[k - i - 1] = priorityQueue.poll();
        }
        System.out.println(Arrays.toString(ret));
    }


    public static void main(String[] args) {
        getLeastNumber2(new int[]{3, 2, 1}, 2);
        getLeastNumber2(new int[]{0, 1, 2, 1}, 1);
        getLeastNumber2(new int[]{0, 1, 2, 1}, 2);
        getLeastNumber2(new int[]{0, 1, 2, 1}, 3);
    }

    public static void getLeastNumber2(final int[] arr, final int k) {
        specialSort(arr, 0, arr.length - 1, k - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void specialSort(final int[] arr, final int left, final int right, final int topN) {
        final int index = randomizedPartition(arr, left, right);
        if (index == topN) {
            return;
        }
        if (topN < index) {
            //左区间
            specialSort(arr, left, index - 1, topN);
        } else {
            //右区间
            specialSort(arr, index + 1, right, topN);
        }
    }

    private static int randomizedPartition(final int[] arr, final int left, final int right) {
        final int index = new Random().nextInt(right - left + 1) + left;
        swap(arr, index, left);
        return partition(arr, left, right);
    }

    private static int partition(final int[] arr, int left, int right) {
        int index = left, item = arr[index];
        //升序
        while (left < right) {
            while (left < right && arr[right] >= item) {
                //找一个小的
                right--;
            }

            while (left < right && arr[left] <= item) {
                //找一个大的
                left++;
            }
            if (left < right) {
                swap(arr, left, right);
            }
        }
        //交换index、left
        swap(arr, index, left);
        return left;
    }

    private static void swap(final int[] arr, final int left, final int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }

}
