package do_it.problem14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Problem14 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            int num1 = Math.abs(o1);
            int num2 = Math.abs(o2);

            if (num1 == num2) {
                return o1 - o2;
            }

            return num1 - num2;
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());

            if (input == 0) {
                if (queue.isEmpty()) {
                    sb.append("0\n");
                } else {
                    sb.append(queue.poll()).append("\n");
                }
            } else {
                queue.add(input);
            }
        }

        System.out.println(sb);
    }
}
