package do_it.problem20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem20 {
    static int[] arr, tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N];
        tmp = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(0, N - 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i]).append("\n");
        }

        System.out.println(sb);
    }

    private static void mergeSort(int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(start, mid);
        mergeSort(mid + 1, end);

        for (int i = start; i <= end; i++) {
            tmp[i] = arr[i];
        }

        int target = start;
        int left = start;
        int right = mid + 1;

        while (left <= mid && right <= end) {
            if (tmp[left] > tmp[right]) {
                arr[target] = tmp[right];
                right++;
            } else {
                arr[target] = tmp[left];
                left++;
            }
            target++;
        }

        while (left <= mid) {
            arr[target] = tmp[left];
            target++;
            left++;
        }

        while (right <= end) {
            arr[target] = tmp[right];
            target++;
            right++;
        }
    }

}
