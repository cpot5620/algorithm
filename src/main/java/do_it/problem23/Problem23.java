package do_it.problem23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem23 {
    static boolean[] isVisited;
    static int N;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        isVisited = new boolean[N + 1];
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        int answer = 0;

        for (int i = 1; i <= N; i++) {
            if (!isVisited[i]) {
                answer++;
                dfs(i);
            }
        }

        System.out.println(answer);
    }

    public static void dfs(int i) {
        if (isVisited[i]) {
            return;
        }

        isVisited[i] = true;
        for (int node : list[i]) {
            if (!isVisited[node]) {
                dfs(node);
            }
        }

    }
}
