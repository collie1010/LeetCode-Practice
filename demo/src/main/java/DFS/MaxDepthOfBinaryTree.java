package DFS;

public class MaxDepthOfBinaryTree {
	public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return 1 + Math.max(leftDepth, rightDepth);
    }
	
	public static void main(String[] args) {
		MaxDepthOfBinaryTree solution = new MaxDepthOfBinaryTree();

        // 測試案例 1: 空樹
        TreeNode root1 = null;
        System.out.println("測試案例 1 - 空樹:");
        System.out.println("最大深度: " + solution.maxDepth(root1));
        System.out.println();

        // 測試案例 2: 只有根節點
        TreeNode root2 = new TreeNode(1);
        System.out.println("測試案例 2 - 只有根節點:");
        System.out.println("最大深度: " + solution.maxDepth(root2));
        System.out.println();

        // 測試案例 3: 平衡二元樹
        //       3
        //      / \
        //     9   20
        //        /  \
        //       15   7
        TreeNode root3 = new TreeNode(3);
        root3.left = new TreeNode(9);
        root3.right = new TreeNode(20);
        root3.right.left = new TreeNode(15);
        root3.right.right = new TreeNode(7);
        System.out.println("測試案例 3 - 平衡二元樹:");
        System.out.println("最大深度: " + solution.maxDepth(root3));
        System.out.println();

        // 測試案例 4: 左傾斜樹
        //   1
        //  /
        // 2
        //  \
        //   3
        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(2);
        root4.left.right = new TreeNode(3);
        System.out.println("測試案例 4 - 左傾斜樹:");
        System.out.println("最大深度: " + solution.maxDepth(root4));
        System.out.println();

        // 測試案例 5: 右傾斜樹
        //   1
        //    \
        //     2
        //      \
        //       3
        //        \
        //         4
        TreeNode root5 = new TreeNode(1);
        root5.right = new TreeNode(2);
        root5.right.right = new TreeNode(3);
        root5.right.right.right = new TreeNode(4);
        System.out.println("測試案例 5 - 右傾斜樹:");
        System.out.println("最大深度: " + solution.maxDepth(root5));
        System.out.println();

        // 測試案例 6: 複雜的不平衡樹
        //       1
        //      / \
        //     2   3
        //    / \
        //   4   5
        //  /
        // 6
        TreeNode root6 = new TreeNode(1);
        root6.left = new TreeNode(2);
        root6.right = new TreeNode(3);
        root6.left.left = new TreeNode(4);
        root6.left.right = new TreeNode(5);
        root6.left.left.left = new TreeNode(6);
        System.out.println("測試案例 6 - 複雜的不平衡樹:");
        System.out.println("最大深度: " + solution.maxDepth(root6));
    }
}
