package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon15650 {
    static int N,M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        dfs(0, 1);
    }

    public static void dfs(int depth, int start) {
        if(depth == M) {
            String answer = String.valueOf(arr[0]);
            for (int i = 1; i < arr.length; i++) {
                answer += " " + arr[i];
            }
            System.out.println(answer);
            return;
        }

        for(int i = start; i <= N; i++) {
            arr[depth] = i;
            dfs(depth + 1, i + 1);
        }
    }
}



