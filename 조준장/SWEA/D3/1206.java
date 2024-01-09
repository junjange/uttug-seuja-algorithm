package implementation;

import java.util.Arrays;
import java.util.Scanner;

public class Java1206 {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);

        int T;
        T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = Integer.parseInt(sc.nextLine());
            int[] m = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int answer = 0;

            for (int i = 2; i < n - 2; i++) {
                int max = Math.max(Math.max(m[i - 1], m[i - 2]), Math.max(m[i + 1], m[i + 2]));

                if (m[i] > max) {
                    answer += m[i] - max;

                }
            }
            System.out.println(String.format("#%d %d", test_case, answer));

        }

    }
}
