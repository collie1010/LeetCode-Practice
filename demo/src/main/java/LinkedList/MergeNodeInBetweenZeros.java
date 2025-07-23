package LinkedList;

public class MergeNodeInBetweenZeros {
    public ListNode mergeNodes(ListNode head) {
        ListNode modify = head.next;
        ListNode nextSum = modify;

        while (nextSum != null) {
            int sum = 0;
            while (nextSum.val != 0) {
                sum += nextSum.val;
                nextSum = nextSum.next;
            }

            modify.val = sum;
            nextSum = nextSum.next;
            modify.next = nextSum;
            modify = modify.next;
        }

        return head.next;
    }

    public static void main(String[] args) {
        MergeNodeInBetweenZeros solution = new MergeNodeInBetweenZeros();

        // 測試案例 1
        ListNode head1 = new ListNode(0, new ListNode(3, new ListNode(1, new ListNode(0, new ListNode(4, new ListNode(5, new ListNode(0)))))));
        ListNode result1 = solution.mergeNodes(head1);
        System.out.print("Output: ");
        while (result1 != null) {
            System.out.print(result1.val + " ");
            result1 = result1.next;
        }
        
        System.out.println();

        // 測試案例 2
        ListNode head2 = new ListNode(0, new ListNode(1, new ListNode(0, new ListNode(2, new ListNode(0)))));
        ListNode result2 = solution.mergeNodes(head2);
        System.out.print("Output: ");
        while (result2 != null) {
            System.out.print(result2.val + " ");
            result2 = result2.next;
        }
        
    }
}
