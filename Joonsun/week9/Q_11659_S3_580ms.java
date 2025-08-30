package cumul_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_11659_S3_580ms {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 입력
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 누적합 저장할 배열
        int[] sumArr = new int[N + 1];

        // 입력값 저장
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            sumArr[i] = sumArr[i - 1] + Integer.parseInt(st.nextToken());
        }

        // 누적합 계산
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            // 누적합 결과
            int ans = sumArr[end] - sumArr[start - 1];
            sb.append(ans).append("\n");
        }

        System.out.println(sb);
        br.close();

    }  // end main
}  // end class

/*
 * <누적 합 구하기>
 * 1 <= N <= 10만
 * 1 <= M <= 10만
 * 1 <= i <= j <= N
 */