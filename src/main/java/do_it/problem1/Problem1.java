package do_it.problem1;

import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        String numbers = sc.nextLine();
        int sum = 0;

        for (int i = 0; i < N; i++) {
            sum += numbers.charAt(i) - '0';
        }

        System.out.println(sum);
    }
}
