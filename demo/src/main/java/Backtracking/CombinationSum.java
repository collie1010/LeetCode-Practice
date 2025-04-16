package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {

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
				currSum.add(candidates[i]);
				backTrack(candidates, i, remain - candidates[i], currSum, result);
				currSum.remove(currSum.size() - 1);
			}

		}
	}

	public static void main(String[] args) {
		// 創建 CombinationSum 物件
		CombinationSum solution = new CombinationSum();

		// 測試用的候選數字陣列與目標值
		int[][] testCases = { { 2, 3, 6, 7 }, // 測試案例 1
				{ 2, 3, 5 }, // 測試案例 2
				{ 2 }, // 測試案例 3
				{ 1 } // 測試案例 4
		};

		int[] targets = { 7, 8, 3, 2 };

		// 執行測試
		for (int i = 0; i < testCases.length; i++) {
			System.out.println("Test Case " + (i + 1) + ":");
			System.out.println("Candidates: " + Arrays.toString(testCases[i]));
			System.out.println("Target: " + targets[i]);

			List<List<Integer>> result = solution.combinationSum(testCases[i], targets[i]);

			System.out.println("All combinations:");
			for (List<Integer> combination : result) {
				System.out.println(combination);
			}
			System.out.println("Number of combinations: " + result.size());
			System.out.println("------------------------");
		}
	}
}
