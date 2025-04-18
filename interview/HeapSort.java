package interview;

public class HeapSort {
    /**
     * 堆排序 - 详细解释
     * 堆排序是一种基于比较的排序算法，利用堆这种数据结构来进行排序。
     * 堆是一种完全二叉树，分为最大堆和最小堆。
     * 最大堆的特点是每个节点的值都大于或等于其子节点的值，最小堆则相反。
     * 堆排序的基本思想是：
     * 1. 将待排序的数组构建成一个最大堆。
     * 2. 将堆顶元素（最大值）与堆的最后一个元素交换，然后将堆的大小减1。
     * 3. 对新的堆顶元素进行堆化操作，使其重新满足最大堆的性质。
     * 4. 重复步骤2和3，直到堆的大小为1。
     * @param arr
     */ 
    public static void heapSort(int[] arr) {
        int n = arr.length;
        // 构建最大堆
        for (int i = n / 2 - 1; i >= 0; i--) {
            // 从第一个非叶子结点从下至上，从右至左调整结构
            heapify(arr, n, i);
        }
        // 逐个取出元素
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i); // 将当前最大元素放到数组末尾
            heapify(arr, i, 0); // 调整堆
        }
    }

    // 堆化函数
    // n - 待排序列尾元素索引
    // i - 当前节点索引（父节点）
    private static void heapify(int[] arr, int n, int i) {
        int largest = i; // 初始化最大元素为当前节点
        int left = 2 * i + 1; // 左子节点
        int right = 2 * i + 2; // 右子节点

        // 如果左子节点大于当前最大元素，则更新最大元素
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        // 如果右子节点大于当前最大元素，则更新最大元素
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        // 如果最大元素不是当前节点，则交换并递归堆化
        // 确保以i为根的子树满足大根堆特性
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    // 交换函数
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 8, 10, 1, 2, 1, 5, 7, 4, 9};
        heapSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
