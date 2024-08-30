package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon9663 {
    static int N, count;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "");
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        count = 0;
        dfs(0);
        System.out.println(count);
    }

    public static void dfs(int depth) {
        if(depth == N) {
            count++;
            return;
        }

        for(int i = 0; i < N; i++) {
            arr[depth] = i;

            if(isPossible(depth)) {
                dfs(depth + 1);
            }
        }
    }

    public static boolean isPossible(int depth) {
        for(int i = 0; i < depth; i++) {
            if(arr[i] == arr[depth]) {
                return false;
            }

            if(Math.abs(i - depth) == Math.abs(arr[i] - arr[depth])) {
                return false;
            }
        }

        return true;
    }
}
