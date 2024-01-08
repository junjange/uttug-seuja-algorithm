package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon14888 {
    static int[] numbers;
    static int[] operators;
    static boolean[] visited;
    static int N;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        numbers = new int[N];
        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        operators = new int[N - 1];
        visited = new boolean[N - 1];
        st = new StringTokenizer(br.readLine(), " ");
        int index = 0;
        for(int i = 0; i < 4; i++) {
            int count = Integer.parseInt(st.nextToken());
            while(count > 0) {
                operators[index] = i;
                count--;
                index++;
            }
        }

        dfs(0, numbers[0]);
        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int depth, int sum) {
        if(depth == N-1) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        for(int i = 0; i < N-1; i++) {
            if(!visited[i]) {
                visited[i] = true;
                if(operators[i] == 0) {
                    dfs(depth + 1, sum + numbers[depth+1]);
                } else if(operators[i] == 1) {
                    dfs(depth + 1, sum - numbers[depth+1]);
                } else if(operators[i] == 2) {
                    dfs(depth + 1, sum * numbers[depth+1]);
                } else if(operators[i] == 3) {
                    dfs(depth + 1, sum / numbers[depth+1]);
                }
                visited[i] = false;
            }
        }
    }
}
