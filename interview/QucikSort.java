package interview;

public class QucikSort {
    // 快速排序
    public static void quickSort(int[] arr, int left, int right) {
        if (left > right) {
            return; // 递归终止条件
        }
        int i = left, j = right;
        int pivot = arr[left]; // 选择基准元素

        while (i != j) {
            // 从右向左找到第一个小于基准元素的元素
            while (arr[j] >= pivot && i < j) {
                j--;
            }
            // 从左向右找到第一个大于基准元素的元素
            while (arr[i] <= pivot && i < j) {
                i++;
            }
            // 交换两个元素
            if (i < j) {
                swap(arr, i, j);
            }
        }

        // 将i和j共同指向的元素与基准元素交换
        swap(arr, left, i);
        // 递归排序基准元素左右边的子数组
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }

    // 交换函数
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 8, 10, 1, 2, 1, 5, 7, 4, 9};
        quickSort(arr, 0, arr.length - 1);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
