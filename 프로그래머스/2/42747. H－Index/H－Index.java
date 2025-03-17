import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations); // 논문 인용 횟수 오름차순 정렬
        int length = citations.length;
        
        for (int i = 0; i < length; i++) {
            int h = length - i; // 남은 논문 개수
            if (citations[i] >= h) { // 현재 논문의 인용 횟수가 남은 논문 개수 이상이라면
                return h;
            }
        }
        return 0;
    }
}
