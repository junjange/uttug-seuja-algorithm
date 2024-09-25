package javaalog;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class _14658 {
    static class Star {
        int x;
        int y;

        public Star(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    static int[] dx;
    static int[] dy;

    static public void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);
        int l = Integer.parseInt(firstLine[2]);
        int k = Integer.parseInt(firstLine[3]);

        ArrayList<Star> stars = new ArrayList<>();

        dx = new int[]{l, l, -l, -l};
        dy = new int[]{l, -l, l, -l};

        for (int i = 0; i < k; i++) {
            String[] line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            stars.add(new Star(x, y));
        }

        int max = 0;
        for (int i = 0; i < k; i++) {
            Star iStar = stars.get(i);
            for (int j = 0; j < k; j++) {
                Star jStar = stars.get(j);
                int cnt = 0;
                for (int c = 0; c < k; c++) {
                    int tx = stars.get(c).x;
                    int ty = stars.get(c).y;

                    if (iStar.x <= tx && tx <= iStar.x + l && jStar.y <= ty && ty <= jStar.y + l) {
                        cnt++;
                    }

                }
                max = Math.max(max, cnt);
            }
        }

        sb.append(k - max);
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
