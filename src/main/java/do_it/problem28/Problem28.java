package do_it.problem28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem28 {
    static boolean[] isVisited;
    static int[] distance;
    static ArrayList<Edge>[] list;
    static int V;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        StringTokenizer st;
        list = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            list[i] = new ArrayList<>();
        }
        isVisited = new boolean[V];
        distance = new int[V];
        //입력
        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int nodeNum = Integer.parseInt(st.nextToken()) - 1;

            while (true) {
                int targetNodeNum = Integer.parseInt(st.nextToken());

                if (targetNodeNum == -1) {
                    break;
                }
                int distance = Integer.parseInt(st.nextToken());
                list[nodeNum].add(new Edge(targetNodeNum - 1, distance));
            }
        }

        bfs(0);

        int max = -1;
        int maxIndex = -1;
        for (int i = 0; i < V; i++) {
            if (max < distance[i]) {
                maxIndex = i;
                max = distance[i];
            }
        }

        distance = new int[V];
        isVisited = new boolean[V];
        bfs(maxIndex);

        int answer = -1;
        for (int i = 0; i < V; i++) {
            answer = Math.max(answer, distance[i]);
        }

        System.out.println(answer);
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        isVisited[start] = true;

        while (!queue.isEmpty()) {
            Integer node = queue.poll();

            for (Edge edge : list[node]) {
                if (!isVisited[edge.targetNode]) {
                    queue.offer(edge.targetNode);
                    isVisited[edge.targetNode] = true;
                    distance[edge.targetNode] = edge.value + distance[node];
                }
            }
        }
    }

    static class Edge {
        int targetNode;
        int value;

        public Edge(int targetNode, int value) {
            this.targetNode = targetNode;
            this.value = value;
        }
    }
}
