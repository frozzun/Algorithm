import java.util.*;

class Solution {
    // 레버까지 최단거리로 가고
    
    // 레버부터 EXIT까지 최단거리로 가기
    // S : start
    // L : 레버
    // E : exit
    public static int answer;
    public static char[][] map;
    public static final int[] dR = {0, 0, 1, -1};
    public static final int[] dC = {1, -1, 0, 0};
    
    public int solution(String[] maps) {
        
        answer = 0;
        map = new char[maps.length][maps[0].length()];
        for(int i=0;i<map.length;i++) {
            map[i] = maps[i].toCharArray();
        }
        
        int[] start = new int[2];
        int[] levar = new int[2];
        int[] end = new int[2];
        
        for(int i=0;i<map.length;i++) {
            for(int j=0;j<map[0].length;j++) {
                char c = map[i][j];
                if(c=='S') {
                    start[0] = i;
                    start[1] = j;
                }
                else if(c=='L') {
                    levar[0] = i;
                    levar[1] = j;
                }
                else if(c=='E') {
                    end[0] = i;
                    end[1] = j;
                }
            }
        }
        
        
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        // Start -> Levar
        answer = bfs(start[0], start[1], levar[0], levar[1], visited);
        if(answer==-1) return answer;
        
        // Levar -> End
        visited = new boolean[maps.length][maps[0].length()];   // visited 배열 초기화
        int ans = bfs(levar[0], levar[1], end[0], end[1], visited);
        if(ans == -1) return ans;
        answer += ans;
        
        
        return answer;
    }
    
    public int bfs(int startR, int startC, int endR, int endC, boolean[][] visited) {
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        
        visited[startR][startC] = true;
        dq.add(new int[]{startR, startC, 0});
        
        while(!dq.isEmpty()) {
            int[] current = dq.poll();
            int cC = current[0];
            int cR = current[1];
            int cDist = current[2];
            
            if(cC==endR && cR==endC) {
                return cDist;
            }
            
            for(int i=0;i<4;i++) {
                int nextC = cC + dC[i];
                int nextR = cR + dR[i];
                int nextD = cDist + 1;
                // 맵 범위 밖
                if(nextC > map.length-1|| nextC < 0 || nextR > map[0].length-1|| nextR < 0) continue;
                
                // 벽
                if(map[nextC][nextR]=='X') continue;
                
                if(visited[nextC][nextR]) continue;
                
                visited[nextC][nextR] = true;
                dq.add(new int[]{nextC, nextR, nextD});
            }
        }
        return -1;
    }
}