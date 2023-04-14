package do_it.problem21;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Problem21 {
    static int[] arr, tmp;
    static long result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        arr = new int[N];
        tmp = new int[N];

        StringTokenizer st = new StringTokenizer(sc.nextLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(0, N - 1);

        System.out.println(result);
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
                result += right - target;
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
            left++;
            target++;
        }

        while (right <= end) {
            arr[target] = tmp[right];
            right++;
            target++;
        }
    }
}
