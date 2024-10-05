package javaalog;

import java.io.*;

public class _1943 {

    static public void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < 3; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] coins = new int[100001];
            int total = 0;
            for (int i = 0; i < n; i++) {
                String[] line = br.readLine().split(" ");
                int coin = Integer.parseInt(line[0]);
                int count = Integer.parseInt(line[1]);

                for (int j = 1; j <= count; j++) {
                    for (int k = total; k > 0; k--) {
                        if (coins[k] > 0) {
                            coins[k + (coin * j)]++;
                        }
                    }
                }

                for (int j = 1; j <= count; j++) {
                    coins[coin * j]++;
                }

                total += (coin * count);
            }

            if (total % 2 != 0) {
                sb.append("0");
                if (t != 2) {
                    sb.append("\n");
                }
                continue;
            }

            if (coins[total / 2] != 0) {
                sb.append("1");
            } else {
                sb.append("0");
            }

            if (t != 2) {
                sb.append("\n");
            }
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
