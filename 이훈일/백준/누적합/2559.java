package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] sums = new int[N+1];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= N; i++) {
            sums[i] = sums[i-1] + Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        for(int i = K; i <= N; i++) {
            int sum = sums[i] - sums[i-K];
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}
