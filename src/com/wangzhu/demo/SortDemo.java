package com.wangzhu.demo;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by wang.zhu on 2021-02-26 17:07.
 **/
public class SortDemo {

    /**
     * 快速排序<br/>
     *
     * @param nums
     * @param left
     * @param right
     */
    private void quickSort(final int[] nums, final int left, final int right) {
        if (left >= right) {
            return;
        }
        final int pivotIndex = wrapGetPivotIndex(nums, left, right);
        quickSort(nums, left, pivotIndex - 1);
        quickSort(nums, pivotIndex + 1, right);
    }

    private int wrapGetPivotIndex(final int[] nums, final int left, final int right) {
        final int index = new Random().nextInt(right - left + 1) + left;
        swap(nums, left, index);
        return getPivotIndex(nums, left, right);
    }

    private int getPivotIndex(final int[] nums, int left, int right) {
        //选取第一个值作为基准
        final int pivotIndex = left, pivot = nums[pivotIndex];
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                //从右到左，找到第一个小于基准的元素
                right--;
            }

            while (left < right && nums[left] <= pivot) {
                //从左到右，找到第一个大于基准的元素
                left++;
            }

            if (left < right) {
                swap(nums, left, right);
                print(nums);
                System.out.println(left + "," + right);
            }
        }
        swap(nums, pivotIndex, left);
        print(nums);
        System.out.println(pivotIndex + ", left=" + left);
        return left;
    }

    private void swap(final int[] nums, final int left, final int right) {
        final int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    private void sort(final int[] arr) {
        //使用快速排序
        quickSort(arr, 0, arr.length - 1);
    }

    private void print(final int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        final int[] arr = {6, 8, 6, 3, 1, 1, 2, 3, 6, 2, 4, 6};
        final SortDemo sortDemo = new SortDemo();
        sortDemo.sort(arr);
        sortDemo.print(arr);
    }
}
