package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(candidates);
		backTrack(candidates, 0, target, new ArrayList<>(), result);
		return result;
	}

	private static void backTrack(int[] candidates, int start, int remain, List<Integer> currSum,
			List<List<Integer>> result) {

		if (remain < 0) {
			return;
		} else if (remain == 0) {
			result.add(new ArrayList<>(currSum));
		} else {
			for (int i = start; i < candidates.length; i++) {
				// 跳過重複的元素
				if (i > start && candidates[i] == candidates[i - 1])
					continue;
				currSum.add(candidates[i]);
				backTrack(candidates, i + 1, remain - candidates[i], currSum, result);
				currSum.remove(currSum.size() - 1);
			}
		}

	}

	public static void main(String[] args) {
		// 創建 CombinationSumII 物件
		CombinationSumII solution = new CombinationSumII();

		// 測試案例
		int[][] testCases = { { 10, 1, 2, 7, 6, 1, 5 }, // 測試案例 1
				{ 2, 5, 2, 1, 2 }, // 測試案例 2
				{ 1, 1, 1, 1, 1 }, // 測試案例 3：多個重複數字
				{ 1 }, // 測試案例 4：單一數字
				{} // 測試案例 5：空陣列
		};

		int[] targets = { 8, 5, 3, 1, 0 };

		// 執行測試
		for (int i = 0; i < testCases.length; i++) {
			System.out.println("Test Case " + (i + 1) + ":");
			System.out.println("Candidates: " + Arrays.toString(testCases[i]));
			System.out.println("Target: " + targets[i]);

			List<List<Integer>> result = solution.combinationSum2(testCases[i], targets[i]);

			if (result.isEmpty()) {
				System.out.println("No combinations found");
			} else {
				System.out.println("All unique combinations:");
				for (List<Integer> combination : result) {
					System.out.println(combination);
				}
			}
			System.out.println("Number of combinations: " + result.size());
			System.out.println("------------------------");
		}
	}
}
