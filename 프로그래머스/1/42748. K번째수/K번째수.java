import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0;i<commands.length;i++) {
            int start = commands[i][0];
            int end = commands[i][1];
            int want = commands[i][2];
            
            int[] arr = new int[end-start+1];
            
            int index = 0;
            for(int j=start-1;j<end;j++) {
                arr[index] = array[j];
                index ++;
            }
            Arrays.sort(arr);
            answer[i] = arr[want-1];
        }
        
        
        
        
        
        return answer;
    }
}