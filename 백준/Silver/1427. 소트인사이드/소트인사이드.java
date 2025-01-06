import java.io.*;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    int length = 0;
    int NN = N;
    while (NN !=0) {
      NN /= 10;
      length ++;
    }

    int[] arrInt = new int[length];

    for (int i = 0; i < length; i++) {
      int a = N%10;
      arrInt[i] = a;
      N /=10;
    }

    // arrInt[] 를 정렬하기 위해
    // counting[] 를 생성 후 누적시킴
    int[] counting = new int[11];
    for (int i = 0; i < arrInt.length; i++) {
      counting[arrInt[i]]++;
    }

    // counting[i] > 0 // while
    for (int i = counting.length-1; i >=0 ; i--) {
      while (counting[i] > 0) {
        bw.write(i + "");
        counting[i]--;
      }
    }
    bw.flush();
  }
}