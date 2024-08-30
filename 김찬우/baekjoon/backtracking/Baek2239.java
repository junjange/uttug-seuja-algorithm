
import java.io.*;
import java.util.*;

public class Main {

    static int[][] arr = new int[9][9];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i=0; i<9; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j=0; j<9; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }

        }

        backTrack(0,0);


    }

    static boolean check (int row, int col, int value) {

        for (int i=0; i<9; i++) {

            if (arr[row][i] == value) {
                return false;
            }

        }

        for (int i=0; i<9; i++) {

            if (arr[i][col] == value) {
                return false;
            }

        }

        int r = (row / 3) * 3;
        int c = (col / 3) * 3;

        for (int i=r; i<r+3; i++) {

            for (int j=c; j<c+3; j++) {
                if (arr[i][j] == value) {
                    return false;
                }
            }
        }

        return true;

    }

    static void backTrack(int row, int col) {

        if (col == 9) {
            backTrack(row+1,0);
            return;
        }

        if (row == 9) {
            for (int i=0; i<9; i++) {

                for (int j=0; j<9; j++) {
                    sb.append(arr[i][j]);
                }
                sb.append('\n');
            }

            System.out.println(sb.toString());
            System.exit(0);

            return;
        }

        if (arr[row][col] == 0) {

            for (int i = 1; i <= 9; i++) {

                if (check(row,col,i)) {
                    arr[row][col] = i;
                    backTrack(row,col+1);
                }

            }

            arr[row][col] = 0;

            return;

        }

        backTrack(row,col+1);


    }

}
