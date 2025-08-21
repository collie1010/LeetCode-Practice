package DFS;

import java.util.List;

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] vis = new boolean[rooms.size()];
        dfs(rooms, vis, 0);
        for (int i = 0; i < vis.length; i++) {
            if (vis[i] == false) return false;
        }

        return true;
    }

    public void dfs(List<List<Integer>> rooms, boolean[] vis, int src) {
        vis[src] = true;
        for (int key : rooms.get(src)) {
            if (vis[key] == false) dfs(rooms, vis, key);
        }
    }
}
