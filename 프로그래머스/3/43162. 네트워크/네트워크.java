import java.util.*;

class Solution {
    static boolean[] visited;
    
    // n : 컴퓨터의 개수
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for(int currentNode=0;currentNode<n;currentNode++) {
            if(!visited[currentNode]) {
                dfs(n, computers, visited, currentNode);
                answer ++;
            }
        }
        
        return answer;
    }
    
    static void dfs(int n, int[][] computers, boolean[] visited, int currentNode) {
        visited[currentNode] = true;
        
        for(int i=0;i<computers[currentNode].length;i++) {
            if(computers[currentNode][i]==1 && !visited[i]) {
                dfs(n, computers, visited, i);
            }
        }
    }
}