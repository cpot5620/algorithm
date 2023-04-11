package do_it.problem9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem9 {
    private static final int A = 0;
    private static final int C = 1;
    private static final int G = 2;
    private static final int T = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int[] arr = new int[4];
        String strings = br.readLine();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < P; i++) {
            char ch = strings.charAt(i);

            if (ch == 'A') {
                arr[A]--;
            } else if (ch == 'C') {
                arr[C]--;
            } else if (ch == 'G') {
                arr[G]--;
            } else {
                arr[T]--;
            }
        }

        int answer = 0;

        int start = 0;
        int end = P - 1;
        while (end < S - 1) {
            if (arr[A] < 1 && arr[C] < 1 && arr[G] < 1 && arr[T] < 1) {
                answer++;
            }
            char first = strings.charAt(start);
            start++;
            end++;
            char last = strings.charAt(end);
            if (first == 'A') {
                arr[A]++;
            } else if (first == 'C') {
                arr[C]++;
            } else if (first == 'G') {
                arr[G]++;
            } else {
                arr[T]++;
            }
            if (last == 'A') {
                arr[A]--;
            } else if (last == 'C') {
                arr[C]--;
            } else if (last == 'G') {
                arr[G]--;
            } else {
                arr[T]--;
            }
        }
        if (arr[A] < 1 && arr[C] < 1 && arr[G] < 1 && arr[T] < 1) {
            answer++;
        }

        System.out.println(answer);
    }
}
