import java.io.*;

public class Main {

  public static int number;
  //N번째로 작은 종말의 수
  public static void main(String[] args) throws IOException {
    //666이 연속으로 있어야 됨
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int count = 0;  //찾은거의 개수
    number = 0;
    //n번쨰 까지 반복
    while(count < n) {
      number++;
      if(find(number)) {
        count ++;
      }
    }
    System.out.println(number);
  }
  // 666이 연속으로 있는지 검증하는 함수
  public static boolean find(int n) {
    String a = String.valueOf(n);
    return a.contains("666");
  }
}