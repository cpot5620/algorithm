package do_it.problem12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem12 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] answer = new int[N];
        st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        stack.push(0);
        for (int i = 1; i < N; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                answer[stack.peek()] = arr[i];
                stack.pop();
            }
            stack.push(i);

        }

        while (!stack.isEmpty()) {
            answer[stack.peek()] = -1;
            stack.pop();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(answer[i]).append(" ");
        }

        System.out.println(sb);

    }
}
