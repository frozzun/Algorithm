import java.util.*;

// 좌표를 2배로 불린다. 
// 그래서 홀수인거 visited로 찾자.
// 지나갈때는 x 두번 호출 or y 두번 호출로 지나가는거 체크
class Solution {
    // 상 하 좌 우
    static int[] x = {1, -1, 0, 0};
    static int[] y = {0, 0, -1, 1};
    
    // map 한계 표시
    static int maxX = 20;
    static int minX = 0;
    static int maxY = 20;
    static int minY = 0;
    
    // 점은 22 X 22 개 있음.
    boolean[][] isVisited = new boolean[23][23];
    
    public int solution(String dirs) {
        
        char[] ch = new char[dirs.length()];
        for(int i=0;i<dirs.length();i++) {
            ch[i] = dirs.charAt(i);
        }
        
        int current_X = 10;
        int current_Y = 10;
        int length = 0;
        
        for(char dir : ch) {
            
            if(dir=='U') {  // UP
                // 최대 최소 조건.
                if(current_Y != maxY) {
                    current_X += x[3];
                    current_Y += y[3];
                    if(!isVisited[current_X][current_Y]) {
                        isVisited[current_X][current_Y] = true;
                        length++;
                    }
                    current_X += x[3];
                    current_Y += y[3];
                }
            }
            else if(dir=='D') { // DOWN
                // 최대 최소 조건.
                if(current_Y != minY) {
                    current_X += x[2];
                    current_Y += y[2];
                    if(!isVisited[current_X][current_Y]) {
                        isVisited[current_X][current_Y] = true;
                        length++;
                    }
                    current_X += x[2];
                    current_Y += y[2];
                }
                
            }
            else if(dir=='L') { //LEFT
                // 최대 최소 조건.
                if(current_X != minX) {
                    current_X += x[1];
                    current_Y += y[1];
                    if(!isVisited[current_X][current_Y]) {
                        isVisited[current_X][current_Y] = true;
                        length++;
                    }
                    current_X += x[1];
                    current_Y += y[1];
                }
                
            }
            else {  // RIGHT
                // 최대 최소 조건.
                if(current_X != maxX) {
                    current_X += x[0];
                    current_Y += y[0];
                    if(!isVisited[current_X][current_Y]) {
                        isVisited[current_X][current_Y] = true;
                        length++;
                    }
                    current_X += x[0];
                    current_Y += y[0];
                }
                
            }
        }
        return length;
    }
}