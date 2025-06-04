package String;

public class ZigzagConversion {
    public String convert(String s, int numRows) {

        if (numRows == 1) return s;


        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int period = 2 * numRows - 2;  // 一個完整的 Z 字形週期
        
        for (int i = 0; i < s.length(); i++) {
            int pos = i % period;  // 在週期中的位置
            
            // 如果在週期的前半部分，直接放入對應行
            if (pos < numRows) {
                rows[pos].append(s.charAt(i));
            } 
            // 如果在週期的後半部分，計算對應的行數
            else {
                rows[period - pos].append(s.charAt(i));
            }
        }

        // 合併所有行
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        ZigzagConversion solution = new ZigzagConversion();
        
        // 測試案例 1
        String s1 = "PAYPALISHIRING";
        int numRows1 = 3;
        String result1 = solution.convert(s1, numRows1);
        System.out.println("測試案例 1:");
        System.out.println("輸入字串: " + s1);
        System.out.println("行數: " + numRows1);
        System.out.println("輸出結果: " + result1);
        System.out.println();

        // 測試案例 2
        String s2 = "PAYPALISHIRING";
        int numRows2 = 4;
        String result2 = solution.convert(s2, numRows2);
        System.out.println("測試案例 2:");
        System.out.println("輸入字串: " + s2);
        System.out.println("行數: " + numRows2);
        System.out.println("輸出結果: " + result2);
        System.out.println();

        // 測試案例 3
        String s3 = "A";
        int numRows3 = 1;
        String result3 = solution.convert(s3, numRows3);
        System.out.println("測試案例 3:");
        System.out.println("輸入字串: " + s3);
        System.out.println("行數: " + numRows3);
        System.out.println("輸出結果: " + result3);
        System.out.println();

        // 測試案例 4
        String s4 = "AB";
        int numRows4 = 1;
        String result4 = solution.convert(s4, numRows4);
        System.out.println("測試案例 4:");
        System.out.println("輸入字串: " + s4);
        System.out.println("行數: " + numRows4);
        System.out.println("輸出結果: " + result4);
    }
}
