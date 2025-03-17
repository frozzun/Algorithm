import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        char[] c = s.toCharArray();        
        
        Stack<Character> stack = new Stack<>();
        for(char ch : c) {
            if(ch == '(') stack.push('(');
            else if(stack.isEmpty()) {
                answer = false;
                break;
            }
            else stack.pop();
        }
        if(stack.isEmpty()) return answer;
        else return false;
    }
}