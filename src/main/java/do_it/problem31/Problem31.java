package do_it.problem31;

import java.util.Scanner;

public class Problem31 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int K = Integer.parseInt(sc.nextLine());

        int start = 0;
        int end = K;
        int answer = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            int count = 0;
            for (int i = 1; i <= N; i++) {
                count += Math.min(mid / i, N);
            }

            if (count < K) {
                start = mid + 1;
            } else {
                answer = mid;
                end = mid - 1;
            }
        }
        System.out.println(answer);
    }


}
