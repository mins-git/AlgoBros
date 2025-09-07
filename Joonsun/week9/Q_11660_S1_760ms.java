package 합응용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_11660_S1_760ms {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 입력
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N + 1][N + 1];  // 입력값 저장할 배열
        int[][] sum = new int[N + 1][N + 1];  // 누적합 저장할 배열

        // 입력값 저장
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 구간 합 저장
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                sum[i][j] = sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1] + arr[i][j];
            }
        }

        // 구간 합 계산
        int ans = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            // 정답
            ans = sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1];
            sb.append(ans).append("\n");
        }

        System.out.println(sb);
        br.close();

    }  // end main
}  // end class
