import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        // 두 개의 수를 뽑아 더해서 만들 수 있는 모든 수를 배열에 오름차순
        // 중복 허용 X
        // O(N^2) 가능.
        
        // 1 : TreeSet에 더해서 만들 수 있는 모든 수 넣기.
        TreeSet<Integer> set = new TreeSet<>();
        
        int length = numbers.length;
        for(int i=0;i<length;i++) {
            for(int j=0;j<length;j++) {
                if(i!=j) {  // index 겹치면 안됨
                    set.add(numbers[i] + numbers[j]);
                }
            }
        }   // set 상태 : 오름차순
        
        // 2 : int 배열로 옮기기
        int size = set.size();
        int[] answer = new int[set.size()];
        for(int i=0;i<size;i++) {   // pollFirst() 하면 size가 계속 줄어듦으로 int size로 선언하고 시작
            int x = set.pollFirst();
            answer[i] = x;
        }
        
        return answer;
    }
}