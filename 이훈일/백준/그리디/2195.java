package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2195 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String P = br.readLine();

        int cur = 0;
        int count = 0;
        while(cur < P.length()) {
            for(int i = S.length(); i >= 0; i--) {
                int end = cur + i;
                if(end <= P.length()) {
                    String sub = P.substring(cur, end);
                    if(S.contains(sub)) {
                        count++;
                        cur = end;
                        break;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
