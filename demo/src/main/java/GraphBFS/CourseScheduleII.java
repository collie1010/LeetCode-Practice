package GraphBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] degree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] p : prerequisites) {
            graph.get(p[1]).add(p[0]);
            degree[p[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) queue.offer(i);
        }

        List<Integer> order = new ArrayList<>();
        while (!queue.isEmpty()) {
            int course = queue.poll();
            order.add(course);

            for (int nei : graph.get(course)) {
                degree[nei]--;
                if (degree[nei] == 0) queue.offer(nei);
            }
        }

        if (order.size() == numCourses) {
            int[] result = new int[order.size()];
            for (int i = 0; i < order.size(); i++){
                result[i] = order.get(i);
            }
            return result;
        } else {
            return new int[0];
        }

    }

}
