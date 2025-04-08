package Array;

public class RunningSumOf1DArray {
	public int[] runningSum(int[] nums) {
        int size = nums.length;
        int[] result = new int [size];

        int count = 0;

        for (int i=0; i<size; i++) {
            count += nums[i];
            result[i] = count;
        }
        
        return result;
    }
}
