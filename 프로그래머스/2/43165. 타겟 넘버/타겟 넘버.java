class Solution {
  static int answer = 0;
  public int solution(int[] numbers, int target) {

    dfs(numbers, target, 0, 0);

    return answer;
  }
  static void dfs(int[] numbers, int target, int sum, int depts) {
    // 배열의 마지막
    if(depts == numbers.length) {
      if(sum==target) {
        answer ++;
        
      }
        return ;
    }
    dfs(numbers, target, sum + numbers[depts], depts + 1);
    dfs(numbers, target, sum - numbers[depts], depts + 1);
  }
}