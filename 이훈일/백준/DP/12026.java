package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon12026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String line = br.readLine();

        int[] dp = new int[N];
        for(int i = 1; i < N; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < N-1; i++) {
            if(dp[i] == Integer.MAX_VALUE) {
                continue;
            }

            for(int j = i+1; j < N; j++) {
                if(line.charAt(i) == 'B') {
                    if(line.charAt(j) == 'O') {
                        dp[j] = Math.min(dp[j], dp[i] + (int) Math.pow(j-i, 2));
                    }
                } else if(line.charAt(i) == 'O') {
                    if(line.charAt(j) == 'J') {
                        dp[j] = Math.min(dp[j], dp[i] + (int) Math.pow(j-i, 2));
                    }
                } else {
                    if(line.charAt(j) == 'B') {
                        dp[j] = Math.min(dp[j], dp[i] + (int) Math.pow(j-i, 2));
                    }
                }
            }
        }

        int answer = 0;
        if(dp[N-1] == Integer.MAX_VALUE) {
            answer = -1;
        } else {
            answer = dp[N-1];
        }

        System.out.println(answer);
    }
}
