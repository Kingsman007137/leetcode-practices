// 415. 字符串相加
// https://leetcode.cn/problems/add-strings/description/

public class P415 {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder("");
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;// 进位
        while(i >= 0 || j >= 0){
            // 这两句其实是就判断完了一个数已经用完的情况
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int tmp = n1 + n2 + carry;
            carry = tmp / 10;
            res.append(tmp % 10);
            i--; j--;
        }
        if(carry == 1) res.append(1);
        return res.reverse().toString();
    }

    // 我自己想的，后面的判断有些冗长，其实可以优化
    // public String addStrings(String num1, String num2) {
    //     StringBuilder res = new StringBuilder();
    //     char[] num1c = num1.toCharArray();
    //     char[] num2c = num2.toCharArray();
    //     int i = num1.length() - 1;
    //     int j = num2.length() - 1;
    //     int bit = 0;
    //     int sum = 0;
    //     while (i >= 0 && j >= 0) {
    //         int n1 = num1c[i] - '0';
    //         int n2 = num2c[j] - '0';
    //         sum = n1 + n2 + bit;
    //         res.append(sum % 10);
    //         bit = sum / 10;
    //         i--;
    //         j--;
    //     }

    //     if (i < 0 && j >= 0) {
    //         while (j >= 0) {
    //             sum = num2c[j] - '0' + bit;
    //             res.append(sum % 10);
    //             bit = sum / 10;
    //             j--;
    //         }
    //     } else if (j < 0 && i >= 0) {
    //         while (i >= 0) {
    //             sum = num1c[i] - '0' + bit;
    //             res.append(sum % 10);
    //             bit = sum / 10;
    //             i--;
    //         }
    //     } 
        
    //     if (bit > 0) {
    //         res.append(bit);
    //     }

    //     return res.reverse().toString();
    // }
}
