package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
	
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		backTrack(nums, 0, new ArrayList<>(), result);
		return result;
	}
	
	private static void backTrack(int[] nums, int start, List<Integer> subset, List<List<Integer>> result) {
		result.add(new ArrayList<>(subset));
		
		for (int i = start; i < nums.length; i++) {
			if(i > start && nums[i] == nums[i - 1]) 
				continue;
			subset.add(nums[i]);
			backTrack(nums, i + 1, subset, result);
			subset.remove(subset.size() - 1);
		}
	}
	
	  public static void main(String[] args) {

		  	SubsetsII solution = new SubsetsII();
	        
	        // 測試案例
	        int[][] testCases = {
	            {1, 2, 2},           // 包含重複數字的案例
	            {1, 2, 3},           // 不包含重複數字的案例
	            {1, 1, 1},           // 全部數字相同的案例
	            {1},                 // 單一數字的案例
	            {}                   // 空陣列的案例
	        };
	        
	        // 執行測試
	        for (int i = 0; i < testCases.length; i++) {
	            System.out.println("Test Case " + (i + 1) + ":");
	            System.out.println("Input array: " + Arrays.toString(testCases[i]));
	            
	            List<List<Integer>> result = solution.subsets(testCases[i]);
	            
	            System.out.println("All unique subsets:");
	            for (List<Integer> subset : result) {
	                System.out.println(subset);
	            }
	            System.out.println("Number of subsets: " + result.size());
	            System.out.println("------------------------");
	        }
	    }
	
}
	
