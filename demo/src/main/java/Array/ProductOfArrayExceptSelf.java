package Array;

public class ProductOfArrayExceptSelf {

	public int[] productExceptSelf(int[] nums) {

		int n = nums.length;
		int[] answer = new int[n];

		// 先把 answer 陣列填入從左到右的乘積
		answer[0] = 1;
		for (int i = 1; i < n; i++) {
			answer[i] = answer[i - 1] * nums[i - 1];
		}

		// 從右到左乘過去
		int rightProduct = 1;
		for (int i = n - 1; i >= 0; i--) {
			answer[i] = answer[i] * rightProduct;
			rightProduct *= nums[i];
		}

		return answer;

	}
	
	public static void main(String[] args) {
		ProductOfArrayExceptSelf solution = new ProductOfArrayExceptSelf();
        
        // 測試案例 1
        int[] nums1 = {1, 2, 3, 4};
        System.out.println("測試案例 1:");
        System.out.print("輸入: ");
        printArray(nums1);
        System.out.print("輸出: ");
        printArray(solution.productExceptSelf(nums1));
        
        // 測試案例 2
        int[] nums2 = {-1, 1, 0, -3, 3};
        System.out.println("\n測試案例 2:");
        System.out.print("輸入: ");
        printArray(nums2);
        System.out.print("輸出: ");
        printArray(solution.productExceptSelf(nums2));
    }
    
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
