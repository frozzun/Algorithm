import java.util.*;

// O(n^2) 는 사용 못함
// O(nlogn) 써야할 듯.
class Solution {
    boolean solution(String s) {
        
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            
            if(i==0 && ch==')') return false; // 시작부터 탈락.
            if(ch=='(') stack.push(ch);
            if(ch==')' && stack.isEmpty()) return false;   // ()))
            else if(ch==')') stack.pop();
            
            else if(i==s.length()-1 && ch=='(') return false;
        }

        
        return stack.isEmpty();
    }
}