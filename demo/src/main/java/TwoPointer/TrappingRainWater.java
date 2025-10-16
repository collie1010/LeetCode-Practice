package TwoPointer;

public class TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;

        int left = 0, right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int totalWater = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                totalWater += leftMax - height[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                totalWater += rightMax - height[right];
            }
        }

        return totalWater;
    }

    // 測試輔助方法
    private static void testCase(int[] height) {
        TrappingRainWater solution = new TrappingRainWater();
        int result = solution.trap(height);
        System.out.println("測試案例：");
        System.out.print("輸入高度陣列: [");
        for (int i = 0; i < height.length; i++) {
            System.out.print(height[i]);
            if (i < height.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        System.out.println("結果: " + result);
        System.out.println("================");
    }

    public static void main(String[] args) {
        // 測試案例1
        int[] height1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        testCase(height1);

        // 測試案例2
        int[] height2 = {4,2,0,3,2,5};
        testCase(height2);

        // 測試案例3（無法儲水）
        int[] height3 = {1,2,3,4,5};
        testCase(height3);

        // 測試案例4（空陣列）
        int[] height4 = {};
        testCase(height4);
    }
}   
