package BinarySearch;

import java.util.Arrays;

public class SuccessfulPairsSpellPotion {
	public int[] successfulPairs(int[] spells, int[] potions, long success) {

		int n = spells.length;
		int m = potions.length;
		int[] result = new int[n];

		// 1. 先將 potions 排序
		Arrays.sort(potions);

		// 2. 對每個 spell 進行二分搜尋
		for (int i = 0; i < n; i++) {
			int spell = spells[i];

			// 找到第一個使得 spell * potion >= success 的位置
			int left = 0, right = m;
			while (left < right) {
				int mid = left + (right - left) / 2;
				if ((long) spell * potions[mid] >= success) {
					right = mid;
				} else {
					left = mid + 1;
				}
			}

			// 計算成功的組合數
			result[i] = m - left;
		}

		return result;

	}

	public static void main(String[] args) {
		SuccessfulPairsSpellPotion solution = new SuccessfulPairsSpellPotion();

		// 測試案例 1
		int[] spells1 = { 5, 1, 3 };
		int[] potions1 = { 1, 2, 3, 4, 5 };
		long success1 = 7;
		System.out.println("測試案例 1:");
		System.out.println("咒語強度: " + Arrays.toString(spells1));
		System.out.println("藥水強度: " + Arrays.toString(potions1));
		System.out.println("成功閾值: " + success1);
		System.out.println("結果: " + Arrays.toString(solution.successfulPairs(spells1, potions1, success1)));
		System.out.println();

		// 測試案例 2
		int[] spells2 = { 3, 1, 2 };
		int[] potions2 = { 8, 5, 8 };
		long success2 = 16;
		System.out.println("測試案例 2:");
		System.out.println("咒語強度: " + Arrays.toString(spells2));
		System.out.println("藥水強度: " + Arrays.toString(potions2));
		System.out.println("成功閾值: " + success2);
		System.out.println("結果: " + Arrays.toString(solution.successfulPairs(spells2, potions2, success2)));
		System.out.println();

		// 測試案例 3 - 大數測試
		int[] spells3 = { 10, 5, 15 };
		int[] potions3 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		long success3 = 50;
		System.out.println("測試案例 3:");
		System.out.println("咒語強度: " + Arrays.toString(spells3));
		System.out.println("藥水強度: " + Arrays.toString(potions3));
		System.out.println("成功閾值: " + success3);
		System.out.println("結果: " + Arrays.toString(solution.successfulPairs(spells3, potions3, success3)));
		System.out.println();

		// 測試案例 4 - 邊界測試
		int[] spells4 = { 1 };
		int[] potions4 = { 1 };
		long success4 = 1;
		System.out.println("測試案例 4 (邊界測試):");
		System.out.println("咒語強度: " + Arrays.toString(spells4));
		System.out.println("藥水強度: " + Arrays.toString(potions4));
		System.out.println("成功閾值: " + success4);
		System.out.println("結果: " + Arrays.toString(solution.successfulPairs(spells4, potions4, success4)));
	}
}
