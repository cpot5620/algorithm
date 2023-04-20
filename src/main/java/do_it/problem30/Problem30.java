package do_it.problem30;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Problem30 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());

        int start = 0, end = 0;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(sc.nextLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            start = Math.max(start, arr[i]);
            end += arr[i];
        }

        int answer = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = (start + end) / 2;
            int sum = 0;
            int count = 0;

            for (int i = 0; i < N; i++) {
                if (sum + arr[i] > mid) {
                    count++;
                    sum = 0;
                }
                sum += arr[i];
            }

            if (sum > 0) {
                count++;
            }

            if (count <= M) {
                answer = mid;
            }

            if (count > M) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
