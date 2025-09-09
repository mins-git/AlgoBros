package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q_1940_S4_172ms {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // arr 정렬
        Arrays.sort(arr);

        // 투 포인터와 정답
        int start = 0;
        int end = N - 1;
        int cnt = 0;

        // 비교연산
        while (start < end) {
            // 두 포인터가 가리키는 인덱스의 합이 M보다 크면
            if (arr[start] + arr[end] > M) {
                end--;  // 뒤쪽 인덱스 -1
            }

            // 인덱스 합이 M보다 작으면
            else if (arr[start] + arr[end] < M) {
                start++;  // 앞쪽 인덱스 +1
            }

            // 같으면
            else {
                cnt++;    // 정답 개수 +1

                // 다음 탐색 준비
                start++;  // 앞쪽 인덱스 +1
                end--;    // 뒤쪽 인덱스 -1
            }
        }

        // 출력
        System.out.println(cnt);
        br.close();

    }  // end main
}  // end class
