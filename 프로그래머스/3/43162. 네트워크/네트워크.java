import java.util.*;

// 컴퓨터의 개수 n, 
// 연결에 대한 정보가 담긴 2차원 배열 computers가 매개변수로 주어질 때, 
// 네트워크의 개수를 return
class Solution {
    static boolean[] visited;
    static int answer = 0;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        
        for(int i=0;i<n;i++) {
            if (!visited[i]) {  // 방문하지 않은 노드에서 새로운 네트워크 탐색 시작
                answer++;       // 새로운 네트워크 발견
                dfs(computers, i);
            }
        }

        return answer;
    }
    
    static void dfs(int[][] computers, int startNode) {
        if(visited[startNode])  return ;
        
        // 방문처리
        visited[startNode] = true;
        
        for (int i = 0; i < computers.length; i++) { // i = 0부터 시작해야 모든 노드 탐색 가능
            if (canConnect(computers, startNode, i)) {
                dfs(computers, i);
            }
        }
    }
    
    
    static boolean canConnect(int[][] computers, int nodeA, int nodeB) {
        //방문한적 없고, 연결이 되어있을 때
        if(!visited[nodeB] && computers[nodeA][nodeB] == 1) return true;
        return false;
    }
}