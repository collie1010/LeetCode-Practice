package HashMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortPeople {
	public String[] sortPeople(String[] names, int[] heights) {
		int numberOfPeople = names.length;

		// Create a map to store height-name pairs
		Map<Integer, String> heightToNameMap = new HashMap<>();

		// Populate the map with height as key and name as value
		for (int i = 0; i < numberOfPeople; i++) {
			heightToNameMap.put(heights[i], names[i]);
		}

		Arrays.sort(heights);

		String[] sortedNames = new String[numberOfPeople];

		// Populate sortedNames array in descending order of height
		for (int i = numberOfPeople - 1; i >= 0; i--) {
			sortedNames[numberOfPeople - i - 1] = heightToNameMap.get(heights[i]);
		}

		return sortedNames;
	}

	public static void main(String[] args) {
		SortPeople solution = new SortPeople();

		// 測試案例 1
		String[] names1 = { "Mary", "John", "Emma" };
		int[] heights1 = { 180, 165, 170 };
		System.out.println("測試案例 1:");
		System.out.println("原始順序：" + Arrays.toString(names1));
		System.out.println("身高：" + Arrays.toString(heights1));
		String[] result1 = solution.sortPeople(names1, heights1);
		System.out.println("排序後：" + Arrays.toString(result1));
		System.out.println();

		// 測試案例 2
		String[] names2 = { "Alice", "Bob", "Charlie", "David" };
		int[] heights2 = { 175, 182, 165, 170 };
		System.out.println("測試案例 2:");
		System.out.println("原始順序：" + Arrays.toString(names2));
		System.out.println("身高：" + Arrays.toString(heights2));
		String[] result2 = solution.sortPeople(names2, heights2);
		System.out.println("排序後：" + Arrays.toString(result2));
		System.out.println();

		// 測試案例 3 - 只有一個人的情況
		String[] names3 = { "Tom" };
		int[] heights3 = { 168 };
		System.out.println("測試案例 3:");
		System.out.println("原始順序：" + Arrays.toString(names3));
		System.out.println("身高：" + Arrays.toString(heights3));
		String[] result3 = solution.sortPeople(names3, heights3);
		System.out.println("排序後：" + Arrays.toString(result3));
	}
}
