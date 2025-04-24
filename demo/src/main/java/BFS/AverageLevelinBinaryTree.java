package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageLevelinBinaryTree {

	public List<Double> averageOfLevels(TreeNode root) {

		List<Double> result = new ArrayList<>();
		if (root == null)
			return result;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			double sum = 0;

			// 處理當前層的所有節點
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				sum += node.val;

				// 將下一層的節點加入隊列
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}

			// 計算該層平均值並加入結果
			result.add(sum / size);
		}

		return result;

	}
	
	public static void main(String[] args) {
        // 創建測試用的二元樹
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
        
        AverageLevelinBinaryTree solution = new AverageLevelinBinaryTree();
        List<Double> result = solution.averageOfLevels(root);
        
        // 印出結果
        System.out.println("每層節點的平均值：");
        for (int i = 0; i < result.size(); i++) {
            System.out.printf("第 %d 層: %.2f\n", i, result.get(i));
        }
        
        // 測試第二個案例：只有一個節點
        System.out.println("\n測試案例 2 - 單一節點：");
        TreeNode singleNode = new TreeNode(1);
        result = solution.averageOfLevels(singleNode);
        System.out.println(result);
        
        // 測試第三個案例：空樹
        System.out.println("\n測試案例 3 - 空樹：");
        result = solution.averageOfLevels(null);
        System.out.println(result);
        
        // 測試第四個案例：完整二元樹
        //       1
        //     /   \
        //    2     3
        //   / \   / \
        //  4   5 6   7
        System.out.println("\n測試案例 4 - 完整二元樹：");
        TreeNode completeTree = new TreeNode(1);
        completeTree.left = new TreeNode(2);
        completeTree.right = new TreeNode(3);
        completeTree.left.left = new TreeNode(4);
        completeTree.left.right = new TreeNode(5);
        completeTree.right.left = new TreeNode(6);
        completeTree.right.right = new TreeNode(7);
        result = solution.averageOfLevels(completeTree);
        for (int i = 0; i < result.size(); i++) {
            System.out.printf("第 %d 層: %.2f\n", i, result.get(i));
        }
    }
}
