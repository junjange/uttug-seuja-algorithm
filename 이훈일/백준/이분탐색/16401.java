package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon16401 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int[] snacks = new int[N];
        int max = 0;
        for(int i = 0; i < N; i++) {
            snacks[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, snacks[i]);
        }

        int start = 1;
        int end = max;
        int answer = 0;
        while(start <= end) {
            int size = start + (end - start) / 2;
            int sum = 0;
            for(int i = 0; i < N; i++) {
                sum += snacks[i] / size;
            }

            if(sum >= M) {
                answer = size;
                start = size + 1;
            } else {
                end = size - 1;
            }
        }

        System.out.println(answer);
    }
}
