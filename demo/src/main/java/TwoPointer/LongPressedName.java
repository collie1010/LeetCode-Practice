package TwoPointer;

public class LongPressedName {
	public boolean isLongPressedName(String name, String typed) {
		int i = 0; // name 的指針
		int j = 0; // typed 的指針

		while (j < typed.length()) {
			// 如果指針都沒超出範圍且字符相同，兩個指針都向前移動
			if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
				i++;
				j++;
			}
			// 如果 typed 當前字符和前一個字符相同，表示長按
			else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
				j++;
			}
			// 其他情況都是無效的
			else {
				return false;
			}
		}

		// 確認是否完全匹配完 name
		return i == name.length();
	}
}
