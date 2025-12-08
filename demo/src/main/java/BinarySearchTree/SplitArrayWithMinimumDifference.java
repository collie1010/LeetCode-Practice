package BinarySearchTree;

public class SplitArrayWithMinimumDifference {
    public int minimumDifference(int[] nums) {
        int n = nums.length;

        // Prefix sum array to calculate sums efficiently
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        // Arrays to store strictly increasing and decreasing information
        boolean[] isIncreasing = new boolean[n];
        boolean[] isDecreasing = new boolean[n];

        // Fill isIncreasing array
        isIncreasing[0] = true;
        for (int i = 1; i < n; i++) {
            isIncreasing[i] = nums[i] > nums[i - 1] && isIncreasing[i - 1];
        }

        // Fill isDecreasing array
        isDecreasing[n - 1] = true;
        for (int i = n - 2; i >= 0; i--) {
            isDecreasing[i] = nums[i] > nums[i + 1] && isDecreasing[i + 1];
        }

        // Find the minimum difference
        int minDiff = Integer.MAX_VALUE;
        boolean validSplitExists = false;

        for (int i = 1; i < n; i++) {
            if (isIncreasing[i - 1] && isDecreasing[i]) {
                validSplitExists = true;

                // Calculate left and right sums using prefix sums
                int leftSum = prefixSum[i];
                int rightSum = prefixSum[n] - prefixSum[i];

                // Update minimum difference
                minDiff = Math.min(minDiff, Math.abs(leftSum - rightSum));
            }
        }

        return validSplitExists ? minDiff : -1;
    }

    public static void main(String[] args) {
        SplitArrayWithMinimumDifference solution = new SplitArrayWithMinimumDifference();

        // Example test cases
        int[] nums1 = {1, 3, 2};
        System.out.println(solution.minimumDifference(nums1)); // Output: 2

        int[] nums2 = {1, 2, 4, 3};
        System.out.println(solution.minimumDifference(nums2)); // Output: 4

        int[] nums3 = {3, 1, 2};
        System.out.println(solution.minimumDifference(nums3)); // Output: -1
    }
}

