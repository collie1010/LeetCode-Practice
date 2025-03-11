package LinkedList;


public class MergeTwoSortedList {
    // 合併兩個已排序的鏈表
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
       
    	if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        // 當兩個鏈表都還有節點時
        while (list1 != null && list2 != null) {
           
        	if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            
            current = current.next;
        }
        
        // 處理剩餘節點
        if (list1 != null) {
            current.next = list1;
        }
        if (list2 != null) {
            current.next = list2;
        }
        
        return dummy.next;
    }
    
    // 遞迴解法
    public ListNode mergeTwoListsRecursive(ListNode list1, ListNode list2) {
        // 基本情況處理
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        
        // 遞迴合併
        if (list1.val <= list2.val) {
            list1.next = mergeTwoListsRecursive(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoListsRecursive(list1, list2.next);
            return list2;
        }
    }

    
    
    public static void main(String[] args) {
        MergeTwoSortedList solution = new MergeTwoSortedList();
        
        // 測試案例 1
        System.out.println("測試案例 1:");
        int[] arr1 = {1, 2, 4};
        int[] arr2 = {1, 3, 4};
        ListNode list1 = ListNode.createLinkedList(arr1);
        ListNode list2 = ListNode.createLinkedList(arr2);
        System.out.println("List1:");
        ListNode.printLinkedList(list1);
        System.out.println("List2:");
        ListNode.printLinkedList(list2);
        ListNode merged = solution.mergeTwoLists(list1, list2);
        System.out.println("合併後:");
        ListNode.printLinkedList(merged);
        System.out.println();
        
        // 測試案例 2
        System.out.println("測試案例 2 (空鏈表):");
        ListNode merged2 = solution.mergeTwoLists(null, null);
        System.out.println("合併後:");
        ListNode.printLinkedList(merged2);
        System.out.println();
        
        // 測試案例 3
        System.out.println("測試案例 3:");
        int[] arr3 = {0};
        ListNode list3 = ListNode.createLinkedList(arr3);
        ListNode merged3 = solution.mergeTwoLists(list3, null);
        System.out.println("合併後:");
        ListNode.printLinkedList(merged3);
    }
}
