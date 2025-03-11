package LinkedList;

public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode list1, ListNode list2) {
		// 創建虛擬頭節點
		ListNode dummy = new ListNode(0);
		ListNode current = dummy;
		int carry = 0;
		
		// 當兩個串列都沒有遍歷玩或有進位時繼續
		while (list1 != null || list2 != null || carry > 0) {
			
			// 獲取當前位的值，如果串列已經遍歷完則為0
			int sum = carry;
			if (list1 != null) {
				sum += list1.val;
				list1 = list1.next;
			}
			
			if (list2 != null) {
				sum += list2.val;
				list2 = list2.next;
			}
			// 計算新的進位值和當前位的值
			carry = sum / 10;
			sum = sum % 10;
			
			// 創建新的節點
			current.next = new ListNode(sum);
			current = current.next;
		}
		
		return dummy.next;
		
	}
	 public static void main(String[] args) {
	        AddTwoNumbers solution = new AddTwoNumbers();
	        
	        // 測試案例 1: l1 = [2,4,3], l2 = [5,6,4]
	        System.out.println("測試案例 1:");
	        ListNode l1 = ListNode.createLinkedList(new int[]{2,4,3});
	        ListNode l2 = ListNode.createLinkedList(new int[]{5,6,4});
	        System.out.println("數字 1:");
	        ListNode.printLinkedList(l1);
	        System.out.println("數字 2:");
	        ListNode.printLinkedList(l2);
	        ListNode result1 = solution.addTwoNumbers(l1, l2);
	        System.out.println("相加結果:");
	        ListNode.printLinkedList(result1);
	        System.out.println();
	        
	        // 測試案例 2: l1 = [0], l2 = [0]
	        System.out.println("測試案例 2:");
	        ListNode l3 = ListNode.createLinkedList(new int[]{0});
	        ListNode l4 = ListNode.createLinkedList(new int[]{0});
	        System.out.println("數字 1:");
	        ListNode.printLinkedList(l3);
	        System.out.println("數字 2:");
	        ListNode.printLinkedList(l4);
	        ListNode result2 = solution.addTwoNumbers(l3, l4);
	        System.out.println("相加結果:");
	        ListNode.printLinkedList(result2);
	        System.out.println();
	        
	        // 測試案例 3: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
	        System.out.println("測試案例 3:");
	        ListNode l5 = ListNode.createLinkedList(new int[]{9,9,9,9,9,9,9});
	        ListNode l6 = ListNode.createLinkedList(new int[]{9,9,9,9});
	        System.out.println("數字 1:");
	        ListNode.printLinkedList(l5);
	        System.out.println("數字 2:");
	        ListNode.printLinkedList(l6);
	        ListNode result3 = solution.addTwoNumbers(l5, l6);
	        System.out.println("相加結果:");
	        ListNode.printLinkedList(result3);
	    }
}
