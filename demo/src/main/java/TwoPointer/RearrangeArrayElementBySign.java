package TwoPointer;

public class RearrangeArrayElementBySign {
	public int[] rearrangeArray(int[] nums) {
		int n = nums.length;

		// Initializing an answer array of size n
		int[] ans = new int[n];

		// Initializing two pointers to track even and
		// odd indices for positive and negative integers respectively
		int posIndex = 0, negIndex = 1;

		for (int i = 0; i < n; i++) {
			if (nums[i] > 0) {
				// Placing the positive integer at the
				// desired index in ans and incrementing posIndex by 2
				ans[posIndex] = nums[i];
				posIndex += 2;
			} else {
				// Placing the negative integer at the
				// desired index in ans and incrementing negIndex by 2
				ans[negIndex] = nums[i];
				negIndex += 2;
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		// 創建類的實例
		RearrangeArrayElementBySign solution = new RearrangeArrayElementBySign();

		// 測試案例1
		int[] nums1 = { 3, -2, 1, -5, 2, -4 };
		System.out.println("測試案例 1:");
		System.out.print("輸入陣列: ");
		printArray(nums1);
		int[] result1 = solution.rearrangeArray(nums1);
		System.out.print("輸出陣列: ");
		printArray(result1);
		System.out.println();

		// 測試案例2
		int[] nums2 = { 1, -1, 2, -2, 3, -3 };
		System.out.println("測試案例 2:");
		System.out.print("輸入陣列: ");
		printArray(nums2);
		int[] result2 = solution.rearrangeArray(nums2);
		System.out.print("輸出陣列: ");
		printArray(result2);
	}

	// 輔助方法：印出陣列
	private static void printArray(int[] arr) {
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (i < arr.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}
}
