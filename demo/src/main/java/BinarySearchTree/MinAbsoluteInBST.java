package BinarySearchTree;

public class MinAbsoluteInBST {
	
	private Integer prev = null;  // 記錄前一個節點的值
	private int minDiff = Integer.MAX_VALUE;  // 記錄最小差值
	
	public int getMinimumDifference(TreeNode root) {
		inorderTraversal(root);
        return minDiff;
	} 
	
	private void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        
        // 遍歷左子樹
        inorderTraversal(node.left);
        
        // 處理當前節點
        if (prev != null) {
            minDiff = Math.min(minDiff, Math.abs(node.val - prev));
        }
        prev = node.val;
        
        // 遍歷右子樹
        inorderTraversal(node.right);
    }
}
