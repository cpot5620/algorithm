package do_it.problem10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Problem10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Deque<Node> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());

            while (!deque.isEmpty() && now < deque.getLast().value) {
                deque.removeLast();
            }

            deque.addLast(new Node(i, now));

            if (deque.getFirst().index < i - L + 1) {
                deque.removeFirst();
            }

            sb.append(deque.getFirst().value).append(" ");
        }

        System.out.println(sb);
    }

    static class Node {
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
