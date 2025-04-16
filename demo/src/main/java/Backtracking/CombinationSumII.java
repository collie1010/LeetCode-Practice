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
	
	private static void backTrack(int[] candidates, int start, int remain, List<Integer> currSum, List<List<Integer>> result) {
		
		if (remain < 0) {
			return;
		} else if (remain == 0) {
			result.add(new ArrayList<>(currSum));
		} else {
			for (int i = start; i < candidates.length; i++) {
				 if(i > start && candidates[i] == candidates[i-1]) continue;
				currSum.add(candidates[i]);
				backTrack(candidates, i + 1, remain - candidates[i], currSum, result);
				currSum.remove(currSum.size() - 1);
			}
		}
		
	}
}
