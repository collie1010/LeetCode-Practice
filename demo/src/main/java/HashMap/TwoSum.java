package HashMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {

		// 使用 HashMap 儲存數字和索引
		Map<Integer, Integer> numMap = new HashMap<>();

		// 遍歷數組
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];

			// 檢查是否存在互補的數字
			if (numMap.containsKey(complement)) {
				return new int[] { numMap.get(complement), i };
			}

			// 將當前數字和索引加入 Map
			numMap.put(nums[i], i);
		}

		// 依題目說明，一定會有解，所以不會執行到這裡
		return new int[] {};
	}

	public static void main(String[] args) {
		// 創建 TwoSum 實例
		TwoSum solution = new TwoSum();

		// 測試案例 1
		int[] nums1 = { 2, 7, 11, 15 };
		int target1 = 9;
		System.out.println("測試案例 1:");
		System.out.println("數組: " + Arrays.toString(nums1));
		System.out.println("目標值: " + target1);
		int[] result1 = solution.twoSum(nums1, target1);
		System.out.println("結果索引: " + Arrays.toString(result1));
		System.out.println("對應數字: [" + nums1[result1[0]] + ", " + nums1[result1[1]] + "]");
		System.out.println();

		// 測試案例 2
		int[] nums2 = { 3, 2, 4 };
		int target2 = 6;
		System.out.println("測試案例 2:");
		System.out.println("數組: " + Arrays.toString(nums2));
		System.out.println("目標值: " + target2);
		int[] result2 = solution.twoSum(nums2, target2);
		System.out.println("結果索引: " + Arrays.toString(result2));
		System.out.println("對應數字: [" + nums2[result2[0]] + ", " + nums2[result2[1]] + "]");
		System.out.println();

		// 測試案例 3
		int[] nums3 = { 3, 3 };
		int target3 = 6;
		System.out.println("測試案例 3:");
		System.out.println("數組: " + Arrays.toString(nums3));
		System.out.println("目標值: " + target3);
		int[] result3 = solution.twoSum(nums3, target3);
		System.out.println("結果索引: " + Arrays.toString(result3));
		System.out.println("對應數字: [" + nums3[result3[0]] + ", " + nums3[result3[1]] + "]");
	}
}
