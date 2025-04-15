package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		// 用來追蹤數字是否已經使用過
		boolean[] used = new boolean[nums.length];
		// 用來存儲當前的排列
		List<Integer> currentPermutation = new ArrayList<>();

		backtrack(nums, used, currentPermutation, result);
		return result;
	}

	private static void backtrack(int[] nums, boolean[] used, List<Integer> currPermutation,
			List<List<Integer>> result) {
		
		// 基本情況：如果當前排列長度等於數組長度，表示找到一個完整排列
		if (currPermutation.size() == nums.length) {
			result.add(new ArrayList<>(currPermutation));
			return;
		}

		// 遍歷所有數字
		for (int i = 0; i < nums.length; i++) {
			// 如果數字已經使用過，則跳過
			if (used[i])
				continue;

			// 選擇當前數字
			used[i] = true;
			currPermutation.add(nums[i]);
			
			// 遞迴處理下一個位置
			backtrack(nums, used, currPermutation, result);

			// 回溯：移除當前數字，標記為未使用
			used[i] = false;
			currPermutation.remove(currPermutation.size() - 1);
		}
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		List<List<Integer>> result = permute(nums);

		// 印出所有排列
		System.out.println("所有可能的排列：");
		for (List<Integer> perm : result) {
			System.out.println(perm);
		}
	}
}
