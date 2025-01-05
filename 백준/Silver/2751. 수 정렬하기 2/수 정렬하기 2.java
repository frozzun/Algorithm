import java.io.*;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] indexes = new int[N];
    for (int i = 0; i < N; i++) {
      indexes[i] = Integer.parseInt(br.readLine());
    }
    
    indexes = Arrays.stream(indexes).sorted().toArray();
    for (int i = 0; i < N; i++) {
      System.out.println(indexes[i]);
    }
  }
}