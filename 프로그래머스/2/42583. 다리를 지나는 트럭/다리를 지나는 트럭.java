import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // queue size : length
        // queue total weight <= weight
        // truck : 1, nothing : 0
        // 시간 지날때마다 트럭 무게 or 0 푸시
        // 트럭 진입 -> 다리 무게 + 트럭 무게
        // 트럭 퇴장 -> 다리 무게 - 트럭 무게
        int bridge_weight = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> truck = new LinkedList<>();
        for(int i : truck_weights) truck.add(i);
        for(int i=0;i<bridge_length;i++) queue.add(0);
        
        int truckCount = truck_weights.length;
        int index = 0;  // 다리를 지난 트럭 개수
        int time=0; // 소요 시간

        while(!truck.isEmpty()) {
            time ++;
            bridge_weight -= queue.poll();
            
            // 차량 다리에 적재 불가능
            if(bridge_weight + truck.peek() > weight) {
                queue.add(0);
            }
            
            // 차량 다리에 적재 가능
            else {
                queue.add(truck.peek());
                bridge_weight += truck.poll();
            }     
        }
        
        time += bridge_length;
        return time;
    }
}