package do_it.problem11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem11 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int num = 1;

        for (int i = 0; i < N; i++) {
            if (arr[i] >= num) {
                while (arr[i] >= num) {
                    stack.push(num);
                    num++;
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {
                int top = stack.pop();
                if (top > arr[i]) {
                    System.out.println("NO");
                    return;
                }
                sb.append("-\n");
            }
        }

        System.out.println(sb);
    }
}
