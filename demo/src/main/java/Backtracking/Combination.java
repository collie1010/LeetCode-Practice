package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combination {

	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		backtrack(1, n, k, new ArrayList<>(), result);
		return result;
	}

	private static void backtrack(int start, int n, int k, List<Integer> currCombination, List<List<Integer>> result) {
		// 基本情況：如果當前組合大小等於 k，表示找到一個有效組合
		if (currCombination.size() == k) {
			result.add(new ArrayList<>(currCombination));
			return;
		}

		// 從 start 開始遍歷到 n
		// 優化：i <= n - (k - current.size()) + 1
		// 這樣可以避免不必要的遍歷
		for (int i = start; i <= n - (k - currCombination.size()) + 1; i++) {
			// 選擇當前數字
			currCombination.add(i);

			// 遞迴處理下一個位置，從 i+1 開始
			backtrack(i + 1, n, k, currCombination, result);

			// 回溯：移除當前數字
			currCombination.remove(currCombination.size() - 1);
		}
	}

	// 另一個版本：從一個給定數組中選擇k個數的組合
	public static List<List<Integer>> combinationFromArray(int[] nums, int k) {
		List<List<Integer>> result = new ArrayList<>();
		backtrackArray(nums, 0, k, new ArrayList<>(), result);
		return result;
	}

	private static void backtrackArray(int[] nums, int start, int k, List<Integer> current,
			List<List<Integer>> result) {
		if (current.size() == k) {
			result.add(new ArrayList<>(current));
			return;
		}

		for (int i = start; i < nums.length; i++) {
			current.add(nums[i]);
			backtrackArray(nums, i + 1, k, current, result);
			current.remove(current.size() - 1);
		}
	}

	public static void main(String[] args) {
		// 測試從 1 到 4 中選擇 2 個數的組合
		int n = 4, k = 2;
		List<List<Integer>> result1 = combine(n, k);
		System.out.println("從 1 到 " + n + " 選擇 " + k + " 個數的組合：");
		for (List<Integer> comb : result1) {
			System.out.println(comb);
		}

        System.out.println("\n從數組中選擇組合：");
        int[] nums = {1, 2, 3, 4};
        List<List<Integer>> result2 = combinationFromArray(nums, 2);
        for (List<Integer> comb : result2) {
            System.out.println(comb);
        }
	}
}
