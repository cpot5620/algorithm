package do_it.problem26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem26 {
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer>[] list;
    static int N;
    static boolean[] isVisited;
    static int[] dfs, bfs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        isVisited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        dfs = new int[N + 1];
        bfs = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(list[i]);
        }


        dfs(V, 1);
        sb.append("\n");
        isVisited = new boolean[N + 1];
        bfs(V);

        System.out.println(sb);
    }

    private static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();

        isVisited[node] = true;
        queue.offer(node);
        sb.append(node).append(" ");

        while (!queue.isEmpty()) {
            int tmp = queue.poll();

            for (Integer i : list[tmp]) {
                if (!isVisited[i]) {
                    isVisited[i] = true;
                    queue.offer(i);
                    sb.append(i).append(" ");
                }
            }
        }

    }

    private static void dfs(int node, int depth) {
        if (depth == N + 1) {
            return;
        }

        if (isVisited[node]) {
            return;
        }

        isVisited[node] = true;
        sb.append(node).append(" ");

        for (Integer i : list[node]) {
            if (!isVisited[i]) {
                dfs(i, depth + 1);
            }
        }
    }
}
