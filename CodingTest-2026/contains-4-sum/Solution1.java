import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄: 수의 개수 N
        int N = Integer.parseInt(br.readLine());
        // 4가 들어간 숫자들의 합
        int sum = 0;

        // 두 번째 줄부터 N개의 줄에 걸쳐 m_i 입력
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());
            // 숫자를 문자열로 바꿔서 4가 포함되어 있는지 확인
            String numberText = String.valueOf(number);

            if (numberText.contains("4")) {
                sum += number;
            }
        }

        // 결과 출력
        System.out.println(sum);
    }
}
