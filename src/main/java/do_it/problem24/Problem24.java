package do_it.problem24;

import java.util.Scanner;

public class Problem24 {
    static StringBuilder answer = new StringBuilder();
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);

        System.out.println(answer);
    }

    static void dfs(int number, int digit) {
        if (digit == N) {
            if (isPrime(number)) {
                answer.append(number).append("\n");
            }
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (i % 2 == 0) {
                continue;
            }

            if (isPrime(number * 10 + i)) {
                dfs(number * 10 + i, digit + 1);
            }
        }
    }

    static boolean isPrime(int number) {
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;

    }
}
