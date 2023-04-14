package do_it.problem16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem16 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Data[] arr = new Data[N];

        for (int i = 0; i < N; i++) {
            arr[i] = new Data(Integer.parseInt(br.readLine()), i);
        }

        Arrays.sort(arr);

        int max = 0;
        for (int i = 0; i < N; i++) {
            int index = arr[i].index - i;
            if (max < index) {
                max = index;
            }
        }

        System.out.println(max + 1);
    }

}

class Data implements Comparable<Data> {
    int value;
    int index;

    public Data(int value, int index) {
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(Data o) {
        return this.value - o.value;
    }
}

