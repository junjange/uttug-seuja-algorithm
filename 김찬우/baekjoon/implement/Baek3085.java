
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static char[][] arr;
    static int max = Integer.MIN_VALUE;
    static int n;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());

        arr = new char[n][n];


        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            String str  = st.nextToken();

            for (int j=0; j<n; j++) {
                arr[i][j] = str.charAt(j);
            }

        }

        for (int i = 0; i < n; i++) {

            for (int j=0; j < n-1; j++) {


                char left = arr[i][j];
                char temp = left;
                char right = arr[i][j+1];

                arr[i][j] = right;
                arr[i][j+1] = temp;

                checkMax();

                arr[i][j+1] = arr[i][j];
                arr[i][j] = temp;


            }

        }



        for (int i = 0; i < n; i++) {

            for (int j=0; j < n-1; j++) {


                char left = arr[j][i];
                char temp = left;
                char right = arr[j+1][i];

                arr[j][i] = right;
                arr[j+1][i] = temp;

               checkMax();

                arr[j+1][i] = arr[j][i];
                arr[j][i] = temp;


            }

        }

        System.out.println(max);


    }

    static void checkMax() {

        for (int z =0; z < n; z++) {

            int cnt =1;

            for (int k=0; k <n-1; k++) {

                if (arr[z][k] == arr[z][k+1]) {
                    cnt++;
                    max = Math.max(max,cnt);

                }else {
                    cnt = 1;
                }


            }


        }

        for (int z =0; z < n; z++) {

            int cnt =1;

            for (int k=0; k <n-1; k++) {

                if (arr[k][z] == arr[k+1][z]) {
                    cnt++;
                    max = Math.max(max,cnt);

                }else {
                    cnt = 1;
                }


            }


        }

    }
}
