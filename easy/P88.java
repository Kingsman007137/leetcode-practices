//88. 合并两个有序数组
//https://leetcode.cn/problems/merge-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150

import java.util.*;

public class P88 {
    //不开新的数组或者集合，直接在nums1里面比较，这就需要从尾部开始
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int tail = m + n - 1;
        while (p1 >= 0 || p2 >= 0) {
            int nextValue;
            if (p1 == -1) {
                nextValue = nums2[p2--];
            } else if (p2 == -1) {
                nextValue = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                nextValue = nums1[p1--];
            } else {
                nextValue = nums2[p2--];
            }
            nums1[tail--] = nextValue;
        }
    }

    // 这一版内存空间并没有多大提升
    // public static void merge(int[] nums1, int m, int[] nums2, int n) {
    //     int p1 = 0, p2 = 0;
    //     int[] temp = new int[m + n];
    //     while (p1 < m || p2 < n) {
    //         int nextValue;
    //         if (p1 == m) {
    //             nextValue = nums2[p2++];
    //         } else if (p2 == n) {
    //             nextValue = nums1[p1++];
    //         } else if (nums1[p1] < nums2[p2]) {
    //             nextValue = nums1[p1++];
    //         } else {
    //             nextValue = nums2[p2++];
    //         }

    //         //最初未能想出用p1 + p2 - 1表示应该到达的下标
    //         temp[p1 + p2 - 1] = nextValue;
    //     }

    //     for (int i = 0; i < m + n; i++) {
    //         nums1[i] = temp[i];
    //     }
    // }

    //不应该用链表，空间内存占用较高，应该用数组
    // public static void merge(int[] nums1, int m, int[] nums2, int n) {
    //     int point1 = 0, point2 = 0;
    //     List<Integer> temp = new ArrayList<>();
    //     while (point1 < m && point2 < n) {
    //         if (nums1[point1] < nums2[point2]) {
    //             temp.add(nums1[point1 ++]); //可以合二为一
    //         } else {
    //             temp.add(nums2[point2 ++]);
    //         }
    //     }

    //     //对比完之后有一个数组有剩余
    //     while (point1 < m) {
    //         temp.add(nums1[point1 ++]);
    //     }
    //     while (point2 < n) {
    //         temp.add(nums2[point2 ++]);
    //     }

    //     for (int i = 0 ; i < m + n; i++) {
    //         nums1[i] = temp.get(i);
    //     }
    // }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
