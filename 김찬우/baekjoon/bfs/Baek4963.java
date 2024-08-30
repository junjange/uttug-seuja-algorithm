package com.example.codingtest.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baek4963 {

    static int n,m;
    static int[][] arr;
    static boolean[][] visited;

    static int[] dx = {1,-1,0,0,1,1,-1,-1};
    static int[] dy = {0,0,1,-1,-1,1,1,-1};

    public static void main(String[] args) {

        // 아이디어
        // 2중 포문을 돌면서 arr[][]==1 && visited[][] == false bfs 실행하면서 상하 좌우 대각선을 확인 하면서 bfs다 돌면 cnt +1

        // 시간 복잡도
        // bfs(v+e) -> 50*50 + 50*50*9 < 1 억



        Scanner sc = new Scanner(System.in);

        while(true){

            m = sc.nextInt();
            n = sc.nextInt();

            if(m ==0 && n==0){
                break;
            }

            int cnt = 0;
            arr = new int[n][m];
            visited = new boolean[n][m];

            for(int i=0; i<n; i++){
                for (int j=0; j<m; j++){
                    arr[i][j] = sc.nextInt();
                }

            }

            for (int i=0; i<n; i++){
                for (int j = 0; j<m; j++){

                    if (arr[i][j] ==1 && !visited[i][j]){
                        bfs(i, j);
                        cnt++;
                    }

                }

            }

            System.out.println(cnt);

        }



    }

    public static void bfs(int x, int y){

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});
        visited[x][y] = true;

        while (!queue.isEmpty()){

            int[] node = queue.poll();
            x= node[0];
            y= node[1];

            for (int i=0; i<8; i++){
                int nx = x+ dx[i];
                int ny = y+ dy[i];

                if (nx>=n || nx < 0 || ny>=m || ny<0){
                    continue;
                }

                if(arr[nx][ny] == 1 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx,ny});
                }

            }
        }
    }
}
