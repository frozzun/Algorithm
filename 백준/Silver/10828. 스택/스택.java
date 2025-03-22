import java.io.*;
import java.util.*;

/**
 * 첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다.
 * 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다.
 * 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다.
 * 문제에 나와있지 않은 명령이 주어지는 경우는 없다.
 */
public class Main {
  public static void main(String[] args) throws IOException {
    Stack<String> stack = new Stack<>();

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    for(int i=0;i<N;i++) {
      //push, pop, size, empty, top
      String[] order = br.readLine().split(" ");
      //push
      if(order[0].equals("push")) {
        stack.push(order[1]);
      }
      // pop
      else if (order[0].equals("pop")){
        if(stack.isEmpty()) bw.write("-1" + "\n");
        else bw.write(stack.pop() + "\n");
      }
      //size
      else if (order[0].equals("size")){
        bw.write(stack.size() + "\n");
      }
      //empty
      else if (order[0].equals("empty")){
        bw.write(stack.isEmpty() ? "1" + "\n" : "0" + "\n");
      }
      //top
      else {
        if(stack.isEmpty()) bw.write("-1" + "\n");
        else bw.write(stack.peek() + "\n");
      }

    }
    bw.flush();

  }
}