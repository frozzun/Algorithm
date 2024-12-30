import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 입력받은 수
    int N = Integer.parseInt(br.readLine());

    // 생성자 최솟값
    int result = 0;


    // i = 생성자 (반복문)
    for(int i = 0; i < N; i++) {
      int number = i;
      int sum = 0;	// 각 자릿수 합 변수

      while(number != 0) {
        sum += number % 10;	// 각 자릿수 더하기
        number /= 10; // while문 종료 조건
      }

      // i 값과 각 자릿수 누적합이 같을 경우 (생성자를 찾았을 경우)
      if(sum + i == N) {
        result = i;
        break;
      }

    }

    System.out.println(result);
  }
}


