package DFS;

public class CountGoodNode {
	
	public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }
    
    private int dfs(TreeNode node, int maxVal) {
        if (node == null) return 0;
        
        maxVal = Math.max(maxVal, node.val);
        int left = dfs(node.left, maxVal);
        int right = dfs(node.right, maxVal);
        return left + right + (node.val >= maxVal ? 1 : 0);
    }
}
