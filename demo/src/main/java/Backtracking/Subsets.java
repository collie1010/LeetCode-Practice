package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

	public List<List<Integer>> subsets(int[] nums) {

		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		backTrack(nums, 0, new ArrayList<>(), result);
		return result;
	}

	private static void backTrack(int[] nums, int start, List<Integer> subset, List<List<Integer>> result) {

		result.add(new ArrayList<>(subset));
		for (int i = start; i < nums.length; i++) {
			subset.add(nums[i]);
			backTrack(nums, i + 1, subset, result);
			subset.remove(subset.size() - 1);
		}

	}

	public static void main(String[] args) {
		// 創建 Subsets 物件
		Subsets solution = new Subsets();

		// 測試用的輸入陣列
		int[] nums = {1, 2, 3};

		// 取得所有子集合
		List<List<Integer>> result = solution.subsets(nums);

		// 印出結果
		System.out.println("Input array: " + Arrays.toString(nums));
		System.out.println("All subsets:");
		for (List<Integer> subset : result) {
			System.out.println(subset);
		}
	}
}
