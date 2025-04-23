package Array;

public class SingleNumber {
	
	public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
	
	public static void main(String[] args) {
        // 建立 SingleNumber 的實例
        SingleNumber solution = new SingleNumber();
        
        // 測試案例1：[2,2,1]
        int[] nums1 = {2, 2, 1};
        System.out.println("測試案例1: ");
        System.out.print("輸入陣列: ");
        printArray(nums1);
        System.out.println("只出現一次的數字是: " + solution.singleNumber(nums1));
        
        // 測試案例2：[4,1,2,1,2]
        int[] nums2 = {4, 1, 2, 1, 2};
        System.out.println("\n測試案例2: ");
        System.out.print("輸入陣列: ");
        printArray(nums2);
        System.out.println("只出現一次的數字是: " + solution.singleNumber(nums2));
    }
    
    // 輔助方法：印出陣列
    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
	
}
