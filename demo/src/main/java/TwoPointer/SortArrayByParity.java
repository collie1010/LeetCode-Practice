package TwoPointer;

public class SortArrayByParity {

	public int[] sortArrayByParity(int[] nums) {

		int[] result = new int[nums.length];
		int evenIndex = 0;
		int oddIndex = nums.length - 1;

		for (int num : nums) {
			if (num % 2 == 0) {
				result[evenIndex] = num;
				evenIndex++;
			} else {
				result[oddIndex] = num;
				oddIndex--;
			}
		}

		return result;

	}

	public static void main(String[] args) {
		// 建立測試案例
		int[][] testCases = { { 3, 1, 2, 4 }, // 測試案例 1
				{ 0, 1, 2, 3, 4, 5 }, // 測試案例 2
				{ 1, 3, 5, 7, 2, 4, 6 }, // 測試案例 3
				{ 2, 4, 6, 8 }, // 全部都是偶數
				{ 1, 3, 5, 7 } // 全部都是奇數
		};

		SortArrayByParity solution = new SortArrayByParity();

		// 測試每個案例
		for (int i = 0; i < testCases.length; i++) {
			System.out.println("測試案例 " + (i + 1) + ":");
			System.out.print("輸入陣列: ");
			printArray(testCases[i]);

			int[] result = solution.sortArrayByParity(testCases[i]);

			System.out.print("輸出陣列: ");
			printArray(result);
			System.out.println();
		}
	}

	// 用於印出陣列的輔助方法
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
