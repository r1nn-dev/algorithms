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

            // 최저가 물품 갱신
            if (price < minPrice) {
                minPrice = price;
                minName = name;
            }

            // 최고가 물품 갱신
            if (price > maxPrice) {
                maxPrice = price;
                maxName = name;
            }
        }

        // 가장 비싼 물품과 가격 출력
		System.out.println(maxName + " " + maxPrice);
        // 가장 저렴한 물품과 가격 출력
		System.out.println(minName + " " + minPrice);
    }
}
