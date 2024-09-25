package javaalog;

import java.io.*;
import java.util.*;

public class _22866 {
    static int[] arr;

    static public void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        String[] line = br.readLine().split(" ");
        int[] answer = new int[n + 1];
        int[] cnt = new int[n + 1];

        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(line[i - 1]);
            answer[i] = -1000000;
        }

        Stack<Integer> stack = new Stack();

        for (int i = 1; i <= n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) answer[i] = stack.peek();
            cnt[i] = stack.size();
            stack.push(i);
        }

        stack.clear();

        for (int i = n; i > 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }

            cnt[i] += stack.size();
            if (!stack.isEmpty() && stack.peek() - i < i - answer[i]) answer[i] = stack.peek();
            stack.push(i);
        }

        for (int i = 1; i <= n; i++) {
            sb.append(cnt[i]);
            if (cnt[i] <= 0) {
                sb.append("\n");
                continue;
            }
            sb.append(String.format(" %d\n", answer[i]));
        }

        bw.write(sb.toString());
        br.close();
        bw.close();

    }
}
