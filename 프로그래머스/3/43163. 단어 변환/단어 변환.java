import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        // answer : 변환하는 횟수
        int answer = 0;
        Queue<String> queue = new LinkedList<>();
        queue.add(begin);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            // 현재 queue에 들어있는거 다 뺄때까지 반복
            for(int i=0; i<size; i++) {
                // 하나 빼고
                String temp = queue.poll();
                
                // 조건 만족하는지 확인
                if(temp.equals(target)) {
                    return answer;
                }
                
                // words 배열 순회
                for(int j = 0;j<words.length;j++) {
                    // 변환 가능 하다고 방문한적 없다면
                    if(canConvert(temp, words[j]) && !visited[j]) {
                        visited[j] = true;
                        queue.add(words[j]);
                    }
                }
            }
            answer ++;
        }
        return 0;
    }
    
    boolean canConvert(String start, String end) {
        int diffCount = 0;
        for(int i=0;i<start.length();i++) {
            if(start.charAt(i) != end.charAt(i)) {
                diffCount ++;
            }
        }
        
        if(diffCount == 1) {
            return true;
        }
        else return false;
    }
}