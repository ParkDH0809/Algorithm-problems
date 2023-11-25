import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int count = s.length();
        String store = s;
        while (count-- > 0) {
            String currentString = store.substring(s.length() - 1) + store.substring(0, s.length() - 1);
            if (isCorrectString(currentString))
                answer++;
            store = currentString;
        }
        return answer;
    }
    
    boolean isCorrectString(String string) {
        Stack<Character> stack = new Stack<>();
        for (char c : string.toCharArray()) {
            if (stack.isEmpty() && (c == ']' || c == '}' || c == ')'))
                return false;
            
            if (c == ']' && stack.pop() != '[')
                return false;
            
            if (c == ')' && stack.pop() != '(')
                return false;
            
            if (c == '}' && stack.pop() != '{')
                return false;
            
            if (c == '[' || c == '{' || c == '(')
                stack.push(c);
        }
        if (stack.isEmpty())
            return true;
        else 
            return false;
    }
}