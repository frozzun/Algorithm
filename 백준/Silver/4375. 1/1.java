import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;
        while ((input = br.readLine()) != null && !input.isEmpty()) { // EOF 처리
            int n = Integer.parseInt(input);
            int current = 1; // x % n 값을 저장
            int index = 1; // 자릿수

            while (true) {
                if (current % n == 0) { // 나머지가 0이면 정답
                    System.out.println(index);
                    break;
                } else {
                    current = (current * 10 + 1) % n; // 다음 값 계산
                    index++;
                }
            }
        }
    }
}
