//207. 课程表
//https://leetcode.cn/problems/course-schedule/description/?envType=study-plan-v2&envId=top-100-liked

import java.util.ArrayList;
import java.util.List;

public class P207 {
    // DFS判断有向图中是否有环，性能好一些，但不太理解，看题解：https://leetcode-cn.com/problems/course-schedule/solution/ke-cheng-biao-by-leetcode-solution/
    // 邻接表存储有向图
    List<List<Integer>> edges;
    // 标记每个节点的状态：0=未搜索，1=搜索中，2=已完成
    int[] visited;
    // 记录图中是否有环
    boolean valid = true;

    // 判断是否可以完成所有课程
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 初始化邻接表
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        // 初始化节点状态数组
        visited = new int[numCourses];
        // 构建邻接表
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }
        // 遍历每个节点，进行深度优先搜索
        for (int i = 0; i < numCourses && valid; ++i) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        // 如果没有环，则可以完成所有课程
        return valid;
    }

    // 深度优先搜索
    public void dfs(int u) {
        // 标记当前节点为搜索中
        visited[u] = 1;
        // 遍历当前节点的所有邻接节点
        for (int v: edges.get(u)) {
            if (visited[v] == 0) {
                // 如果邻接节点未搜索，则继续搜索
                dfs(v);
                if (!valid) {
                    return;
                }
            } else if (visited[v] == 1) {
                // 如果邻接节点在搜索中，说明图中有环
                valid = false;
                return;
            }
        }
        // 标记当前节点为已完成
        visited[u] = 2;
    }

    // ------------------------------------------------------------------------
    // BFS一层层处理入度为0的结点，如果最后所有结点的入度都为0，说明可以完成，性能一般
    // public boolean canFinish(int numCourses, int[][] prerequisites) {
    //     int m = prerequisites.length;
    //     // 入度数组，下标表示课程号，值为该课程号对应结点在有向图中的入度
    //     int[] inDegree = new int[numCourses];
    //     // key为课程号，value为以这个课程号为先修课的所有课程
    //     Map<Integer, List<Integer>> map = new HashMap();
    //     Queue<Integer> queue = new LinkedList();
    //     for (int i = 0; i < m; i++) {
    //         inDegree[prerequisites[i][0]]++;
    //         map.putIfAbsent(prerequisites[i][1], new ArrayList());
    //         map.get(prerequisites[i][1]).add(prerequisites[i][0]);
    //     }
    //     // 入度为0的为第一层
    //     for (int i = 0; i < numCourses; i++) {
    //         if (inDegree[i] == 0) {
    //             queue.offer(i);
    //         }
    //     }

    //     // 一层层消除入度为0的结点
    //     while (!queue.isEmpty()) {
    //         int key = queue.poll();
    //         for (int value: map.getOrDefault(key, new ArrayList<Integer>())) {
    //             if (--inDegree[value] == 0) {
    //                 queue.offer(value);
    //             }
    //         }
    //         numCourses--;
    //     }
           // 变相说明是否所有结点的入度都为0 
    //     return numCourses == 0;
    // }
}
