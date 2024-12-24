import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(bufferedReader.readLine());
    int groupWordCount = 0;

    for (int i = 0; i < N; i++) {
      //그룹 단어 체크 로직
      String inputWord = bufferedReader.readLine();
      if(isGroupWord(inputWord)) {
        groupWordCount++;
      }
    }
    System.out.println(groupWordCount);
  }

  public static boolean isGroupWord(String word) {
    boolean[] visited = new boolean[26]; // 알파벳 a-z 방문 여부
    char lastChar = 0; // 마지막으로 본 문자

    for (char c : word.toCharArray()) {
      if (c != lastChar) { // 연속된 문자가 아니면
        if (visited[c - 'a']) { // 이미 등장한 문자라면 그룹 단어 아님
          return false;
        }
        visited[c - 'a'] = true; // 해당 문자를 방문했다고 기록
        lastChar = c; // 마지막 문자 갱신
      }
    }
    return true; // 그룹 단어임
  }
}




