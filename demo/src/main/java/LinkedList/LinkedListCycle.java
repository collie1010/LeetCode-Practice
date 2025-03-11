package LinkedList;

public class LinkedListCycle {
	public boolean hasCycle (ListNode head) {
		
		if (head == null) {
			return false;
		}
		
		ListNode slow = head;
		ListNode fast = head;
		
		// 當快指針可以移動時繼續循環
		while (fast != null && fast.next != null) {
			// 慢指針移動一步
			slow = slow.next;
			// 快指針移動兩步
			fast = fast.next.next;
			// 如果快慢指針相遇就代表有循環
			if (slow == fast) {
				return true;
			}
		}
		// 如果快指針到達終點 代表沒有循環
		return false;
	}
	
	private static ListNode createCyclicList(int[] arr, int pos) {
        if (arr == null || arr.length == 0) return null;
        
        // 創建基本鏈表
        ListNode head = ListNode.createLinkedList(arr);
        
        // 如果 pos 為負數，表示不建立循環
        if (pos < 0) return head;
        
        // 找到循環的起點和終點
        ListNode cycleStart = head;
        for (int i = 0; i < pos; i++) {
            cycleStart = cycleStart.next;
        }
        
        // 找到最後一個節點
        ListNode last = head;
        while (last.next != null) {
            last = last.next;
        }
        
        // 建立循環
        last.next = cycleStart;
        
        return head;
    }
    
    public static void main(String[] args) {
        LinkedListCycle solution = new LinkedListCycle();
        
        // 測試案例 1: [3,2,0,-4], pos = 1
        System.out.println("測試案例 1:");
        ListNode head1 = createCyclicList(new int[]{3,2,0,-4}, 1);
        System.out.println("是否有循環: " + solution.hasCycle(head1));
        
        // 測試案例 2: [1,2], pos = 0
        System.out.println("\n測試案例 2:");
        ListNode head2 = createCyclicList(new int[]{1,2}, 0);
        System.out.println("是否有循環: " + solution.hasCycle(head2));
        
        // 測試案例 3: [1], pos = -1
        System.out.println("\n測試案例 3:");
        ListNode head3 = createCyclicList(new int[]{1}, -1);
        System.out.println("是否有循環: " + solution.hasCycle(head3));
    }
}
