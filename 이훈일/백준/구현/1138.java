package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] answer = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i < N; i++) {
            int count = Integer.parseInt(st.nextToken());
            int curCount = 0;
            int position = 0;

            for(int j = 0; j < N; j++) {
                if(answer[j] == 0) {
                    if(curCount == count) {
                        position = j;
                        break;
                    } else {
                        curCount++;
                    }
                }
            }

            answer[position] = i+1;
        }

        StringBuilder sb = new StringBuilder();
        for(int num : answer) {
            sb.append(num + " ");
        }

        System.out.println(sb.toString());
    }
}
