package LinkedList;

public class ReverseLinkedListII {
	
	public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        ListNode curr = prev.next;

        for (int i = 0; i < right - left; i++) {
            ListNode temp = curr.next;
            curr.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
        }

        return dummy.next;
    }
	
	public static void main(String[] args) {
		int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
		ListNode list = ListNode.createLinkedList(arr);
		
		ReverseLinkedListII solution = new ReverseLinkedListII();
		solution.reverseBetween(list, 2, 4);
		ListNode.printLinkedList(list);
	}
}
