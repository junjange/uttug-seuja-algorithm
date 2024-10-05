package javaalog;

import java.io.*;

public class _2179 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            words[i] = word;
        }

        int first_answer = -1;
        int second_answer = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) {

            for (int j = i + 1; j < n; j++) {
                int cnt = check(words[i], words[j]);

                if (max < cnt) {
                    max = cnt;
                    first_answer = i;
                    second_answer = j;
                }

            }
        }

        sb.append(words[first_answer]).append("\n").append(words[second_answer]);
        bw.write(sb.toString());
        br.close();
        bw.close();

    }

    static int check(String word, String other) {
        int cnt = 0;
        int size = Math.min(word.length(), other.length());

        for (int i = 0; i < size; i++) {
            if (word.charAt(i) == other.charAt(i)) {
                cnt++;
                continue;
            }
            return cnt;
        }
        return cnt;
    }
}
