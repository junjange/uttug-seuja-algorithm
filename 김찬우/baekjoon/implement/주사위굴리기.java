package swea;

import java.io.*;
import java.util.*;


public class 주사위굴리기2 {

    static int[][] map;
    static int n;
    static int m;
    static int k;
    static int startX;
    static int startY;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int[] dice = new int[6];


    public static void main(String[] args) throws IOException {



        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        startX = Integer.parseInt(st.nextToken());
        startY = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map= new int[n][m];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<k; i++) {
            int d = Integer.parseInt(st.nextToken());

            int nx = startX+dx[d-1];
            int ny = startY+dy[d-1];

            if (nx < 0 || nx >=n || ny <0 || ny >=m) {
                continue;
            }

            if (d==1) {

                int temp = dice[5];
                dice[5] = dice[3];
                dice[3] = dice[2];
                dice[2] = dice[1];
                dice[1] = temp;

            } else if (d==2) {

                int temp = dice[1];
                dice[1] = dice[2];
                dice[2] = dice[3];
                dice[3] = dice[5];
                dice[5] = temp;

            } else if (d==3) {

                int temp = dice[0];

                dice[0] = dice[2];
                dice[2] = dice[4];
                dice[4] = dice[5];
                dice[5] = temp;

            } else {

                int temp = dice[5];

                dice[5] = dice[4];
                dice[4] = dice[2];
                dice[2] = dice[0];
                dice[0] = temp;

            }


            int currentDice = dice[5];

            if (map[nx][ny] == 0) {
                map[nx][ny] = currentDice;
            }else {
                dice[5] = map[nx][ny];
                map[nx][ny] = 0;
            }

            startX = nx;
            startY = ny;


            System.out.println(dice[2]);


        }

    }



}


