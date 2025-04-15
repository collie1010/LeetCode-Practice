package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationII {
	
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(nums, new boolean[nums.length], new ArrayList<>(), result);
        return result;
	}
	
	public static void backTrack(int[] nums, boolean[] used, List<Integer> currPermutation, List<List<Integer>> result) {
		
		if (currPermutation.size() == nums.length) {
			
			result.add(new ArrayList<>(currPermutation));
			return;
			
		} else {
			
			for(int i = 0; i < nums.length; i++) {
				if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue; 
				used[i] = true;
				currPermutation.add(nums[i]);
				backTrack(nums, used, currPermutation, result);
				used[i] = false;
				currPermutation.remove(currPermutation.size() - 1);
			}
		}
		
	}
	
	public static void main(String[] args) {
        // 創建 Solution 物件
		PermutationII solution = new PermutationII();
        
        // 測試案例
        int[][] testCases = {
            {1, 1, 2},       // 包含重複數字的案例
            {1, 2, 3},       // 不包含重複數字的案例
            {1, 1, 1},       // 全部數字相同的案例
            {1},             // 單一數字的案例
            {}               // 空陣列的案例
        };
        
        // 測試每個案例
        for (int[] nums : testCases) {
            System.out.println("Input array: " + Arrays.toString(nums));
            List<List<Integer>> result = solution.permuteUnique(nums);
            System.out.println("All unique permutations:");
            for (List<Integer> perm : result) {
                System.out.println(perm);
            }
            System.out.println("Total number of permutations: " + result.size());
            System.out.println("-----------------");
        }
    }
}
