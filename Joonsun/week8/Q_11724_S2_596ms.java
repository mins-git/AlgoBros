package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q_11724_S2_596ms {
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());   // 정점 수
        int L = Integer.parseInt(st.nextToken());   // 간선 수

        // ArrayList로 그래프 틀 생성
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        // 무향 그래프에 값 넣기
        for (int i = 1; i <= L; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 무향 그래프 추가
            list[a].add(b);
            list[b].add(a);
        }

        // 방문쳌
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
                cnt++;
            }
        }

        // 출력
        System.out.println(cnt);
        br.close();

    }  // end main

    public static void dfs(int n) {
        // 현재 노드
        visited[n] = true;

        // 다음 노드 탐색
        for (int next : list[n]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}  // end class
