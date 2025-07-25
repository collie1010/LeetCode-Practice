package Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        
        for (String token : tokens) {
            if (token.equals("+")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a + b);
            } else if (token.equals("-")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a - b);
            } else if (token.equals("*")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a * b);
            } else if (token.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a / b);
            } else {
                // 將數字轉換為整數並壓入堆疊
                stack.push(Integer.parseInt(token));
            }
        }
        
        // 最後堆疊中只會剩下一個元素，即為結果
        return stack.pop();
    }   

    public static void main(String[] args) {
        EvaluateReversePolishNotation solution = new EvaluateReversePolishNotation();
        
        // 測試案例 1
        String[] tokens1 = {"2", "1", "+", "3", "*"};
        System.out.println(solution.evalRPN(tokens1)); // 9
        
        // 測試案例 2
        String[] tokens2 = {"4", "13", "5", "/", "+"};
        System.out.println(solution.evalRPN(tokens2)); // 6
        
        // 測試案例 3
        String[] tokens3 = {"10", "6", "9", "3", "/", "-", "*"};
        System.out.println(solution.evalRPN(tokens3)); // -60
    }
}
