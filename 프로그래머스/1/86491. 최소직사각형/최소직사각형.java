class Solution {
    public int solution(int[][] sizes) {
        
        for(int i=0;i<sizes.length;i++) {
            // 왼쪽이 크게 오른쪽이 작게.
            if(sizes[i][0] < sizes[i][1]) {
                swap(sizes[i]);
            }
        }
        
        int maxLeft = 0;
        int maxRight = 0;
        for(int i=0;i<sizes.length;i++) {
            if(maxLeft < sizes[i][0]) maxLeft = sizes[i][0];
            if(maxRight < sizes[i][1]) maxRight = sizes[i][1];
        }
        
        
        int answer = maxLeft * maxRight;
        return answer;
    }
    
    public void swap(int[] wallet) {
        int temp = wallet[0];
        wallet[0] = wallet[1];
        wallet[1] = temp;
    }
}