package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> result = new ArrayList<>();
		backTrack(1, k, n, new ArrayList<>(), result);
		return result;
	}

	private static void backTrack(int start, int k, int n, List<Integer> currSum, List<List<Integer>> result) {

		if (k == 0 && n == 0) {
			result.add(new ArrayList<>(currSum));
		}

		for (int i = start; i <= 9; i++) {
			if (i > n)
				break;
			currSum.add(i);
			backTrack(i + 1, k - 1, n - i, currSum, result);
			currSum.remove(currSum.size() - 1);
		}

	}

	public static void main(String[] args) {
		// 創建 CombinationSumIII 物件
		CombinationSumIII solution = new CombinationSumIII();

		// 測試案例：每個案例包含 k（要選擇的數字個數）和 n（目標總和）
		int[][] testCases = { { 3, 7 }, // 從 1-9 中選擇 3 個數字，總和為 7
				{ 3, 9 }, // 從 1-9 中選擇 3 個數字，總和為 9
				{ 4, 1 }, // 不可能的案例
				{ 2, 18 }, // 不可能的案例（因為只能用1-9的數字）
				{ 2, 10 }, // 從 1-9 中選擇 2 個數字，總和為 10
		};

		// 執行測試
		for (int[] test : testCases) {
			int k = test[0];
			int n = test[1];

			System.out.println("Finding combinations where:");
			System.out.println("k (number of digits) = " + k);
			System.out.println("n (target sum) = " + n);

			List<List<Integer>> result = solution.combinationSum3(k, n);

			if (result.isEmpty()) {
				System.out.println("No valid combinations found");
			} else {
				System.out.println("Valid combinations:");
				for (List<Integer> combination : result) {
					System.out.println(combination);
				}
			}
			System.out.println("Number of combinations: " + result.size());
			System.out.println("------------------------");
		}
	}

}
