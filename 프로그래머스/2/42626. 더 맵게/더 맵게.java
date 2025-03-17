import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        /*
        섞은 음식의 스코빌 지수 = 
        가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
        */
        // 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞
        // K <= 가장 맵지않은 + 2* 두번째 맵지않은
        // return 섞는 최소 횟수
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : scoville) {
            pq.add(i);
        }
        
        // 가장 먼저 나올 스코빌 지수가 K 보다 작으면 반복
        while(pq.peek() < K) {
            if(pq.size() == 1) return -1;
            
            pq.add(pq.poll() + pq.poll() * 2);
            answer ++;  // 섞은 횟수 증가
        }
        
        return answer;
    }
}