package com.example.algo;

public class BinarySearchTree {
	
	private class Node {
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	private Node root;
	
	public BinarySearchTree() {
		root = null;
	}
	
	public void insert(int data) {
		root = insertRec(root, data);
	}
	
	private Node insertRec(Node root, int data) {
		// 如果樹是空的或到達葉節點，建立新節點
		if (root == null) {
			root = new Node(data);
			return root;
		}
		
		// 遞迴插入適當的位置
		if (data < root.data) {
			root.left = insertRec(root.left, data);
		} else if (data > root.data) {
			root.right = insertRec(root.right, data);
		}
		
		return root;
	}
	
	public boolean search(int data) {
		return searchRec(root, data);
	}
	
	private boolean searchRec(Node root, int data) {
		// 基本情況:樹為空或找到值
		if (root == null || root.data == data) {
			return root != null;
		}
		
		// 值小於目前節點，往左子樹搜尋
		if (data < root.data) {
			return searchRec(root.left, data); 
		}
		
		 // 值大於目前節點，往右子樹搜尋
		return searchRec(root.right, data);
		
	}
	
	// 刪除節點
    public void delete(int data) {
        root = deleteRec(root, data);
    }
    
    private Node deleteRec(Node root, int data) {
        // 基本情況：樹為空
        if (root == null)
            return root;
            
        // 遞迴找到要刪除的節點
        if (data < root.data)
            root.left = deleteRec(root.left, data);
        else if (data > root.data)
            root.right = deleteRec(root.right, data);
        else {
            // 節點有0或1個子節點的情況
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
                
            // 節點有2個子節點的情況
            // 找到右子樹中最小的節點（繼承者）
            root.data = minValue(root.right);
            
            // 刪除繼承者
            root.right = deleteRec(root.right, root.data);
        }
        
        return root;
    }
    
    // 找出最小值
    private int minValue(Node root) {
        int minv = root.data;
        while (root.left != null) {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }
    
    // 中序遍歷（排序順序）
    public void inorderTraversal() {
        inorderRec(root);
        System.out.println();
    }
    
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    // 取得樹的高度
    public int getHeight() {
        return getHeightRec(root);
    }
    
    private int getHeightRec(Node root) {
        if (root == null)
            return 0;
        return Math.max(getHeightRec(root.left), getHeightRec(root.right)) + 1;
    }
    
    // 印出樹狀結構
    public void printTree() {
        printTreeRec(root, 0);
    }
    
    private void printTreeRec(Node root, int level) {
        if (root == null)
            return;
            
        printTreeRec(root.right, level + 1);
        
        for (int i = 0; i < level; i++)
            System.out.print("    ");
            
        System.out.println(root.data);
        
        printTreeRec(root.left, level + 1);
    }

}
