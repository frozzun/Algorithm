import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int Num=0;

    String[] parts = bufferedReader.readLine().split(" ");

    String N = parts[0];
    int B = Integer.parseInt(parts[1]);

    char[] c = N.toCharArray();

    int length = N.length();

    for(int i = 0; i < length; i++) {
      if(c[i]>=65 && c[i]<=90) {
        double d = Math.pow(B, length-i-1);
        int dd = (int)d;
        Num = Num + (c[i]-55)*dd;

      }

      else {
        double d = Math.pow(B, length-i-1);
        int dd = (int)d;
        Num = Num + (c[i]-48)*dd;
      }
    }
    System.out.println(Num);
  }
}




