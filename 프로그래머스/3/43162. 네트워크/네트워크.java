import java.util.*;

class Solution {
    public static boolean[] visited;
    public static int answer;
    
    public int solution(int n, int[][] computers) {
        // 순환 함수 찾기?
        // computers[i][j] = 1 : i번 컴퓨터와 j번 컴퓨터가 연결돼있음
        // bfs 해서 node 기억, answer ++;
        // node 연결 안된거 다시 bfs
        visited = new boolean[n];
        answer = 0;
        
        for(int i=0;i<n;i++) {
            if(!visited[i]) bfs(i, computers);
        }
        
        return answer;
    }
    
    public static void bfs(int start, int[][] computers) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        
        visited[start] = true;
        dq.add(start);
        
        while(!dq.isEmpty()) {
            int current = dq.poll();
            
            for(int i=0;i<computers[current].length;i++) {
                if(i!=current) {
                    if(computers[current][i]==1 && !visited[i]) {  // 연결 돼있음
                        visited[i]=true;
                        dq.add(i);
                    }
                }
            }   //for
            
        }   // while
        answer ++;
        
    }   // bfs
}