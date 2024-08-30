package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon21318 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String line = br.readLine();
        int[] graph = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] dp = new int[N];
        dp[0] = 0;
        for(int i = 1; i < N; i++) {
            if(graph[i-1] > graph[i]) {
                dp[i] = dp[i-1] + 1;
            } else {
                dp[i] = dp[i-1];
            }
        }

        int Q = Integer.parseInt(br.readLine());
        for(int i = 0; i < Q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;

            System.out.println(dp[end] - dp[start]);
        }
    }
}
