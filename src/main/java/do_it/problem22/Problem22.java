package do_it.problem22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem22 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        radixSort(arr, 5);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void radixSort(int[] arr, int maxSize) {
        int[] output = new int[arr.length];
        int digitNumber = 1;
        int count = 0;

        while (count < maxSize) {
            int[] bucket = new int[10];
            for (int i = 0; i < arr.length; i++) {
                bucket[(arr[i] / digitNumber) % 10]++;
            }
            for (int i = 1; i < 10; i++) {
                bucket[i] += bucket[i - 1];
            }
            for (int i = arr.length - 1; i >= 0; i--) {
                output[bucket[(arr[i] / digitNumber % 10)] - 1] = arr[i];
                bucket[(arr[i] / digitNumber % 10)]--;
            }

            for (int i = 0; i < arr.length; i++) {
                arr[i] = output[i];
            }
            digitNumber *= 10;
            count++;
        }
    }


}
