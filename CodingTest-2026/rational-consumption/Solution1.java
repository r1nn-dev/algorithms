// Solution1.java: 선형 탐색

import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄에서 물품의 개수 N을 입력받는다.
        int n = Integer.parseInt(br.readLine());

        // 최소/최대 가격과 해당 물품명을 저장한다.
        int minPrice = Integer.MAX_VALUE;
        int maxPrice = Integer.MIN_VALUE;

        String minName = "";
        String maxName = "";

        // N개의 물품을 하나씩 확인한다.
        for (int i = 0; i < n; i++) {
            // 한 줄을 공백 기준으로 물품명과 가격으로 분리한다.
            StringTokenizer st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            int price = Integer.parseInt(st.nextToken());

            // 현재 물품이 지금까지의 최저가보다 저렴하면
            // 가격과 물품명을 함께 갱신한다.
            if (price < minPrice) {
                minPrice = price;
                minName = name;
            }

            // 현재 물품이 지금까지의 최고가보다 비싸면
            // 가격과 물품명을 함께 갱신한다.
            if (price > maxPrice) {
                maxPrice = price;
                maxName = name;
            }
        }

        // 가장 비싼 물품을 먼저 출력하고,
        // 다음 줄에 가장 저렴한 물품을 출력한다.
        System.out.println(maxName);
        System.out.println(minName);
    }
}
