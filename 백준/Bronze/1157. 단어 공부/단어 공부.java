import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int[] arr = new int[26];
    String input = scanner.next();
    String inputUpperCase = input.toUpperCase();

    for (int i = 0; i < inputUpperCase.length(); i++) {
      int a = inputUpperCase.charAt(i);
      arr[a - 'A']++;
    }

    int max = 0;
    char ch = '?';
    
    // arr에서 최대 값 찾기.
    for (int i = 0; i < 26; i++) {
      if(arr[i]> max) {
        max = arr[i];
        ch = (char)('A' + i);
      } else if (arr[i] == max) {
        ch = '?';
      }
    }
    System.out.println(ch);

  }
}