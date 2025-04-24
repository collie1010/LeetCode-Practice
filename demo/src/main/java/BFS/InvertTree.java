package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class InvertTree {
	public TreeNode invertTree(TreeNode root) {
		if (root == null)
			return null;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode current = queue.poll();

			// 交換左右子樹
			TreeNode temp = current.left;
			current.left = current.right;
			current.right = temp;

			// 將左右子節點加入隊列
			if (current.left != null)
				queue.add(current.left);
			if (current.right != null)
				queue.add(current.right);
		}

		return root;
	}

}
