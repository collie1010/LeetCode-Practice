package LinkedList;

public class ReverseLinkedList {
	
	public ListNode reverseLinkedList (ListNode head) {
		// 處理空串列
		if (head == null) {
			return null;
		}
		// 處理只有單一個節點的情況
		if (head.next == null) {
			return head;
		}
		
		ListNode prevNode = null;
		ListNode current = head;
		ListNode nextNode = null;
		
		while (current != null) {
			nextNode = current.next;
			current.next = prevNode;
			prevNode = current;
			current = nextNode;
		}
		
		return prevNode;
	}
	
	 public static void main(String[] args) {
	        ReverseLinkedList solution = new ReverseLinkedList();
	        
	        // 測試案例 1: [1,2,3,4,5]
	        System.out.println("測試案例 1:");
	        int[] arr1 = {1, 2, 3, 4, 5};
	        ListNode head1 = ListNode.createLinkedList(arr1);
	        System.out.println("反轉前:");
	        ListNode.printLinkedList(head1);
	        
	        ListNode reversed1 = solution.reverseLinkedList(head1);
	        System.out.println("反轉後:");
	        ListNode.printLinkedList(reversed1);
	        System.out.println();
	        
	        // 測試案例 2: [1,2]
	        System.out.println("測試案例 2:");
	        int[] arr2 = {1, 2};
	        ListNode head2 = ListNode.createLinkedList(arr2);
	        System.out.println("反轉前:");
	        ListNode.printLinkedList(head2);
	        
	        ListNode reversed2 = solution.reverseLinkedList(head2);
	        System.out.println("反轉後:");
	        ListNode. printLinkedList(reversed2);
	        System.out.println();
	        
	        // 測試案例 3: 空鏈表
	        System.out.println("測試案例 3 (空鏈表):");
	        ListNode head3 = null;
	        System.out.println("反轉前:");
	        ListNode.printLinkedList(head3);
	        
	        ListNode reversed3 = solution.reverseLinkedList(head3);
	        System.out.println("反轉後:");
	        ListNode.printLinkedList(reversed3);
	        System.out.println();
	        
	        // 測試案例 4: 單個節點
	        System.out.println("測試案例 4 (單個節點):");
	        ListNode head4 = new ListNode(1);
	        System.out.println("反轉前:");
	        ListNode.printLinkedList(head4);
	        
	        ListNode reversed4 = solution.reverseLinkedList(head4);
	        System.out.println("反轉後:");
	        ListNode.printLinkedList(reversed4);
	    }
	
}
