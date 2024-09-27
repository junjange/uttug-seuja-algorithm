package javaalog;

import java.io.*;
import java.util.*;

public class _24337 {
    static public void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int a = Integer.parseInt(line[1]);
        int b = Integer.parseInt(line[2]);

        ArrayList<Integer> arr = new ArrayList<>();

        if (a + b - 1 > n) {
            sb.append(-1);
        } else {
            for (int i = 1; i < a; i++) {
                arr.add(i);
            }

            arr.add(Math.max(a, b));

            for (int i = b - 1; i >= 1; i--) {
                arr.add(i);
            }

            if (a == 1) {
                while (arr.size() < n) {
                    arr.add(1, 1);
                }
            } else {
                while (arr.size() < n) {
                    arr.add(0, 1);
                }
            }

            for (int i = 0; i < n; i++) {
                sb.append(arr.get(i));
                if (i != n - 1) {
                    sb.append(" ");
                }
            }

        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}

/**
 * 5 3 3
 * 1 2 3 0 0
 * 0 0 3 2 1
 * 0 0 0 0 1
 */
