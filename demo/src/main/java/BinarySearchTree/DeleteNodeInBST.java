package BinarySearchTree;

public class DeleteNodeInBST {
	public TreeNode deleteNode(TreeNode root, int key) {
		// 如果樹為空，直接返回
		if (root == null) {
			return null;
		}

		// 搜尋要刪除的節點
		if (key < root.val) {
			// 如果key小於當前節點，往左子樹搜尋
			root.left = deleteNode(root.left, key);
		} else if (key > root.val) {
			// 如果key大於當前節點，往右子樹搜尋
			root.right = deleteNode(root.right, key);
		} else {
			// 找到要刪除的節點

			// 情況1：節點是葉子節點
			if (root.left == null && root.right == null) {
				return null;
			}

			// 情況2：節點只有一個子節點
			if (root.left == null) {
				return root.right;
			}
			if (root.right == null) {
				return root.left;
			}

			// 情況3：節點有兩個子節點
			// 找到右子樹中最小的節點
			TreeNode minNode = findMin(root.right);
			// 用右子樹最小節點的值替換當前節點的值
			root.val = minNode.val;
			// 刪除右子樹中的最小節點
			root.right = deleteNode(root.right, minNode.val);
		}

		return root;
	}

	// 輔助方法：找到樹中最小的節點
	private TreeNode findMin(TreeNode node) {
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}
}
