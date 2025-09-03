class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int x1 = arr1[0].length;
        int x2 = arr2[0].length;
        int y1 = arr1.length;
        int y2 = arr2.length;
        
        // x, y의 최댓값들 찾기.
        // int maxValueX = Math.max(x1, x2);
        // int maxValueY = Math.max(y1, y2);
        int maxValueX = x2;
        int maxValueY = y1;
        
        int[][] answer = new int[maxValueY][x2];
        // answer[y][x]
        for(int y=0;y<maxValueY;y++) {   // i, j 의 범위는 어떻게?
            for(int x=0;x<maxValueX;x++) {
                for(int i=0;i<x1;i++) {
                    answer[y][x] += arr1[y][i]*arr2[i][x];
                }
            }
        }
        
        
        return answer;
    }
}