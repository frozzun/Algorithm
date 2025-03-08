import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = new int[arr.length];
        // 중복 제거 문제
        int temp = 1;
        int length = arr.length;
        int index = arr[0]; // 이전 arr 값
        answer[0] = arr[0];
        
        for(int i=1;i<length;i++) {
            
            if(index != arr[i]) {
                answer[temp] = arr[i];
                temp ++;
            }
            index = arr[i];
        }
        
        int[] real_answer = new int[temp];
        for(int i=0;i<temp;i++) {
            real_answer[i] = answer[i];
        }
        return real_answer;
    }
}