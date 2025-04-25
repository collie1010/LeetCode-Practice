package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class MaxLevelSum {

	private int maxSum = Integer.MIN_VALUE;
	private int maxLevel = 0;
	private int currLevel = 1;

	public int maxLevelSum(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {

			int size = queue.size();
			int currSum = 0;

			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				currSum += node.val;

				// 將下一層的節點加入隊列
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}

			if (currSum > maxSum) {
				maxSum = currSum;
				maxLevel = currLevel;
			}

			currLevel++;
		}

		return maxLevel;
	}

	public static void main(String[] args) {
		MaxLevelSum solution = new MaxLevelSum();

		// 測試案例 1：題目中的例子
		// 1
		// / \
		// 7 0
		// / \
		// 7 -8
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(7);
		root1.right = new TreeNode(0);
		root1.left.left = new TreeNode(7);
		root1.left.right = new TreeNode(-8);

		System.out.println("Test Case 1: " + solution.maxLevelSum(root1)); // 應輸出 2

		// 測試案例 2：多個層級具有相同的最大和
		// 1
		// / \
		// 2 2
		// / \
		// 1 1
		solution = new MaxLevelSum();
		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(2);
		root2.right = new TreeNode(2);
		root2.left.left = new TreeNode(3);
		root2.left.right = new TreeNode(1);

		System.out.println("Test Case 2: " + solution.maxLevelSum(root2)); // 應輸出 2
	}
}
