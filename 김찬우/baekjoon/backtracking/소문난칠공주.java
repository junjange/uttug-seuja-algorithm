package com.example.codingtest.swea;

import java.io.*;
import java.util.*;

public class 소문난칠공주 {
    static char[][] map = new char[5][5];
    static int[][] visited1;
    static int number = 0;
    static int[][] visited2;
    static int result = 0;
    static int[] dx = {0,-1,0,1};
    static int[] dy = {1,0,-1,0};
    static int S = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i=0; i<5; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j=0; j<5; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        visited1 = new int[5][5];
        backTracking(0,0);
        System.out.println(result);

    }

    static void backTracking(int depth, int start) {

        if (depth == 7 ) {

            visited2 = new int[5][5];

            for (int i=0; i<5; i++) {
                for (int j=0; j<5; j++) {
                    visited2[i][j] = visited1[i][j];
                }
            }

            loop:
            for (int i=0; i<5; i++) {
                for (int j=0; j<5; j++) {
                    if (visited1[i][j] ==1 && visited2[i][j] == 1) {
                        S = 0;
                        visited2[i][j] = 0;

                        if (map[i][j] == 'S') {
                            S++;
                        }

                        bfs(i,j);
                        break loop;
                    }
                }
            }

            if (number ==7 && S >=4) {
                result++;
            }
            return;
        }

        for (int i = start; i<25; i++) {

            int nx = i / 5;
            int ny = i % 5;

            visited1[nx][ny] = 1;
            backTracking(depth+1, i+1);
            visited1[nx][ny] = 0;
        }
    }


    static void bfs(int x , int y) {

        number = 1;
        Queue<int[]> queue =  new ArrayDeque<>();
        queue.offer(new int[]{x,y});

        while (!queue.isEmpty()) {
            int[] node = queue.poll();

            x = node[0];
            y = node[1];

            for (int i=0; i<4; i++) {

                int nx = x +dx[i];
                int ny = y +dy[i];

                if (nx <0 || nx >=5 || ny < 0 || ny >=5) {
                    continue;
                }

                if (visited1[nx][ny] == 1 && visited2[nx][ny] ==1 ) {

                    if (map[nx][ny] == 'S') {
                        S++;
                    }
                    number++;
                    visited2[nx][ny] = 0;
                    queue.offer(new int[]{nx,ny});
                }

            }

        }
    }
}
