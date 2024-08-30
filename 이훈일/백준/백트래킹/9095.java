package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon9095 {

    static int N;
    static int count;
    static int[] numbers = new int[]{1, 2, 3};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            count = 0;

            dfs(0);

            System.out.println(count);
        }
    }

    public static void dfs(int sum) {
        if(sum >= N) {
            if(sum == N) {
                count++;
            }
            return;
        }

        for(int i = 0; i < 3; i++) {
            dfs(sum + numbers[i]);
        }
    }
}
