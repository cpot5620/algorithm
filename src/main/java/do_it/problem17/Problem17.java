package do_it.problem17;

import java.util.Scanner;

public class Problem17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int N = input.length();

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = input.charAt(i) - '0';
        }

        for (int i = 0; i < N; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < N; j++) {
                if (arr[maxIndex] < arr[j]) {
                    maxIndex = j;
                }
            }
            int tmp = arr[maxIndex];
            arr[maxIndex] = arr[i];
            arr[i] = tmp;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i]);
        }

        System.out.println(sb);

    }
}
