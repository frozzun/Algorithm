import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

    int index = 0;

    String input = scanner.readLine();
    char[] arr = input.toCharArray();

    for (int i = 0; i < arr.length; i++) {
      if (i + 1 < arr.length && arr[i]=='c' && arr[i+1]=='=') {
        index++;
        i++;
      }
      else if (i + 1 < arr.length && arr[i]=='c' && arr[i+1]=='-') {
        index++;
        i++;
      }
      else if (i + 2 < arr.length && arr[i]=='d' && arr[i+1]=='z' && arr[i+2]=='=') {
        index++;
        i=i+2;
      }
      else if (i + 1 < arr.length && arr[i]=='d' && arr[i+1]=='-') {
        index++;
        i++;
      }
      else if (i + 1 < arr.length && arr[i]=='l' && arr[i+1]=='j') {
        index++;
        i++;
      }
      else if (i + 1 < arr.length && arr[i]=='n' && arr[i+1]=='j') {
        index++;
        i++;
      }
      else if (i + 1 < arr.length && arr[i]=='s' && arr[i+1]=='=') {
        index++;
        i++;
      }
      else if (i + 1 < arr.length && arr[i]=='z' && arr[i+1]=='=') {
        index++;
        i++;
      }
      else index++;
    }

    System.out.println(index);
  }
}