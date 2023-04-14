package do_it.problem19;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Problem19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(sc.nextLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        quickSort(arr, 0, N - 1, K - 1);

        System.out.println(arr[K - 1]);
    }

    private static void quickSort(int[] arr, int start, int end, int K) {
        if (start >= end) {
            return;
        }

        int pivot = partition(arr, start, end);
        if (pivot == K) {
            return;
        }

        if (pivot > K) {
            quickSort(arr, pivot, end - 1, K);
        } else {
            quickSort(arr, start + 1, pivot, K);
        }
    }


    private static int partition(int[] arr, int start, int end) {
        int mid = (start + end) / 2;
        swap(arr, start, mid);

        int pivot = arr[start];
        int i = start, j = end;

        while (i < j) {
            while (pivot > arr[i]) {
                i++;
            }

            while (i < j && pivot <= arr[j]) {
                j--;
            }
            swap(arr, i, j);
        }

        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
