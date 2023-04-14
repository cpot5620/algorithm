package do_it.problem18;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Problem18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int[] sumArr = new int[N];
        sumArr[0] = arr[0];
        for (int i = 1; i < N; i++) {
            sumArr[i] = sumArr[i - 1] + arr[i];
        }
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += sumArr[i];
        }

        System.out.println(sum);
    }
}
