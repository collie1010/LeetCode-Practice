package TwoPointer;

public class MoveZero {
	public void moveZeroes(int[] nums) {
        int lastNonZeroFoundAt = 0;
        
        // 將所有非零元素往前移
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // 交換元素
                int temp = nums[lastNonZeroFoundAt];
                nums[lastNonZeroFoundAt] = nums[i];
                nums[i] = temp;
                
                lastNonZeroFoundAt++;
            }
        }
    }
}
