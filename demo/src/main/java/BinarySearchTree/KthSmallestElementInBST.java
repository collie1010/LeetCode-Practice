package BinarySearchTree;

public class KthSmallestElementInBST {
	private int count = 0; // 計數當前是第幾個節點
	private int result = 0; // 存儲結果

	public int kthSmallest(TreeNode root, int k) {
		inorderTraversal(root, k);
		return result;
	}

	private void inorderTraversal(TreeNode node, int k) {
		if (node == null) {
			return;
		}

		// 遍歷左子樹
		inorderTraversal(node.left, k);

		// 處理當前節點
		count++;
		if (count == k) {
			result = node.val;
			return;
		}

		// 遍歷右子樹
		inorderTraversal(node.right, k);
	}
	
	
	public static void main(String[] args) {
		KthSmallestElementInBST solution = new KthSmallestElementInBST();
        
        // 測試案例 1
        //     3
        //    / \
        //   1   4
        //    \
        //     2
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        root1.left.right = new TreeNode(2);
        
        System.out.println("Test Case 1:");
        System.out.println("k = 1, result = " + solution.kthSmallest(root1, 1));  // 應該輸出 1
        
        // 重置 Solution 的靜態變數（因為要進行新的測試）
        solution = new KthSmallestElementInBST();
        
        // 測試案例 2
        //      5
        //     / \
        //    3   6
        //   / \
        //  2   4
        // /
        //1
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(6);
        root2.left.left = new TreeNode(2);
        root2.left.right = new TreeNode(4);
        root2.left.left.left = new TreeNode(1);
        
        System.out.println("\nTest Case 2:");
        System.out.println("k = 3, result = " + solution.kthSmallest(root2, 3));  // 應該輸出 3
    }
}
