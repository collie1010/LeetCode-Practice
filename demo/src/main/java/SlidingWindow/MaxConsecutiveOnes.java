package SlidingWindow;

public class MaxConsecutiveOnes {
	public int longestOnes(int[] nums, int k) {
        // 定義雙指針作為滑動窗口的左右邊界
        int left = 0;
        int maxLength = 0;
        int zeroCount = 0;  // 記錄窗口內0的個數
        
        // 右指針遍歷數組
        for (int right = 0; right < nums.length; right++) {
            // 如果當前數字是0，增加0的計數
            if (nums[right] == 0) {
                zeroCount++;
            }
            
            // 當窗口內的0的數量超過k時，需要移動左指針
            while (zeroCount > k) {
                // 如果左指針指向的是0，則減少0的計數
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            
            // 更新最大長度
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}
