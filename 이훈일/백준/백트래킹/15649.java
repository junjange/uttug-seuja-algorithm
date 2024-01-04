package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon15649 {
    static int N, M;
    static boolean[] visited;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        arr = new int[M];
        backtracking(0);

    }

    public static void backtracking(int depth) {
        if(depth == M) {
            String answer = String.valueOf(arr[0]);
            for(int i = 1; i < M; i++) {
                answer += " " + arr[i];
            }
            System.out.println(answer);
            return;
        }

        for(int i = 1; i <= N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                backtracking(depth + 1);
                visited[i] = false;
            }
        }
    }
}
