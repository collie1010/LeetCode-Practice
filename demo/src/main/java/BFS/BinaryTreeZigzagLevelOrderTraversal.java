package BFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		boolean isLeftToRight = true; // 用來追踪當前層的方向

		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			List<Integer> currentLevel = new ArrayList<>();

			// 處理當前層的所有節點
			for (int i = 0; i < levelSize; i++) {
				TreeNode node = queue.poll();
				currentLevel.add(node.val);

				// 子節點永遠按照從左到右的順序加入隊列
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}

			// 如果是從右到左，則反轉當前層的結果
			if (!isLeftToRight) {
				Collections.reverse(currentLevel);
			}

			result.add(currentLevel);
			isLeftToRight = !isLeftToRight; // 切換方向
		}

		return result;
	}
    
    public static void main(String[] args) {
    	BinaryTreeZigzagLevelOrderTraversal solution = new BinaryTreeZigzagLevelOrderTraversal();
        
    	// 測試樹1：完整二元樹
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(3);
        tree1.left.left = new TreeNode(4);
        tree1.left.right = new TreeNode(5);
        tree1.right.left = new TreeNode(6);
        tree1.right.right = new TreeNode(7);
        System.out.println("測試樹1結果: " + solution.zigzagLevelOrder(tree1));

        // 測試樹2：不平衡樹
        TreeNode tree2 = new TreeNode(3);
        tree2.left = new TreeNode(9);
        tree2.right = new TreeNode(20);
        tree2.right.left = new TreeNode(15);
        tree2.right.right = new TreeNode(7);
        System.out.println("測試樹2結果: " + solution.zigzagLevelOrder(tree2));

        // 測試樹3：只有左子樹
        TreeNode tree3 = new TreeNode(1);
        tree3.left = new TreeNode(2);
        tree3.left.left = new TreeNode(3);
        tree3.left.left.left = new TreeNode(4);
        System.out.println("測試樹3結果: " + solution.zigzagLevelOrder(tree3));

        // 測試樹4：只有右子樹
        TreeNode tree4 = new TreeNode(1);
        tree4.right = new TreeNode(2);
        tree4.right.right = new TreeNode(3);
        System.out.println("測試樹4結果: " + solution.zigzagLevelOrder(tree4));

        // 測試空樹
        System.out.println("空樹結果: " + solution.zigzagLevelOrder(null));
    }
}
