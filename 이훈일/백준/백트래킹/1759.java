package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1759 {
    static int L, C;
    static char[] dic;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        dic = new char[C];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < C; i++) {
            dic[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(dic);
        sb = new StringBuilder();
        dfs(0, 0, 0);
    }

    public static void dfs(int depth, int cur, int vowelCount) {
        if(depth == L) {
            if(vowelCount >= 1 && L-vowelCount >= 2) {
                System.out.println(sb.toString());
            }
            return;
        }

        for(int i = cur; i < C; i++) {
            sb.insert(depth, dic[i]);

            if(dic[i] == 'a' || dic[i] == 'e' || dic[i] == 'i'
            || dic[i] == 'o' || dic[i] == 'u') {
                dfs(depth+1, i+1, vowelCount+1);
            } else {
                dfs(depth+1, i+1, vowelCount);

            }

            sb.deleteCharAt(depth);
        }
    }
}
