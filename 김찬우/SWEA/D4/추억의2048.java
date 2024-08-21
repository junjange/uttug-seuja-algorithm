import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    private static int[][] map;
    private static int n;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= t; test_case++) {

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            String direction = st.nextToken();
            map = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            if (direction.equals("up")) {
                up();
            }
            else if (direction.equals("down")) {
                down();
            }
            else if (direction.equals("left")) {
                left();
            }
            else if (direction.equals("right")) {
                right();
            }

            System.out.println("#" + test_case);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }

        }

    }

    private static void up() {

        for (int c = 0; c < n; c++) {
            ArrayList<Integer> tempList = new ArrayList<>();
            for (int r = 0; r < n; r++) {
                appendMap(r, c, tempList);
            }

            updateList(tempList);

            int r = 0;
            while (!tempList.isEmpty()) {
                map[r++][c] = tempList.get(0);
                tempList.remove(0);
            }
        }
    }

    private static void down() {

        for (int c = 0; c < n; c++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int r = n - 1; r >= 0; r--) {
                appendMap(r, c, list);
            }

            updateList(list);

            int r = n - 1;
            while (!list.isEmpty()) {
                map[r--][c] = list.get(0);
                list.remove(0);
            }
        }
    }

    private static void left() {

        for (int r = 0; r < n; r++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int c = 0; c < n; c++) {
                appendMap(r, c, list);
            }

            updateList(list);

            int c = 0;
            while (!list.isEmpty()) {
                map[r][c++] = list.get(0);
                list.remove(0);
            }
        }
    }

    private static void right() {

        for (int r = 0; r < n; r++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int c = n - 1; c >= 0; c--) {
                appendMap(r, c, list);
            }

            updateList(list);

            int c = n - 1;
            while (!list.isEmpty()) {
                map[r][c--] = list.get(0);
                list.remove(0);
            }
        }
    }


    private static void appendMap(int r, int c, List<Integer> list) {
        if (map[r][c] != 0) {
            list.add(map[r][c]);
            map[r][c] = 0;
        }
    }


    private static void updateList (List<Integer> list) {
        int idx = 0;
        while (list.size() > idx + 1) {
            if (list.get(idx).equals(list.get(idx + 1))) {
                list.set(idx, list.get(idx) + list.get(idx + 1));
                list.remove(idx + 1);
            }
            idx++;
        }
    }
}
