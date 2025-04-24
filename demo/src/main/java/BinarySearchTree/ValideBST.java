package BinarySearchTree;

public class ValideBST {
	
	private TreeNode prev = null;

	public boolean isValidBST(TreeNode root) {
		return inorderTraversal(root);
	}

	private boolean inorderTraversal(TreeNode node) {
		if (node == null) {
			return true;
		}

		// 遍歷左子樹
		if (!inorderTraversal(node.left)) {
			return false;
		}

		// 檢查當前節點值是否大於前一個節點值
		if (prev != null && node.val <= prev.val) {
			return false;
		}
		prev = node;

		// 遍歷右子樹
		return inorderTraversal(node.right);
	}
}
