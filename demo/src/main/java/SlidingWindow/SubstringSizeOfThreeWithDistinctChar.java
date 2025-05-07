package SlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class SubstringSizeOfThreeWithDistinctChar {
	public int countGoodSubstrings(String s) {
		if (s.length() < 3) {
			return 0;
		}

		int count = 0;
		char[] chars = s.toCharArray();

		for (int i = 0; i <= chars.length - 3; i++) {
			if (chars[i] != chars[i + 1] && chars[i + 1] != chars[i + 2] && chars[i] != chars[i + 2]) {
				count++;
			}
		}

		return count;
	}

	public int countGoodSubstrings2(String s) {
		if (s.length() < 3) {
			return 0;
		}

		int count = 0;

		for (int i = 0; i <= s.length() - 3; i++) {
			Set<Character> set = new HashSet<>();
			set.add(s.charAt(i));
			set.add(s.charAt(i + 1));
			set.add(s.charAt(i + 2));

			if (set.size() == 3) {
				count++;
			}
		}

		return count;

	}

	public int countGoodSubstrings3(String s) {
		if (s.length() < 3) {
			return 0;
		}

		int count = 0;
		char[] chars = s.toCharArray();

		for (int i = 0; i <= chars.length - 3; i++) {
			if (chars[i] != chars[i + 1] && chars[i + 1] != chars[i + 2] && chars[i] != chars[i + 2]) {
				count++;
			}
		}

		return count;
	}
}
