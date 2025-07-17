package HashMap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 將所有數字放入 HashSet 中
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int maxLength = 0;

        // 遍歷每個數字
        for (int num : numSet) {
            // 只有當 num 是序列的起始點時才開始計算
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;

                // 向右延伸序列
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }

                // 更新最大長度
                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence solution = new LongestConsecutiveSequence();
        
        // 測試案例 1
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Output: " + solution.longestConsecutive(nums1));
        System.out.println("Expected: 4\n");
        
        // 測試案例 2
        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("Output: " + solution.longestConsecutive(nums2));
        System.out.println("Expected: 9\n");
        
        // 測試案例 3
        int[] nums3 = {1, 0, 1, 2};
        System.out.println("Input: " + Arrays.toString(nums3));
        System.out.println("Output: " + solution.longestConsecutive(nums3));
        System.out.println("Expected: 3\n");
        
        // 邊界測試
        int[] nums4 = {};
        System.out.println("Input: " + Arrays.toString(nums4));
        System.out.println("Output: " + solution.longestConsecutive(nums4));
        System.out.println("Expected: 0\n");
        
        int[] nums5 = {1};
        System.out.println("Input: " + Arrays.toString(nums5));
        System.out.println("Output: " + solution.longestConsecutive(nums5));
        System.out.println("Expected: 1");
    }
}
