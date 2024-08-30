package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon7795 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 0; test_case < T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] A = new int[N];
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            int[] B = new int[M];
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(A);
            Arrays.sort(B);

            int aPoint = 0;
            int bPoint = 0;
            int count = 0;
            while(bPoint < M) {
                for(int i = aPoint; i < N; i++) {
                    if(A[i] > B[bPoint]) {
                        count += N-i;
                        aPoint = i;
                        break;
                    }
                }

                bPoint++;
            }

            System.out.println(count);
        }
    }
}
