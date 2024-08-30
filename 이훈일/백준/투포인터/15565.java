package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon15565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> dolls = new ArrayList<>();
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            int doll = Integer.parseInt(st.nextToken());

            if(doll == 1) {
                dolls.add(i);
            }
        }

        int answer = Integer.MAX_VALUE;
        if(dolls.size() < K) {
            answer = -1;
        } else {
            int start = 0;
            int end = K-1;

            while(end < dolls.size()) {
                int size = dolls.get(end) - dolls.get(start) + 1;
                answer = Math.min(answer, size);
                start ++;
                end ++;
            }
        }

        System.out.println(answer);
    }
}
