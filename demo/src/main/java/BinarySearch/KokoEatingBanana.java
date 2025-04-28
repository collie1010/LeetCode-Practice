package BinarySearch;

/**
 * 輸入：piles = [3,6,7,11], h = 8
 * 輸出：4
 * 解釋：
 * 如果 k = 4（每小時吃4根香蕉）
 * 第一堆(3根)：需要1小時吃完
 * 第二堆(6根)：需要2小時吃完（每小時4根）
 * 第三堆(7根)：需要2小時吃完
 * 第四堆(11根)：需要3小時吃完
 * 總共需要 1 + 2 + 2 + 3 = 8 小時
 *  
 * */
public class KokoEatingBanana {
	public int minEatingSpeed(int[] piles, int h) {
        // 1. 確定二分搜尋的範圍
        int left = 1;  // 最小速度
        int right = getMaxPile(piles);  // 最大速度
        
        // 2. 進行二分搜尋
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // 如果以當前速度可以在h小時內吃完
            if (canEatAll(piles, mid, h)) {
                right = mid;  // 嘗試更小的速度
            } else {
                left = mid + 1;  // 需要更大的速度
            }
        }
        
        return left;
    }
    
    // 輔助函數：計算以給定速度是否能在h小時內吃完所有香蕉
    private boolean canEatAll(int[] piles, int speed, int h) {
        long totalHours = 0;  // 使用long避免溢出
        
        for (int pile : piles) {
            // 計算吃完每堆香蕉需要的時間
            // 使用向上取整：(pile - 1) / speed + 1
            totalHours += (pile - 1) / speed + 1;
            
            // 如果已經超過h小時，直接返回false
            if (totalHours > h) {
                return false;
            }
        }
        
        return totalHours <= h;
    }
    
    // 輔助函數：找出最大的香蕉堆
    private int getMaxPile(int[] piles) {
        int maxPile = piles[0];
        for (int pile : piles) {
            maxPile = Math.max(maxPile, pile);
        }
        return maxPile;
    }
    
    public static void main(String[] args) {
    	KokoEatingBanana solution = new KokoEatingBanana();
        
        // 測試案例1
        int[] piles1 = {3, 6, 7, 11};
        int h1 = 8;
        System.out.println("測試案例 1:");
        System.out.println("香蕉堆: " + arrayToString(piles1));
        System.out.println("時間限制: " + h1 + " 小時");
        System.out.println("最小吃香蕉速度: " + solution.minEatingSpeed(piles1, h1));
        System.out.println();
        
        // 測試案例2
        int[] piles2 = {30, 11, 23, 4, 20};
        int h2 = 5;
        System.out.println("測試案例 2:");
        System.out.println("香蕉堆: " + arrayToString(piles2));
        System.out.println("時間限制: " + h2 + " 小時");
        System.out.println("最小吃香蕉速度: " + solution.minEatingSpeed(piles2, h2));
        System.out.println();
        
        // 測試案例3
        int[] piles3 = {30, 11, 23, 4, 20};
        int h3 = 6;
        System.out.println("測試案例 3:");
        System.out.println("香蕉堆: " + arrayToString(piles3));
        System.out.println("時間限制: " + h3 + " 小時");
        System.out.println("最小吃香蕉速度: " + solution.minEatingSpeed(piles3, h3));
        System.out.println();
        
        // 額外測試案例
        int[] piles4 = {312884470};
        int h4 = 312884469;
        System.out.println("測試案例 4 (大數測試):");
        System.out.println("香蕉堆: " + arrayToString(piles4));
        System.out.println("時間限制: " + h4 + " 小時");
        System.out.println("最小吃香蕉速度: " + solution.minEatingSpeed(piles4, h4));
    }
    
    // 輔助方法：將陣列轉換為字串
    private static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
