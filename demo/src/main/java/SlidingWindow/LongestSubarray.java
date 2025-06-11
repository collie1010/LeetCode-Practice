package SlidingWindow;

public class LongestSubarray {
	public int longestSubarray(int[] nums) {
        int left = 0;           // 左指針
        int zeroCount = 0;      // 窗口內0的數量
        int maxLength = 0;      // 最長子數組長度
        
        // 右指針遍歷數組
        for (int right = 0; right < nums.length; right++) {
            // 如果當前數字是0，增加0的計數
            if (nums[right] == 0) {
                zeroCount++;
            }
            
            // 如果窗口內的0超過1個，需要移動左指針
            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            
            // 更新最大長度（注意要減1，因為必須刪除一個元素）
            maxLength = Math.max(maxLength, right - left + 1 - 1);
        }
        
        // 如果原數組全是1，則必須刪除一個，所以返回長度減1
        return maxLength;
    }
}
