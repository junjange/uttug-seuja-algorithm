package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1074 {
    static int N, r, c, sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        sum = 0;
        int size = (int) Math.pow(2, N);
        partition(0, 0, size);
        System.out.println(sum);
    }

    public static void partition(int x, int y, int len) {
        if(len == 1) {
            return;
        }

        int newLen = len / 2;
        int sqrt = (int)Math.pow(newLen, 2);

        if(r < x + newLen && c < y + newLen) {
            partition(x, y, newLen);
        } else if(r < x + newLen && c >= y + newLen) {
            sum += sqrt;
            partition(x, y+newLen, newLen);
        } else if(r >= x + newLen && c < y + newLen) {
            sum += sqrt * 2;
            partition(x+newLen, y, newLen);
        } else if(r >= x + newLen && c >= y + newLen) {
            sum += sqrt * 3;
            partition(x+newLen, y+newLen, newLen);
        }
    }
}
