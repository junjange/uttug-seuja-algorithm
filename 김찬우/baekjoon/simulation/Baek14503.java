package com.example.codingtest.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek14503 {

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    static int n,m,x, y,d,cnt;
    static int[][] arr;

    static int result;

    public static void main(String[] args) throws IOException {

        // 아이디어
        // 1, 현재칸을 청소한다 ==> 2를 넣는다.
        //  주변에 빈칸이 없으면 바라보고 있는 방향 기준 한칸뒤로

        //시간 복잡도

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        st = new StringTokenizer(br.readLine(), " ");

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for(int i=0; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }

        }

        while (true){

            if(arr[x][y] == 0){
                cnt++;
                arr[x][y] = 2;
            }

            boolean check = false;

            // 주변을 확인
            int dir = d;
            for(int i=0; i<4; i++){
                dir = (dir+3)%4;
                int nx = x+dx[dir];
                int ny = y+dy[dir];

                if(0 <= nx && nx<n && 0 <= ny && ny < m){
                    if(arr[nx][ny] == 0 ){
                        d = dir;
                        x = nx;
                        y = ny;
                        check = true;
                        break;
                    }
                }

            }

            if(!check){
                dir = d;
                dir = (dir+2) % 4;
                int nx = x+dx[dir];
                int ny = y+dy[dir];
                if(0 <= nx && nx < n && 0 <= ny && ny < m){

                    if(arr[nx][ny] == 1){
                        break;
                    }

                    else{
                        x = nx;
                        y = ny;
                    }

                }else{
                    break;
                }

            }


        }

        System.out.println(cnt);


    }


}
