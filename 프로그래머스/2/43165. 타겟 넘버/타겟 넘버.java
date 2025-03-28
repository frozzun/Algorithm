import java.util.*;

class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
                 
        dfs(numbers, target, 0, 0);
        return answer;
    }
    
    public void dfs(int[] numbers, int target, int depth, int temp) {
        // 만족, 종료 조건 설정
        if(depth == numbers.length-1) {
            if(temp + numbers[depth] == target || temp - numbers[depth] == target) {
                answer ++;
                return ;
            }
            else return ;
        }
        else {
            dfs(numbers, target, depth+1, temp + numbers[depth]);
            dfs(numbers, target, depth+1, temp - numbers[depth]);
        }
    }
}