import java.io.*;
import java.util.Arrays;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] answer = new int[n];

        for (int i = 0; i < n - 1; i++) {
            answer[i]++;
            answer[i + 1]++;

            double slop = calculate(i, i + 1);

            for (int j = i + 2; j < n; j++) {
                double new_slop = calculate(i, j);

                if (slop < new_slop) {
                    slop = new_slop;
                    answer[i]++;
                    answer[j]++;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int a : answer) {
            max = Math.max(max, a);
        }
        sb.append(max);
        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    static double calculate(int i, int j) {
        return (double) (arr[j] - arr[i]) / (j - i);
    }
}
