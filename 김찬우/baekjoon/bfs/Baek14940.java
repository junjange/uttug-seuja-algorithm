package com.example.codingtest.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek14940 {

    static int[][] arr;
    static boolean[][] visited;
    static int n,m;
    static int[] dx ={-1,1,0,0};
    static int[] dy ={0,0,1,-1};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];
        int start =0;
        int end =0;

        for(int i=0; i<n; i++){

            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<m; j++){
                int num = Integer.parseInt(st.nextToken());

                if(num == 2){
                    start = i;
                    end = j;
                    arr[i][j] = 0;
                }else{
                    arr[i][j] = num;
                }


            }
        }

        bfs(start,end);

        for(int i=0; i<n; i++){

            for(int j=0; j<m; j++){

                if(visited[i][j]){
                    sb.append(arr[i][j]);
                    sb.append(" ");
                }else{
                    if(arr[i][j] == 1){
                        sb.append(-1);
                        sb.append(" ");
                    }else{

                        sb.append(0);
                        sb.append(" ");

                    }

                }

            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    public static void bfs(int x , int y){

        Queue<int[]> queue =  new LinkedList<>();
        visited[x][y] = true;
        queue.offer(new int[]{x,y});

        while (!queue.isEmpty()){

            int[] node = queue.poll();
            x = node[0];
            y = node[1];

            for(int i=0; i<4; i++){

                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx >= n || nx < 0 || ny >= m || ny < 0 ){
                    continue;
                }
                if (arr[nx][ny] == 0) continue;

                if(!visited[nx][ny]){
                    arr[nx][ny] = arr[x][y]+1;
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx,ny});
                }

            }

        }


    }
}
