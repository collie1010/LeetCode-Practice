package LinkedList;

public class PartitionList {
	
	public ListNode partition (ListNode head, int x) {
		
		 // 創建兩個虛擬頭節點
        ListNode smallerHead = new ListNode(0);
        ListNode biggerHead = new ListNode(0);
        
        // 創建兩個指針來構建兩個子鏈表
        ListNode smaller = smallerHead;
        ListNode bigger = biggerHead;
        
        // 遍歷原始鏈表
        while (head != null) {
            if (head.val < x) {
                // 將節點加入到較小值的鏈表
                smaller.next = head;
                smaller = smaller.next;
            } else {
                // 將節點加入到較大值的鏈表
                bigger.next = head;
                bigger = bigger.next;
            }
            head = head.next;
        }
        
        // 將較大值鏈表的末尾設為 null
        bigger.next = null;
        // 將較小值鏈表與較大值鏈表連接
        smaller.next = biggerHead.next;
        
        return smallerHead.next;
	}
	
	  public static void main(String[] args) {
	        PartitionList solution = new PartitionList();

	        // 測試案例 1: [1,4,3,2,5,2], x = 3
	        System.out.println("測試案例 1:");
	        int[] arr1 = {1,4,3,2,5,2};
	        ListNode head1 = ListNode.createLinkedList(arr1);
	        System.out.println("原始鏈表:");
	        ListNode.printLinkedList(head1);
	        
	        System.out.println("分割點 x = 3");
	        ListNode result1 = solution.partition(head1, 3);
	        System.out.println("分割後的鏈表:");
	        ListNode.printLinkedList(result1);
	        System.out.println();
	        
	        // 測試案例 2: [2,1], x = 2
	        System.out.println("測試案例 2:");
	        int[] arr2 = {2,1};
	        ListNode head2 = ListNode.createLinkedList(arr2);
	        System.out.println("原始鏈表:");
	        ListNode.printLinkedList(head2);
	        
	        System.out.println("分割點 x = 2");
	        ListNode result2 = solution.partition(head2, 2);
	        System.out.println("分割後的鏈表:");
	        ListNode.printLinkedList(result2);
	        System.out.println();
	        
	        // 測試案例 3: 空鏈表
	        System.out.println("測試案例 3 (空鏈表):");
	        ListNode head3 = null;
	        System.out.println("原始鏈表:");
	        ListNode.printLinkedList(head3);
	        
	        System.out.println("分割點 x = 1");
	        ListNode result3 = solution.partition(head3, 1);
	        System.out.println("分割後的鏈表:");
	        ListNode.printLinkedList(result3);
	        System.out.println();
	        
	        // 測試案例 4: 單個節點
	        System.out.println("測試案例 4 (單個節點):");
	        int[] arr4 = {1};
	        ListNode head4 = ListNode.createLinkedList(arr4);
	        System.out.println("原始鏈表:");
	        ListNode.printLinkedList(head4);
	        
	        System.out.println("分割點 x = 0");
	        ListNode result4 = solution.partition(head4, 0);
	        System.out.println("分割後的鏈表:");
	        ListNode.printLinkedList(result4);
	    }
	
}
