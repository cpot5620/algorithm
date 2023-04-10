package do_it.problem5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] sum = new long[N + 1];
        long[] counts = new long[M];
        long answer = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
            int remainder = (int) (sum[i] % M);

            if (remainder == 0) {
                answer++;
            }

            counts[remainder]++;
        }

        for (int i = 0; i < M; i++) {
            long c = counts[i];
            if (c > 1) {
                answer += c * (c - 1) / 2;
            }
        }

        System.out.println(answer);
    }
}
