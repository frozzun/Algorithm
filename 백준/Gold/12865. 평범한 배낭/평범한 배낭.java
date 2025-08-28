import java.io.*;

public class Main {

  static int N, K;  // 갯수, 최대 무게
  static int[][] items;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 선언

    String[] first = br.readLine().split(" ");
    N = Integer.parseInt(first[0]);
    K = Integer.parseInt(first[1]);

    items = new int[N][2];
    for (int i = 0; i < N; i++) {
      String[] a = br.readLine().split(" ");
      items[i][0] = Integer.parseInt(a[0]);
      items[i][1] = Integer.parseInt(a[1]);
    }

    // ✅ 1D DP 배열
    // dp[j] 배열 : 가방 용량이 j 일 때 얻을 수 있는 최대 가치
    int[] dp = new int[K + 1];

    for (int i = 0; i < N; i++) {
      int weight = items[i][0];
      int value = items[i][1];

      // ✅ 뒤에서 앞으로 (중복 방지)
      for (int j = K; j >= weight; j--) {
        dp[j] = Math.max(dp[j], dp[j - weight] + value);
      }
    }

    System.out.println(dp[K]);
  }
}
