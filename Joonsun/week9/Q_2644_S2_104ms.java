package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q_2644_S2_104ms {
    static int n, a, b;
    static ArrayList<Integer>[] relation;
    static boolean check;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력
        n = Integer.parseInt(br.readLine());  // 사람 수

        // 촌수 파악 대상
        st = new StringTokenizer(br.readLine(), " ");
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        // 관계 개수
        int m = Integer.parseInt(br.readLine());

        // 부모-자식 관계 정의
        visited = new int[n + 1];
        relation = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            relation[i] = new ArrayList<>();
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            relation[x].add(y);
            relation[y].add(x);
        }

        // 재귀
        bfs(a, b);

        // 출력
        System.out.println(check ? visited[b] : -1);
        br.close();

    }  // end main

    public static void bfs(int parent, int child) {
        // BFS를 위한 큐 생성
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(parent);  // 기준 노드 큐에 삽입

        // 큐가 비어 있지 않을 때까지 반복
        while (!queue.isEmpty()) {
            int currNode = queue.poll();  // 기준 노드 꺼내서 currNode에 넣기

            // 목표 노드 도달했다면 탐색 종료
            if (currNode == child) {
                check = true;
                return;
            }

            // 현재 노드와 연결된 모든 인접 노드 확인
            for (int next : relation[currNode]) {
                // 미방문 노드이면
                if (visited[next] == 0) {
                    visited[next] = visited[currNode] + 1;  // 촌수 계산
                    queue.offer(next);  // 다음 노드 삽입
                }
            }
        }
    }  // end bfs
}  // end class
