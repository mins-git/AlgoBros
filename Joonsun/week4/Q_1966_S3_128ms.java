package dataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.LinkedList;

public class Q_1966_S3_128ms {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            LinkedList<int[]> q = new LinkedList<>();	// Queue로 활용할 연결리스트
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                // {초기 위치, 중요도}
                q.offer(new int[] { i, Integer.parseInt(st.nextToken()) });
            }

            int cnt = 0;	// 출력 횟수

            while (!q.isEmpty()) {	// 한 케이스에 대한 반복문
                int[] front = q.poll();	// 가장 첫 원소
                boolean isMax = true;	// front 원소가 가장 큰 원소인지를 판단하는 변수

                // 큐에 남아있는 원소들과 중요도를 비교
                for(int i = 0; i < q.size(); i++) {
                    // 처음 뽑은 원소보다 큐에 있는 i번째 원소가 중요도가 클 경우
                    if(front[1] < q.get(i)[1]) {
                        // 뽑은 원소 및 i 이전의 원소들을 뒤로 보낸다.
                        q.offer(front);
                        for(int j = 0; j < i; j++) {
                            q.offer(q.poll());
                        }

                        // front원소가 가장 큰 원소가 아니였으므로 false를 하고 탐색을 마침
                        isMax = false;
                        break;
                    }
                }

                // front 원소가 가장 큰 원소가 아니였으므로 다음 반복문으로 넘어감
                if(isMax == false) {
                    continue;
                }

                // front 원소가 가장 큰 원소였으므로 해당 원소는 출력해야하는 문서다.
                cnt++;
                if(front[0] == M) {	// 찾고자 하는 문서라면 해당 테스트케이스 종료
                    break;
                }
            }

            sb.append(cnt).append('\n');
        }
        System.out.println(sb);
        br.close();

    }  // end main
}  // end class

/*
 * <입력>
 * 테스트케이스
 * 문서 수, 위치
 * 출력 순서
 * 출력 순서를 알고 싶은 값의 우선순위와 같은 다른 문서가 있다면 무조건 마지막
 *
 * 1 <= N <= 100
 * 0 <= M <= N
 */
