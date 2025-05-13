package TwoPointer;

public class CapitalizeTheTitle {
	public String capitalizeTitle(String title) {
		// 轉換為字元陣列，方便修改
		char[] chars = title.toLowerCase().toCharArray();
		int start = 0;
		int end = 0;
		int n = chars.length;

		while (end < n) {
			// 找到單詞的結尾（空格或字串結束）
			while (end < n && chars[end] != ' ') {
				end++;
			}

			// 如果單詞長度大於2，將首字母改為大寫
			if (end - start > 2) {
				chars[start] = Character.toUpperCase(chars[start]);
			}

			// 移動到下一個單詞的開始
			end++;
			start = end;
		}

		return new String(chars);

	}
}
