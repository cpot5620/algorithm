package do_it.problem27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem27 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N + 1][M + 1];
        boolean[][] isVisited = new boolean[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            String input = br.readLine();
            for (int j = 1; j <= M; j++) {
                char c = input.charAt(j - 1);
                if (c == '1') {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = 0;
                }
            }
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{1, 1});

        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            isVisited[position[0]][position[1]] = true;

            for (int i = 0; i < 4; i++) {
                int x = position[0] + dx[i];
                int y = position[1] + dy[i];

                if (x > 0 && y > 0 && x <= N && y <= M) {
                    if (arr[x][y] != 0 && !isVisited[x][y]) {
                        isVisited[x][y] = true;
                        queue.offer(new int[]{x, y});
                        arr[x][y] = arr[position[0]][position[1]] + 1;
                    }
                }
            }
        }

        System.out.println(arr[N][M]);
    }


}
