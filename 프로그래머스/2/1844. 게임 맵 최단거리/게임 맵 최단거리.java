import java.util.*;

class Solution {
    private static final int[] dc = {1, -1, 0, 0};
    private static final int[] dr = {0, 0, 1, -1};
    static int MAX_SIZE_C;
    static int MAX_SIZE_R;
    static boolean[][] visited;
    static int[] target;
    
    public int solution(int[][] maps) {
        MAX_SIZE_C = maps.length;
        MAX_SIZE_R = maps[0].length;
        visited = new boolean[maps.length][maps[0].length];
        target = new int[]{MAX_SIZE_C-1, MAX_SIZE_R-1};
        
        return bfs(0, 0, maps);
    }
    
    static int bfs(int cC, int cR, int[][] maps) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        
        // 방문 처리, { 행(row), 열(column), 거리}
        visited[cC][cR] = true;
        queue.add(new int[]{cC, cR, 1});
        
        while(!queue.isEmpty()) {
            
            int[] current = queue.poll();
            // 종료 조건
            if(current[0]==target[0] && current[1]==target[1]) return current[2];
            
            for(int i=0;i<4;i++) {
                int nc = current[0] + dc[i];
                int nr = current[1] + dr[i];
                int dist = current[2] + 1;
                
                // map 밖으로 가는 경우
                if(nc > MAX_SIZE_C-1 || nc < 0 || nr > MAX_SIZE_R-1 || nr < 0) continue;
                // 벽으로 가는 경우
                if(maps[nc][nr]==0) continue;
                
                // 이미 방문
                if(visited[nc][nr]) continue;
                
                visited[nc][nr] = true;
                queue.add(new int[]{nc, nr, dist});
            }
            
        }
        
        return -1;
    }
}