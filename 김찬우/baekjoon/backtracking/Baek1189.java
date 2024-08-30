package com.example.codingtest.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek1189 {

    static int r,c,k,count;
    static boolean[][] visited;

    static ArrayList<Integer> result = new ArrayList<>();

    static char[][] arr;

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr= new char[r][c];
        visited = new boolean[r][c];



        for (int i=0; i<r; i++) {

            st = new StringTokenizer(br.readLine(), " ");
            String str = st.nextToken();

            for (int j=0; j < c; j++) {
                arr[i][j] = str.charAt(j);
            }

        }

        visited[r-1][0] = true;

        bfs(r-1,0,1);


        System.out.println(count);


    }

    static void bfs(int x, int y, int cnt){

        if(x == 0 && y == c-1 ){
            if(cnt == k){
                count++;
            }
            return;
        }

        for(int i=0; i<4; i++){

            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if(nx < 0 || nx >= r || ny < 0 || ny >= c){
                continue;
            }

            if(!visited[nx][ny] && arr[nx][ny] != 'T'){

                visited[nx][ny] = true;
                bfs(nx,ny,cnt+1);
                visited[nx][ny] = false;
            }

        }

    }
}
