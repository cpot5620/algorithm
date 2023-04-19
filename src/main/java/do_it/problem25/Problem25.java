package do_it.problem25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem25 {
    static int N, M;
    static boolean[] isVisited;
    static ArrayList<Integer>[] list;
    static boolean arrive;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }
        isVisited = new boolean[N];


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            dfs(i, 1);
            if (arrive) {
                break;
            }
        }

        if (arrive) {
            System.out.println(1);
            return;
        }
        System.out.println(0);
    }

    static void dfs(int node, int depth) {
        if (depth == 5 || arrive) {
            arrive = true;
            return;
        }


        if (isVisited[node]) {
            return;
        }

        isVisited[node] = true;

        for (int i : list[node]) {
            if (!isVisited[i]) {
                dfs(i, depth + 1);
            }
        }

        isVisited[node] = false;
    }
}
