package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			List<Integer> currentLevel = new ArrayList<>();
			
			for(int i = 0; i < levelSize; i++) {
				TreeNode node = queue.poll();
				currentLevel.add(node.val);
				
				if (node.left != null) {
					queue.offer(node.left);
				}
				if(node.right != null) {
					queue.offer(node.right);
				}
			} 
			
			result.add(currentLevel);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		BinaryTreeLevelOrderTraversal solution = new BinaryTreeLevelOrderTraversal();
        
        // 建立測試樹
        //      3
        //    /   \
        //   9    20
        //       /  \
        //      15   7
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        
        // 執行層序遍歷並印出結果
        List<List<Integer>> result = solution.levelOrder(root);
        System.out.println(result);
    }
}
