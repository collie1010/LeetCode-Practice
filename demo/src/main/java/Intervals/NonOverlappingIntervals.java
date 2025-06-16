package Intervals;

import java.util.Arrays;

public class NonOverlappingIntervals {
	public int eraseOverlapIntervals(int[][] intervals) {
		int result = 0;

		Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
		int prev_end = intervals[0][1];

		for (int i = 1; i < intervals.length; i++) {
			if (prev_end > intervals[i][0])
				result++;
			else
				prev_end = intervals[i][1];
		}

		return result;
	}
	
	public static void main(String[] args) {
		 NonOverlappingIntervals solution = new NonOverlappingIntervals();
        
        // 測試案例 1: 基本重疊情況
        int[][] intervals1 = {{1,2}, {2,3}, {3,4}, {1,3}};
        int result1 = solution.eraseOverlapIntervals(intervals1);
        System.out.println("測試案例 1:");
        System.out.println("輸入: " + Arrays.deepToString(intervals1));
        System.out.println("需要移除的區間數量: " + result1 + "\n");
        

        // 測試案例 2: 完全重疊
        int[][] intervals2 = {{1,2}, {1,2}, {1,2}};
        int result2 = solution.eraseOverlapIntervals(intervals2);
        System.out.println("測試案例 2:");
        System.out.println("輸入: " + Arrays.deepToString(intervals2));
        System.out.println("需要移除的區間數量: " + result2 + "\n");

        // 測試案例 3: 無重疊
        int[][] intervals3 = {{1,2}, {2,3}, {3,4}};
        int result3 = solution.eraseOverlapIntervals(intervals3);
        System.out.println("測試案例 3:");
        System.out.println("輸入: " + Arrays.deepToString(intervals3));
        System.out.println("需要移除的區間數量: " + result3 + "\n");
        

        // 測試案例 4: 複雜重疊
        int[][] intervals4 = {{1,3}, {2,4}, {3,5}, {4,6}};
        int result4 = solution.eraseOverlapIntervals(intervals4);
        System.out.println("測試案例 4:");
        System.out.println("輸入: " + Arrays.deepToString(intervals4));
        System.out.println("需要移除的區間數量: " + result4 + "\n");
        

        // 測試案例 5: 單一區間
        int[][] intervals5 = {{1,2}};
        int result5 = solution.eraseOverlapIntervals(intervals5);
        System.out.println("測試案例 5:");
        System.out.println("輸入: " + Arrays.deepToString(intervals5));
        System.out.println("需要移除的區間數量: " + result5 + "\n");
        

        // 測試案例 6: 邊界情況
        int[][] intervals6 = {{-2,-1}, {-1,0}, {0,1}};
        int result6 = solution.eraseOverlapIntervals(intervals6);
        System.out.println("測試案例 6:");
        System.out.println("輸入: " + Arrays.deepToString(intervals6));
        System.out.println("需要移除的區間數量: " + result6 + "\n");
        
    }
}
