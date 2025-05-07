package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargeGroupPositions {
	public List<List<Integer>> largeGroupPositions(String s) {
		List<List<Integer>> result = new ArrayList<>();
		int n = s.length();
		int i = 0; // 左指針

		while (i < n) {
			int j = i; // 右指針
			// 找出相同字符的結束位置
			while (j < n && s.charAt(j) == s.charAt(i)) {
				j++;
			}

			// 檢查群組長度
			if (j - i >= 3) {
				result.add(Arrays.asList(i, j - 1));
			}

			i = j;
		}

		return result;
	}

	public List<List<Integer>> largeGroupPositions2(String s) {
		List<List<Integer>> result = new ArrayList<>();
		if (s == null || s.length() < 3) {
			return result;
		}

		char[] chars = s.toCharArray();
		int count = 1;
		int start = 0;

		for (int i = 1; i < chars.length; i++) {
			if (chars[i] == chars[i - 1]) {
				count++;
			} else {
				if (count >= 3) {
					result.add(Arrays.asList(start, i - 1));
				}
				start = i;
				count = 1;
			}
		}

		// 檢查最後一個群組
		if (count >= 3) {
			result.add(Arrays.asList(start, chars.length - 1));
		}

		return result;
	}
}
