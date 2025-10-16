package Stack;

import java.util.Stack;

public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer>stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;
        for(int i = 0; i <= n;i++){
            int h = (i == n) ? 0: heights[i];
            while(!stack.isEmpty() && h < heights[stack.peek()]){
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i :i - stack.peek() -1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }

    // 測試輔助方法
    private static void testCase(int[] heights) {   
        LargestRectangleArea solution = new LargestRectangleArea();
        int result = solution.largestRectangleArea(heights);
        System.out.println("測試案例：");
        System.out.print("輸入高度陣列: [");
        for (int i = 0; i < heights.length; i++) {
            System.out.print(heights[i]);
            if (i < heights.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        System.out.println("結果: " + result);
        System.out.println("================");
    }   

    public static void main(String[] args) {
        // 測試案例1
        int[] heights1 = {2,1,5,6,2,3};
        testCase(heights1);

        // 測試案例2
        int[] heights2 = {2,4};
        testCase(heights2);

        // 測試案例3（單一高度）
        int[] heights3 = {5};
        testCase(heights3);

        // 測試案例4（遞增高度）
        int[] heights4 = {1,2,3,4,5};
        testCase(heights4);

        // 測試案例5（空陣列）
        int[] heights5 = {};
        testCase(heights5);
    }
}
