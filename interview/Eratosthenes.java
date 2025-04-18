package interview;

import java.util.Arrays;

// 埃氏筛法求范围内的素数
public class Eratosthenes {
    public int eratosthenes(int n) {
        // 创建一个布尔数组，初始值为true
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true); // 将所有元素初始化为true
        isPrime[0] = false; // 0不是素数
        isPrime[1] = false; // 1不是素数
        // 从2开始筛选
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) { // 如果i是素数
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false; // 标记i的倍数为合数
                }
            }
        }

        // 统计素数的数量
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count;
    }

    // -------------------------------------------------------------
    // 暴力法求范围内的素数
    public int bruteForce(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    // 判断一个数是否为素数
    private boolean isPrime(int num) {
        if (num < 2) {
            return false; // 0和1不是素数
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false; // 找到一个因子，说明不是素数
            }
        }
        return true; // 没有找到因子，说明是素数
    }

    public static void main(String[] args) {
        Eratosthenes eratosthenes = new Eratosthenes();
        int n = 1000000; // 你可以修改这个值来测试不同的范围
        long start1 = System.currentTimeMillis();
        int count1 = eratosthenes.eratosthenes(n);
        long end1 = System.currentTimeMillis();
        System.out.println("埃氏筛法耗时: " + (end1 - start1) + "ms");
        System.out.println("埃氏筛法找到的素数数量: " + count1);
        long start2 = System.currentTimeMillis();
        int count2 = eratosthenes.bruteForce(n);
        long end2 = System.currentTimeMillis();
        System.out.println("暴力法耗时: " + (end2 - start2) + "ms");
        System.out.println("暴力法找到的素数数量: " + count2);
    }
}
