import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> numSets = new HashSet<Integer>();
        for(int i=0;i<nums.length; i++) {
            numSets.add(nums[i]);
        }
        
        int num = numSets.size();
        
        if(num>=nums.length/2) {
            return nums.length/2;
        }
        else return num;
    }
}