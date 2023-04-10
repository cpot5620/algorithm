package do_it.problem6;

import java.util.Scanner;

public class Problem6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int answer = 1; // N으로 나타낼 수 있는 경우
        int start = 0;
        int end = 0;
        int sum = 0;

        while (end < N) {
            if (sum == N) {
                answer++;
                end++;
                sum += end;
            } else if (sum > N) {
                sum -= start;
                start++;
            } else {
                end++;
                sum += end;
            }
        }

        System.out.println(answer);
    }
}
