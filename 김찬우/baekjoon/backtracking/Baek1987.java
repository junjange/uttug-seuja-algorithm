package com.example.codingtest.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Baek1987 {

    static int n,m;
    static char[][] arr;
    static boolean[][] visited;
    static int result=0;

    static StringBuilder sb = new StringBuilder();

    static int[] dx ={0,0,1,-1};
    static int[] dy ={1,-1,0,0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new char[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++){

            st = new StringTokenizer(br.readLine());

            String word = st.nextToken();

            for(int j=0; j<m; j++){

                arr[i][j] = word.charAt(j);
            }

        }

        sb.append(arr[0][0]);
        visited[0][0] = true;

        bfs(0, 0,1);

        System.out.println(result);


    }

    public static void bfs(int x, int y, int count){

        result = Math.max(result,count);

        for(int i=0; i<4; i++){

            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && nx < n && ny>=0 && ny<m && !visited[nx][ny]){

                if(sb.indexOf(String.valueOf(arr[nx][ny])) == -1){
                    sb.append(arr[nx][ny]);
                    visited[nx][ny] = true;
                    bfs(nx,ny,count+1);
                    sb.deleteCharAt(sb.length()-1);
                    visited[nx][ny] = false;

                }


            }

        }

    }
}
