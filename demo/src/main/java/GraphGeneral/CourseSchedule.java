package GraphGeneral;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 建立鄰接表
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
        }

        // 狀態陣列：0 = 未訪問，1 = 訪問中，2 = 已訪問
        int[] state = new int[numCourses];

        // 對每個節點進行 DFS
        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0) {
                if (hasCycle(graph, state, i)) {
                    return false; // 發現環，無法完成課程
                }
            }
        }
        return true; // 無環，可以完成課程
    }

    private boolean hasCycle(List<List<Integer>> graph, int[] state, int node) {
        if (state[node] == 1) return true; // 發現環
        if (state[node] == 2) return false; // 已訪問過，無需再訪問

        state[node] = 1; // 標記為訪問中
        for (int neighbor : graph.get(node)) {
            if (hasCycle(graph, state, neighbor)) {
                return true; // 發現環
            }
        }
        state[node] = 2; // 標記為已訪問
        return false;
    }
}
