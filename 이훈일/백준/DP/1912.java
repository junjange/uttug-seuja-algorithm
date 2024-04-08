package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int max = Integer.MIN_VALUE;
        int[] dp = new int[N+1];
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            dp[i+1] = Math.max(num, num+dp[i]);
            max = Math.max(max, dp[i+1]);
        }

        System.out.println(max);
    }
}
