import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static boolean[][] visited;
    static int n,m,k;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }

        }
        
        back(0,0);
        System.out.println(max);

        
    }
    public static void back(int depth , int sum) {
        

        if (depth == k) {
            max = Math.max(sum,max);
            return;
        }

        for (int i=0; i<n; i++) {

            for (int j=0; j<m; j++) {

                if (!visited[i][j]) {

                    boolean check = true;

                    for (int z=0; z<4; z++) {

                        int nx = i+dx[z];
                        int ny = j+dy[z];


                        if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                            continue;
                        }

                        if (visited[nx][ny]) {
                            check = false;
                            break;
                        }

                    }

                    if (check) {

                        visited[i][j] = true;
                        back(depth+1,sum+arr[i][j]);
                        visited[i][j] =false;

                        
                    }

                }




            }
        }

    }
}
