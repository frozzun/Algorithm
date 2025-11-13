import java.util.*;

class Solution {
    // N개의 마을 중에서 K시간 이하로 배달 가능한 마을만 주문 받
    // 모든 마을의 dist[] 받기 -> K로 필터링.
    // develop : K넘어가는 순간 걍 방문 X?
    
    public class Node {
        int idx;    // 인덱스 번호
        int weight; // 가중치
        
        public Node(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }
    }
    
    // road[0][1] = [1, 2, 1] :
    public int solution(int N, int[][] road, int K) {
        int[] dist = new int[N+1];
        for(int i=0;i<N+1;i++) dist[i] = 500001;
        
        ArrayList<Node>[] adjList = new ArrayList[N+1];
        for(int i=1;i<=N;i++) {
            adjList[i] = new ArrayList<>();
        }
        
        for(int[] edge : road) {
            // edge[0] : Node1, edge[1] : Node2, edge[2] : weight
            // 양방향 연결.
            adjList[edge[0]].add(new Node(edge[1], edge[2]));
            adjList[edge[1]].add(new Node(edge[0], edge[2]));
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.weight, o2.weight));
        pq.add(new Node(1, 0));  // start Node;
        dist[1] = 0;
        
        while(!pq.isEmpty()) {
            Node current = pq.poll();
            if(dist[current.idx] > K) continue;
            
            if(dist[current.idx] < current.weight) continue;
            
            // adjList[current] 연결된거 순회
            for(Node next : adjList[current.idx]) {
                if(dist[next.idx] > current.weight + next.weight) {
                    
                    // dist 갱신
                    dist[next.idx] = current.weight + next.weight;
                    
                    // 방문하지 않았다면 pq에 넣기
                    pq.add(new Node(next.idx, dist[next.idx]));
                    
                    
                }
            } 
        }
        
        int answer = 0;
        for(int di : dist) {
            if(di <= K) answer ++;
        }
        
        
        
        return answer;
    }
    
}