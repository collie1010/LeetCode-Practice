package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		if (root == null)
			return result;

		while (!queue.isEmpty()) {

			int size = queue.size();

			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();

				// 如果是該層的最後一個節點，加入結果列表
				if (i == size - 1) {
					result.add(node.val);
				}

				// 將下一層的節點加入隊列
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}

		}

		return result;
	}
	
	// 解法二：使用 DFS
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }
    
    private void dfs(TreeNode node, int level, List<Integer> result) {
        if (node == null) {
            return;
        }
        
        // 如果當前層級等於結果列表的大小，表示這是該層第一次訪問
        if (level == result.size()) {
            result.add(node.val);
        }
        
        // 先遍歷右子樹，再遍歷左子樹
        dfs(node.right, level + 1, result);
        dfs(node.left, level + 1, result);
    }
    
    public static void main(String[] args) {
    	RightSideView solution = new RightSideView();
        
        // 測試案例 1
        //      1
        //     / \
        //    2   3
        //   /     \
        //  5       4
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(5);
        root1.right.right = new TreeNode(4);
        
        System.out.println("Test Case 1:");
        System.out.println("BFS: " + solution.rightSideView(root1));
        System.out.println("DFS: " + solution.rightSideView2(root1));
        
        // 測試案例 2
        //      1
        //     / \
        //    2   3
        //   /   /
        //  4   5
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.right.left = new TreeNode(5);
        
        System.out.println("\nTest Case 2:");
        System.out.println("BFS: " + solution.rightSideView(root2));
        System.out.println("DFS: " + solution.rightSideView2(root2));
    }
}
