package Stack;

public class DecodeString {
    public String decodeString(String s) {
        java.util.Stack<Integer> countStack = new java.util.Stack<>();
        java.util.Stack<StringBuilder> stringStack = new java.util.Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0'); // 處理多位數字
            } else if (ch == '[') {
                countStack.push(k);
                stringStack.push(currentString);
                currentString = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                StringBuilder decodedString = stringStack.pop();
                int currentK = countStack.pop();
                for (int i = 0; i < currentK; i++) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } else {
                currentString.append(ch);
            }
        }

        return currentString.toString();
    }

    // 測試輔助方法
    private static void testCase(String s) {
        DecodeString solution = new DecodeString();
        String result = solution.decodeString(s);
        System.out.println("測試案例：");
        System.out.println("輸入字串: \"" + s + "\"");
        System.out.println("結果: \"" + result + "\"");
        System.out.println("================");
    }

    public static void main(String[] args) {
        // 測試案例1
        String s1 = "3[a]2[bc]";
        testCase(s1);

        // 測試案例2
        String s2 = "3[a2[c]]";
        testCase(s2);

        // 測試案例3
        String s3 = "2[abc]3[cd]ef";
        testCase(s3);

        // 測試案例4（無重複編碼）
        String s4 = "abcde";
        testCase(s4);

        // 測試案例5（空字串）
        String s5 = "";
        testCase(s5);
    }
}
