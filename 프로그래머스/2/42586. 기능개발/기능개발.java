import java.util.*;

class Solution {
  public int[] solution(int[] progresses, int[] speeds) {

    // 뒤에 있는건 대기했다가 앞에 있는거랑 같이 배포
    // progresses + speeds * days = 100 이면 기능 개발 완료
    // if head가 100이라면 head가 100이 아닌 값 까지 pop
    Stack<Integer> stack = new Stack<>();
    List<Integer> answer = new ArrayList<>();


    // 작업 완료까지 남은 날짜.
    int[] day = new int[progresses.length];

    for(int i=0;i< progresses.length;i++) {
      if((100-progresses[i])%speeds[i]!=0) {
        day[i] = (100-progresses[i])/speeds[i] + 1;
      }
      else {
        day[i] = (100-progresses[i])/speeds[i];
      }
    }

    for(int i= progresses.length-1; i >=0; i--) {
      stack.push(day[i]);
    }

    // 이제 Stack 에서 빼야됨
    // day[i] 보다 day[i+] 가 작으면 day[i] 뺄 때 같이뺌
    int now = stack.pop();
    int count = 1;

    while(!stack.isEmpty()) {
      // 같이 빠져
      if(now>=stack.peek()) {
        stack.pop();
        count ++;
      }
      // 따로 빠져
      else {
        answer.add(count);
        now = stack.pop();
        count = 1;
      }
    }
    
    answer.add(count);

    return answer.stream().mapToInt(i -> i).toArray();
  }
}