package do_it.problem7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int answer = 0;
        int i = 0;
        int j = N - 1;
        while (i < j) {
            int num = arr[i] + arr[j];

            if (num == M) {
                answer++;
                i++;
                j--;
            } else if (num > M) {
                j--;
            } else {
                i++;
            }
        }

        System.out.println(answer);

    }
}
