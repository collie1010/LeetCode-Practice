package Stack;

public class ValildParentheses {
    public boolean isValid(String s) {
        java.util.Stack<Character> stack = new java.util.Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((c == ')' && top != '(') || 
                    (c == '}' && top != '{') || 
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValildParentheses solution = new ValildParentheses();
        
        // 測試案例 1
        System.out.println(solution.isValid("()")); // true
        
        // 測試案例 2
        System.out.println(solution.isValid("()[]{}")); // true
        
        // 測試案例 3
        System.out.println(solution.isValid("(]")); // false
        
        // 測試案例 4
        System.out.println(solution.isValid("([)]")); // false
        
        // 測試案例 5
        System.out.println(solution.isValid("{[]}")); // true
    }
}
