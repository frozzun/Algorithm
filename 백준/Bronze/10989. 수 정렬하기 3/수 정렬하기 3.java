import java.io.*;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    /*
     * 카운팅 정렬 사용
     * 수의 범위 ( 0 ~ 10000) 사실상 0은 제외
     */
    int[] cnt = new int[10001];

    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      // 해당 인덱스의 값을 1 증가
      cnt[Integer.parseInt(br.readLine())]++;
    }

    for (int i = 1; i < 10001; i++) {
      // i 값이 개수가 0 이 될 때 까지 출력 (빈도수를 의미)
      while (cnt[i] > 0) {
        bw.write(i + "\n");
        cnt[i]--;
      }
    }
    bw.flush();
    bw.close();
  }
}