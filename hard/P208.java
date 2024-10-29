//208. 实现 Trie (前缀树)
//https://leetcode.cn/problems/implement-trie-prefix-tree/description/?envType=study-plan-v2&envId=top-100-liked

public class P208 {
    // Trie这个数据结构很有意思，在CS61B里学到过，相同前缀的单词会共用一个子分支
    // 看图就明白了：https://leetcode.cn/problems/implement-trie-prefix-tree/solutions/721110/gong-shui-san-xie-yi-ti-shuang-jie-er-we-esm9/?envType=study-plan-v2&envId=top-100-liked
    public class TrieNode {
        public TrieNode[] trieNodes = new TrieNode[26];
        public boolean end = false;       
    }

    TrieNode root;
    public P208() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (node.trieNodes[i] == null) {
                node.trieNodes[i] = new TrieNode();
            }
            // 移到子结点，继续创建这一路分支
            node = node.trieNodes[i];
        }
        node.end = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (node.trieNodes[i] == null) {
                return false;
            }
            node = node.trieNodes[i];
        }
        // 必须要走到叶子结点，才说明这个单词是存在的
        return node.end;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            int i = c - 'a';
            if (node.trieNodes[i] == null) {
                return false;
            }
            node = node.trieNodes[i];
        }
        // 找前缀就不需要走到叶子结点
        return true;
    }
}
