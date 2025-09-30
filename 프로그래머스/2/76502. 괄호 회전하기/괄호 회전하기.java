import java.util.*;

class Solution {
    public int solution(String s) {
        
        char[] ch = new char[s.length()];
        ch = s.toCharArray();
        
        int answer = 0;
        for(int i=0;i<ch.length;i++) {
            if(checkClose(ch)) answer ++;
            ch = rotate(ch);
        }
        
        
        return answer;
    }
    
    // 문자열 배열 회전 시키는 char[] 함수 : 왼쪽으로 한칸씩 이동. 
    private static char[] rotate(char[] ch) {
        int length = ch.length;
        char ch0 = ch[0];
        for(int i=0;i<length-1;i++) {
            ch[i] = ch[i+1];
        }
        ch[length-1] = ch0;
        
        return ch;
    }
    
    // 올바른 괄호 문자열인지 확인하는 boolean 함수
    private static boolean checkClose(char[] ch) {
        
        // 시작 닫힌 괄호면 return false
        if(ch[0]==']' || ch[0]=='}' || ch[0]==')') return false;
        
        
        int length = ch.length;
        
        Deque<Character> dq = new LinkedList<>();
        
        for(char c : ch) {
            
            // 열린 괄호라면.
            if(isOpen(c)) {
                dq.push(c);
            }
            
            // 닫힌 괄호라면.
            else {
                // dq가 비어있으면 return false;
                if(dq.isEmpty()) return false;
                
                char poll = dq.poll();
                // 짝이 맞나 비교해야됨
                if(!isCouple(poll, c)) return false;
            }
        }
        if(!dq.isEmpty()) return false;
        // ** 개선점 있나? **
        return true;
    }
    
    private static boolean isOpen(char c) {
        if(c=='[' || c=='{' || c=='(') return true;
        return false;
    }
    
    private static boolean isCouple(char c1, char c2) {
        if(c1 == '[' && c2 == ']') return true;
        else if(c1 == '{' && c2 == '}') return true;
        else if (c1 == '(' && c2 == ')') return true;
        return false;
    }
}