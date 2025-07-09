package TwoPointer;

import java.util.Arrays;

public class FindDuplicate {
	public int findDuplicate(int[] nums) {
		// 第一階段：檢測環
		int slow = 0, fast = 0;
		while (true) {
			slow = nums[slow]; // 慢指針每次走一步
			fast = nums[nums[fast]]; // 快指針每次走兩步
			if (slow == fast)
				break; // 當兩指針相遇時跳出
		}

		// 第二階段：找出環的入口（重複的數字）
		int slow2 = 0;
		while (true) {
			slow = nums[slow]; // 第一個慢指針繼續走
			slow2 = nums[slow2]; // 第二個慢指針從起點開始走
			if (slow == slow2)
				return slow; // 相遇點即為重複數字
		}
	}

	public static void main(String[] args) {
		FindDuplicate solution = new FindDuplicate();

		// 測試案例 1
		int[] nums1 = { 1, 3, 4, 2, 2 };
		System.out.println("測試案例 1:");
		System.out.println("輸入陣列: " + arrayToString(nums1));
		System.out.println("重複的數字是: " + solution.findDuplicate(nums1));

		// 測試案例 2
		int[] nums2 = { 3, 1, 3, 4, 2 };
		System.out.println("\n測試案例 2:");
		System.out.println("輸入陣列: " + arrayToString(nums2));
		System.out.println("重複的數字是: " + solution.findDuplicate(nums2));

		// 測試案例 3
		int[] nums3 = { 1, 1 };
		System.out.println("\n測試案例 3:");
		System.out.println("輸入陣列: " + arrayToString(nums3));
		System.out.println("重複的數字是: " + solution.findDuplicate(nums3));
		
		int[] num = {1,2,3};
		int a = Arrays.stream(num).min().getAsInt();
		System.out.println(a);
	}

	// 輔助方法：將陣列轉換為字串
	private static String arrayToString(int[] arr) {
		StringBuilder sb = new StringBuilder("[");
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
			if (i < arr.length - 1) {
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}
}
