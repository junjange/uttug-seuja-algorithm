package com.example.codingtest.swexam.argoTest;

import java.io.*;
import java.util.*;

public class 파핑파핑 {
    static int n, nearZeroCnt, cnt;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
    static int[] dy = {0, 0, 1, -1, 1, -1, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int test_case=1; test_case<=T; test_case++) {

            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            visited = new boolean[n][n];
            int totalCnt = n*n;
            int landmineCnt = nearZeroCnt = cnt = 0;

            for(int i=0;i<n;i++) {
                String currLine = br.readLine();
                for(int j=0;j<n;j++) {
                    if(currLine.charAt(j) == '*') {
                        map[i][j] = -1;
                        landmineCnt++;  // 지뢰개수
                    } else {
                        map[i][j] = -2;
                    }
                }
            }


            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    if(map[i][j] != -1) {
                        int count = 0;
                        for (int k = 0; k < 8; k++) {

                            int a = i+dy[k];
                            int b = j+dx[k];

                            if ( a >= 0 && a < n && b >= 0 && b < n) {

                                if (map[a][b] == -1) {
                                    count++;
                                }

                            }

                        }
                        map[i][j] = count;
                    }
                }
            }


            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    if(!visited[i][j] && map[i][j] == 0) areaClick(i, j);
                }
            }
            System.out.println("#"+test_case+" "+(totalCnt-landmineCnt-nearZeroCnt+cnt));

        }
    }

    static void areaClick(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});
        visited[y][x] = true;
        nearZeroCnt++;

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            for(int i=0;i<8;i++) {
                int currY = curr[0]+dy[i];
                int currX = curr[1]+dx[i];
                if( currY >= 0 && currY < n && currX >= 0 && currX < n) {
                    if(!visited[currY][currX]){
                        if(map[currY][currX] == 0) q.add(new int[]{currY, currX});
                        visited[currY][currX] = true;
                        nearZeroCnt++;
                    }
                }
            }

        }
        cnt++;
    }


}

