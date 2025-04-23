package Array;

import java.util.Arrays;

public class MajorityElement {

	// Boyer-Moore 投票算法
	public static int majorityElement(int[] nums) {
		int count = 0;
		Integer candidate = null;

		for (int num : nums) {
			if (count == 0) {
				candidate = num;
			}
			count += (num == candidate) ? 1 : -1;
		}

		return candidate;
	}

	public static int majorityElementSort(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length / 2];
	}

	public static void main(String[] args) {
		// 測試案例
		int[][] testCases = { { 3, 2, 3 }, // 案例 1
				{ 2, 2, 1, 1, 1, 2, 2 }, // 案例 2
				{ 1 }, // 單一元素
				{ 1, 1, 1, 1, 2, 2, 2 }, // 多數元素在前
				{ 2, 2, 2, 1, 1, 1, 1 } // 多數元素在後
		};

		System.out.println("多數元素測試程式");
		System.out.println("==============");

		for (int i = 0; i < testCases.length; i++) {
			System.out.printf("測試案例 %d:%n", i + 1);
			System.out.print("輸入陣列: ");
			printArray(testCases[i]);

			// 使用 Boyer-Moore 算法
			int result1 = majorityElement(testCases[i]);
			System.out.println("Boyer-Moore 算法結果: " + result1);

			// 使用排序法
			int result2 = majorityElementSort(testCases[i].clone());
			System.out.println("排序法結果: " + result2);
		}

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
