import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int sum = 0;

        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());

            int temp = number;
            boolean hasFour = false;

            while (temp > 0) {
                int digit = temp % 10;

                if (digit == 4) {
                    hasFour = true;
                    break;
                }

                temp /= 10;
            }

            if (hasFour) {
                sum += number;
            }
        }

        System.out.println(sum);
    }
}
