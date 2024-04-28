//79. 单词搜索
//https://leetcode.cn/problems/word-search/description/?envType=study-plan-v2&envId=top-100-liked

public class P79 {
    // 二维字符网格中每个元素都当起点来尝试，四个方位递归搜索字符串下一个字符
    // 不过搜过且符合的字符不能重复使用，这就是为什么要加上回溯的逻辑，把搜过的字符变为'\0'，搜完再变回来
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        // 没找到之前，每个元素都要作为起点来尝试
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 加多一个判断，如果起点都不等没必要进入递归
                if (board[i][j] == word.charAt(0) && dfs(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    // index是word的下标，i，j是board的下标
    private boolean dfs(char[][] board, String word, int index, int i, int j) {
        int m = board.length, n = board[0].length;
        if (i >= m || i < 0 || j >= n || j < 0 || board[i][j] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        // 不能往回搜，所以先把这个变为'\0'，所以递归过程中所有遍历过的正确结果都会变为'\0'
        board[i][j] = '\0';
        //上下左右都比较一遍。
        boolean res = dfs(board, word, index + 1, i + 1, j) || dfs(board, word, index + 1, i - 1, j)
                   || dfs(board, word, index + 1, i, j + 1) || dfs(board, word, index + 1, i, j - 1);
        // 遍历完了再改回来，这里是回溯的精髓
        board[i][j] = word.charAt(index);
        return res;
    }
}
